/**
 * @author Lais Frigério da Silva
 */

package controller;

import DAO.AgendaDAO;
import java.util.List;
import model.Agenda;
import model.Consulta;
import model.Horario;

public class AgendaController {
    private final AgendaDAO aDAO;
    
    public AgendaController() {
        this.aDAO = new AgendaDAO();
    }
    
    public int cadastrar(Agenda agenda){
        return this.aDAO.cadastrar(agenda);
    }
    
    public boolean editar(Agenda agenda){
        return this.aDAO.editar(agenda);
    }
    
    public boolean excluir(Agenda agenda){
        return this.aDAO.excluir(agenda);
    }
        
    public List<Horario> agendamentos(String busca){
        return this.aDAO.agendamentos(busca);
    }
    
    public List<Horario> agendamentos(String data, String busca) {
        return this.aDAO.agendamentos(data, busca);
    }
    
    public List<Agenda> agendamentos(Consulta c) {
        return this.aDAO.agendamentos(c);
    }
    
    public int checkNumeroSessoesConsulta(Agenda a) {
        return this.aDAO.checkNumeroSessoesConsulta(a);
    }
    
}
