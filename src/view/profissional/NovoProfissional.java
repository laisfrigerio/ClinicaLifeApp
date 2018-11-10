package view.profissional;

import comboBox.GenericComboBox;
import model.MD5;
import controller.ProfissionalController;
import controller.EspecialidadeController;
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
import model.Profissional;
import model.Formatacao;
import model.Especialidade;
import model.Usuario;
import model.Validacao;
import view.FixedButtonModel;
import view.Main;

public class NovoProfissional extends javax.swing.JFrame {
    private final Main tela;
    private final EspecialidadeController ec = new EspecialidadeController();

    public NovoProfissional(Main tela) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/doctor.png")).getImage());
        bSalvarFisioterapeuta.setModel(new FixedButtonModel());
        bSalvarFisioterapeuta.setBorder(BorderFactory.createEtchedBorder(0));
        bCancelarFisioterapeuta.setModel(new FixedButtonModel());
        bCancelarFisioterapeuta.setBorder(BorderFactory.createEtchedBorder(0));
        UIManager.put("Button.focus", new ColorUIResource(new Color(0,0,0,0)));
        UIManager.put("OptionPane.background",new ColorUIResource(255,255,255));
        UIManager.put("Panel.background",new ColorUIResource(255,255,255));
        UIManager.put("Button.background", Color.WHITE);
        this.tela = tela;
        this.setTitle("Novo Profissional");
        List<Especialidade> lista = ec.especialidades();
        jComboEspecialidades.setModel(new GenericComboBox(lista));
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
        tLogin = new javax.swing.JFormattedTextField();
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
        tCelular = new javax.swing.JFormattedTextField();
        tFone = new javax.swing.JFormattedTextField();
        tCEP = new javax.swing.JFormattedTextField();
        Login = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Login1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tBanco = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tAgencia = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tDigito = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        tCC = new javax.swing.JTextField();
        tSenha = new javax.swing.JPasswordField();
        jComboEspecialidades = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        bCancelarFisioterapeuta = new javax.swing.JButton();
        bSalvarFisioterapeuta = new javax.swing.JButton();

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
        jLabel3.setText("Celular");
        jLabel3.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel3.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel3.setPreferredSize(new java.awt.Dimension(40, 20));

        tNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tNomeKeyTyped(evt);
            }
        });

        tLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tLoginActionPerformed(evt);
            }
        });
        tLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tLoginKeyTyped(evt);
            }
        });

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
            tCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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

        Login.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Login.setText("Login");
        Login.setMaximumSize(new java.awt.Dimension(40, 20));
        Login.setMinimumSize(new java.awt.Dimension(40, 20));
        Login.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(211, 0, 0));
        jLabel6.setText("*");
        jLabel6.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel6.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel6.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(211, 0, 0));
        jLabel7.setText("*");
        jLabel7.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel7.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel7.setPreferredSize(new java.awt.Dimension(5, 20));

        Login1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Login1.setText("Senha");
        Login1.setMaximumSize(new java.awt.Dimension(40, 20));
        Login1.setMinimumSize(new java.awt.Dimension(40, 20));
        Login1.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel23.setText("Especialidade");
        jLabel23.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel23.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel23.setPreferredSize(new java.awt.Dimension(40, 20));

        tBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tBancoKeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel24.setText("Agência");
        jLabel24.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel24.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel24.setPreferredSize(new java.awt.Dimension(40, 20));

        tAgencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tAgenciaKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel25.setText("Digito");
        jLabel25.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel25.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel25.setPreferredSize(new java.awt.Dimension(40, 20));

        tDigito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tDigitoKeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel26.setText("Conta Corrente");
        jLabel26.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel26.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel26.setPreferredSize(new java.awt.Dimension(40, 20));

        tCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCCKeyTyped(evt);
            }
        });

        tSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tSenhaKeyTyped(evt);
            }
        });

        jComboEspecialidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(211, 0, 0));
        jLabel8.setText("*");
        jLabel8.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel8.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel8.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel27.setText("Banco");
        jLabel27.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel27.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel27.setPreferredSize(new java.awt.Dimension(40, 20));

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboEspecialidades, 0, 466, Short.MAX_VALUE)
                            .addComponent(tCC))
                        .addGap(351, 351, 351))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(tCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tBairro)
                                    .addComponent(tRua)))
                            .addGroup(inputLayout.createSequentialGroup()
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(tCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tEstado))
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(tBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(241, 241, 241)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tDigito)))))
                        .addGap(350, 350, 350))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inputLayout.createSequentialGroup()
                                .addGap(314, 314, 314)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inputLayout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(tNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inputLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(tFone, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputLayout.createSequentialGroup()
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(15, 15, 15)
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(tLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Login1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tCelular)
                                            .addComponent(tSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(tNome))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Login1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
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
                    .addComponent(tEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tDigito, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bCancelarFisioterapeuta.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarFisioterapeuta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarFisioterapeuta.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarFisioterapeuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/error.png"))); // NOI18N
        bCancelarFisioterapeuta.setText("Cancelar");
        bCancelarFisioterapeuta.setBorder(null);
        bCancelarFisioterapeuta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCancelarFisioterapeuta.setDoubleBuffered(true);
        bCancelarFisioterapeuta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bCancelarFisioterapeutaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bCancelarFisioterapeutaFocusLost(evt);
            }
        });
        bCancelarFisioterapeuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelarFisioterapeutaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCancelarFisioterapeutaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCancelarFisioterapeutaMouseExited(evt);
            }
        });
        bCancelarFisioterapeuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bCancelarFisioterapeutaKeyPressed(evt);
            }
        });

        bSalvarFisioterapeuta.setBackground(new java.awt.Color(0, 102, 52));
        bSalvarFisioterapeuta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bSalvarFisioterapeuta.setForeground(new java.awt.Color(255, 255, 255));
        bSalvarFisioterapeuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/checked.png"))); // NOI18N
        bSalvarFisioterapeuta.setText("Salvar");
        bSalvarFisioterapeuta.setBorder(null);
        bSalvarFisioterapeuta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSalvarFisioterapeuta.setDoubleBuffered(true);
        bSalvarFisioterapeuta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bSalvarFisioterapeutaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bSalvarFisioterapeutaFocusLost(evt);
            }
        });
        bSalvarFisioterapeuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSalvarFisioterapeutaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bSalvarFisioterapeutaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bSalvarFisioterapeutaMouseExited(evt);
            }
        });
        bSalvarFisioterapeuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bSalvarFisioterapeutaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bSalvarFisioterapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCancelarFisioterapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalvarFisioterapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarFisioterapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(bg, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSalvarFisioterapeutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarFisioterapeutaMouseClicked
        this.create();
    }//GEN-LAST:event_bSalvarFisioterapeutaMouseClicked

    private void bSalvarFisioterapeutaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarFisioterapeutaMouseEntered
        bSalvarFisioterapeuta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarFisioterapeutaMouseEntered

    private void bSalvarFisioterapeutaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarFisioterapeutaMouseExited
        bSalvarFisioterapeuta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarFisioterapeutaMouseExited

    private void bCancelarFisioterapeutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarFisioterapeutaMouseClicked
        this.dispose();
    }//GEN-LAST:event_bCancelarFisioterapeutaMouseClicked

    private void bCancelarFisioterapeutaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarFisioterapeutaMouseEntered
        bCancelarFisioterapeuta.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarFisioterapeutaMouseEntered

    private void bCancelarFisioterapeutaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarFisioterapeutaMouseExited
        bCancelarFisioterapeuta.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarFisioterapeutaMouseExited

    private void bCancelarFisioterapeutaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarFisioterapeutaFocusGained
        bCancelarFisioterapeuta.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarFisioterapeutaFocusGained

    private void bCancelarFisioterapeutaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarFisioterapeutaFocusLost
        bCancelarFisioterapeuta.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarFisioterapeutaFocusLost

    private void bSalvarFisioterapeutaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarFisioterapeutaFocusGained
        bSalvarFisioterapeuta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarFisioterapeutaFocusGained

    private void bSalvarFisioterapeutaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarFisioterapeutaFocusLost
        bSalvarFisioterapeuta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarFisioterapeutaFocusLost

    private void bCancelarFisioterapeutaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarFisioterapeutaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.dispose();
        }
    }//GEN-LAST:event_bCancelarFisioterapeutaKeyPressed

    private void tCEPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tCEPFocusLost
        String cep = tCEP.getText();
        WebServiceCep get = WebServiceCep.searchCep(cep);
        if(get.wasSuccessful()) {
            tRua.setText(get.getLogradouro());
            tBairro.setText(get.getBairro());
            tCidade.setText(get.getCidade());
            tEstado.setText(get.getUf());
        } else {
            System.out.println("Error code = " + get.getResulCode());
            System.out.println("Error descrição = " + get.getResultText());
        }
    }//GEN-LAST:event_tCEPFocusLost

    private void tLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tLoginActionPerformed

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

    private void tLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tLoginKeyTyped
        if(tLogin.getText().length() > 19)
            evt.consume();
    }//GEN-LAST:event_tLoginKeyTyped

    private void tSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSenhaKeyTyped
        if(tSenha.getPassword().toString().length() > 19)
            evt.consume();
    }//GEN-LAST:event_tSenhaKeyTyped

    private void tBancoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tBancoKeyTyped
        if(tBanco.getText().length() > 199)
            evt.consume();
    }//GEN-LAST:event_tBancoKeyTyped

    private void tAgenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tAgenciaKeyTyped
        if(tAgencia.getText().length() > 10)
            evt.consume();
    }//GEN-LAST:event_tAgenciaKeyTyped

    private void tDigitoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tDigitoKeyTyped
        if(tDigito.getText().length() > 0)
            evt.consume();
    }//GEN-LAST:event_tDigitoKeyTyped

    private void tCCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCCKeyTyped
        if(tCC.getText().length() > 19)
            evt.consume();
    }//GEN-LAST:event_tCCKeyTyped

    private void bSalvarFisioterapeutaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bSalvarFisioterapeutaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.create();
        }
    }//GEN-LAST:event_bSalvarFisioterapeutaKeyPressed

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
            java.util.logging.Logger.getLogger(NovoProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Login;
    private javax.swing.JLabel Login1;
    private javax.swing.JButton bCancelarFisioterapeuta;
    private javax.swing.JButton bSalvarFisioterapeuta;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel input;
    private javax.swing.JComboBox<String> jComboEspecialidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tAgencia;
    private javax.swing.JFormattedTextField tBairro;
    private javax.swing.JTextField tBanco;
    private javax.swing.JTextField tCC;
    private javax.swing.JFormattedTextField tCEP;
    private javax.swing.JFormattedTextField tCelular;
    private javax.swing.JFormattedTextField tCidade;
    private javax.swing.JTextField tDigito;
    private javax.swing.JTextField tEstado;
    private javax.swing.JFormattedTextField tFone;
    private javax.swing.JFormattedTextField tLogin;
    private javax.swing.JTextField tNome;
    private javax.swing.JTextField tNumero;
    private javax.swing.JFormattedTextField tRua;
    private javax.swing.JPasswordField tSenha;
    // End of variables declaration//GEN-END:variables

    private void create() {
        if(Validacao.isEmpty(tLogin.getText()) || Validacao.isEmpty(tNome.getText()) || Validacao.isEmpty(new String(tSenha.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Os campos (Nome), (Login), (Senha) são obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        if(!Validacao.isEmpty(tNumero.getText()) && !Validacao.isNumeric(tNumero.getText())) {
            JOptionPane.showMessageDialog(null, "O campo (Número) deve conter apenas números", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        
        if(Validacao.loginExists(tLogin.getText(), 0)) {
            JOptionPane.showMessageDialog(null, "Login já cadastrado", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        
        Especialidade especialidade = (Especialidade)this.jComboEspecialidades.getSelectedItem();
        if (especialidade == null) {
            JOptionPane.showMessageDialog(null, "O campo (Especialidade) é obrigatório", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        
        String CEP = Formatacao.removeCEPmask(tCEP.getText());
        Endereco e = null;
        if(!Validacao.isEmpty(CEP) || !Validacao.isEmpty(tRua.getText())) {
            e = new Endereco();
            e.setCEP(CEP);
            e.setRua(tRua.getText());
            e.setNumero(Integer.parseInt(tNumero.getText()));
            e.setBairro(tBairro.getText());
            e.setCidade(tCidade.getText());
            e.setEstado(tEstado.getText());
        }
        
        Usuario u = new Usuario();
        MD5 md5 = new MD5();
        u.setNome(tNome.getText());
        u.setLogin(tLogin.getText());
        u.setSenha(md5.md5(new String(tSenha.getPassword())));
        
        Profissional prof = new Profissional();
        prof.setEndereco(e);        
        prof.setUsuario(u);
        prof.setFone(Formatacao.removeFoneMask(tFone.getText()));
        prof.setCelular(Formatacao.removeFoneMask(tCelular.getText()));
        prof.setBanco(tBanco.getText());
        prof.setAgencia(tAgencia.getText());
        prof.setDigito(tDigito.getText());
        prof.setContaCorrente(tCC.getText());
        prof.setEspecialidade(especialidade);
        
        ProfissionalController fc = new ProfissionalController();
        if(fc.cadastrar(prof)){
            JOptionPane.showMessageDialog(null, "O Cadastro foi efetuado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            List<Profissional> lista = fc.profissionais();
            if(lista!=null)
               this.tela.tableModelProfissional.addLista(lista);                  
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar o cadastro. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
}
