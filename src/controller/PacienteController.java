/**
 * @author Lais Frigério da Silva
 */

package controller;

import DAO.PacienteDAO;
import java.util.List;
import model.Paciente;

public class PacienteController {
    PacienteDAO pDAO = new PacienteDAO();
    
    public boolean cadastrar(Paciente cliente){
        return pDAO.cadastrar(cliente);
    }
    
    public boolean editar(Paciente cliente){
        return pDAO.editar(cliente);
    }
    
    public boolean remover(Paciente cliente){
        return pDAO.remover(cliente);
    }
    
    public List<Paciente> pacientes(){
        return pDAO.pacientes();
    }
    
    public List<Paciente> pacientes(String busca){
        return pDAO.pacientes(busca);
    }
    
    public Paciente pacientes(int id){
        return null;
    }
    
    public static boolean CPFexists(String cpf, int id) {
        return PacienteDAO.CPFexists(cpf, id);
    }
}
