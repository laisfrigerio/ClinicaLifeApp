/**
 * @author Lais Frigério da Silva
 */

package tables;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Avaliacao;
import model.Formatacao;

public class AvaliacaoTable extends AbstractTableModel {
    private List<Avaliacao> avaliacoes;
    private final String[] colunas = {"Código", "Profissional", "Cliente", "Data"};
    
    public AvaliacaoTable(){
         this.avaliacoes = new ArrayList(); 
    }

    @Override
    public int getRowCount() {
        return this.avaliacoes.size();
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
        Avaliacao atualAvaliacao = this.avaliacoes.get(row);
        String val = null;
        switch(column){
            case 0: val = Integer.toString(atualAvaliacao.getId()); break;
            case 1: val = atualAvaliacao.getFisioterapeuta().getUsuario().getNome(); break;
            case 2: val = atualAvaliacao.getPaciente().getNome(); break;
            case 3: val = Formatacao.setDateMask(atualAvaliacao.getDataAvaliacao()); break;
            default: System.out.println("Inválide column (Avaliacao Table)"); break;
        }
        return val;
    }
    
    public Avaliacao getAvaliacao(int row){
        return this.avaliacoes.get(row);
    }
    
    public void addAvaliacao(Avaliacao u){
        this.avaliacoes.add(u);
        fireTableDataChanged();   
    } 
    
    public void addLista(List<Avaliacao> lista){
        this.avaliacoes = lista;
        fireTableDataChanged();  
    }
    
    public void limpar(){
        this.avaliacoes.clear();
        fireTableDataChanged();  
    }
    
    public boolean isEmpty(){
        return this.avaliacoes.isEmpty();
    }
}
