/**
 * @author Lais Frigério da Silva
 */

package view.profissional;

import controller.ProfissionalController;
import interfaces.TelaAntecedente;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import model.Profissional;
import model.Validacao;
import tables.ProfissionalTable;
import view.FixedButtonModel;

public class BuscarProfissional extends javax.swing.JFrame {
    private final TelaAntecedente telaAntecedente;
    private final ProfissionalTable tableModelProfissional = new ProfissionalTable();
    private final ProfissionalController fc = new ProfissionalController();

    public BuscarProfissional(TelaAntecedente ta) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/doctor.png")).getImage());
        bOkFisioterapeuta.setModel(new FixedButtonModel());
        bOkFisioterapeuta.setBorder(BorderFactory.createEtchedBorder(0));
        bCancelarFsioterapeuta.setModel(new FixedButtonModel());
        bCancelarFsioterapeuta.setBorder(BorderFactory.createEtchedBorder(0));
        tBuscarProfissional.setModel(new FixedButtonModel());
        tBuscarProfissional.setBorder(BorderFactory.createEtchedBorder(0));
        scrollPanelPaciente.getViewport().setBackground(Color.WHITE);
        scrollPanelPaciente.setBorder(BorderFactory.createEmptyBorder());
        tableFisioterapeutas.setShowVerticalLines(false);
        tableFisioterapeutas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableFisioterapeutas.getColumnModel().getColumn(0).setPreferredWidth(10);
        tableFisioterapeutas.getColumnModel().getColumn(1).setPreferredWidth(270);
        tableFisioterapeutas.getColumnModel().getColumn(2).setPreferredWidth(10);
        tableFisioterapeutas.getColumnModel().getColumn(3).setPreferredWidth(10);
        List<Profissional> lista = fc.profissionais();
        if(lista!=null) {
            tableModelProfissional.addLista(lista);
        }
        tableFisioterapeutas.setModel(tableModelProfissional);
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("Button.focus", new ColorUIResource(new Color(0,0,0,0)));
        this.telaAntecedente = ta;
        this.setTitle("Buscar Profissional");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        input = new javax.swing.JPanel();
        lPesquisar = new javax.swing.JLabel();
        tPesquisar = new javax.swing.JTextField();
        bOkFisioterapeuta = new javax.swing.JButton();
        bCancelarFsioterapeuta = new javax.swing.JButton();
        tBuscarProfissional = new javax.swing.JButton();
        mainPaciente = new javax.swing.JPanel();
        scrollPanelPaciente = new javax.swing.JScrollPane();
        tableFisioterapeutas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Paciente");
        setMinimumSize(new java.awt.Dimension(600, 230));
        setResizable(false);

        bg.setBackground(new java.awt.Color(247, 247, 247));

        input.setBackground(new java.awt.Color(247, 247, 247));

        lPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lPesquisar.setText("Pesquisar");
        lPesquisar.setMaximumSize(new java.awt.Dimension(40, 20));
        lPesquisar.setMinimumSize(new java.awt.Dimension(40, 20));
        lPesquisar.setPreferredSize(new java.awt.Dimension(40, 20));

        bOkFisioterapeuta.setBackground(new java.awt.Color(0, 102, 52));
        bOkFisioterapeuta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bOkFisioterapeuta.setForeground(new java.awt.Color(255, 255, 255));
        bOkFisioterapeuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/checked.png"))); // NOI18N
        bOkFisioterapeuta.setText("Ok");
        bOkFisioterapeuta.setBorder(null);
        bOkFisioterapeuta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bOkFisioterapeuta.setDoubleBuffered(true);
        bOkFisioterapeuta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bOkFisioterapeutaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bOkFisioterapeutaFocusLost(evt);
            }
        });
        bOkFisioterapeuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bOkFisioterapeutaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bOkFisioterapeutaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bOkFisioterapeutaMouseExited(evt);
            }
        });

        bCancelarFsioterapeuta.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarFsioterapeuta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarFsioterapeuta.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarFsioterapeuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/error.png"))); // NOI18N
        bCancelarFsioterapeuta.setText("Cancelar");
        bCancelarFsioterapeuta.setBorder(null);
        bCancelarFsioterapeuta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCancelarFsioterapeuta.setDoubleBuffered(true);
        bCancelarFsioterapeuta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bCancelarFsioterapeutaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bCancelarFsioterapeutaFocusLost(evt);
            }
        });
        bCancelarFsioterapeuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelarFsioterapeutaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCancelarFsioterapeutaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCancelarFsioterapeutaMouseExited(evt);
            }
        });
        bCancelarFsioterapeuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bCancelarFsioterapeutaKeyPressed(evt);
            }
        });

        tBuscarProfissional.setBackground(new java.awt.Color(0, 102, 52));
        tBuscarProfissional.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tBuscarProfissional.setForeground(new java.awt.Color(255, 255, 255));
        tBuscarProfissional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        tBuscarProfissional.setText("Pesquisar");
        tBuscarProfissional.setBorder(null);
        tBuscarProfissional.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tBuscarProfissional.setDoubleBuffered(true);
        tBuscarProfissional.setFocusPainted(false);
        tBuscarProfissional.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tBuscarProfissionalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tBuscarProfissionalFocusLost(evt);
            }
        });
        tBuscarProfissional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tBuscarProfissionalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tBuscarProfissionalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tBuscarProfissionalMouseExited(evt);
            }
        });
        tBuscarProfissional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tBuscarProfissionalKeyPressed(evt);
            }
        });

        mainPaciente.setLayout(new java.awt.CardLayout());

        scrollPanelPaciente.setBorder(null);

        tableFisioterapeutas.setAutoCreateRowSorter(true);
        tableFisioterapeutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableFisioterapeutas.setDoubleBuffered(true);
        scrollPanelPaciente.setViewportView(tableFisioterapeutas);

        mainPaciente.add(scrollPanelPaciente, "card2");

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addComponent(lPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tBuscarProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bOkFisioterapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelarFsioterapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tBuscarProfissional, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(mainPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOkFisioterapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarFsioterapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

    private void bOkFisioterapeutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkFisioterapeutaMouseClicked
        int row = this.tableFisioterapeutas.getSelectedRow();
        if(row > -1){
            Profissional f = this.tableModelProfissional.getFisioterapeuta(row);
            this.telaAntecedente.setProfissional(f);
            this.telaAntecedente.setNomeProfissional(f.getUsuario().getNome());
            this.telaAntecedente.setCodigoProfissional(f.getId());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um(a) fisioterapeuta da tabela", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bOkFisioterapeutaMouseClicked

    private void bOkFisioterapeutaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkFisioterapeutaMouseEntered
        bOkFisioterapeuta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bOkFisioterapeutaMouseEntered

    private void bOkFisioterapeutaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkFisioterapeutaMouseExited
        bOkFisioterapeuta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bOkFisioterapeutaMouseExited

    private void bCancelarFsioterapeutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarFsioterapeutaMouseClicked
        this.dispose();
    }//GEN-LAST:event_bCancelarFsioterapeutaMouseClicked

    private void bCancelarFsioterapeutaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarFsioterapeutaMouseEntered
        bCancelarFsioterapeuta.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarFsioterapeutaMouseEntered

    private void bCancelarFsioterapeutaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarFsioterapeutaMouseExited
        bCancelarFsioterapeuta.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarFsioterapeutaMouseExited

    private void bCancelarFsioterapeutaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarFsioterapeutaFocusGained
        bCancelarFsioterapeuta.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarFsioterapeutaFocusGained

    private void bCancelarFsioterapeutaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarFsioterapeutaFocusLost
        bCancelarFsioterapeuta.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarFsioterapeutaFocusLost

    private void bOkFisioterapeutaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bOkFisioterapeutaFocusGained
        bOkFisioterapeuta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bOkFisioterapeutaFocusGained

    private void bOkFisioterapeutaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bOkFisioterapeutaFocusLost
        bOkFisioterapeuta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bOkFisioterapeutaFocusLost

    private void bCancelarFsioterapeutaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarFsioterapeutaKeyPressed
        this.dispose();
    }//GEN-LAST:event_bCancelarFsioterapeutaKeyPressed

    private void tBuscarProfissionalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBuscarProfissionalMouseEntered
        tBuscarProfissional.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_tBuscarProfissionalMouseEntered

    private void tBuscarProfissionalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBuscarProfissionalMouseExited
        tBuscarProfissional.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_tBuscarProfissionalMouseExited

    private void tBuscarProfissionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBuscarProfissionalMouseClicked
        this.search();
    }//GEN-LAST:event_tBuscarProfissionalMouseClicked

    private void tBuscarProfissionalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tBuscarProfissionalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.search();
        }
    }//GEN-LAST:event_tBuscarProfissionalKeyPressed

    private void tBuscarProfissionalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tBuscarProfissionalFocusGained
        tBuscarProfissional.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_tBuscarProfissionalFocusGained

    private void tBuscarProfissionalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tBuscarProfissionalFocusLost
        tBuscarProfissional.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_tBuscarProfissionalFocusLost

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
            java.util.logging.Logger.getLogger(BuscarProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelarFsioterapeuta;
    private javax.swing.JButton bOkFisioterapeuta;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel input;
    private javax.swing.JLabel lPesquisar;
    private javax.swing.JPanel mainPaciente;
    private javax.swing.JScrollPane scrollPanelPaciente;
    private javax.swing.JButton tBuscarProfissional;
    private javax.swing.JTextField tPesquisar;
    private javax.swing.JTable tableFisioterapeutas;
    // End of variables declaration//GEN-END:variables

    private void search() {
        String busca = this.tPesquisar.getText();
        List<Profissional> lista;
        lista = !Validacao.isEmpty(busca) ? fc.profissionais(busca) : fc.profissionais();
        if(lista != null)
            this.tableModelProfissional.addLista(lista);
        this.tPesquisar.requestFocusInWindow();
        tBuscarProfissional.setBackground(Color.decode("#006634"));
    }
}
