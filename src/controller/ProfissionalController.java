/**
 * @author Lais Frigério da Silva
 */

package controller;

import DAO.ProfissionalDAO;
import java.util.List;
import model.Profissional;

public class ProfissionalController {
    ProfissionalDAO pDAO = new ProfissionalDAO();
    
    public boolean cadastrar(Profissional profissional){
        return pDAO.cadastrar(profissional);
    }
    
    public boolean editar(Profissional profissional){
        return pDAO.editar(profissional);
    }
    
    public boolean remover(Profissional profissional){
        return true;
    }
    
    public List<Profissional> profissionais(){
        return pDAO.profissionais();
    }
    
    public List<Profissional> profissionais(String busca){
        return pDAO.profissionais(busca);
    }
    
    public Profissional profissional(int id){
        return null;
    }
}
