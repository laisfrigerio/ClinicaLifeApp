/**
 * @author Lais Frigério da Silva
 * @data 29.10.2018
 */

package comboBox;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * @param <E>
 */
public class GenericComboBox<E> extends AbstractListModel<E> implements ComboBoxModel<E> {

    private List<E> lista;
    private E selection;
    
    public List<E> getLista() {
        return this.lista;
    }
    
    public GenericComboBox(List<E> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getSize() {
        return this.lista.size();
    }

    @Override
    public E getElementAt(int index) {
        return this.lista.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
       this.selection = (E) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.selection;
    }
    
}
