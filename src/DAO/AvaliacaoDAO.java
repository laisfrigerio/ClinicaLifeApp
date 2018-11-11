/**
 * @author Lais Frigério da Silva
 */

package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Avaliacao;
import model.Profissional;
import model.Formatacao;
import model.Paciente;
import model.Usuario;
import model.Validacao;

public class AvaliacaoDAO {
    private final static String CADASTRAR = "INSERT INTO avaliacao (medico, diag_cli, diag_fis,"
            + "data_avaliacao,id_paciente_avaliacao, id_fisioterapeuta_avaliacao) values"
            + " (?, ?, ?, ?, ?, ?)";
    private final static String EDITAR = "UPDATE avaliacao SET medico = ?, diag_cli = ?, "
            + "diag_fis = ?, data_avaliacao = ?, id_paciente_avaliacao = ?, id_fisioterapeuta_avaliacao = ?"
            + " WHERE id_avaliacao = ?";
    private final static String AVALIACOES = "SELECT medico, diag_cli, diag_fis, data_avaliacao,"
            + "id_paciente_avaliacao, id_fisioterapeuta_avaliacao, nome_paciente, "
            + "nome_usuario, id_avaliacao FROM avaliacao INNER JOIN usuario on "
            + "id_fisioterapeuta_avaliacao = id_fisioterapeuta_usuario INNER JOIN"
            + " paciente on id_paciente = id_paciente_avaliacao ORDER BY data_avaliacao DESC";
    private final static String PESQUISAR = "SELECT medico, diag_cli, diag_fis, data_avaliacao,"
            + "id_paciente_avaliacao, id_fisioterapeuta_avaliacao, nome_paciente, "
            + "nome_usuario, id_avaliacao FROM avaliacao INNER JOIN usuario on "
            + "id_fisioterapeuta_avaliacao = id_fisioterapeuta_usuario INNER JOIN"
            + " paciente on id_paciente = id_paciente_avaliacao WHERE id_avaliacao = ?"
            + " OR nome_usuario LIKE ? OR nome_paciente LIKE ? OR data_avaliacao = ?"
            + " ORDER BY data_avaliacao DESC";
    
    public boolean cadastrar(Avaliacao a){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(CADASTRAR);
            stmt.setString(1, a.getMedico());
            stmt.setString(2, a.getDiagnosticoClinico());
            stmt.setString(3, a.getDiagnosticoFisio());
            stmt.setDate(4, new java.sql.Date(a.getDataAvaliacao().getTime()));
            stmt.setInt(5,a.getPaciente().getId());
            stmt.setInt(6, a.getFisioterapeuta().getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if(conn!=null)
                    conn.close();
                if(stmt!=null)
                    stmt.close();
            } catch (Exception ex){
                System.out.println("ERROR - (Cadastrar Avaliação) | Try close "
                        + "prepared statement or conection \n " + ex);
            }
        }       
        return false;
    }
    
    public boolean editar(Avaliacao a){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(EDITAR);
            stmt.setString(1, a.getMedico());
            stmt.setString(2, a.getDiagnosticoClinico());
            stmt.setString(3, a.getDiagnosticoFisio());
            stmt.setDate(4, new java.sql.Date(a.getDataAvaliacao().getTime()));
            stmt.setInt(5,a.getPaciente().getId());
            stmt.setInt(6, a.getFisioterapeuta().getId());
            stmt.setInt(7, a.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if(conn!=null)
                    conn.close();
                if(stmt!=null)
                    stmt.close();
            } catch (Exception ex){
                System.out.println("ERROR - (Editar Avaliação) | Try close "
                        + "prepared statement or conection \n " + ex);
            }
        }       
        return false;
    }
    
    public List<Avaliacao> avaliacoes(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Avaliacao> lista = new ArrayList();
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(AVALIACOES);
            rs = stmt.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                Profissional fisioterapeuta = new Profissional();
                Avaliacao a = new Avaliacao(); 
                Paciente p = new Paciente();
                u.setNome(rs.getString(8));               
                fisioterapeuta.setId(rs.getInt(6));                
                fisioterapeuta.setUsuario(u);
                p.setNome(rs.getString(7));
                p.setId(rs.getInt(5));
                a.setMedico(rs.getString(1));
                a.setDiagnosticoClinico(rs.getString(2));
                a.setDiagnosticoFisio(rs.getString(3));
                a.setFisioterapeuta(fisioterapeuta);
                a.setPaciente(p);
                a.setId(rs.getInt(9));
                a.setDataAvaliacao(rs.getDate(4));
                lista.add(a);
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
                System.out.println("ERROR - (Lista Avaliação) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        return null;
    }
    
    public List<Avaliacao> avaliacoes(String busca){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Avaliacao> lista = new ArrayList();
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(PESQUISAR);
            if(Validacao.isNumeric(busca))
                stmt.setInt(1, Integer.parseInt(busca));
            else
                stmt.setInt(1, 0);
            stmt.setString(2, "%" + busca + "%");
            stmt.setString(3, "%" + busca + "%");
            if(Validacao.isNumeric(busca) && busca.length() == 8)
                busca = Validacao.setDateMask(busca);
            if(Validacao.isDate(busca))
                stmt.setDate(4, new java.sql.Date(Formatacao.string2Date(busca).getTime()));
            else
                stmt.setNull(4, java.sql.Types.NULL);
            rs = stmt.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                Profissional fisioterapeuta = new Profissional();
                Avaliacao a = new Avaliacao(); 
                Paciente p = new Paciente();
                u.setNome(rs.getString(8));               
                fisioterapeuta.setId(rs.getInt(6));                
                fisioterapeuta.setUsuario(u);
                p.setNome(rs.getString(7));
                p.setId(rs.getInt(5));
                a.setMedico(rs.getString(1));
                a.setDiagnosticoClinico(rs.getString(2));
                a.setDiagnosticoFisio(rs.getString(3));
                a.setFisioterapeuta(fisioterapeuta);
                a.setPaciente(p);
                a.setId(rs.getInt(9));
                a.setDataAvaliacao(rs.getDate(4));
                lista.add(a);
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
                System.out.println("ERROR - (Lista Avaliação - Pesquisa) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        return null;
    }
}
