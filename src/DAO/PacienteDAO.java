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
import model.Paciente;
import model.Endereco;
import model.Formatacao;
import model.Validacao;

public class PacienteDAO {
    private EnderecoDAO eDAO;
    private final static String CADASTRAR_PACIENTE = "INSERT INTO paciente (nome_paciente, CPF, RG, "
            + "fone_paciente,celular_paciente, fone_contato_paciente, sexo, estado_civil, data_nasc,"
            + " peso, observacao, id_endereco_paciente) values "
            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String EDITAR_PACIENTE = "UPDATE paciente SET nome_paciente = ?, CPF = ?, "
            + "RG = ?, fone_paciente = ?, celular_paciente = ?, fone_contato_paciente = ?, sexo = ?, "
            + " estado_civil = ?, data_nasc = ?, peso = ?, observacao = ?, id_endereco_paciente = ? "
            + " WHERE id_paciente = ? ";
    private final static String REMOVER_PACIENTE = "DELETE FROM paciente WHERE id_paciente = ?";
    private final static String PACIENTES = "SELECT id_paciente, nome_paciente, CPF, RG, fone_paciente, "
            + "celular_paciente, fone_contato_paciente, sexo, estado_civil, data_nasc, peso,"
            + "observacao, id_endereco_paciente, id_endereco, CEP, rua, bairro, cidade, estado, numero"
            + " FROM paciente LEFT JOIN "
            + "endereco on id_endereco =  id_endereco_paciente ORDER BY nome_paciente";
    private final static String PESQUISA = "SELECT id_paciente, nome_paciente, CPF, RG, fone_paciente, "
            + "celular_paciente, fone_contato_paciente, sexo, estado_civil, data_nasc, peso,"
            + "observacao, id_endereco_paciente, id_endereco, CEP, rua, bairro, cidade, estado, numero"
            + " FROM paciente LEFT JOIN "
            + "endereco on id_endereco =  id_endereco_paciente WHERE id_paciente = ? OR "
            + "nome_paciente LIKE ? OR CPF = ? OR data_nasc = ? ORDER BY nome_paciente";
    private final static String PACIENTE = "SELECT id_paciente, nome_paciente, CPF, RG, fone_paciente, "
            + "celular_paciente, fone_contato_paciente, sexo, estado_civil, data_nasc, peso,"
            + "observacao, id_endereco_paciente, id_endereco, CEP, rua, bairro, cidade, estado, numero FROM paciente "
            + "INNER JOIN endereco on id_endereco =  id_endereco_paciente WHERE id_paciente = ?";
    private final static String CPF_EXISTS = "SELECT CPF FROM paciente WHERE CPF = ?";
    private final static String CPF_EXISTS_MINUS = "SELECT CPF FROM paciente WHERE CPF = ? AND id_paciente != ?";
    
    public PacienteDAO() {
        this.eDAO = new EnderecoDAO();
    }
    
    public boolean cadastrar(Paciente paciente){
        int id_endereco = 0;
        Connection conn = null;
        PreparedStatement stmt = null, stmte = null;
        ResultSet rs = null;
        try {
            conn = new ConectionFactory().getConnection();
            conn.setAutoCommit(false);
            // Cadastrar endereço
            if(paciente.getEndereco() != null){
                id_endereco = this.eDAO.cadastrar(conn, stmte, rs, paciente.getEndereco());
                if(id_endereco == java.sql.Types.NULL)
                    return false;
            }
            // Cadastrar paciente
            stmt = conn.prepareStatement(CADASTRAR_PACIENTE);
            stmt.setString(1, paciente.getNome());
            stmt.setString(2,paciente.getCPF());
            stmt.setString(3,paciente.getRG());
            stmt.setString(4,paciente.getFone());
            stmt.setString(5,paciente.getCelular());
            stmt.setString(6,paciente.getFoneContato());
            stmt.setString(7,paciente.getSexo());
            stmt.setString(8,paciente.getEstadoCivil());
            stmt.setDate(9, new java.sql.Date(paciente.getDataNasc().getTime()));
            stmt.setDouble(10,paciente.getPeso());
            stmt.setString(11,paciente.getObservacao());
            if (id_endereco == 0) {
                stmt.setNull(12, Types.NULL);
            } else {
                stmt.setInt(12, id_endereco);
            }
            stmt.executeUpdate();           
            conn.commit();
            return true;
        } catch (SQLException | ClassNotFoundException | IOException ex){
            System.out.println(ex);
        } finally{
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
                if(rs!=null) rs.close();
            } catch(Exception ex){
                System.out.println("ERROR (Cadastrar Paciente) - Ao fechar a conexão ou prepared statement");
            }
        }
        return false;
    }
    
    public boolean editar(Paciente paciente){
        int id_endereco = 0;
        boolean removerEndereco = false;
        Connection conn = null;
        PreparedStatement stmt = null, stmte = null;
        ResultSet rs = null;
        try {
            conn = new ConectionFactory().getConnection();
            conn.setAutoCommit(false);
            
            Paciente buscaPaciente = this.paciente(paciente.getId());            
            if(paciente.getEndereco() != null) {
                
                // Editar endereço
                if(paciente.getEndereco().getId() != 0){
                    id_endereco = this.eDAO.editar(conn, stmte, paciente.getEndereco());
                } else {
                    // Cadastrar endereço novo
                    id_endereco = this.eDAO.cadastrar(conn, stmte, rs, paciente.getEndereco());
                    if(id_endereco == 0)
                        return false;
                }
            } else if (buscaPaciente.getEndereco() != null) {
                removerEndereco = true;
                id_endereco = 0;
            }
            
            stmt = conn.prepareStatement(EDITAR_PACIENTE);
            stmt.setString(1, paciente.getNome());
            stmt.setString(2,paciente.getCPF());
            stmt.setString(3,paciente.getRG());
            stmt.setString(4,paciente.getFone());
            stmt.setString(5,paciente.getCelular());
            stmt.setString(6,paciente.getFoneContato());
            stmt.setString(7,paciente.getSexo());
            stmt.setString(8,paciente.getEstadoCivil());
            stmt.setDate(9, new java.sql.Date(paciente.getDataNasc().getTime()));
            stmt.setDouble(10,paciente.getPeso());
            stmt.setString(11,paciente.getObservacao());
            if(id_endereco == 0)
                stmt.setNull(12,java.sql.Types.NULL);
            else
                stmt.setInt(12, id_endereco);
            stmt.setInt(13, paciente.getId());
            stmt.executeUpdate();
            
            if (removerEndereco) {
                this.eDAO.remover(conn, stmte, buscaPaciente.getEndereco().getId());
            }
            
            conn.commit();
            return true;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally{
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
                if(stmte!=null) stmte.close();
                if(rs!=null) rs.close();
            } catch(Exception ex){
                System.out.println("ERROR (Editar Paciente) - Ao fechar a conexão ou prepared statement");
            }
        }
        return false;
    }
    
    public boolean remover(Paciente paciente){
        Connection conn = null;
        PreparedStatement stmt = null, stmte = null;
        try {
            conn = new ConectionFactory().getConnection();
            conn.setAutoCommit(false);   
            // Remover endereço
            this.eDAO.remover(conn, stmte, paciente.getEndereco().getId());
            // Remover paciente
            stmt = conn.prepareStatement(REMOVER_PACIENTE);
            stmt.setInt(1, paciente.getId());
            stmt.executeUpdate();
            conn.commit();
            return true;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally{
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
            } catch(Exception ex){
                System.out.println("ERROR (Remover Paciente) - Ao fechar a conexão ou prepared statement");
            }
        }
        return false;
    }
    
    public List<Paciente> pacientes(){
        Connection conn = null;
        PreparedStatement stmt = null;
        List<Paciente> lista = new ArrayList();
        ResultSet rs = null;
        try{
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(PACIENTES);
            rs = stmt.executeQuery();
            while(rs.next()){
                Paciente c = new Paciente();
                Endereco e = null;
                if(rs.getInt(13) != 0){
                    e = new Endereco();
                    e.setId(rs.getInt(14)); 
                    e.setCEP(rs.getString(15));
                    e.setRua(rs.getString(16));
                    e.setBairro(rs.getString(17));
                    e.setCidade(rs.getString(18));
                    e.setEstado(rs.getString(19));
                    e.setNumero(rs.getInt(20));
                }               
                c.setEndereco(e);
                c.setId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setCPF(rs.getString(3));
                c.setRG(rs.getString(4));
                c.setFone(rs.getString(5));
                c.setCelular(rs.getString(6));
                c.setFoneContato(rs.getString(7));
                c.setSexo(rs.getString(8));
                c.setEstadoCivil(rs.getString(9));
                c.setDataNasc(rs.getDate(10));
                c.setPeso(rs.getDouble(11));
                c.setObservacao(rs.getString(12));
                lista.add(c);
            }
            return lista;
        }catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally{
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
                if(rs!=null) rs.close();
            } catch(Exception ex){
                System.out.println("ERROR (Listar Pacientes) - Ao fechar a conexão ou prepared statement");
            }
        }
        return null;
    }
    
    public List<Paciente> pacientes(String busca){
        Connection conn = null;
        PreparedStatement stmt = null;
        List<Paciente> lista = new ArrayList();
        ResultSet rs = null;
        try{
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(PESQUISA);
            if(Validacao.isNumeric(busca) && Validacao.isLessOrEqualThan(busca, 10))
                stmt.setInt(1, Integer.parseInt(busca));
            else
                stmt.setInt(1, 0);
            stmt.setString(2, "%" + busca + "%");
            stmt.setString(3, busca);
            if(Validacao.isNumeric(busca) && busca.length() == 8)
                busca = Validacao.setDateMask(busca);
            if(Validacao.isDate(busca))
                stmt.setDate(4, new java.sql.Date(Formatacao.string2Date(busca).getTime()));
            else
                stmt.setNull(4, java.sql.Types.NULL);
            rs = stmt.executeQuery();
            while(rs.next()){
                Paciente c = new Paciente();
                Endereco e = null;
                if(rs.getInt(13) != 0){
                    e = new Endereco();
                    e.setId(rs.getInt(14)); 
                    e.setCEP(rs.getString(15));
                    e.setRua(rs.getString(16));
                    e.setBairro(rs.getString(17));
                    e.setCidade(rs.getString(18));
                    e.setEstado(rs.getString(19));
                    e.setNumero(rs.getInt(20));
                }               
                c.setEndereco(e);
                c.setId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setCPF(rs.getString(3));
                c.setRG(rs.getString(4));
                c.setFone(rs.getString(5));
                c.setCelular(rs.getString(6));
                c.setFoneContato(rs.getString(7));
                c.setSexo(rs.getString(8));
                c.setEstadoCivil(rs.getString(9));
                c.setDataNasc(rs.getDate(10));
                c.setPeso(rs.getDouble(11));
                c.setObservacao(rs.getString(12));
                lista.add(c);
            }
            return lista;
        }catch (SQLException | ClassNotFoundException | IOException  ex) {
            System.out.println(ex);
        } finally{
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
                if(rs!=null) rs.close();
            } catch(Exception ex){
                System.out.println("ERROR (Listar Pacientes) - Ao fechar a conexão ou prepared statement");
            }
        }
        return null;
    }
    
    public Paciente paciente(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        Paciente c = null;
        ResultSet rs = null;
        try{
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(PACIENTE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                c = new Paciente();
                Endereco e = new Endereco();
                e.setId(rs.getInt(14)); 
                e.setCEP(rs.getString(15));
                e.setRua(rs.getString(16));
                e.setBairro(rs.getString(17));
                e.setCidade(rs.getString(18));
                e.setEstado(rs.getString(19));
                e.setNumero(rs.getInt(20));
                c.setEndereco(e);
                c.setId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setCPF(rs.getString(3));
                c.setRG(rs.getString(4));
                c.setFone(rs.getString(5));
                c.setCelular(rs.getString(6));
                c.setFoneContato(rs.getString(7));
                c.setSexo(rs.getString(8));
                c.setEstadoCivil(rs.getString(9));
                c.setDataNasc(rs.getDate(10));
                c.setPeso(rs.getDouble(11));
                c.setObservacao(rs.getString(12));
            }
            return c;
        }catch (SQLException | ClassNotFoundException | IOException  ex) {
            System.out.println(ex);
        } finally{
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
                if(rs!=null) rs.close();
            } catch(Exception ex){
                System.out.println("ERROR (Buscar Paciente) - Ao fechar a conexão ou prepared statement");
            }
        }
        return null;
    }
    
    public static boolean CPFexists(String cpf, int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = new ConectionFactory().getConnection();
            
            if (id == 0) {
                stmt = conn.prepareStatement(CPF_EXISTS);
            } else {
                stmt = conn.prepareStatement(CPF_EXISTS_MINUS);
                stmt.setInt(2, id);
            }
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                return true;
            }
            
            return false;
        } catch (SQLException | ClassNotFoundException | IOException  ex) {
            System.out.println(ex);
            return false;
        } finally {
            
            try {
                if (conn!=null) conn.close();
                if (stmt!=null) stmt.close();
                if (rs!=null) rs.close();
            } catch (Exception e) {
                System.out.println("ERROR (Buscar CPF) - Ao fechar a conexão ou prepared statement");
            }
        }
    }
}
