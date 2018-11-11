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
import model.Profissional;
import model.Usuario;
import model.Validacao;

public class UsuarioDAO {
    private final String LOGIN = "SELECT id_usuario, nome_usuario, senha, login, "
            + "id_fisioterapeuta_usuario, tipo_usuario FROM usuario WHERE senha = ? "
            + "AND login = ?";
    private final String CADASTRAR = "INSERT INTO usuario (nome_usuario, login, senha,"
            + "tipo_usuario) values (?,?,?,?)";
    private final String EDITAR = "UPDATE usuario SET nome_usuario = ?, login = ?,"
            + "senha = ? WHERE id_usuario = ?";
    private final String USUARIOS = "SELECT id_usuario, nome_usuario, login, senha, "
            + "tipo_usuario FROM usuario WHERE tipo_usuario = 1";
    private final String PESQUISA = "SELECT id_usuario, nome_usuario, login, senha, "
            + "tipo_usuario FROM usuario WHERE id_usuario = ? OR nome_usuario LIKE ? OR"
            + " login LIKE ?";
    private static final String LOGIN_EXISTS = "SELECT * FROM usuario WHERE login = ?";
    private static final String LOGIN_EXISTS_MINUS = "SELECT * FROM usuario WHERE login = ? AND id_fisioterapeuta_usuario != ?";
    
    public Usuario login(String login, String senha){
        Usuario u = null;
        Profissional f = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(LOGIN);
            stmt.setString(1, senha);
            stmt.setString(2,login);
            rs = stmt.executeQuery();
            if(rs.next()){
                f = new Profissional();
                f.setId(rs.getInt(5));
                u = new Usuario();
                u.setId(rs.getInt(1));
                u.setNome(rs.getString(2));
                u.setSenha(rs.getString(3));
                u.setLogin(rs.getString(4));
                u.setTipoFunc(rs.getInt(5));
                u.setProfissional(f);
            }
        } catch (SQLException | ClassNotFoundException | IOException  ex) {
            System.out.println(ex);
        } finally{
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
                if(rs!=null) rs.close();
            } catch(Exception ex){
                System.out.println("ERROR (Efetuar Login) - Ao fechar a conexão, prepared statement ou result set");
            }
        }
        return u;
    }
    
    public boolean cadastrar(Usuario u) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(CADASTRAR);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setInt(4, u.getTipoFunc());
            stmt.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
            } catch(Exception ex){
                System.out.println("ERROR (Efetuar cadastro) - Ao fechar a conexão ou prepared statement");
            }
        }
        return false;
    }
    
    public boolean editar(Usuario u) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(EDITAR);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setInt(4, u.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
            } catch(Exception ex){
                System.out.println("ERROR (Efetuar Edição) - Ao fechar a conexão ou prepared statement");
            }
        }
        return false;
    }
    
    public List<Usuario> usuarios(){
        Connection conn = null;
        PreparedStatement stmt = null; 
        ResultSet rs = null;
        List<Usuario> lista = new ArrayList();
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(USUARIOS);
            rs = stmt.executeQuery();
            while(rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt(1));
                u.setNome(rs.getString(2));
                u.setLogin(rs.getString(3));
                u.setSenha(rs.getString(4));
                u.setTipoFunc(rs.getInt(5));
                lista.add(u);
            }
            return lista;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
            } catch(Exception ex){
                System.out.println("ERROR (Efetuar Buscar todos) - Ao fechar a conexão, prepared statement ou result set");
            }
        }
        return null;   
    }
    
    public List<Usuario> usuarios(String busca){
        Connection conn = null;
        PreparedStatement stmt = null; 
        ResultSet rs = null;
        List<Usuario> lista = new ArrayList();
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(PESQUISA);
            if(Validacao.isNumeric(busca))
                stmt.setInt(1, Integer.parseInt(busca));
            else
                stmt.setInt(1, 0);
            stmt.setString(2, "%" + busca + "%");
            stmt.setString(3, "%" + busca + "%");
            rs = stmt.executeQuery();
            while(rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt(1));
                u.setNome(rs.getString(2));
                u.setLogin(rs.getString(3));
                u.setSenha(rs.getString(4));
                u.setTipoFunc(rs.getInt(5));
                lista.add(u);
            }
            return lista;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
            } catch(Exception ex){
                System.out.println("ERROR (Efetuar Buscar específicos) - Ao fechar a conexão, prepared statement ou result set");
            }
        }
        return null;   
    }
    
    public static boolean loginExists(String login, int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = new ConectionFactory().getConnection();
            
            if (id != 0) {
                stmt = conn.prepareStatement(LOGIN_EXISTS_MINUS);
                stmt.setInt(2, id);
            } else {
                stmt = conn.prepareStatement(LOGIN_EXISTS);
            }
            stmt.setString(1, login);
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
