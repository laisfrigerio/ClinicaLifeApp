/**
 * @author Lais Frigério da Silva
 */

package tables;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Consulta;

public class ConsultaTable extends AbstractTableModel {
    private List<Consulta> consultas;
    private final String[] colunas = {"Código", "Paciente", "Procedimento", "Valor", "Quantidade de Sessões"};
    
    public ConsultaTable(){
         this.consultas = new ArrayList(); 
    }

    @Override
    public int getRowCount() {
        return this.consultas.size();
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
        Consulta atualConsulta = this.consultas.get(row);
        String val = null;
        switch(column){
            case 0: val = Integer.toString(atualConsulta.getId()); break;
            case 1: val = atualConsulta.getPaciente().getNome(); break;
            case 2: val = atualConsulta.getProcedimento() == null ? "" : atualConsulta.getProcedimento().getNome(); break;
            case 3: val = Double.toString(atualConsulta.getValor()); break;
            case 4: val = Integer.toString(atualConsulta.getQntdSessao()); break;
            default: System.out.println("Inválide column (Consulta Table)"); break;
        }
        return val;
    }
    
    public Consulta getConsulta(int row){
        return this.consultas.get(row);
    }
    
    public void addConsulta(Consulta u){
        this.consultas.add(u);
        fireTableDataChanged();   
    } 
    
    public void addLista(List<Consulta> lista){
        this.consultas = lista;
        fireTableDataChanged();  
    }
    
    public void limpar(){
        this.consultas.clear();
        fireTableDataChanged();  
    }
    
    public boolean isEmpty(){
        return this.consultas.isEmpty();
    }
}
