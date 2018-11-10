package controller;

import DAO.ProcedimentoDAO;
import java.util.List;
import model.Procedimento;

/**
 *
 * @author Lais Frigério da Silva | 02.11.2018
 */
public class ProcedimentoController {
    private final ProcedimentoDAO pDAO;
    
    public ProcedimentoController() {
        this.pDAO = new ProcedimentoDAO();
    }
    
    public boolean cadastrar(Procedimento p){
        return pDAO.cadastrar(p);
    }
    
    public boolean editar(Procedimento p){
        return pDAO.editar(p);
    }
    
    public boolean remover(Procedimento p){
        return pDAO.remover(p);
    }
    
    public List<Procedimento> procedimentos(){
        return pDAO.procedimentos();
    }
    
    public List<Procedimento> procedimentos(String busca){
        return pDAO.procedimentos(busca);
    }
    
    public Procedimento procedimento(int id){
        return null;
    }
}
