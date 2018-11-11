/**
 * @author Lais Frigério da Silva
 */

package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Endereco;
import model.Profissional;
import model.Especialidade;
import model.Usuario;
import model.Validacao;

public class ProfissionalDAO {
    private EnderecoDAO eDAO;
    private final static String CADASTRAR_PROFISSIONAL = "INSERT INTO profissional ( "
            + "fone, celular, conta_corrente, agencia, digito, banco, endereco_id, especialidade_id) values"
            + " (?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String EDITAR_PROFISSIONAL = "UPDATE profissional SET "
            + "fone = ?, celular = ?, conta_corrente = ?, agencia = ?, digito = ?, banco = ?, "
            + "endereco_id = ?, especialidade_id = ? WHERE id = ?";
    private final static String CADASTRAR_USUARIO = "INSERT INTO usuario (nome_usuario, login, senha,"
            + "tipo_usuario, id_fisioterapeuta_usuario) values (?,?,?,2,?)";
    private final static String EDITAR_USUARIO = "UPDATE usuario SET nome_usuario = ?, login = ?,"
            + "senha = ? WHERE id_usuario = ?";
    private final static String PROFISSIONAIS = "SELECT id_usuario,nome_usuario, login, senha, "
            + "profissional.id, fone,celular,banco,agencia,digito,conta_corrente, endereco_id,"
            + "CEP,rua,bairro,cidade,estado,numero, especialidade_id, es.nome"
            + " FROM usuario INNER JOIN profissional on id_fisioterapeuta_usuario = profissional.id"
            + " LEFT JOIN especialidade as es ON es.id = especialidade_id"
            + " LEFT JOIN endereco on id_endereco = endereco_id";
    private final static String PROFISSIONAL = "SELECT id_usuario,nome_usuario, login, senha, "
            + "profissional.id, fone,celular,banco,agencia,digito,conta_corrente, endereco_id,"
            + "CEP,rua,bairro,cidade,estado,numero,profissional.especialidade_id, es.nome"
            + " FROM usuario INNER JOIN profissional on id_fisioterapeuta_usuario = profissional.id"
            + " LEFT JOIN especialidade as es ON es.id = especialidade_id"
            + " LEFT JOIN endereco on id_endereco = endereco_id WHERE profissional.id = ?";
    private final static String PESQUISA = "SELECT id_usuario,nome_usuario, login, senha, "
            + "profissional.id, fone,celular,banco,agencia,digito,conta_corrente,id_endereco,"
            + "CEP,rua,bairro,cidade,estado,numero,especialidade_id, es.nome"
            + " FROM usuario INNER JOIN profissional on id_fisioterapeuta_usuario = profissional.id"
            + " LEFT JOIN especialidade as es ON es.id = especialidade_id"
            + " LEFT JOIN endereco on id_endereco = endereco_id WHERE profissional.id = "
            + "? OR nome_usuario LIKE ? OR login LIKE ? OR es.nome LIKE ?";
    
    public ProfissionalDAO() {
        this.eDAO = new EnderecoDAO();
    }
    
    public boolean cadastrar(Profissional f){
        int id_endereco = 0, id_fisio = 0;
        Connection conn = null;
        PreparedStatement stmtf = null, stmtu = null, stmte = null;
        ResultSet rs = null;
        try {
            conn = new ConectionFactory().getConnection();
            conn.setAutoCommit(false);
            
            // Cadastrar endereço
            if(f.getEndereco() != null){
                id_endereco = this.eDAO.cadastrar(conn, stmte, rs, f.getEndereco());
                if(id_endereco == java.sql.Types.NULL)
                    return false;
            }  
            // Cadastrar fisioterapeuta
            stmtf = conn.prepareStatement(CADASTRAR_PROFISSIONAL, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtf.setString(1,f.getFone());
            stmtf.setString(2,f.getCelular());
            stmtf.setString(3,f.getContaCorrente());
            stmtf.setString(4,f.getAgencia());
            stmtf.setString(5,f.getDigito());
            stmtf.setString(6,f.getBanco());
            if (id_endereco == 0) {
                stmtf.setNull(7, Types.NULL);
            } else {
                stmtf.setInt(7, id_endereco);
            }
            stmtf.setInt(8, f.getEspecialidade().getId());
            stmtf.executeUpdate();
            rs = stmtf.getGeneratedKeys();
            if(rs.next())
                id_fisio = rs.getInt(1);
            if(id_fisio == 0)
                return false;           
            // Cadastrar usuario
            stmtu = conn.prepareStatement(CADASTRAR_USUARIO);
            stmtu.setString(1, f.getUsuario().getNome());
            stmtu.setString(2, f.getUsuario().getLogin());
            stmtu.setString(3, f.getUsuario().getSenha());
            stmtu.setInt(4, id_fisio);
            stmtu.executeUpdate();  
            conn.commit();
            return true;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if(conn!= null) conn.close();
                if(stmtf!=null) stmtf.close();
                if(stmtu!=null) stmtu.close();
                if(stmte!=null) stmte.close();
                if(rs!=null) rs.close();
            } catch (Exception ex) {
                System.out.println("ERROR - (Cadastrar Profissional) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        return false;
    }
    
    public boolean editar(Profissional f){
        int id_endereco = 0;
        boolean removerEndereco = false;
        Connection conn = null;
        PreparedStatement stmtf = null, stmtu = null, stmte = null;
        ResultSet rs = null;
        try {
            conn = new ConectionFactory().getConnection();
            conn.setAutoCommit(false);
            
            Profissional buscaProfissional = this.profissional(f.getId());            
            // Cadastrar endereço
            if(f.getEndereco() != null){
                
                // Editar endereço
                if(f.getEndereco().getId() != 0){
                    id_endereco = this.eDAO.editar(conn, stmte, f.getEndereco());
                } else {
                    // Cadastrar endereço novo
                    id_endereco = this.eDAO.cadastrar(conn, stmte, rs, f.getEndereco());
                    if(id_endereco == 0)
                        return false;
                }
            } else if (buscaProfissional != null && buscaProfissional.getEndereco() != null) {
                removerEndereco = true;
            }
            // Editar profissional
            stmtf = conn.prepareStatement(EDITAR_PROFISSIONAL);
            stmtf.setString(1,f.getFone());
            stmtf.setString(2,f.getCelular());
            stmtf.setString(3,f.getContaCorrente());
            stmtf.setString(4,f.getAgencia());
            stmtf.setString(5,f.getDigito());
            stmtf.setString(6,f.getBanco());
            if(id_endereco == 0)
                stmtf.setNull(7,java.sql.Types.NULL);
            else
                stmtf.setInt(7, id_endereco);
            stmtf.setInt(8, f.getEspecialidade().getId());
            stmtf.setInt(9, f.getId());
            stmtf.executeUpdate();          
            // Cadastrar usuario
            stmtu = conn.prepareStatement(EDITAR_USUARIO);
            stmtu.setString(1, f.getUsuario().getNome());
            stmtu.setString(2, f.getUsuario().getLogin());
            stmtu.setString(3, f.getUsuario().getSenha());
            stmtu.setInt(4, f.getUsuario().getId());
            stmtu.executeUpdate();  
            
            if (removerEndereco) {
                this.eDAO.remover(conn, stmte, buscaProfissional.getEndereco().getId());
            }
            
            conn.commit();
            return true;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if(conn!= null)
                    conn.close();
                if(stmtf!=null)
                    stmtf.close();
                if(stmtu!=null)
                    stmtu.close();
                if(stmte!=null)
                    stmte.close();
                if(rs!=null)
                    rs.close();
            } catch (Exception ex) {
                System.out.println("ERROR - (Editar Profissional) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        return false;
    }
    
    public List<Profissional> profissionais(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Profissional> lista = new ArrayList();
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(PROFISSIONAIS);
            rs = stmt.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                Endereco e = null;
                Profissional f = new Profissional();
                
                u.setId(rs.getInt(1));
                u.setNome(rs.getString(2));
                u.setLogin(rs.getString(3));
                u.setSenha(rs.getString(4));
                
                if(rs.getInt(12)!=0){
                    e = new Endereco();
                    e.setId(rs.getInt(12));
                    e.setCEP(rs.getString(13));
                    e.setRua(rs.getString(14));
                    e.setBairro(rs.getString(15));
                    e.setCidade(rs.getString(16));
                    e.setEstado(rs.getString(17));
                    e.setNumero(rs.getInt(18));
                }
                
                if (rs.getInt(19)!=0) {
                    Especialidade tp = new Especialidade();
                    tp.setId(rs.getInt(19));
                    tp.setNome(rs.getString(20));
                    f.setEspecialidade(tp);
                }
                f.setUsuario(u);
                f.setEndereco(e);
                f.setId(rs.getInt(5));
                f.setFone(rs.getString(6));
                f.setCelular(rs.getString(7));
                f.setBanco(rs.getString(8));
                f.setAgencia(rs.getString(9));
                f.setDigito(rs.getString(10));
                f.setContaCorrente(rs.getString(11));
                
                lista.add(f);
            }
            return lista;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try{
                if(conn!=null)
                    conn.close();
                if(stmt!=null)
                    stmt.close();
                if(rs!=null)
                    rs.close();
            } catch (Exception ex){
                System.out.println("ERROR - (Lista Fisioterapeuta) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        return null;
    }
    
    public List<Profissional> profissionais(String busca){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Profissional> lista = new ArrayList();
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(PESQUISA);
            if(Validacao.isNumeric(busca))
                stmt.setInt(1, Integer.parseInt(busca));
            else
                stmt.setInt(1, 0);
            stmt.setString(2, "%" + busca + "%");
            stmt.setString(3, "%" + busca + "%");
            stmt.setString(4, "%" + busca + "%");
            rs = stmt.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                Endereco e = null;
                Profissional p = new Profissional();
                
                u.setId(rs.getInt(1));
                u.setNome(rs.getString(2));
                u.setLogin(rs.getString(3));
                u.setSenha(rs.getString(4));
                
                if(rs.getInt(12)!=0){
                    e = new Endereco();
                    e.setId(rs.getInt(12));
                    e.setCEP(rs.getString(13));
                    e.setRua(rs.getString(14));
                    e.setBairro(rs.getString(15));
                    e.setCidade(rs.getString(16));
                    e.setEstado(rs.getString(17));
                    e.setNumero(rs.getInt(18));
                }
                
                if (rs.getInt(19)!=0) {
                    Especialidade tp = new Especialidade();
                    tp.setId(rs.getInt(19));
                    tp.setNome(rs.getString(20));
                    p.setEspecialidade(tp);
                }
                
                p.setUsuario(u);
                p.setEndereco(e);
                p.setId(rs.getInt(5));
                p.setFone(rs.getString(6));
                p.setCelular(rs.getString(7));
                p.setBanco(rs.getString(8));
                p.setAgencia(rs.getString(9));
                p.setDigito(rs.getString(10));
                p.setContaCorrente(rs.getString(11));
                
                lista.add(p);
            }
            return lista;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try{
                if(conn!=null)
                    conn.close();
                if(stmt!=null)
                    stmt.close();
                if(rs!=null)
                    rs.close();
            } catch (Exception ex){
                System.out.println("ERROR - (Lista Fisioterapeuta) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        return null;
    }
    
    public Profissional profissional(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        Profissional p = null;
        ResultSet rs = null;
        try{
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(PROFISSIONAL);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                p = new Profissional();
                Endereco e = new Endereco();
                e.setId(rs.getInt(12)); 
                e.setCEP(rs.getString(13));
                e.setRua(rs.getString(14));
                e.setBairro(rs.getString(15));
                e.setCidade(rs.getString(16));
                e.setEstado(rs.getString(17));
                e.setNumero(rs.getInt(18));
                p.setEndereco(e);
                p.setId(rs.getInt(1));
                Usuario u = new Usuario();
                u.setNome(rs.getString(2));
                p.setUsuario(u);
                p.setFone(rs.getString(5));
                p.setCelular(rs.getString(6));
                
                if (rs.getInt(19)!=0) {
                    Especialidade tp = new Especialidade();
                    tp.setId(rs.getInt(19));
                    tp.setNome(rs.getString(20));
                    p.setEspecialidade(tp);
                }
            }
            return p;
        }catch (SQLException | ClassNotFoundException | IOException  ex) {
            System.out.println(ex);
        } finally{
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
                if(rs!=null) rs.close();
            } catch(Exception ex){
                System.out.println("ERROR (Buscar Profissional) - Ao fechar a conexão ou prepared statement");
            }
        }
        return null;
    }
}
