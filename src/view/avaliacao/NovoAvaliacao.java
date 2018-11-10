package view.avaliacao;

import view.profissional.BuscarProfissional;
import view.paciente.BuscarPaciente;
import controller.AvaliacaoController;
import interfaces.TelaAntecedente;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import model.Avaliacao;
import model.Profissional;
import model.Consulta;
import model.Formatacao;
import model.Paciente;
import model.Validacao;
import view.FixedButtonModel;
import view.Main;

public class NovoAvaliacao extends javax.swing.JFrame implements TelaAntecedente {
    private final Main tela;
    private Paciente paciente = null;
    private Profissional fisioterapeuta = null;

    public NovoAvaliacao(Main tela) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/check-form.png")).getImage());
        bSalvarAvaliacao.setModel(new FixedButtonModel());
        bSalvarAvaliacao.setBorder(BorderFactory.createEtchedBorder(0));
        bCancelarFisioterapia.setModel(new FixedButtonModel());
        bCancelarFisioterapia.setBorder(BorderFactory.createEtchedBorder(0));
        bBuscarFisioterapeuta.setModel(new FixedButtonModel());
        bBuscarFisioterapeuta.setBorder(BorderFactory.createEtchedBorder(0));
        bBuscarPaciente.setModel(new FixedButtonModel());
        bBuscarPaciente.setBorder(BorderFactory.createEtchedBorder(0));
        UIManager.put("Button.focus", new ColorUIResource(new Color(0,0,0,0)));
        UIManager.put("OptionPane.background",new ColorUIResource(255,255,255));
        UIManager.put("Panel.background",new ColorUIResource(255,255,255));
        UIManager.put("Button.background", Color.WHITE);
        this.tela = tela;
        this.setTitle("Nova Avaliação");
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        format.setMaximumFractionDigits(0);
        tNomePaciente.setDisabledTextColor(Color.gray);
        tNomePaciente.setBorder(BorderFactory.createLineBorder(Color.gray));
        tNomePaciente.setBackground(Color.decode("#F7F7F7"));
        tCodigoPaciente.setDisabledTextColor(Color.gray);
        tCodigoPaciente.setBorder(BorderFactory.createLineBorder(Color.gray));
        tCodigoPaciente.setBackground(Color.decode("#F7F7F7"));
        tNomeFisioterapeuta.setDisabledTextColor(Color.gray);
        tNomeFisioterapeuta.setBorder(BorderFactory.createLineBorder(Color.gray));
        tNomeFisioterapeuta.setBackground(Color.decode("#F7F7F7"));
        tCodigoProfissional.setDisabledTextColor(Color.gray);
        tCodigoProfissional.setBorder(BorderFactory.createLineBorder(Color.gray));
        tCodigoProfissional.setBackground(Color.decode("#F7F7F7"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        input = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tNomePaciente = new javax.swing.JTextField();
        tNomeFisioterapeuta = new javax.swing.JTextField();
        bBuscarPaciente = new javax.swing.JButton();
        bBuscarFisioterapeuta = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tData = new javax.swing.JFormattedTextField();
        tCodigoPaciente = new javax.swing.JTextField();
        tCodigoProfissional = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tMedico = new javax.swing.JTextField();
        bCancelarFisioterapia = new javax.swing.JButton();
        bSalvarAvaliacao = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDiagnosticoClinico = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tDiagnosticoFisio = new javax.swing.JTextArea();

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Fisioterapeuta");
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
        jLabel3.setText("Data");
        jLabel3.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel3.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel3.setPreferredSize(new java.awt.Dimension(40, 20));

        tNomePaciente.setEnabled(false);
        tNomePaciente.setSelectionColor(new java.awt.Color(0, 102, 67));

        tNomeFisioterapeuta.setEnabled(false);
        tNomeFisioterapeuta.setSelectionColor(new java.awt.Color(0, 102, 67));

        bBuscarPaciente.setBackground(new java.awt.Color(0, 102, 52));
        bBuscarPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        bBuscarPaciente.setText("Buscar Paciente");
        bBuscarPaciente.setBorder(null);
        bBuscarPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBuscarPaciente.setDoubleBuffered(true);
        bBuscarPaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bBuscarPacienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bBuscarPacienteFocusLost(evt);
            }
        });
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
        bBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarPacienteActionPerformed(evt);
            }
        });

        bBuscarFisioterapeuta.setBackground(new java.awt.Color(0, 102, 52));
        bBuscarFisioterapeuta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarFisioterapeuta.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarFisioterapeuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        bBuscarFisioterapeuta.setText("Buscar Profissional");
        bBuscarFisioterapeuta.setBorder(null);
        bBuscarFisioterapeuta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBuscarFisioterapeuta.setDoubleBuffered(true);
        bBuscarFisioterapeuta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bBuscarFisioterapeutaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bBuscarFisioterapeutaFocusLost(evt);
            }
        });
        bBuscarFisioterapeuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBuscarFisioterapeutaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBuscarFisioterapeutaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bBuscarFisioterapeutaMouseExited(evt);
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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setText("Código");
        jLabel9.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel9.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel9.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(211, 0, 0));
        jLabel10.setText("*");
        jLabel10.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel10.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel10.setPreferredSize(new java.awt.Dimension(5, 20));

        try {
            tData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tCodigoPaciente.setEnabled(false);

        tCodigoProfissional.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel13.setText("Médico");
        jLabel13.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel13.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel13.setPreferredSize(new java.awt.Dimension(40, 20));

        tMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tMedicoKeyTyped(evt);
            }
        });

        bCancelarFisioterapia.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarFisioterapia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarFisioterapia.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarFisioterapia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/error.png"))); // NOI18N
        bCancelarFisioterapia.setText("Cancelar");
        bCancelarFisioterapia.setBorder(null);
        bCancelarFisioterapia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCancelarFisioterapia.setDoubleBuffered(true);
        bCancelarFisioterapia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bCancelarFisioterapiaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bCancelarFisioterapiaFocusLost(evt);
            }
        });
        bCancelarFisioterapia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelarFisioterapiaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCancelarFisioterapiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCancelarFisioterapiaMouseExited(evt);
            }
        });
        bCancelarFisioterapia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bCancelarFisioterapiaKeyPressed(evt);
            }
        });

        bSalvarAvaliacao.setBackground(new java.awt.Color(0, 102, 52));
        bSalvarAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bSalvarAvaliacao.setForeground(new java.awt.Color(255, 255, 255));
        bSalvarAvaliacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/checked.png"))); // NOI18N
        bSalvarAvaliacao.setText("Salvar");
        bSalvarAvaliacao.setBorder(null);
        bSalvarAvaliacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSalvarAvaliacao.setDoubleBuffered(true);
        bSalvarAvaliacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bSalvarAvaliacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bSalvarAvaliacaoFocusLost(evt);
            }
        });
        bSalvarAvaliacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSalvarAvaliacaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bSalvarAvaliacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bSalvarAvaliacaoMouseExited(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel15.setText("Diagnóstico Clínico");
        jLabel15.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel15.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel15.setPreferredSize(new java.awt.Dimension(40, 20));

        tDiagnosticoClinico.setColumns(20);
        tDiagnosticoClinico.setRows(5);
        jScrollPane1.setViewportView(tDiagnosticoClinico);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel17.setText("Diagnóstico Clínico");
        jLabel17.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel17.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel17.setPreferredSize(new java.awt.Dimension(40, 20));

        tDiagnosticoFisio.setColumns(20);
        tDiagnosticoFisio.setRows(5);
        jScrollPane2.setViewportView(tDiagnosticoFisio);

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(bBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bBuscarFisioterapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputLayout.createSequentialGroup()
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tNomePaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                    .addComponent(tNomeFisioterapeuta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tCodigoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bSalvarAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bCancelarFisioterapia, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tData, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inputLayout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                        .addComponent(tMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2))))
                        .addGap(16, 16, 16))))
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscarFisioterapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNomeFisioterapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCodigoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalvarAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarFisioterapia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
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

    private void bSalvarAvaliacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarAvaliacaoMouseClicked
        if(this.paciente==null) {
            JOptionPane.showMessageDialog(null, "É obrigatório selecionar um Paciente", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (this.fisioterapeuta==null) {
            JOptionPane.showMessageDialog(null, "É obrigatório selecionar um(a) Fisioterapeuta", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (!Validacao.dateIsValid(tData.getText())) {
            JOptionPane.showMessageDialog(null, "Informa uma data válida", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            Avaliacao a = new Avaliacao();
            a.setFisioterapeuta(this.fisioterapeuta);
            a.setPaciente(this.paciente);
            a.setDataAvaliacao(Formatacao.string2Date(tData.getText()));
            a.setMedico(tMedico.getText());
            a.setDiagnosticoClinico(tDiagnosticoClinico.getText());
            a.setDiagnosticoFisio(tDiagnosticoFisio.getText());
            AvaliacaoController ac = new AvaliacaoController();
            if( ac.cadastrar(a)){
                JOptionPane.showMessageDialog(null, "O cadastro foi efetuado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                List<Avaliacao> lista = ac.avaliacoes();
                if(lista != null) {
                    this.tela.tableModelAvaliacao.addLista(lista);
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar o cadastro. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_bSalvarAvaliacaoMouseClicked

    private void bSalvarAvaliacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarAvaliacaoMouseEntered
        bSalvarAvaliacao.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarAvaliacaoMouseEntered

    private void bSalvarAvaliacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarAvaliacaoMouseExited
        bSalvarAvaliacao.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarAvaliacaoMouseExited

    private void bCancelarFisioterapiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarFisioterapiaMouseClicked
        this.dispose();
    }//GEN-LAST:event_bCancelarFisioterapiaMouseClicked

    private void bCancelarFisioterapiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarFisioterapiaMouseEntered
        bCancelarFisioterapia.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarFisioterapiaMouseEntered

    private void bCancelarFisioterapiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarFisioterapiaMouseExited
        bCancelarFisioterapia.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarFisioterapiaMouseExited

    private void bCancelarFisioterapiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarFisioterapiaFocusGained
        bCancelarFisioterapia.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarFisioterapiaFocusGained

    private void bCancelarFisioterapiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarFisioterapiaFocusLost
        bCancelarFisioterapia.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarFisioterapiaFocusLost

    private void bSalvarAvaliacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarAvaliacaoFocusGained
        bSalvarAvaliacao.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarAvaliacaoFocusGained

    private void bSalvarAvaliacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarAvaliacaoFocusLost
        bSalvarAvaliacao.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarAvaliacaoFocusLost

    private void bCancelarFisioterapiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarFisioterapiaKeyPressed
        this.dispose();
    }//GEN-LAST:event_bCancelarFisioterapiaKeyPressed

    private void bBuscarPacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarPacienteFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarPacienteFocusGained

    private void bBuscarPacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarPacienteFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarPacienteFocusLost

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

    private void bBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarPacienteActionPerformed

    private void bBuscarFisioterapeutaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarFisioterapeutaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarFisioterapeutaFocusGained

    private void bBuscarFisioterapeutaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarFisioterapeutaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarFisioterapeutaFocusLost

    private void bBuscarFisioterapeutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarFisioterapeutaMouseClicked
        BuscarProfissional bf = new BuscarProfissional(this);
        bf.setVisible(true);
    }//GEN-LAST:event_bBuscarFisioterapeutaMouseClicked

    private void bBuscarFisioterapeutaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarFisioterapeutaMouseEntered
        bBuscarFisioterapeuta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarFisioterapeutaMouseEntered

    private void bBuscarFisioterapeutaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarFisioterapeutaMouseExited
        bBuscarFisioterapeuta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarFisioterapeutaMouseExited

    private void tMedicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tMedicoKeyTyped
       if(tMedico.getText().length() > 7)
            evt.consume();
    }//GEN-LAST:event_tMedicoKeyTyped

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
            java.util.logging.Logger.getLogger(NovoAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void setPaciente(Paciente p){
        this.paciente = p;
    }
    
    @Override
    public Paciente getPaciente(){
        return this.paciente;
    }
    
    @Override
    public void setProfissional(Profissional f){
        this.fisioterapeuta = f;
    }
    
    @Override
    public Profissional getProfissional(){
        return this.fisioterapeuta;
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
        this.tNomeFisioterapeuta.setText(n);
    }
    
    @Override
    public void setCodigoProfissional(int c){
        this.tCodigoProfissional.setText(Integer.toString(c));
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
    private javax.swing.JButton bBuscarFisioterapeuta;
    private javax.swing.JButton bBuscarPaciente;
    private javax.swing.JButton bCancelarFisioterapia;
    private javax.swing.JButton bSalvarAvaliacao;
    private javax.swing.JPanel bg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tCodigoPaciente;
    private javax.swing.JTextField tCodigoProfissional;
    private javax.swing.JFormattedTextField tData;
    private javax.swing.JTextArea tDiagnosticoClinico;
    private javax.swing.JTextArea tDiagnosticoFisio;
    private javax.swing.JTextField tMedico;
    private javax.swing.JTextField tNomeFisioterapeuta;
    private javax.swing.JTextField tNomePaciente;
    // End of variables declaration//GEN-END:variables
}
