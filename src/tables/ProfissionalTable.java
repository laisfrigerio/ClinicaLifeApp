/**
 * @author Lais Frigério da Silva
 */

package tables;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Profissional;

public class ProfissionalTable extends AbstractTableModel {
    private List<Profissional> fisioterapeutas;
    private final String[] colunas = {"Código", "Nome", "Especialidade", "Login"};
    
    public ProfissionalTable(){
         this.fisioterapeutas = new ArrayList(); 
    }

    @Override
    public int getRowCount() {
        return fisioterapeutas.size();
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
        Profissional atualProfissional = this.fisioterapeutas.get(row);
        String val = null;
        switch(column){
            case 0: val = Integer.toString(atualProfissional.getId()); break;
            case 1: val = atualProfissional.getUsuario().getNome(); break;
            case 2: val = atualProfissional.getEspecialidade() != null 
                    ? atualProfissional.getEspecialidade().getNome() 
                    : ""; break;
            case 3: val = atualProfissional.getUsuario().getLogin(); break;
            default: System.out.println("Inválide column (Fisioterapeuta Table)"); break;
        }
        return val;
    }
    
    public Profissional getFisioterapeuta(int row){
        return this.fisioterapeutas.get(row);
    }
    
    public void addFisioterapeuta(Profissional u){
        this.fisioterapeutas.add(u);
        fireTableDataChanged();   
    } 
    
    public void addLista(List<Profissional> lista){
        this.fisioterapeutas = lista;
        fireTableDataChanged();  
    }
    
    public void limpar(){
        this.fisioterapeutas.clear();
        fireTableDataChanged();  
    }
    
    public boolean isEmpty(){
        return this.fisioterapeutas.isEmpty();
    }
}
