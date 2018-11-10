package view.consulta;

import view.paciente.BuscarPaciente;
import comboBox.GenericComboBox;
import controller.ConsultaController;
import controller.ProcedimentoController;
import interfaces.TelaAntecedente;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import model.Profissional;
import model.Consulta;
import model.Formatacao;
import model.Paciente;
import model.Procedimento;
import model.Validacao;
import view.FixedButtonModel;
import view.Main;

public class EditarConsulta extends javax.swing.JFrame implements TelaAntecedente {
    private final Main tela;
    private final Consulta consulta;
    private final ProcedimentoController pc = new ProcedimentoController();

    public EditarConsulta(Main tela, Consulta f) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/physiotherapy.png")).getImage());
        bSalvarConsulta.setModel(new FixedButtonModel());
        bSalvarConsulta.setBorder(BorderFactory.createEtchedBorder(0));
        bCancelarConsulta.setModel(new FixedButtonModel());
        bCancelarConsulta.setBorder(BorderFactory.createEtchedBorder(0));
        bBuscarPaciente.setModel(new FixedButtonModel());
        bBuscarPaciente.setBorder(BorderFactory.createEtchedBorder(0));
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("Button.focus", new ColorUIResource(new Color(0,0,0,0)));
        this.tela = tela;
        this.consulta = f;
        this.setTitle("Editar Consulta");
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        format.setMaximumFractionDigits(0);
        this.tValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        tNomePaciente.setDisabledTextColor(Color.gray);
        tNomePaciente.setBorder(BorderFactory.createLineBorder(Color.gray));
        tNomePaciente.setBackground(Color.decode("#F7F7F7"));
        tCodigoPaciente.setDisabledTextColor(Color.gray);
        tCodigoPaciente.setBorder(BorderFactory.createLineBorder(Color.gray));
        tCodigoPaciente.setBackground(Color.decode("#F7F7F7"));
        tCodigoPaciente.setText(Integer.toString(this.consulta.getPaciente().getId()));
        tNomePaciente.setText(this.consulta.getPaciente().getNome());
        tQuantidade.setText(Integer.toString(this.consulta.getQntdSessao()));
        tValor.setText(Double.toString(this.consulta.getValor()));
        UIManager.put("OptionPane.background",new ColorUIResource(255,255,255));
        UIManager.put("Panel.background",new ColorUIResource(255,255,255));
        UIManager.put("Button.background", Color.WHITE);
        
        List<Procedimento> lista = pc.procedimentos();
        jComboProcedimentos.setModel(new GenericComboBox(lista));
        
        if (this.consulta.getProcedimento()!=null) {
            for(int i = 0; i<lista.size(); i++) {
                Procedimento p = lista.get(i);
                if (p.getId() == this.consulta.getProcedimento().getId()) {
                    jComboProcedimentos.setSelectedIndex(i);
                }
            }
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
        bBuscarPaciente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tCodigoPaciente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tQuantidade = new javax.swing.JTextField();
        bCancelarConsulta = new javax.swing.JButton();
        bSalvarConsulta = new javax.swing.JButton();
        tValor = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboProcedimentos = new javax.swing.JComboBox<>();

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

        bBuscarPaciente.setBackground(new java.awt.Color(0, 102, 52));
        bBuscarPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        bBuscarPaciente.setText("Buscar Paciente");
        bBuscarPaciente.setBorder(null);
        bBuscarPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBuscarPaciente.setDoubleBuffered(true);
        bBuscarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBuscarPacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBuscarPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bBuscarPacienteMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Código");
        jLabel4.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel4.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel4.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(211, 0, 0));
        jLabel8.setText("*");
        jLabel8.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel8.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel8.setPreferredSize(new java.awt.Dimension(5, 20));

        tCodigoPaciente.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel13.setText("Quantidade");
        jLabel13.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel13.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel13.setPreferredSize(new java.awt.Dimension(40, 20));

        tQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tQuantidadeKeyTyped(evt);
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

        bSalvarConsulta.setBackground(new java.awt.Color(0, 102, 52));
        bSalvarConsulta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bSalvarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        bSalvarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/checked.png"))); // NOI18N
        bSalvarConsulta.setText("Salvar");
        bSalvarConsulta.setBorder(null);
        bSalvarConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSalvarConsulta.setDoubleBuffered(true);
        bSalvarConsulta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bSalvarConsultaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bSalvarConsultaFocusLost(evt);
            }
        });
        bSalvarConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSalvarConsultaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bSalvarConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bSalvarConsultaMouseExited(evt);
            }
        });
        bSalvarConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bSalvarConsultaKeyPressed(evt);
            }
        });

        tValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel15.setText("Valor");
        jLabel15.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel15.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel15.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(211, 0, 0));
        jLabel16.setText("*");
        jLabel16.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel16.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel16.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(211, 0, 0));
        jLabel17.setText("*");
        jLabel17.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel17.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel17.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(211, 0, 0));
        jLabel18.setText("*");
        jLabel18.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel18.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel18.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel23.setText("Procedimento");
        jLabel23.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel23.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel23.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(211, 0, 0));
        jLabel9.setText("*");
        jLabel9.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel9.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel9.setPreferredSize(new java.awt.Dimension(5, 20));

        jComboProcedimentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(inputLayout.createSequentialGroup()
                            .addComponent(bSalvarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bCancelarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(inputLayout.createSequentialGroup()
                            .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(inputLayout.createSequentialGroup()
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(inputLayout.createSequentialGroup()
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(27, 27, 27)
                            .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(inputLayout.createSequentialGroup()
                                    .addComponent(tNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(inputLayout.createSequentialGroup()
                                    .addComponent(tQuantidade)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tValor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jComboProcedimentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addComponent(bBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tValor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboProcedimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalvarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(bg, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSalvarConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarConsultaMouseClicked
        this.edit();
    }//GEN-LAST:event_bSalvarConsultaMouseClicked

    private void bSalvarConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarConsultaMouseEntered
        bSalvarConsulta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarConsultaMouseEntered

    private void bSalvarConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarConsultaMouseExited
        bSalvarConsulta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarConsultaMouseExited

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

    private void bSalvarConsultaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarConsultaFocusGained
        bSalvarConsulta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarConsultaFocusGained

    private void bSalvarConsultaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarConsultaFocusLost
        bSalvarConsulta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarConsultaFocusLost

    private void bCancelarConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarConsultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.dispose();
        }
    }//GEN-LAST:event_bCancelarConsultaKeyPressed

    private void bBuscarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarPacienteMouseClicked
        BuscarPaciente bp = new BuscarPaciente(this);
        bp.setVisible(true);
    }//GEN-LAST:event_bBuscarPacienteMouseClicked

    private void bBuscarPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarPacienteMouseEntered
        bBuscarPaciente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarPacienteMouseEntered

    private void bBuscarPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarPacienteMouseExited
        bBuscarPaciente.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarPacienteMouseExited

    private void tQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tQuantidadeKeyTyped
        if(tQuantidade.getText().length() > 7)
        evt.consume();
    }//GEN-LAST:event_tQuantidadeKeyTyped

    private void bSalvarConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bSalvarConsultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.edit();
        }
    }//GEN-LAST:event_bSalvarConsultaKeyPressed

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
            java.util.logging.Logger.getLogger(EditarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private javax.swing.JButton bBuscarPaciente;
    private javax.swing.JButton bCancelarConsulta;
    private javax.swing.JButton bSalvarConsulta;
    private javax.swing.JPanel bg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel input;
    private javax.swing.JComboBox<String> jComboProcedimentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tCodigoPaciente;
    private javax.swing.JTextField tNomePaciente;
    private javax.swing.JTextField tQuantidade;
    private javax.swing.JFormattedTextField tValor;
    // End of variables declaration//GEN-END:variables

    private void edit() {
        if(this.consulta.getPaciente()==null) {
            JOptionPane.showMessageDialog(null, "É obrigatório selecionar um Paciente", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (Validacao.isEmpty(tValor.getText()) || Validacao.isEmpty(tQuantidade.getText())) {
            JOptionPane.showMessageDialog(null, "Os campos (Quantidade) e (Valor) são obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        } 
        
        if (!Validacao.isNumeric(tQuantidade.getText())) {
            JOptionPane.showMessageDialog(null, "Informe apenas números no campo (Quantidade)", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Procedimento procedimento = (Procedimento)this.jComboProcedimentos.getSelectedItem();
        if (procedimento == null) {
            JOptionPane.showMessageDialog(null, "O campo (Procedimento) é obrigatório", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        
        consulta.setPaciente(this.consulta.getPaciente());
        consulta.setQntdSessao(Integer.parseInt(tQuantidade.getText()));
        String valor;
        if(Validacao.hasComma(tValor.getText()))
           valor = Formatacao.removeComma(tValor.getText());
        else
            valor = tValor.getText();
        consulta.setValor(Double.parseDouble(valor));
        consulta.setProcedimento(procedimento);
        
        ConsultaController cc = new ConsultaController();
        if (cc.editar(consulta)) {
            List<Consulta> lista = cc.consultas();
            if(lista != null) {
                this.tela.tableModelConsultas.addLista(lista);
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a atualização dos dados. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
}
