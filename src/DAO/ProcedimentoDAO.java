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
import model.Procedimento;

/**
 *
 * @author Lais Frigério da Silva | 02.11.2018
 */
public class ProcedimentoDAO {
    
    private final static String CADASTRAR = "INSERT INTO procedimento (nome)"
            + " values (?)";
    private final static String EDITAR = "UPDATE procedimento SET "
            + "nome = ? WHERE id = ?";
    private final static String REMOVER = "DELETE FROM procedimento WHERE "
            + "id = ?";
    private final static String PROCEDIMENTOS = "SELECT id, nome FROM procedimento";
    private final static String PESQUISA = "SELECT id, nome FROM procedimento WHERE nome LIKE ?";
    
    public boolean cadastrar(Procedimento p){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(CADASTRAR);
            stmt.setString(1, p.getNome());
            stmt.executeUpdate();
            return true;
        } catch (IOException | ClassNotFoundException | SQLException ex) {
           System.out.println(ex); 
        } finally {
            try {
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
            } catch (Exception ex) {
                System.out.println("ERROR - (Cadastrar Procedimento) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        
        return false;
    }
    
    public boolean editar(Procedimento p){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(EDITAR);
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getId());
            stmt.executeUpdate();
            return true;
        } catch (IOException | ClassNotFoundException | SQLException ex) {
           System.out.println(ex); 
        } finally {
            try {
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
            } catch (Exception ex) {
                System.out.println("ERROR - (Editar Procedimento) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        
        return false;
    }
    
    public boolean remover(Procedimento p){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(REMOVER);
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();
            return true;
        } catch (IOException | ClassNotFoundException | SQLException ex) {
           System.out.println(ex); 
        } finally {
            try {
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
            } catch (Exception ex) {
                System.out.println("ERROR - (Remover Procedimento) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        
        return false;
    }
    
    public List<Procedimento> procedimentos(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Procedimento> lista = new ArrayList();
        
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(PROCEDIMENTOS);
            rs = stmt.executeQuery();
            while(rs.next()) {
                Procedimento tp = new Procedimento();
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
                System.out.println("ERROR - (Listar Procedimentos) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        
        return null;
    }
    
    public List<Procedimento> procedimentos(String busca){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Procedimento> lista = new ArrayList();
        
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(PESQUISA);
            stmt.setString(1, "%" + busca + "%");
            rs = stmt.executeQuery();
            while(rs.next()) {
                Procedimento p = new Procedimento();
                p.setNome(rs.getString("nome"));
                p.setId(rs.getInt("id"));
                lista.add(p);
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
                System.out.println("ERROR - (Listar Procedimentos) | Try close "
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
    public Procedimento procedimento(int id){
        return null;
    }
}
