/**
 * @author Lais Frigério da Silva
 */

package tables;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Formatacao;
import model.Paciente;

public class PacienteTable extends AbstractTableModel {
    private List<Paciente> pacientes;
    private String[] colunas = {"Código", "Nome", "CPF", "Data de Nascimento"};
    
    public PacienteTable(){
        pacientes = new ArrayList();
    }
    
    @Override
    public int getRowCount() {
        return pacientes.size();
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
        Paciente atualPaciente = this.pacientes.get(row);
        String val = null;
        switch(column){
            case 0: val = Integer.toString(atualPaciente.getId()); break;
            case 1: val = atualPaciente.getNome(); break;
            case 2: val = Formatacao.setCPFmask(atualPaciente.getCPF()); break;
            case 3: val = Formatacao.setDateMask(atualPaciente.getDataNasc()); break;
            default: System.out.println("Inválide column (Paciente Table)"); break;
        }
        return val;
    }
    
    public Paciente getPaciente(int row){
        return this.pacientes.get(row);
    }
    
    public void addPaciente(Paciente u){
        this.pacientes.add(u);
        fireTableDataChanged();   
    } 
    
    public void addLista(List<Paciente> lista){
        this.pacientes = lista;
        fireTableDataChanged();  
    }
    
    public void limpar(){
        this.pacientes.clear();
        fireTableDataChanged();  
    }
    
    public boolean isEmpty(){
        return this.pacientes.isEmpty();
    }
}
