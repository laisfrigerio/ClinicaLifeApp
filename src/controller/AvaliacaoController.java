/**
 * @author Lais Frigério da Silva
 */

package controller;

import DAO.AvaliacaoDAO;
import java.util.List;
import model.Avaliacao;

public class AvaliacaoController {
    AvaliacaoDAO aDAO = new AvaliacaoDAO();
    
    public boolean cadastrar(Avaliacao avaliacao){
        return aDAO.cadastrar(avaliacao);
    }
    
    public boolean editar(Avaliacao avaliacao){
        return aDAO.editar(avaliacao);
    }
    
    public boolean remover(Avaliacao avaliacao){
        return true;
    }
    
    public List<Avaliacao> avaliacoes(){
        return aDAO.avaliacoes();
    }
    
    public List<Avaliacao> avaliacoes(String busca){
        return aDAO.avaliacoes(busca);
    }
    
    public Avaliacao avaliacao(int id){
        return null;
    }
}
