/**
 * @author Lais Frigério da Silva
 */

package interfaces;

import model.Profissional;
import model.Consulta;
import model.Paciente;

public interface TelaAntecedente {
    
    public void setPaciente(Paciente p);
    
    public Paciente getPaciente();
    
    public void setProfissional(Profissional p);
    
    public Profissional getProfissional();
    
    public void setConsulta(Consulta c);
    
    public Consulta getConsulta();
    
    public void setNomePaciente(String n);
  
    public void setCodigoPaciente(int c);
    
    public void setNomeProfissional(String n);
    
    public void setCodigoProfissional(int c);

    public void setSessoes(int s);
    
    public void setCodigoConsulta(int c);
    
    public void setNomeProcedimento(String p);
}
