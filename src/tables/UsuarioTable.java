/**
 * @author Lais Frigério da Silva
 */

package tables;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Usuario;

public class UsuarioTable extends AbstractTableModel {
    private List<Usuario> usuarios;
    private final String[] colunas = {"Código", "Nome", "Login"};
    
    public UsuarioTable(){
         this.usuarios = new ArrayList(); 
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
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
        Usuario atualUsuario = this.usuarios.get(row);
        String val = null;
        switch(column){
            case 0: val = Integer.toString(atualUsuario.getId()); break;
            case 1: val = atualUsuario.getNome(); break;
            case 2: val = atualUsuario.getLogin(); break;
            default: System.out.println("Inválide column (Usuario Table)"); break;
        }
        return val;
    }
    
    public Usuario getUsuario(int row){
        return this.usuarios.get(row);
    }
    
    public void addUsuario(Usuario u){
        this.usuarios.add(u);
        fireTableDataChanged();   
    } 
    
    public void addLista(List<Usuario> lista){
        this.usuarios = lista;
        fireTableDataChanged();  
    }
    
    public void limpar(){
        this.usuarios.clear();
        fireTableDataChanged();  
    }
    
    public boolean isEmpty(){
        return this.usuarios.isEmpty();
    }
}
