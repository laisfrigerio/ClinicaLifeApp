/**
 * @author Lais Frigério da Silva
 */

package view.consulta;

import com.sun.glass.events.KeyEvent;
import controller.ConsultaController;
import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import model.Validacao;
import interfaces.TelaAntecedente;
import model.Consulta;
import tables.ConsultaTable;
import view.FixedButtonModel;

public class BuscarConsulta extends javax.swing.JFrame {
    private final TelaAntecedente telaAntecendente;
    private final ConsultaTable tableModelConsultas = new ConsultaTable();
    private final ConsultaController cc = new ConsultaController();

    public BuscarConsulta(TelaAntecedente ta) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/physiotherapy.png")).getImage());
        bOkConsulta.setModel(new FixedButtonModel());
        bOkConsulta.setBorder(BorderFactory.createEtchedBorder(0));
        bCancelarConsulta.setModel(new FixedButtonModel());
        bCancelarConsulta.setBorder(BorderFactory.createEtchedBorder(0));
        bBuscarConsulta.setModel(new FixedButtonModel());
        bBuscarConsulta.setBorder(BorderFactory.createEtchedBorder(0));
        scrollPanelConsulta.getViewport().setBackground(Color.WHITE);
        scrollPanelConsulta.setBorder(BorderFactory.createEmptyBorder());
        tableConsultas.setShowVerticalLines(false);
        tableConsultas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableConsultas.getColumnModel().getColumn(0).setPreferredWidth(10);
        tableConsultas.getColumnModel().getColumn(1).setPreferredWidth(270);
        tableConsultas.getColumnModel().getColumn(2).setPreferredWidth(10);
        tableConsultas.getColumnModel().getColumn(3).setPreferredWidth(10);
        List<Consulta> lista = cc.consultas();
        if(lista!=null) {
            tableModelConsultas.addLista(lista);
        }
        tableConsultas.setModel(tableModelConsultas);
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("Button.focus", new ColorUIResource(new Color(0,0,0,0)));
        this.telaAntecendente = ta;
        this.setTitle("Buscar Consulta");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        input = new javax.swing.JPanel();
        lPesquisar = new javax.swing.JLabel();
        tPesquisar = new javax.swing.JTextField();
        bOkConsulta = new javax.swing.JButton();
        bCancelarConsulta = new javax.swing.JButton();
        bBuscarConsulta = new javax.swing.JButton();
        mainPaciente = new javax.swing.JPanel();
        scrollPanelConsulta = new javax.swing.JScrollPane();
        tableConsultas = new javax.swing.JTable();

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

        tPesquisar.setNextFocusableComponent(bBuscarConsulta);

        bOkConsulta.setBackground(new java.awt.Color(0, 102, 52));
        bOkConsulta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bOkConsulta.setForeground(new java.awt.Color(255, 255, 255));
        bOkConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/checked.png"))); // NOI18N
        bOkConsulta.setText("Ok");
        bOkConsulta.setBorder(null);
        bOkConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bOkConsulta.setDoubleBuffered(true);
        bOkConsulta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bOkConsultaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bOkConsultaFocusLost(evt);
            }
        });
        bOkConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bOkConsultaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bOkConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bOkConsultaMouseExited(evt);
            }
        });

        bCancelarConsulta.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarConsulta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/error.png"))); // NOI18N
        bCancelarConsulta.setText("Cancelar");
        bCancelarConsulta.setBorder(null);
        bCancelarConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCancelarConsulta.setDoubleBuffered(true);
        bCancelarConsulta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bCancelarConsultaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bCancelarConsultaFocusLost(evt);
            }
        });
        bCancelarConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelarConsultaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCancelarConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCancelarConsultaMouseExited(evt);
            }
        });
        bCancelarConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bCancelarConsultaKeyPressed(evt);
            }
        });

        bBuscarConsulta.setBackground(new java.awt.Color(0, 102, 52));
        bBuscarConsulta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        bBuscarConsulta.setText("Pesquisar");
        bBuscarConsulta.setBorder(null);
        bBuscarConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBuscarConsulta.setDoubleBuffered(true);
        bBuscarConsulta.setFocusPainted(false);
        bBuscarConsulta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bBuscarConsultaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bBuscarConsultaFocusLost(evt);
            }
        });
        bBuscarConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBuscarConsultaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBuscarConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bBuscarConsultaMouseExited(evt);
            }
        });
        bBuscarConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bBuscarConsultaKeyPressed(evt);
            }
        });

        mainPaciente.setLayout(new java.awt.CardLayout());

        scrollPanelConsulta.setBorder(null);

        tableConsultas.setAutoCreateRowSorter(true);
        tableConsultas.setModel(new javax.swing.table.DefaultTableModel(
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
        tableConsultas.setDoubleBuffered(true);
        scrollPanelConsulta.setViewportView(tableConsultas);

        mainPaciente.add(scrollPanelConsulta, "card2");

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
                        .addComponent(bBuscarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bOkConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(bBuscarConsulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(mainPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOkConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void bOkConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkConsultaMouseClicked
        int row = this.tableConsultas.getSelectedRow();
        if(row > -1){
            Consulta c = this.tableModelConsultas.getConsulta(row);
            this.telaAntecendente.setConsulta(c);
            this.telaAntecendente.setSessoes(c.getQntdSessao());
            this.telaAntecendente.setCodigoConsulta(c.getId());
            this.telaAntecendente.setPaciente(c.getPaciente());
            this.telaAntecendente.setCodigoPaciente(c.getPaciente().getId());
            this.telaAntecendente.setNomePaciente(c.getPaciente().getNome());
            if(c.getProcedimento() != null) {
                this.telaAntecendente.setNomeProcedimento(c.getProcedimento().getNome());
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma consulta da tabela", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bOkConsultaMouseClicked

    private void bOkConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkConsultaMouseEntered
        bOkConsulta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bOkConsultaMouseEntered

    private void bOkConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOkConsultaMouseExited
        bOkConsulta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bOkConsultaMouseExited

    private void bCancelarConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarConsultaMouseClicked
        this.dispose();
    }//GEN-LAST:event_bCancelarConsultaMouseClicked

    private void bCancelarConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarConsultaMouseEntered
        bCancelarConsulta.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarConsultaMouseEntered

    private void bCancelarConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarConsultaMouseExited
        bCancelarConsulta.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarConsultaMouseExited

    private void bCancelarConsultaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarConsultaFocusGained
        bCancelarConsulta.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarConsultaFocusGained

    private void bCancelarConsultaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarConsultaFocusLost
        bCancelarConsulta.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarConsultaFocusLost

    private void bOkConsultaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bOkConsultaFocusGained
        bOkConsulta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bOkConsultaFocusGained

    private void bOkConsultaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bOkConsultaFocusLost
        bOkConsulta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bOkConsultaFocusLost

    private void bCancelarConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarConsultaKeyPressed
        this.dispose();
    }//GEN-LAST:event_bCancelarConsultaKeyPressed

    private void bBuscarConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarConsultaMouseEntered
        bBuscarConsulta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarConsultaMouseEntered

    private void bBuscarConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarConsultaMouseExited
        bBuscarConsulta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarConsultaMouseExited

    private void bBuscarConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarConsultaMouseClicked
        this.search();
    }//GEN-LAST:event_bBuscarConsultaMouseClicked

    private void bBuscarConsultaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarConsultaFocusGained
        bBuscarConsulta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarConsultaFocusGained

    private void bBuscarConsultaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarConsultaFocusLost
        bBuscarConsulta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarConsultaFocusLost

    private void bBuscarConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bBuscarConsultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.search();
        }
    }//GEN-LAST:event_bBuscarConsultaKeyPressed

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
            java.util.logging.Logger.getLogger(BuscarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscarConsulta;
    private javax.swing.JButton bCancelarConsulta;
    private javax.swing.JButton bOkConsulta;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel input;
    private javax.swing.JLabel lPesquisar;
    private javax.swing.JPanel mainPaciente;
    private javax.swing.JScrollPane scrollPanelConsulta;
    private javax.swing.JTextField tPesquisar;
    private javax.swing.JTable tableConsultas;
    // End of variables declaration//GEN-END:variables

    private void search() {
        String busca = this.tPesquisar.getText();
        List<Consulta> lista;
        lista = !Validacao.isEmpty(busca) ? cc.consultas(busca) : cc.consultas();
        if(lista != null)
            this.tableModelConsultas.addLista(lista);
        this.tPesquisar.requestFocusInWindow();
        bBuscarConsulta.setBackground(Color.decode("#008542"));
    }
}
