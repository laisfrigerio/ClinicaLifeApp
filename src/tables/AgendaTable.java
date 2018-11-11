/**
 * @author Lais Frigério da Silva
 */

package tables;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Agenda;
import model.Formatacao;
import model.Horario;

public class AgendaTable extends AbstractTableModel{
    private List<Horario> agenda;
    private final String[] colunas = {"Horário", "Paciente","Paciente", "Paciente", "Paciente", "Paciente"};
    
     public AgendaTable(){
         this.agenda = new ArrayList(); 
    }
     
    @Override
    public int getRowCount() {
        return this.agenda.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    } 

    @Override
    public Object getValueAt(int row, int column) {
        Horario atualAgenda = this.agenda.get(row);
        String val = null;
        switch(column){
            case 0: val = Formatacao.time2StringNoSec(atualAgenda.getHora()); break;
            case 1: 
                val = this.getVal(atualAgenda, 1);
                break;
            case 2: 
                val = this.getVal(atualAgenda, 2);
                break;
            case 3: 
                val = this.getVal(atualAgenda, 3);
                break;
            case 4: 
                val = this.getVal(atualAgenda, 4);
                break;
            case 5: 
                val = this.getVal(atualAgenda, 5);
                break;
            default: System.out.println("Inválide column (Agenda Table)"); break;
        }
        return val;
    }
    
    public Horario getHorario(int row) {
        return this.agenda.get(row);
    }
    
    public Agenda getAgendamento(int row, int column){
        return this.agenda.get(row).getAgendamento(column);
    }
    
    public void addLista(List<Horario> horarios) {
        this.agenda = horarios;
    }
    
    public void limpar(){
        this.agenda.clear();
        fireTableDataChanged();  
    }
    
    public boolean isEmpty(){
        return this.agenda.isEmpty();
    } 
    
    private String getVal(Horario a, int row) {
        if(a.getAgendamento(row).getConsulta() != null && a.getAgendamento(row).getConsulta().getPaciente() != null) {
            return a.getAgendamento(row).getConsulta().getPaciente().getNome();
        } else  {
            return ""; 
        }
    }
    
}
