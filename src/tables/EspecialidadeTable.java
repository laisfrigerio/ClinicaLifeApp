/**
 * @author Lais Frigério da Silva
 * @data 27.10.2018
 */

package tables;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Especialidade;


public class EspecialidadeTable extends AbstractTableModel {
    private List<Especialidade> especialidades;
    private final String[] colunas = {"Código", "Nome"};
    
    public EspecialidadeTable(){
         this.especialidades = new ArrayList(); 
    }

    @Override
    public int getRowCount() {
        return especialidades.size();
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
        Especialidade atualTipoProfissional = this.especialidades.get(row);
        String val = null;
        switch(column){
            case 0: val = Integer.toString(atualTipoProfissional.getId()); break;
            case 1: val = atualTipoProfissional.getNome(); break;
            default: System.out.println("Inválide column (Tipo Profissional Table)"); break;
        }
        return val;
    }
    
    public Especialidade getEspecialidade(int row){
        return this.especialidades.get(row);
    }
    
    public void addEspecialidade(Especialidade tp){
        this.especialidades.add(tp);
        fireTableDataChanged();   
    } 
    
    public void addLista(List<Especialidade> lista){
        this.especialidades = lista;
        fireTableDataChanged();  
    }
    
    public void limpar(){
        this.especialidades.clear();
        fireTableDataChanged();  
    }
    
    public boolean isEmpty(){
        return this.especialidades.isEmpty();
    }
}
