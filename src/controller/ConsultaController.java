/**
 * @author Lais Frigério da Silva
 */

package controller;

import DAO.ConsultaDAO;
import java.util.List;
import model.Consulta;

public class ConsultaController {
    ConsultaDAO fDAO = new ConsultaDAO();
    
    public boolean cadastrar(Consulta consulta){
        return fDAO.cadastrar(consulta);
    }
    
    public boolean editar(Consulta consulta){
        return fDAO.editar(consulta);
    }
    
    public boolean remover(Consulta consulta){
        return true;
    }
    
    public List<Consulta> consultas(){
        return fDAO.consultas();
    }
    
    public List<Consulta> consultas(String busca){
        return fDAO.consultas(busca);
    }
    
    public Consulta consulta(int id){
        return null;
    }
}
