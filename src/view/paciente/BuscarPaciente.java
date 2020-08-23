/**
 * @author Lais Frigério da Silva
 */

package view.paciente;

import controller.PacienteController;
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
import model.Formatacao;
import model.Paciente;
import model.Validacao;
import tables.PacienteTable;
import view.FixedButtonModel;

public class BuscarPaciente extends javax.swing.JFrame {
    private final TelaAntecedente telaAtecedente;
    private final PacienteTable tableModelPaciente = new PacienteTable();
    private final PacienteController pc = new PacienteController();

    public BuscarPaciente(TelaAntecedente ta) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/doctor.png")).getImage());
        bOkPaciente.setModel(new FixedButtonModel());
        bOkPaciente.setBorder(BorderFactory.createEtchedBorder(0));
        bCancelarPaciente.setModel(new FixedButtonModel());
        bCancelarPaciente.setBorder(BorderFactory.createEtchedBorder(0));
        tBuscarPaciente.setModel(new FixedButtonModel());
        tBuscarPaciente.setBorder(BorderFactory.createEtchedBorder(0));
        scrollPanelPaciente.getViewport().setBackground(Color.WHITE);
        scrollPanelPaciente.setBorder(BorderFactory.createEmptyBorder());
        tablePacientes.setShowVerticalLines(false);
        tablePacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablePacientes.getColumnModel().getColumn(0).setPreferredWidth(10);
        tablePacientes.getColumnModel().getColumn(1).setPreferredWidth(270);
        tablePacientes.getColumnModel().getColumn(2).setPreferredWidth(10);
        tablePacientes.getColumnModel().getColumn(3).setPreferredWidth(10);
        UIManager.put("OptionPane.background",new ColorUIResource(255,255,255));
        UIManager.put("Panel.background",new ColorUIResource(255,255,255));
        UIManager.put("Button.background", Color.WHITE);
        List<Paciente> lista = pc.pacientes();
        if(lista!=null) {
            tableModelPaciente.addLista(lista);
        }
        tablePacientes.setModel(tableModelPaciente);
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("Button.focus", new ColorUIResource(new Color(0,0,0,0)));
        this.telaAtecedente = ta;
        this.setTitle("Buscar Paciente");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        input = new javax.swing.JPanel();
        lPesquisar = new javax.swing.JLabel();
        tPesquisar = new javax.swing.JTextField();
        bOkPaciente = new javax.swing.JButton();
        bCancelarPaciente = new javax.swing.JButton();
        tBuscarPaciente = new javax.swing.JButton();
        mainPaciente = new javax.swing.JPanel();
        scrollPanelPaciente = new javax.swing.JScrollPane();
        tablePacientes = new javax.swing.JTable();

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

        bOkPaciente.setBackground(new java.awt.Color(0, 102, 52));
        bOkPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bOkPaciente.setForeground(new java.awt.Color(255, 255, 255));
        bOkPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/checked.png"))); // NOI18N
        bOkPaciente.setText("Ok");
        bOkPaciente.setBorder(null);
        bOkPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bOkPaciente.setDoubleBuffered(true);
        bOkPaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bOkPacienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bOkPacienteFocusLost(evt);
            }
        });
        bOkPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bOkPacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bOkPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bOkPacienteMouseExited(evt);
            }
        });

        bCancelarPaciente.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/error.png"))); // NOI18N
        bCancelarPaciente.setText("Cancelar");
        bCancelarPaciente.setBorder(null);
        bCancelarPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bCancelarPaciente.setDoubleBuffered(true);
        bCancelarPaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bCancelarPacienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bCancelarPacienteFocusLost(evt);
            }
        });
        bCancelarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelarPacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCancelarPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCancelarPacienteMouseExited(evt);
            }
        });
        bCancelarPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bCancelarPacienteKeyPressed(evt);
            }
        });

        tBuscarPaciente.setBackground(new java.awt.Color(0, 102, 52));
        tBuscarPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tBuscarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        tBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        tBuscarPaciente.setText("Pesquisar");
        tBuscarPaciente.setBorder(null);
        tBuscarPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tBuscarPaciente.setDoubleBuffered(true);
        tBuscarPaciente.setFocusPainted(false);
        tBuscarPaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tBuscarPacienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tBuscarPacienteFocusLost(evt);
            }
        });
        tBuscarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tBuscarPacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tBuscarPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tBuscarPacienteMouseExited(evt);
            }
        });
        tBuscarPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tBuscarPacienteKeyPressed(evt);
            }
        });

        mainPaciente.setLayout(new java.awt.CardLayout());

        scrollPanelPaciente.setBorder(null);

        tablePacientes.setAutoCreateRowSorter(true);
        tablePacientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePacientes.setDoubleBuffered(true);
        scrollPanelPaciente.setViewportView(tablePacientes);

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
                        .addComponent(tBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bOkPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(tBuscarPaciente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(mainPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOkPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void bOkPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkPacienteMouseClicked
        int row = this.tablePacientes.getSelectedRow();
        if(row > -1){
            Paciente p = this.tableModelPaciente.getPaciente(row);
            this.telaAtecedente.setPaciente(p);
            this.telaAtecedente.setNomePaciente(p.getNome());
            this.telaAtecedente.setCodigoPaciente(p.getId());                  
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um paciente da tabela", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bOkPacienteMouseClicked

    private void bOkPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkPacienteMouseEntered
        bOkPaciente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bOkPacienteMouseEntered

    private void bOkPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkPacienteMouseExited
        bOkPaciente.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bOkPacienteMouseExited

    private void bCancelarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarPacienteMouseClicked
        this.dispose();
    }//GEN-LAST:event_bCancelarPacienteMouseClicked

    private void bCancelarPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarPacienteMouseEntered
        bCancelarPaciente.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarPacienteMouseEntered

    private void bCancelarPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarPacienteMouseExited
        bCancelarPaciente.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarPacienteMouseExited

    private void bCancelarPacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarPacienteFocusGained
        bCancelarPaciente.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarPacienteFocusGained

    private void bCancelarPacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarPacienteFocusLost
        bCancelarPaciente.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarPacienteFocusLost

    private void bOkPacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bOkPacienteFocusGained
        bOkPaciente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bOkPacienteFocusGained

    private void bOkPacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bOkPacienteFocusLost
        bOkPaciente.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bOkPacienteFocusLost

    private void bCancelarPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarPacienteKeyPressed
        this.dispose();
    }//GEN-LAST:event_bCancelarPacienteKeyPressed

    private void tBuscarPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBuscarPacienteMouseEntered
        tBuscarPaciente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_tBuscarPacienteMouseEntered

    private void tBuscarPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBuscarPacienteMouseExited
        tBuscarPaciente.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_tBuscarPacienteMouseExited

    private void tBuscarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBuscarPacienteMouseClicked
        this.search();
    }//GEN-LAST:event_tBuscarPacienteMouseClicked

    private void tBuscarPacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tBuscarPacienteFocusGained
       tBuscarPaciente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_tBuscarPacienteFocusGained

    private void tBuscarPacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tBuscarPacienteFocusLost
        tBuscarPaciente.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_tBuscarPacienteFocusLost

    private void tBuscarPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tBuscarPacienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.search();
        }
    }//GEN-LAST:event_tBuscarPacienteKeyPressed

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
            java.util.logging.Logger.getLogger(BuscarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelarPaciente;
    private javax.swing.JButton bOkPaciente;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel input;
    private javax.swing.JLabel lPesquisar;
    private javax.swing.JPanel mainPaciente;
    private javax.swing.JScrollPane scrollPanelPaciente;
    private javax.swing.JButton tBuscarPaciente;
    private javax.swing.JTextField tPesquisar;
    private javax.swing.JTable tablePacientes;
    // End of variables declaration//GEN-END:variables

    private void search() {
        String busca = this.tPesquisar.getText();
        List<Paciente> lista;
        if(!Validacao.isEmpty(busca)) {
            if(Validacao.isDate(busca))
                busca = Formatacao.removeDateMask(busca);
            lista = pc.pacientes(busca);
            if(lista != null)
                this.tableModelPaciente.addLista(lista);
            else
                this.tableModelPaciente.limpar();
        } else {
            lista = pc.pacientes();
            if(lista != null)
                this.tableModelPaciente.addLista(lista);
            else
                this.tableModelPaciente.limpar();
        }
        this.tPesquisar.requestFocusInWindow();
    }
}
