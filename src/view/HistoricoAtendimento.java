/**
 * @author Lais Frigério da Silva
 */

package view;

import controller.AgendaController;
import interfaces.TelaAntecedente;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import model.Agenda;
import model.Profissional;
import model.Consulta;
import model.Formatacao;
import model.Paciente;
import model.Procedimento;

public class HistoricoAtendimento extends javax.swing.JFrame implements TelaAntecedente {
    private final Main tela;
    private final Consulta consulta;
    private final AgendaController ac;

    public HistoricoAtendimento(Main tela, Consulta c) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/physiotherapy.png")).getImage());
        bCancelarConsulta.setModel(new FixedButtonModel());
        bCancelarConsulta.setBorder(BorderFactory.createEtchedBorder(0));
        UIManager.put("Button.focus", new ColorUIResource(new Color(0,0,0,0)));
        this.tela = tela;
        this.consulta = c;
        this.setTitle("Histórico de atendimento");
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        format.setMaximumFractionDigits(0);
        // this.tValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        Formatacao.setDisableTextField(tNomePaciente);
        Formatacao.setDisableTextField(tQntd);
        Formatacao.setDisableTextField(tCodigoPaciente);
        Formatacao.setDisableTextField(tCodigoConsulta);
        Formatacao.setDisableTextField(tCodigoPaciente);
        Formatacao.setDisableTextField(tValor);
        Formatacao.setDisableTextField(tProcedimento);
        
        tCodigoPaciente.setText(Integer.toString(this.consulta.getPaciente().getId()));
        tValor.setText(Double.toString(this.consulta.getValor()));
        tNomePaciente.setText(this.consulta.getPaciente().getNome());
        tCodigoConsulta.setText(String.valueOf(this.consulta.getId()));
        tQntd.setText(String.valueOf(this.consulta.getQntdSessao()));
        Procedimento procedimento = this.consulta.getProcedimento();
        tProcedimento.setText(procedimento != null ? procedimento.getNome() : "");
        UIManager.put("OptionPane.background",new ColorUIResource(255,255,255));
        UIManager.put("Panel.background",new ColorUIResource(255,255,255));
        UIManager.put("Button.background", Color.WHITE);
        
        ac = new AgendaController();
        List<Agenda> agendamentos = ac.agendamentos(this.consulta);
        for(Agenda a:agendamentos) {
            this.pHistoricoConsulta.setLayout(new BoxLayout(this.pHistoricoConsulta, BoxLayout.PAGE_AXIS));
            PanelHistoricoConsulta pf = new PanelHistoricoConsulta(a);
            this.pHistoricoConsulta.add(pf);
            pHistoricoConsulta.revalidate();
            pHistoricoConsulta.repaint();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        input = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tNomePaciente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tCodigoPaciente = new javax.swing.JTextField();
        bCancelarConsulta = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tCodigoConsulta = new javax.swing.JTextField();
        pHistoricoFisioterapia1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tQntd = new javax.swing.JTextField();
        sHistoricoFisioterapia = new javax.swing.JScrollPane();
        pHistoricoConsulta = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tValor = new javax.swing.JTextField();
        tProcedimento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Usuário");
        setMinimumSize(new java.awt.Dimension(600, 230));
        setResizable(false);

        bg.setBackground(new java.awt.Color(247, 247, 247));

        input.setBackground(new java.awt.Color(247, 247, 247));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Paciente");
        jLabel1.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel1.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel1.setPreferredSize(new java.awt.Dimension(40, 20));

        tNomePaciente.setEnabled(false);
        tNomePaciente.setSelectionColor(new java.awt.Color(0, 102, 67));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Código");
        jLabel4.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel4.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel4.setPreferredSize(new java.awt.Dimension(40, 20));

        tCodigoPaciente.setEnabled(false);

        bCancelarConsulta.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarConsulta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/error.png"))); // NOI18N
        bCancelarConsulta.setText("Fechar");
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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Consulta");
        jLabel5.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel5.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel5.setPreferredSize(new java.awt.Dimension(40, 20));

        tCodigoConsulta.setEnabled(false);
        tCodigoConsulta.setSelectionColor(new java.awt.Color(0, 102, 67));

        javax.swing.GroupLayout pHistoricoFisioterapia1Layout = new javax.swing.GroupLayout(pHistoricoFisioterapia1);
        pHistoricoFisioterapia1.setLayout(pHistoricoFisioterapia1Layout);
        pHistoricoFisioterapia1Layout.setHorizontalGroup(
            pHistoricoFisioterapia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pHistoricoFisioterapia1Layout.setVerticalGroup(
            pHistoricoFisioterapia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Qntd");
        jLabel6.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel6.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel6.setPreferredSize(new java.awt.Dimension(40, 20));

        tQntd.setEnabled(false);

        javax.swing.GroupLayout pHistoricoConsultaLayout = new javax.swing.GroupLayout(pHistoricoConsulta);
        pHistoricoConsulta.setLayout(pHistoricoConsultaLayout);
        pHistoricoConsultaLayout.setHorizontalGroup(
            pHistoricoConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );
        pHistoricoConsultaLayout.setVerticalGroup(
            pHistoricoConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );

        sHistoricoFisioterapia.setViewportView(pHistoricoConsulta);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Valor");
        jLabel7.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel7.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel7.setPreferredSize(new java.awt.Dimension(40, 20));

        tValor.setEnabled(false);

        tProcedimento.setEnabled(false);
        tProcedimento.setSelectionColor(new java.awt.Color(0, 102, 67));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Procedimento");
        jLabel2.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel2.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel2.setPreferredSize(new java.awt.Dimension(40, 20));

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bCancelarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addComponent(pHistoricoFisioterapia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sHistoricoFisioterapia)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(27, 27, 27)
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(inputLayout.createSequentialGroup()
                                                .addComponent(tCodigoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tQntd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(inputLayout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tValor, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(tProcedimento))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCodigoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tQntd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tValor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(pHistoricoFisioterapia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(tProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(inputLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(sHistoricoFisioterapia, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCancelarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
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

    private void bCancelarConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarConsultaKeyPressed
        this.dispose();
    }//GEN-LAST:event_bCancelarConsultaKeyPressed

    private void bCancelarConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarConsultaMouseExited
        bCancelarConsulta.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarConsultaMouseExited

    private void bCancelarConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarConsultaMouseEntered
        bCancelarConsulta.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarConsultaMouseEntered

    private void bCancelarConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarConsultaMouseClicked
        this.dispose();
    }//GEN-LAST:event_bCancelarConsultaMouseClicked

    private void bCancelarConsultaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarConsultaFocusLost
        bCancelarConsulta.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarConsultaFocusLost

    private void bCancelarConsultaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarConsultaFocusGained
        bCancelarConsulta.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarConsultaFocusGained

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
            java.util.logging.Logger.getLogger(HistoricoAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
    }
    
    
    @Override
    public void setPaciente(Paciente p){
        this.consulta.setPaciente(p);
    }
    
    @Override
    public Paciente getPaciente(){
        return this.consulta.getPaciente();
    }
    
    @Override
    public void setProfissional(Profissional f){
        //this.consulta.setProfissional(f);;
    }
    
    @Override
    public Profissional getProfissional(){
        return null;
    }
    
    @Override
    public void setNomePaciente(String n){
        this.tNomePaciente.setText(n);
    }
    
    @Override
    public void setCodigoPaciente(int c){
        this.tCodigoPaciente.setText(Integer.toString(c));
    }
    
    @Override
    public void setNomeProfissional(String n){
        //this.tNomeFisioterapeuta.setText(n);
    }
    
    @Override
    public void setCodigoProfissional(int c){
        //this.tCodigoFisioterapeuta.setText(Integer.toString(c));
    }
    
    @Override
    public void setConsulta(Consulta f) {
        // do nothing here
    }

    @Override
    public Consulta getConsulta() {
        return null;
    }

    @Override
    public void setSessoes(int s) {
        // do nothing here
    }

    @Override
    public void setCodigoConsulta(int c) {
        // do nothing here
    }
    
    @Override
    public void setNomeProcedimento(String p) {
        // do nothing here
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelarConsulta;
    private javax.swing.JPanel bg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel pHistoricoConsulta;
    private javax.swing.JPanel pHistoricoFisioterapia1;
    private javax.swing.JScrollPane sHistoricoFisioterapia;
    private javax.swing.JTextField tCodigoConsulta;
    private javax.swing.JTextField tCodigoPaciente;
    private javax.swing.JTextField tNomePaciente;
    private javax.swing.JTextField tProcedimento;
    private javax.swing.JTextField tQntd;
    private javax.swing.JTextField tValor;
    // End of variables declaration//GEN-END:variables
}
