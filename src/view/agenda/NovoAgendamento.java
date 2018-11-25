/**
 * @author Lais Frigério da Silva
 */

package view.agenda;

import controller.AgendaController;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import model.Profissional;
import model.Consulta;
import model.Formatacao;
import model.Paciente;
import model.Validacao;
import interfaces.TelaAntecedente;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import model.Agenda;
import model.Horario;
import view.consulta.BuscarConsulta;
import view.profissional.BuscarProfissional;
import view.Main;
import view.avaliacao.NovoAvaliacao;

public class NovoAgendamento extends javax.swing.JFrame implements TelaAntecedente {
    private final Main tela;
    private final Agenda agenda;
    private Paciente paciente = null;
    private Consulta consulta = null;
    private Profissional profissional = null;

    public NovoAgendamento(Main tela, Agenda a) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/calendar.png")).getImage());
        UIManager.put("Button.focus", new ColorUIResource(new Color(0,0,0,0)));
        UIManager.put("ToolTip.background", Color.decode("#F7F7F7")); 
        UIManager.put("ToolTip.border", new LineBorder(Color.decode("#006634"), 1));
        UIManager.put("OptionPane.background",new ColorUIResource(255,255,255));
        UIManager.put("Panel.background",new ColorUIResource(255,255,255));
        UIManager.put("Button.background", Color.WHITE);
        
        JButton buttons[] = {bSalvarAgendamento,bCancelarAgendamento, bBuscarProfissional, bBuscarConsulta};
        Formatacao.setButtons(buttons);
        
        this.tela = tela;
        this.agenda = a;
        this.setTitle("Novo agendamento");
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        format.setMaximumFractionDigits(0);
        Formatacao.setDisableTextField(tData);
        Formatacao.setDisableTextField(tHora);
        Formatacao.setDisableTextField(tCodigoFisioterapia);
        Formatacao.setDisableTextField(tCodigoPaciente);
        Formatacao.setDisableTextField(tNomeFisioterapeuta);
        Formatacao.setDisableTextField(tCodigoProfissional);
        Formatacao.setDisableTextField(tSessoes);
        Formatacao.setDisableTextField(tNomePaciente);
        Formatacao.setDisableTextField(tProcedimento);
        tHora.setText(Formatacao.dateTime2OnlyStringTime(a.getDataAgendamento()));
        tData.setText(Formatacao.dateTime2OnlyStringDate(a.getDataAgendamento()));
        tHora.setEditable(false);
        tData.setEditable(false);
        jComboBoxRepetir.addItem("");
        jComboBoxRepetir.addItem(Agenda.DIARIAMENTE);
        jComboBoxRepetir.addItem(Agenda.SEMANALMENTE);
        jComboBoxRepetir.addItem(Agenda.QUINZENALMENTE);
        jComboBoxRepetir.addItem(Agenda.MENSALMENTE);
        jComboBoxRepetir.addItem(Agenda.ANUALMENTE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        input = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tCodigoFisioterapia = new javax.swing.JTextField();
        tNomeFisioterapeuta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tCodigoPaciente = new javax.swing.JTextField();
        tCodigoProfissional = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tNomePaciente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tSessoes = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        bCancelarAgendamento = new javax.swing.JButton();
        bSalvarAgendamento = new javax.swing.JButton();
        bBuscarConsulta = new javax.swing.JButton();
        bBuscarProfissional = new javax.swing.JButton();
        jScrollObservacoes = new javax.swing.JScrollPane();
        tObservacao = new javax.swing.JTextArea();
        tProcedimento = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tData = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tHora = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jComboBoxRepetir = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        tQuantidade = new javax.swing.JTextField();
        radioButtonRepetirSabado = new javax.swing.JRadioButton();

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
        jLabel2.setText("Profissional");
        jLabel2.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel2.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel2.setPreferredSize(new java.awt.Dimension(40, 20));

        tCodigoFisioterapia.setEnabled(false);
        tCodigoFisioterapia.setSelectionColor(new java.awt.Color(0, 102, 67));

        tNomeFisioterapeuta.setEnabled(false);
        tNomeFisioterapeuta.setSelectionColor(new java.awt.Color(0, 102, 67));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Código Consulta");
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

        tCodigoPaciente.setEnabled(false);

        tCodigoProfissional.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Total Sessões");
        jLabel5.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel5.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel5.setPreferredSize(new java.awt.Dimension(40, 20));

        tNomePaciente.setEnabled(false);
        tNomePaciente.setSelectionColor(new java.awt.Color(0, 102, 67));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(211, 0, 0));
        jLabel11.setText("*");
        jLabel11.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel11.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel11.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel12.setText("Código");
        jLabel12.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel12.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel12.setPreferredSize(new java.awt.Dimension(40, 20));

        tSessoes.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel14.setText("Observação");
        jLabel14.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel14.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel14.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(211, 0, 0));
        jLabel15.setText("*");
        jLabel15.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel15.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel15.setPreferredSize(new java.awt.Dimension(5, 20));

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

        bCancelarAgendamento.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarAgendamento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarAgendamento.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/error.png"))); // NOI18N
        bCancelarAgendamento.setText("Cancelar");
        bCancelarAgendamento.setBorder(null);
        bCancelarAgendamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCancelarAgendamento.setDoubleBuffered(true);
        bCancelarAgendamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bCancelarAgendamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bCancelarAgendamentoFocusLost(evt);
            }
        });
        bCancelarAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelarAgendamentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCancelarAgendamentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCancelarAgendamentoMouseExited(evt);
            }
        });
        bCancelarAgendamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bCancelarAgendamentoKeyPressed(evt);
            }
        });

        bSalvarAgendamento.setBackground(new java.awt.Color(0, 102, 52));
        bSalvarAgendamento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bSalvarAgendamento.setForeground(new java.awt.Color(255, 255, 255));
        bSalvarAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/checked.png"))); // NOI18N
        bSalvarAgendamento.setText("Salvar");
        bSalvarAgendamento.setBorder(null);
        bSalvarAgendamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSalvarAgendamento.setDoubleBuffered(true);
        bSalvarAgendamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bSalvarAgendamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bSalvarAgendamentoFocusLost(evt);
            }
        });
        bSalvarAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSalvarAgendamentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bSalvarAgendamentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bSalvarAgendamentoMouseExited(evt);
            }
        });

        bBuscarConsulta.setBackground(new java.awt.Color(0, 102, 52));
        bBuscarConsulta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        bBuscarConsulta.setText("Buscar Consulta");
        bBuscarConsulta.setBorder(null);
        bBuscarConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBuscarConsulta.setDoubleBuffered(true);
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

        bBuscarProfissional.setBackground(new java.awt.Color(0, 102, 52));
        bBuscarProfissional.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarProfissional.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarProfissional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        bBuscarProfissional.setText("Buscar Profissional");
        bBuscarProfissional.setBorder(null);
        bBuscarProfissional.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBuscarProfissional.setDoubleBuffered(true);
        bBuscarProfissional.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bBuscarProfissionalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bBuscarProfissionalFocusLost(evt);
            }
        });
        bBuscarProfissional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBuscarProfissionalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBuscarProfissionalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bBuscarProfissionalMouseExited(evt);
            }
        });

        tObservacao.setColumns(20);
        tObservacao.setRows(5);
        jScrollObservacoes.setViewportView(tObservacao);

        tProcedimento.setEnabled(false);
        tProcedimento.setSelectionColor(new java.awt.Color(0, 102, 67));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel18.setText("Procedimento");
        jLabel18.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel18.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel18.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Data");
        jLabel3.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel3.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel3.setPreferredSize(new java.awt.Dimension(40, 20));

        tData.setBackground(new java.awt.Color(240, 240, 240));
        try {
            tData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tData.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(211, 0, 0));
        jLabel13.setText("*");
        jLabel13.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel13.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel13.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Hora");
        jLabel6.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel6.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel6.setPreferredSize(new java.awt.Dimension(40, 20));

        tHora.setBackground(new java.awt.Color(240, 240, 240));
        tHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        tHora.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(211, 0, 0));
        jLabel7.setText("*");
        jLabel7.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel7.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel7.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(211, 0, 0));
        jLabel19.setText("*");
        jLabel19.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel19.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel19.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel20.setText("Recorrência");
        jLabel20.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel20.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel20.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel22.setText("Quantidade");

        radioButtonRepetirSabado.setBackground(new java.awt.Color(247, 247, 247));
        radioButtonRepetirSabado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        radioButtonRepetirSabado.setText("Recorrência no sábado");

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(tProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(inputLayout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16)
                                    .addComponent(tCodigoFisioterapia, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(inputLayout.createSequentialGroup()
                                            .addComponent(tData, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tHora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(tNomeFisioterapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(16, 16, 16)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tCodigoProfissional, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(tCodigoPaciente)
                            .addComponent(tSessoes, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(bBuscarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bBuscarProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioButtonRepetirSabado))
                            .addGroup(inputLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jScrollObservacoes))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bSalvarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bBuscarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscarProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tCodigoFisioterapia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tSessoes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNomeFisioterapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCodigoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tHora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel22))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(radioButtonRepetirSabado))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(tQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSalvarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(338, 338, 338))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(bg, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bBuscarProfissionalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProfissionalMouseExited
        bBuscarProfissional.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarProfissionalMouseExited

    private void bBuscarProfissionalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProfissionalMouseEntered
        bBuscarProfissional.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarProfissionalMouseEntered

    private void bBuscarProfissionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProfissionalMouseClicked
        BuscarProfissional bf = new BuscarProfissional(this);
        bf.setVisible(true);
    }//GEN-LAST:event_bBuscarProfissionalMouseClicked

    private void bBuscarProfissionalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarProfissionalFocusLost
        bBuscarProfissional.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarProfissionalFocusLost

    private void bBuscarProfissionalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarProfissionalFocusGained
        bBuscarProfissional.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarProfissionalFocusGained

    private void bBuscarConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarConsultaMouseExited
        bBuscarConsulta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarConsultaMouseExited

    private void bBuscarConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarConsultaMouseEntered
        bBuscarConsulta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarConsultaMouseEntered

    private void bBuscarConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarConsultaMouseClicked
        BuscarConsulta bf = new BuscarConsulta(this);
        bf.setVisible(true);
    }//GEN-LAST:event_bBuscarConsultaMouseClicked

    private void bBuscarConsultaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarConsultaFocusLost
        bBuscarConsulta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarConsultaFocusLost

    private void bBuscarConsultaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarConsultaFocusGained
        bBuscarConsulta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarConsultaFocusGained

    private void bSalvarAgendamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarAgendamentoMouseExited
        bSalvarAgendamento.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarAgendamentoMouseExited

    private void bSalvarAgendamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarAgendamentoMouseEntered
        bSalvarAgendamento.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarAgendamentoMouseEntered

    private void bSalvarAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarAgendamentoMouseClicked
        if(this.paciente==null) {
            JOptionPane.showMessageDialog(null, "É obrigatório selecionar um Paciente", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (this.profissional==null) {
            JOptionPane.showMessageDialog(null, "É obrigatório selecionar um(a) Profissional", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (this.consulta==null) {
            JOptionPane.showMessageDialog(null, "É obrigatório selecionar uma Consulta", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!Validacao.dateIsValid(tData.getText())) {
            JOptionPane.showMessageDialog(null, "Informe uma data válida", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!Validacao.isEmpty(tQuantidade.getText()) && !Validacao.isNumeric(tQuantidade.getText())) {
            JOptionPane.showMessageDialog(null, "O campo (Quantidade) deve conter apenas números", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        AgendaController ac = new AgendaController();
        this.agenda.setConsulta(this.consulta);
        
        if (!Validacao.isEmpty(tQuantidade.getText()) && Validacao.isNumeric(tQuantidade.getText())) {
            int quantidade = Integer.parseInt(tQuantidade.getText());
            
            if (quantidade < 1) {
                JOptionPane.showMessageDialog(null, "O campo (Quantidade) deve ser maior que 0 (zero)", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (quantidade > this.consulta.getQntdSessao()) {
                JOptionPane.showMessageDialog(null, "O campo (Quantidade) deve ser menor ou igual ao campo (Total Sessões)", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            this.agenda.setQuantidade(quantidade);
        }
        
        String recorrencia = (String)jComboBoxRepetir.getSelectedItem();
        this.agenda.setRecorrenciaSabado(radioButtonRepetirSabado.isSelected());
        this.agenda.setRecorrencia(recorrencia);
       
        this.agenda.setProfissional(this.profissional);
        this.agenda.getConsulta().setPaciente(this.paciente);
        this.agenda.setObservacao(tObservacao.getText());
        int qntdAgendamentosCadastrados = ac.checkNumeroSessoesConsulta(this.agenda);
        if (qntdAgendamentosCadastrados == this.consulta.getQntdSessao()) {
            JOptionPane.showMessageDialog(null, "Não é mais possível realziar um novo agendamento para esta consulta, pois a mesma já atingiu a quantidade máxima de sessões.", "Atenção", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if ( (this.consulta.getQntdSessao() - qntdAgendamentosCadastrados) < this.agenda.getQuantidade() ) {
            JOptionPane.showMessageDialog(null, "Não é mais possível realziar um novo agendamento para esta consulta, pois não é possível cadastradar mais sessões do que o permitido (Total Sessões)", "Atenção", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        switch (ac.cadastrar(this.agenda)) {
            case 0:
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar o cadastro. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.ERROR_MESSAGE);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Agendamento efetuado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                if (this.tela.getTDate().getDate() != null) {
                    List<Horario> lista = ac.agendamentos(Formatacao.date2StringScreen(this.tela.getTDate().getDate()));
                    if(lista != null) {
                        this.tela.tableModelAgenda.addLista(lista);
                        for(int i = 0; i<20; i++)
                        this.tela.getTableAgenda().setRowHeight(i, 30);
                        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                        this.tela.getTableAgenda().getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
                        this.tela.getTableAgenda().getColumnModel().getColumn(0).setMinWidth(100);
                        this.tela.getTableAgenda().getColumnModel().getColumn(0).setMaxWidth(100);
                    }
                }
                this.dispose();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Não foi possível replicar o agendamento, por motivo de horário cheio.", "Atenção", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }//GEN-LAST:event_bSalvarAgendamentoMouseClicked

    private void bSalvarAgendamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarAgendamentoFocusLost
        bSalvarAgendamento.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarAgendamentoFocusLost

    private void bSalvarAgendamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarAgendamentoFocusGained
        bSalvarAgendamento.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarAgendamentoFocusGained

    private void bCancelarAgendamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoKeyPressed
        this.agenda.setConsulta(null);
        this.dispose();
    }//GEN-LAST:event_bCancelarAgendamentoKeyPressed

    private void bCancelarAgendamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoMouseExited
        bCancelarAgendamento.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarAgendamentoMouseExited

    private void bCancelarAgendamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoMouseEntered
        bCancelarAgendamento.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarAgendamentoMouseEntered

    private void bCancelarAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoMouseClicked
        this.agenda.setConsulta(null);
        this.dispose();
    }//GEN-LAST:event_bCancelarAgendamentoMouseClicked

    private void bCancelarAgendamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoFocusLost
        bCancelarAgendamento.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarAgendamentoFocusLost

    private void bCancelarAgendamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarAgendamentoFocusGained
        bCancelarAgendamento.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarAgendamentoFocusGained

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
        this.profissional = f;
    }
    
    @Override
    public Profissional getProfissional(){
        return this.profissional;
    }
    
    @Override
    public void setConsulta(Consulta f){
        this.consulta = f;
    }
    
    @Override
    public Consulta getConsulta(){
        return this.consulta;
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
    public void setSessoes(int s){
        this.tSessoes.setText(Integer.toString(s));
    }
    
    @Override
    public void setCodigoConsulta(int c){
        this.tCodigoFisioterapia.setText(Integer.toString(c));
    }
    
    @Override
    public void setNomeProcedimento(String p)
    {
        this.tProcedimento.setText(p);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscarConsulta;
    private javax.swing.JButton bBuscarProfissional;
    private javax.swing.JButton bCancelarAgendamento;
    private javax.swing.JButton bSalvarAgendamento;
    private javax.swing.JPanel bg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel input;
    private javax.swing.JComboBox<String> jComboBoxRepetir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollObservacoes;
    private javax.swing.JRadioButton radioButtonRepetirSabado;
    private javax.swing.JTextField tCodigoFisioterapia;
    private javax.swing.JTextField tCodigoPaciente;
    private javax.swing.JTextField tCodigoProfissional;
    private javax.swing.JFormattedTextField tData;
    private javax.swing.JFormattedTextField tHora;
    private javax.swing.JTextField tNomeFisioterapeuta;
    private javax.swing.JTextField tNomePaciente;
    private javax.swing.JTextArea tObservacao;
    private javax.swing.JTextField tProcedimento;
    private javax.swing.JTextField tQuantidade;
    private javax.swing.JTextField tSessoes;
    // End of variables declaration//GEN-END:variables
}
