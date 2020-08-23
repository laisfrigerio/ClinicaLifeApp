/**
 * @author Lais Frigério da Silva
 */

package clinicalife;

import javax.swing.UIManager;
import view.Login;

public class ClinicaLife {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        Login login = new Login();
        login.setVisible(true);
    }
    
}
