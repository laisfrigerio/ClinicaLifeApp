/**
 * @author Lais Frigério da Silva
 * @data 02.11.2018
 */

package tables;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Procedimento;

public class ProcedimentoTable extends AbstractTableModel {
    private List<Procedimento> procedimentos;
    private final String[] colunas = {"Código", "Nome"};
    
    public ProcedimentoTable(){
         this.procedimentos = new ArrayList(); 
    }

    @Override
    public int getRowCount() {
        return procedimentos.size();
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
        Procedimento atualProcedimento = this.procedimentos.get(row);
        String val = null;
        switch(column){
            case 0: val = Integer.toString(atualProcedimento.getId()); break;
            case 1: val = atualProcedimento.getNome(); break;
            default: System.out.println("Inválide column (Tipo Profissional Table)"); break;
        }
        return val;
    }
    
    public Procedimento getProcedimento(int row){
        return this.procedimentos.get(row);
    }
    
    public void addProcedimento(Procedimento tp){
        this.procedimentos.add(tp);
        fireTableDataChanged();   
    } 
    
    public void addLista(List<Procedimento> lista){
        this.procedimentos = lista;
        fireTableDataChanged();  
    }
    
    public void limpar(){
        this.procedimentos.clear();
        fireTableDataChanged();  
    }
    
    public boolean isEmpty(){
        return this.procedimentos.isEmpty();
    }
}
