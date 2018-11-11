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
import model.Especialidade;

/**
 *
 * @author Lais Frigério da Silva | 27.10.2018
 */
public class EspecialidadeDAO {
    
    private final static String CADASTRAR = "INSERT INTO especialidade (nome)"
            + " values (?)";
    private final static String EDITAR = "UPDATE especialidade SET "
            + "nome = ? WHERE id = ?";
    private final static String REMOVER = "DELETE FROM especialidade WHERE "
            + "id = ?";
    private final static String ESPECIALIDADES = "SELECT id, nome FROM especialidade";
    private final static String PESQUISA = "SELECT id, nome FROM especialidade WHERE nome LIKE ?";
    
    public boolean cadastrar(Especialidade tp){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(CADASTRAR);
            stmt.setString(1, tp.getNome());
            stmt.executeUpdate();
            return true;
        } catch (IOException | ClassNotFoundException | SQLException ex) {
           System.out.println(ex); 
        } finally {
            try {
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
            } catch (Exception ex) {
                System.out.println("ERROR - (Cadastrar Tipo Profissional) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        
        return false;
    }
    
    public boolean editar(Especialidade tp){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(EDITAR);
            stmt.setString(1, tp.getNome());
            stmt.setInt(2, tp.getId());
            stmt.executeUpdate();
            return true;
        } catch (IOException | ClassNotFoundException | SQLException ex) {
           System.out.println(ex); 
        } finally {
            try {
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
            } catch (Exception ex) {
                System.out.println("ERROR - (Editar Tipo Profissional) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        
        return false;
    }
    
    public boolean remover(Especialidade tp){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(REMOVER);
            stmt.setInt(1, tp.getId());
            stmt.executeUpdate();
            return true;
        } catch (IOException | ClassNotFoundException | SQLException ex) {
           System.out.println(ex); 
        } finally {
            try {
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
            } catch (Exception ex) {
                System.out.println("ERROR - (Remover Especialidade) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        
        return false;
    }
    
    public List<Especialidade> especialidades(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Especialidade> lista = new ArrayList();
        
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(ESPECIALIDADES);
            rs = stmt.executeQuery();
            while(rs.next()) {
                Especialidade e = new Especialidade();
                e.setNome(rs.getString("nome"));
                e.setId(rs.getInt("id"));
                lista.add(e);
            }
            return lista;
        } catch (IOException | ClassNotFoundException | SQLException ex) {
           System.out.println(ex); 
        } finally {
            try {
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
                if(rs!=null) rs.close();
            } catch (Exception ex) {
                System.out.println("ERROR - (Listar Tipo de Profissionais) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        
        return null;
    }
    
    public List<Especialidade> especialidades(String busca){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Especialidade> lista = new ArrayList();
        
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(PESQUISA);
            stmt.setString(1, "%" + busca + "%");
            rs = stmt.executeQuery();
            while(rs.next()) {
                Especialidade tp = new Especialidade();
                tp.setNome(rs.getString("nome"));
                tp.setId(rs.getInt("id"));
                lista.add(tp);
            }
            return lista;
        } catch (IOException | ClassNotFoundException | SQLException ex) {
           System.out.println(ex); 
        } finally {
            try {
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
                if(rs!=null) rs.close();
            } catch (Exception ex) {
                System.out.println("ERROR - (Listar Tipo de Profissionais) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        
        return null;
    }
    
    /**
     * @TODO implement get Especialidade register by identifier
     * @param id
     * @return 
     */
    public Especialidade especialidade(int id){
        return null;
    }
}
