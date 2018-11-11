/**
 * @author Lais Frigério da Silva
 */

package view.usuario;

import model.MD5;
import controller.UsuarioController;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import model.Usuario;
import model.Validacao;
import view.FixedButtonModel;
import view.Main;

public class NovoUsuario extends javax.swing.JFrame {
    private final Main tela;

    public NovoUsuario(Main tela) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/user_24.png")).getImage());
        bSalvarUsuario.setModel(new FixedButtonModel());
        bSalvarUsuario.setBorder(BorderFactory.createEtchedBorder(0));
        bCancelarUsuario.setModel(new FixedButtonModel());
        bCancelarUsuario.setBorder(BorderFactory.createEtchedBorder(0));
        UIManager.put("Button.focus", new ColorUIResource(new Color(0,0,0,0)));
        UIManager.put("OptionPane.background",new ColorUIResource(255,255,255));
        UIManager.put("Panel.background",new ColorUIResource(255,255,255));
        UIManager.put("Button.background", Color.WHITE);
        this.tela = tela;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        input = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lNomeUsuario = new javax.swing.JTextField();
        lLoginUsuario = new javax.swing.JTextField();
        bSalvarUsuario = new javax.swing.JButton();
        bCancelarUsuario = new javax.swing.JButton();
        lSenhaUsuario = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Usuário");
        setMinimumSize(new java.awt.Dimension(600, 230));
        setResizable(false);

        bg.setBackground(new java.awt.Color(247, 247, 247));

        input.setBackground(new java.awt.Color(247, 247, 247));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(211, 0, 0));
        jLabel5.setText("*");
        jLabel5.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel5.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel5.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Nome");
        jLabel1.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel1.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel1.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(211, 0, 0));
        jLabel6.setText("*");
        jLabel6.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel6.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel6.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Login");
        jLabel2.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel2.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel2.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(211, 0, 0));
        jLabel7.setText("*");
        jLabel7.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel7.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel7.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Senha");
        jLabel3.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel3.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel3.setPreferredSize(new java.awt.Dimension(40, 20));

        bSalvarUsuario.setBackground(new java.awt.Color(0, 102, 52));
        bSalvarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bSalvarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        bSalvarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/checked.png"))); // NOI18N
        bSalvarUsuario.setText("Salvar");
        bSalvarUsuario.setBorder(null);
        bSalvarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSalvarUsuario.setDoubleBuffered(true);
        bSalvarUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bSalvarUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bSalvarUsuarioFocusLost(evt);
            }
        });
        bSalvarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSalvarUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bSalvarUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bSalvarUsuarioMouseExited(evt);
            }
        });
        bSalvarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bSalvarUsuarioKeyPressed(evt);
            }
        });

        bCancelarUsuario.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/error.png"))); // NOI18N
        bCancelarUsuario.setText("Cancelar");
        bCancelarUsuario.setBorder(null);
        bCancelarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCancelarUsuario.setDoubleBuffered(true);
        bCancelarUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bCancelarUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bCancelarUsuarioFocusLost(evt);
            }
        });
        bCancelarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelarUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCancelarUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCancelarUsuarioMouseExited(evt);
            }
        });
        bCancelarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bCancelarUsuarioKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addComponent(lLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(bSalvarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lSenhaUsuario))
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalvarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(bg, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSalvarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarUsuarioMouseClicked
        this.create();
    }//GEN-LAST:event_bSalvarUsuarioMouseClicked

    private void bSalvarUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarUsuarioMouseEntered
        bSalvarUsuario.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarUsuarioMouseEntered

    private void bSalvarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarUsuarioMouseExited
        bSalvarUsuario.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarUsuarioMouseExited

    private void bCancelarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarUsuarioMouseClicked
        this.dispose();
    }//GEN-LAST:event_bCancelarUsuarioMouseClicked

    private void bCancelarUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarUsuarioMouseEntered
        bCancelarUsuario.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarUsuarioMouseEntered

    private void bCancelarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarUsuarioMouseExited
        bCancelarUsuario.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarUsuarioMouseExited

    private void bCancelarUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarUsuarioFocusGained
        bCancelarUsuario.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarUsuarioFocusGained

    private void bCancelarUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarUsuarioFocusLost
        bCancelarUsuario.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarUsuarioFocusLost

    private void bSalvarUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarUsuarioFocusGained
        bSalvarUsuario.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarUsuarioFocusGained

    private void bSalvarUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarUsuarioFocusLost
        bSalvarUsuario.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarUsuarioFocusLost

    private void bCancelarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.dispose();
        }
    }//GEN-LAST:event_bCancelarUsuarioKeyPressed

    private void bSalvarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bSalvarUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.create();
        }
    }//GEN-LAST:event_bSalvarUsuarioKeyPressed

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
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelarUsuario;
    private javax.swing.JButton bSalvarUsuario;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField lLoginUsuario;
    private javax.swing.JTextField lNomeUsuario;
    private javax.swing.JPasswordField lSenhaUsuario;
    // End of variables declaration//GEN-END:variables

    private void create() {
        String senha = new String(lSenhaUsuario.getPassword());
        String nome = lNomeUsuario.getText();
        String login = lLoginUsuario.getText();
        if(Validacao.isEmpty(nome) || Validacao.isEmpty(login) || Validacao.isEmpty(senha)) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (!Validacao.isLessOrEqualThan(nome, 200)) {
            JOptionPane.showMessageDialog(null, "O campo nome deve ter no máximo 200 caracteres", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (!Validacao.isLessOrEqualThan(login, 20)) {
            JOptionPane.showMessageDialog(null, "O campo login deve ter no máximo 20 caracteres", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (!Validacao.isLessOrEqualThan(senha, 20)) {
            JOptionPane.showMessageDialog(null, "O campo senha deve ter no máximo 20 caracteres", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            MD5 md5 = new MD5();
            Usuario u = new Usuario();
            UsuarioController uc = new UsuarioController();
            senha = md5.md5(senha);
            u.setNome(nome);
            u.setLogin(login);           
            u.setSenha(senha);
            u.setTipoFunc(1);
            if (uc.cadastrar(u)) {
                JOptionPane.showMessageDialog(null, "O cadastro foi efetuado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                List<Usuario> lista = uc.usuarios();
                if(lista != null) {
                    this.tela.tableModelUsuario.addLista(lista);
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar o cadastro. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
