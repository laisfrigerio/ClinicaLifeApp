package view;

import model.MD5;
import controller.UsuarioController;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import model.Usuario;
import model.Validacao;

public class Login extends javax.swing.JFrame {
    
    int clickFirst;
    
    public Login() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/user_24.png")).getImage());
        this.setTitle("Login");
        clickFirst = 0;
        tpassword.setText("senha");
        Error.setVisible(false);
        progress.setVisible(false);
        //this.setMaximumSize(screenSize);
        //this.setMinimumSize(screenSize);
        this.getContentPane().setBackground(Color.white); 
        //this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tlogin = new javax.swing.JTextField();
        bottao = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tpassword = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        Error = new javax.swing.JPanel();
        errorLabel = new javax.swing.JLabel();
        progress = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(470, 200));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginPanel.setBackground(new java.awt.Color(247, 247, 247));
        loginPanel.setPreferredSize(new java.awt.Dimension(380, 350));
        loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        loginPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 130));

        tlogin.setBackground(new java.awt.Color(247, 247, 247));
        tlogin.setFont(new java.awt.Font("Roboto Th", 0, 20)); // NOI18N
        tlogin.setText("Usuário");
        tlogin.setBorder(null);
        tlogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tloginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tloginFocusLost(evt);
            }
        });
        tlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tloginMouseClicked(evt);
            }
        });
        tlogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tloginKeyTyped(evt);
            }
        });
        loginPanel.add(tlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 263, -1));

        bottao.setActionCommand("button");
        bottao.setBackground(new java.awt.Color(0, 102, 52));
        bottao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bottao.setForeground(new java.awt.Color(255, 255, 255));
        bottao.setLabel("Acessar");
        bottao.setName("Acessar"); // NOI18N
        bottao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bottaoMouseClicked(evt);
            }
        });
        bottao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bottaoKeyPressed(evt);
            }
        });
        loginPanel.add(bottao, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 80, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/padlock.png"))); // NOI18N
        loginPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 110, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/user_1.png"))); // NOI18N
        loginPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 110, 70));

        tpassword.setBackground(new java.awt.Color(247, 247, 247));
        tpassword.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tpassword.setText("jPasswordField1");
        tpassword.setBorder(null);
        tpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tpasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tpasswordFocusLost(evt);
            }
        });
        loginPanel.add(tpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 260, 20));

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator2.setForeground(new java.awt.Color(247, 247, 247));
        loginPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 260, -1));

        jSeparator3.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator3.setForeground(new java.awt.Color(247, 247, 247));
        loginPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 260, -1));

        Error.setBackground(new java.awt.Color(247, 247, 247));

        errorLabel.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText("Atenção: Usuário não encontrado!");

        javax.swing.GroupLayout ErrorLayout = new javax.swing.GroupLayout(Error);
        Error.setLayout(ErrorLayout);
        ErrorLayout.setHorizontalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addComponent(errorLabel)
                .addGap(0, 5, Short.MAX_VALUE))
        );
        ErrorLayout.setVerticalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorLabel)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        loginPanel.add(Error, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        progress.setBackground(new java.awt.Color(247, 247, 247));
        progress.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loader_little_gif.gif"))); // NOI18N
        progress.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        loginPanel.add(progress, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 70, 50));

        getContentPane().add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 370));

        jPanel4.setPreferredSize(new java.awt.Dimension(380, 350));

        jLabel1.setText("hi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(255, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(177, 177, 177))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel1)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 210));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tloginMouseClicked
        if(tlogin.getText().equals("Usuário"))
            tlogin.setText("");
    }//GEN-LAST:event_tloginMouseClicked

    private void tloginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tloginFocusLost
        if(tlogin.getText().equals(""))
            tlogin.setText("Usuário");
    }//GEN-LAST:event_tloginFocusLost

    private void tloginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tloginFocusGained
        if(clickFirst == 0) {
            clickFirst = 1;
        } else if(tlogin.getText().equals("Usuário"))
            tlogin.setText("");
    }//GEN-LAST:event_tloginFocusGained

    private void tloginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tloginKeyTyped
        if(tlogin.getText().equals("Usuário")) {
            tlogin.setText("");
        }
    }//GEN-LAST:event_tloginKeyTyped

    private void tpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tpasswordFocusLost
        String pass = new String(tpassword.getPassword());
        if(pass.equals(""))
        tpassword.setText("senha");
    }//GEN-LAST:event_tpasswordFocusLost

    private void tpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tpasswordFocusGained
        String pass = new String(tpassword.getPassword());
        if(pass.equals("senha"))
        tpassword.setText("");
    }//GEN-LAST:event_tpasswordFocusGained

    private void bottaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bottaoMouseClicked
        this.doLogin();
    }//GEN-LAST:event_bottaoMouseClicked

    private void bottaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bottaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           this.doLogin();
        }
    }//GEN-LAST:event_bottaoKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    private void doLogin()
    {
        MD5 md5 = new MD5();
        String login = tlogin.getText();
        String senha = new String(tpassword.getPassword());
        if(!Validacao.isEmpty(login) && !Validacao.isEmpty(senha)){
            Usuario u = new Usuario();  
            senha = md5.md5(senha);
            u.setSenha(senha);
            u.setLogin(login);
            UsuarioController uc = new UsuarioController();
            u = uc.login(u.getLogin(), u.getSenha());
            if(u != null) {
                Main home = new Main(1, "Agenda");
                home.setVisible(true);
                dispose();
            } else {
                progress.setVisible(false);
                Error.setVisible(true);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Error;
    private java.awt.Button bottao;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel progress;
    private javax.swing.JTextField tlogin;
    private javax.swing.JPasswordField tpassword;
    // End of variables declaration//GEN-END:variables
}
