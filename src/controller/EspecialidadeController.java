/**
 * @author Lais Frigério da Silva
 */

package controller;

import DAO.EspecialidadeDAO;
import java.util.List;
import model.Especialidade;

/**
 *
 * @author Lais Frigério Da Silva | 27.10.2018
 */
public class EspecialidadeController {
    private final EspecialidadeDAO eDAO;
    
    public EspecialidadeController() {
        this.eDAO = new EspecialidadeDAO();
    }
    
    public boolean cadastrar(Especialidade e){
        return eDAO.cadastrar(e);
    }
    
    public boolean editar(Especialidade e){
        return eDAO.editar(e);
    }
    
    public boolean remover(Especialidade e){
        return eDAO.remover(e);
    }
    
    public List<Especialidade> especialidades(){
        return eDAO.especialidades();
    }
    
    public List<Especialidade> especialidades(String busca){
        return eDAO.especialidades(busca);
    }
}
