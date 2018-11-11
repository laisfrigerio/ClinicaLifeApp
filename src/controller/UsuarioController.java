/**
 * @author Lais Frigério da Silva
 */

package controller;

import DAO.UsuarioDAO;
import java.util.List;
import model.Usuario;

public class UsuarioController {
    UsuarioDAO uDAO = new UsuarioDAO();
    public boolean cadastrar(Usuario usuario){
        return uDAO.cadastrar(usuario);
    }
    
    public boolean editar(Usuario usuario){
        return uDAO.editar(usuario);
    }
    
    public List<Usuario> usuarios(){
        return uDAO.usuarios();
    }
    
    public List<Usuario> usuarios(String busca){
        return uDAO.usuarios(busca);
    }
    
    public Usuario login(String login, String senha){
        return uDAO.login(login, senha);
    }
    
    public static boolean loginExists(String login, int id) {
        return UsuarioDAO.loginExists(login, id);
    }
}
