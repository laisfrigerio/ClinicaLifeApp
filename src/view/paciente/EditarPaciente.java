/**
 * @author Lais Frigério da Silva
 */

package view.paciente;

import controller.PacienteController;
import controller.WebServiceCep;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import model.Endereco;
import model.Formatacao;
import model.Paciente;
import model.Validacao;
import view.FixedButtonModel;
import view.Main;

public class EditarPaciente extends javax.swing.JFrame {
    private final Main tela;
    private final Paciente paciente;

    public EditarPaciente(Main tela, Paciente p) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/team.png")).getImage());
        bSalvarPaciente.setModel(new FixedButtonModel());
        bSalvarPaciente.setBorder(BorderFactory.createEtchedBorder(0));
        bCancelarPaciente.setModel(new FixedButtonModel());
        bCancelarPaciente.setBorder(BorderFactory.createEtchedBorder(0));
        UIManager.put("Button.focus", new ColorUIResource(new Color(0,0,0,0)));
        UIManager.put("OptionPane.background",new ColorUIResource(255,255,255));
        UIManager.put("Panel.background",new ColorUIResource(255,255,255));
        UIManager.put("Button.background", Color.WHITE);
        this.tela = tela;
        this.paciente = p;
        tObservacao.setLineWrap(true);
        tObservacao.setWrapStyleWord(true);
        
        //Set field's value
        tNome.setText(p.getNome());
        tCPF.setText(p.getCPF());
        tRG.setText(p.getRG());
        tDataNasc.setText(Formatacao.setDateMask(p.getDataNasc()));
        tFone.setText(p.getFone());
        tContato.setText(p.getFoneContato());
        tCelular.setText(p.getCelular());
        if(p.getEndereco() != null) {
            tCEP.setText(p.getEndereco().getCEP());
            tRua.setText(p.getEndereco().getRua());
            tNumero.setText(Integer.toString(p.getEndereco().getNumero()));
            tBairro.setText(p.getEndereco().getBairro());
            tCidade.setText(p.getEndereco().getCidade());
            tEstado.setText(p.getEndereco().getEstado());
        }
        tSexo.setText(p.getSexo());
        tPeso.setText(Double.toString(p.getPeso()));
        tObservacao.setText(p.getObservacao());
        cEstadoCivil.setSelectedItem(p.getEstadoCivil());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        input = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tCPF = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tRG = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tDataNasc = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tRua = new javax.swing.JFormattedTextField();
        tNumero = new javax.swing.JTextField();
        tBairro = new javax.swing.JFormattedTextField();
        tCidade = new javax.swing.JFormattedTextField();
        tEstado = new javax.swing.JTextField();
        tContato = new javax.swing.JFormattedTextField();
        tFone = new javax.swing.JFormattedTextField();
        tCelular = new javax.swing.JFormattedTextField();
        tSexo = new javax.swing.JTextField();
        tCEP = new javax.swing.JFormattedTextField();
        tPeso = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cEstadoCivil = new javax.swing.JComboBox<>();
        sObservacao = new javax.swing.JScrollPane();
        tObservacao = new javax.swing.JTextArea();
        bSalvarPaciente = new javax.swing.JButton();
        bCancelarPaciente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Paciente");
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Fone");
        jLabel2.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel2.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel2.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Contato");
        jLabel3.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel3.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel3.setPreferredSize(new java.awt.Dimension(40, 20));

        tNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tNomeKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("CPF");
        jLabel4.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel4.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel4.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(211, 0, 0));
        jLabel8.setText("*");
        jLabel8.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel8.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel8.setPreferredSize(new java.awt.Dimension(5, 20));

        try {
            tCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setText("RG");
        jLabel9.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel9.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel9.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(211, 0, 0));
        jLabel10.setText("*");
        jLabel10.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel10.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel10.setPreferredSize(new java.awt.Dimension(5, 20));

        tRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tRGActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Celular");
        jLabel6.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel6.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel6.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setText("Sexo");
        jLabel11.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel11.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel11.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel12.setText("Peso");
        jLabel12.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel12.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel12.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel14.setText("Observação");
        jLabel14.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel14.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel14.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel15.setText("Data de Nascimento");
        jLabel15.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel15.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel15.setPreferredSize(new java.awt.Dimension(40, 20));

        try {
            tDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(211, 0, 0));
        jLabel16.setText("*");
        jLabel16.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel16.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel16.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel17.setText("CEP");
        jLabel17.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel17.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel17.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel18.setText("Rua");
        jLabel18.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel18.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel18.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel19.setText("Número");
        jLabel19.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel19.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel19.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel20.setText("Bairro");
        jLabel20.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel20.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel20.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel21.setText("CIdade");
        jLabel21.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel21.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel21.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel22.setText("Estado");
        jLabel22.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel22.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel22.setPreferredSize(new java.awt.Dimension(40, 20));

        tRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tRuaActionPerformed(evt);
            }
        });
        tRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tRuaKeyTyped(evt);
            }
        });

        tBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tBairroKeyTyped(evt);
            }
        });

        tCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCidadeKeyTyped(evt);
            }
        });

        tEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tEstadoKeyTyped(evt);
            }
        });

        try {
            tContato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tSexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tSexoKeyTyped(evt);
            }
        });

        try {
            tCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tCEP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tCEPFocusLost(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel23.setText("Estado Cívil");
        jLabel23.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel23.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel23.setPreferredSize(new java.awt.Dimension(40, 20));

        cEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro(a)", "Casado(a)", "Divorciado(a)", "Viuvo(a)", "Separdo(a)" }));

        tObservacao.setColumns(20);
        tObservacao.setRows(5);
        sObservacao.setViewportView(tObservacao);

        bSalvarPaciente.setBackground(new java.awt.Color(0, 102, 52));
        bSalvarPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bSalvarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        bSalvarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/checked.png"))); // NOI18N
        bSalvarPaciente.setText("Salvar");
        bSalvarPaciente.setBorder(null);
        bSalvarPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSalvarPaciente.setDoubleBuffered(true);
        bSalvarPaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bSalvarPacienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bSalvarPacienteFocusLost(evt);
            }
        });
        bSalvarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSalvarPacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bSalvarPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bSalvarPacienteMouseExited(evt);
            }
        });
        bSalvarPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bSalvarPacienteKeyPressed(evt);
            }
        });

        bCancelarPaciente.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/error.png"))); // NOI18N
        bCancelarPaciente.setText("Cancelar");
        bCancelarPaciente.setBorder(null);
        bCancelarPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tNome)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(tCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(tRG, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tFone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(tContato, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tRua)
                            .addComponent(tBairro, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(tNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(inputLayout.createSequentialGroup()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(sObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inputLayout.createSequentialGroup()
                                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(inputLayout.createSequentialGroup()
                                            .addComponent(tSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(54, 54, 54)
                                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(inputLayout.createSequentialGroup()
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(tEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(inputLayout.createSequentialGroup()
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(inputLayout.createSequentialGroup()
                                    .addComponent(bSalvarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bCancelarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tRG, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tContato, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tRua, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalvarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(bg, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSalvarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarPacienteMouseClicked
        this.cadastrar();
    }//GEN-LAST:event_bSalvarPacienteMouseClicked

    private void bSalvarPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarPacienteMouseEntered
        bSalvarPaciente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarPacienteMouseEntered

    private void bSalvarPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarPacienteMouseExited
        bSalvarPaciente.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarPacienteMouseExited

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

    private void bSalvarPacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarPacienteFocusGained
        bSalvarPaciente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarPacienteFocusGained

    private void bSalvarPacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarPacienteFocusLost
        bSalvarPaciente.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarPacienteFocusLost

    private void bCancelarPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarPacienteKeyPressed
        this.dispose();
    }//GEN-LAST:event_bCancelarPacienteKeyPressed

    private void tCEPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tCEPFocusLost
        String cep = tCEP.getText();
        WebServiceCep get = WebServiceCep.searchCep(cep);
        Endereco e = null;
        if(get.wasSuccessful()) {
            e = new Endereco();
            e.setCEP(cep);
            e.setRua(get.getLogradouro());
            e.setBairro(get.getBairro());
            e.setCidade(get.getCidade());
            e.setEstado(get.getUf());
            tRua.setText(get.getLogradouro());
            tBairro.setText(get.getBairro());
            tCidade.setText(get.getCidade());
            tEstado.setText(get.getUf());
        }
    }//GEN-LAST:event_tCEPFocusLost

    private void tRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tRGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tRGActionPerformed

    private void tRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tRuaActionPerformed

    private void tNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNomeKeyTyped
        if(tNome.getText().length() > 199)
            evt.consume();
    }//GEN-LAST:event_tNomeKeyTyped

    private void tRuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tRuaKeyTyped
        if(tRua.getText().length() > 199)
            evt.consume();
    }//GEN-LAST:event_tRuaKeyTyped

    private void tBairroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tBairroKeyTyped
        if(tBairro.getText().length() > 199)
            evt.consume();
    }//GEN-LAST:event_tBairroKeyTyped

    private void tCidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCidadeKeyTyped
        if(tCidade.getText().length() > 199)
            evt.consume();
    }//GEN-LAST:event_tCidadeKeyTyped

    private void tEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tEstadoKeyTyped
        if(tEstado.getText().length() > 1)
            evt.consume();
    }//GEN-LAST:event_tEstadoKeyTyped

    private void tSexoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSexoKeyTyped
        if(tSexo.getText().length() > 0)
            evt.consume();
    }//GEN-LAST:event_tSexoKeyTyped

    private void bSalvarPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bSalvarPacienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           this.cadastrar();
        }
    }//GEN-LAST:event_bSalvarPacienteKeyPressed

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
            java.util.logging.Logger.getLogger(EditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    private void cadastrar() {
        String CPF = Formatacao.removeCPFmask(tCPF.getText());
        String RG = Formatacao.removeRGmask(tRG.getText());
        String data = Formatacao.removeDateMask(tDataNasc.getText());
        if(Validacao.isEmpty(RG) || Validacao.isEmpty(CPF) || Validacao.isEmpty(tNome.getText()) || Validacao.isEmpty(data)) {
            JOptionPane.showMessageDialog(null, "Os campos (Nome), (CPF), (RG) e (Data de Nascimento) são obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        if(!Validacao.CPFisValid(CPF)) {
            JOptionPane.showMessageDialog(null, "CPF inválido", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        if(Validacao.CPFexists(CPF, this.paciente.getId())) {
            JOptionPane.showMessageDialog(null, "CPF já cadastrado", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        if(!Validacao.hasOnlyLettersAndNumbers(RG)){
           JOptionPane.showMessageDialog(null, "O campo (RG) deve conter apenas números, letras, pontos(.) ou traços (-)", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ; 
        }
        if(!Validacao.dateIsValid(tDataNasc.getText())) {
            JOptionPane.showMessageDialog(null, "Data inválida", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ; 
        }
        String peso = Formatacao.replaceComma2Dot(tPeso.getText());
        if(!Validacao.isEmpty(peso) && !Validacao.isDouble(peso)) {
            JOptionPane.showMessageDialog(null, "Entre com um peso válido", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        if(!Validacao.isEmpty(tSexo.getText()) && !Validacao.equals(tSexo.getText(), 1)) {
            JOptionPane.showMessageDialog(null, "Informe: F para Feminino ou M para Masculino", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        if(!Validacao.isEmpty(tNumero.getText()) && !Validacao.isNumeric(tNumero.getText())) {
            JOptionPane.showMessageDialog(null, "O campo (Número) deve conter apenas números", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        if(!Validacao.isEmpty(tEstado.getText())  && !Validacao.equals(tEstado.getText(), 2)) {
            JOptionPane.showMessageDialog(null, "O campo (Estado) deve conter apenas 2 caracteres (SIGLA)", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        String CEP = Formatacao.removeCEPmask(tCEP.getText());
        Endereco e = null;
        
        if(!Validacao.isEmpty(CEP) || !Validacao.isEmpty(tRua.getText())) {
            e = new Endereco();
            e.setCEP(CEP);
            e.setRua(tRua.getText());
            if(Validacao.isNumeric(tNumero.getText())) {
                e.setNumero(Integer.parseInt(tNumero.getText()));
            }           
            e.setBairro(tBairro.getText());
            e.setCidade(tCidade.getText());
            e.setEstado(tEstado.getText());
            if(this.paciente.getEndereco() != null)
                e.setId(this.paciente.getEndereco().getId());
            else
                e.setId(0);
        }
        
        Paciente p = new Paciente();
        p.setId(paciente.getId());
        p.setEndereco(e);
        p.setNome(tNome.getText());
        p.setCPF(CPF);
        p.setRG(RG);
        p.setDataNasc(Formatacao.string2Date(tDataNasc.getText()));       
        p.setFone(Formatacao.removeFoneMask(tFone.getText()));
        p.setFoneContato(Formatacao.removeFoneMask(tContato.getText()));
        p.setCelular(Formatacao.removeFoneMask(tCelular.getText()));
        p.setSexo(tSexo.getText());
        p.setEstadoCivil((String)cEstadoCivil.getSelectedItem());
        if(!Validacao.isEmpty(tPeso.getText()))
            p.setPeso(Double.parseDouble(peso));
        p.setObservacao(tObservacao.getText());
        
        PacienteController pc = new PacienteController();
        if(pc.editar(p)){
            List<Paciente> lista = pc.pacientes();
            if(lista!=null)
                this.tela.tableModelPaciente.addLista(lista);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a atualização dos dados. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelarPaciente;
    private javax.swing.JButton bSalvarPaciente;
    private javax.swing.JPanel bg;
    private javax.swing.JComboBox<String> cEstadoCivil;
    private javax.swing.JPanel input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane sObservacao;
    private javax.swing.JFormattedTextField tBairro;
    private javax.swing.JFormattedTextField tCEP;
    private javax.swing.JFormattedTextField tCPF;
    private javax.swing.JFormattedTextField tCelular;
    private javax.swing.JFormattedTextField tCidade;
    private javax.swing.JFormattedTextField tContato;
    private javax.swing.JFormattedTextField tDataNasc;
    private javax.swing.JTextField tEstado;
    private javax.swing.JFormattedTextField tFone;
    private javax.swing.JTextField tNome;
    private javax.swing.JTextField tNumero;
    private javax.swing.JTextArea tObservacao;
    private javax.swing.JTextField tPeso;
    private javax.swing.JFormattedTextField tRG;
    private javax.swing.JFormattedTextField tRua;
    private javax.swing.JTextField tSexo;
    // End of variables declaration//GEN-END:variables
}
