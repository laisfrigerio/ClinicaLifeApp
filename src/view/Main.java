/**
 * @author Lais Frigério da Silva
 */

package view;

import view.avaliacao.NovoAvaliacao;
import view.avaliacao.EditarAvaliacao;
import view.consulta.EditarConsulta;
import view.usuario.EditarUsuario;
import view.usuario.NovoUsuario;
import view.consulta.NovoConsulta;
import view.profissional.EditarProfissional;
import view.profissional.NovoProfissional;
import view.paciente.EditarPaciente;
import view.paciente.NovoPaciente;
import view.agenda.EditarAgendamento;
import view.agenda.NovoAgendamento;
import view.procedimento.EditarProcedimento;
import view.procedimento.NovoProcedimento;
import DAO.HorarioDAO;
import com.sun.glass.events.KeyEvent;
import controller.AgendaController;
import controller.ProfissionalController;
import controller.ConsultaController;
import controller.PacienteController;
import controller.UsuarioController;
import controller.AvaliacaoController;
import controller.ProcedimentoController;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import model.Agenda;
import model.Avaliacao;
import model.Profissional;
import model.Consulta;
import model.Formatacao;
import model.Horario;
import model.Paciente;
import model.Procedimento;
import model.Usuario;
import model.Validacao;
import tables.AgendaTable;
import tables.AvaliacaoTable;
import tables.ProfissionalTable;
import tables.ConsultaTable;
import tables.PacienteTable;
import tables.ProcedimentoTable;
import tables.UsuarioTable;

public class Main extends javax.swing.JFrame {
    private int currentTela;
    public UsuarioTable tableModelUsuario = new UsuarioTable();
    public PacienteTable tableModelPaciente = new PacienteTable();
    public ProfissionalTable tableModelProfissional = new ProfissionalTable();
    public ProcedimentoTable tableModelProcedimentos = new ProcedimentoTable();
    public ConsultaTable tableModelConsultas = new ConsultaTable();
    public AvaliacaoTable tableModelAvaliacao = new AvaliacaoTable();
    public AgendaTable tableModelAgenda = new AgendaTable();
    private List<Horario> horarios = null;
    
    public Main(int c, String title) {
        initComponents();
        
        //tDate.setBackground(Color.red);
        this.currentTela = c;
        this.setTitle(title);
        this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        sidebarScroll.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelPaciente.getViewport().setBackground(Color.WHITE);
        scrollPanelPaciente.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelProfissional.getViewport().setBackground(Color.WHITE);
        scrollPanelProfissional.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelProcedimento.getViewport().setBackground(Color.WHITE);
        scrollPanelProcedimento.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelUsuario.getViewport().setBackground(Color.WHITE);
        scrollPanelUsuario.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelConsulta.getViewport().setBackground(Color.WHITE);
        scrollPanelConsulta.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelAvaliacao.getViewport().setBackground(Color.WHITE);
        scrollPanelAvaliacao.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelAgenda.setBorder(BorderFactory.createEmptyBorder());
        //scrollPanelFisioterapia.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollPanelFisioterapia.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPanelFisioterapeuta.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPanelUsuario.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPanelPaciente.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableUsuarios.setShowVerticalLines(false);
        tableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablePacientes.setShowVerticalLines(false);
        tablePacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableProfissionais.setShowVerticalLines(false);
        tableProfissionais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableProcedimentos.setShowVerticalLines(false);
        tableProcedimentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableConsultas.setShowVerticalLines(false);
        tableConsultas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableConsultas.setAutoResizeMode(1);
        tableAvaliacoes.setShowVerticalLines(false);
        tableAvaliacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableAgenda.setShowVerticalLines(false);
        tableAgenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);        
        switch(this.currentTela) {
            case 1:
                pAgenda.setBackground(Color.decode("#F0F0F0"));
                lAgenda.setForeground(Color.decode("#006634"));
                Date date = new Date();
                tDate.setDate(date);
                updateAgendaConteudo();
                setHorarios();
                this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/calendar.png")).getImage());
                break;
            default:
                break;
        }
        UIManager.put("OptionPane.background",new ColorUIResource(255,255,255));
        UIManager.put("Panel.background",new ColorUIResource(255,255,255));
        UIManager.put("Button.background", Color.WHITE);
        UIManager.put("ToolTip.background", Color.decode("#F7F7F7")); 
        UIManager.put("ToolTip.border", new LineBorder(Color.decode("#006634"), 1));
        ToolTipManager.sharedInstance().setInitialDelay(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        contentAgenda = new javax.swing.JPanel();
        headerAgenda = new javax.swing.JPanel();
        iconContentHomeAgenda = new javax.swing.JLabel();
        pathContentHomeAgenda = new javax.swing.JLabel();
        navButtonsAgenda = new javax.swing.JPanel();
        bNovoAgenda = new javax.swing.JButton();
        bEditarAgenda = new javax.swing.JButton();
        lPesquisarAgenda = new javax.swing.JLabel();
        tBuscarAgenda = new javax.swing.JTextField();
        bBuscarAgenda = new javax.swing.JButton();
        lPesquisarAgenda1 = new javax.swing.JLabel();
        tDate = new com.toedter.calendar.JDateChooser();
        bRemoverAgenda = new javax.swing.JButton();
        mainAgenda = new javax.swing.JPanel();
        scrollPanelAgenda = new javax.swing.JScrollPane();
        tableAgenda = new javax.swing.JTable();
        contentPaciente = new javax.swing.JPanel();
        headerPaciente = new javax.swing.JPanel();
        iconContentHomePaciente = new javax.swing.JLabel();
        pathContentHomePaciente = new javax.swing.JLabel();
        pathPaciente = new javax.swing.JLabel();
        navButtonsPaciente = new javax.swing.JPanel();
        bNovoPaciente = new javax.swing.JButton();
        bEditarPaciente = new javax.swing.JButton();
        lPesquisarPaciente = new javax.swing.JLabel();
        tBuscarPaciente = new javax.swing.JTextField();
        bBuscarPaciente = new javax.swing.JButton();
        mainPaciente = new javax.swing.JPanel();
        scrollPanelPaciente = new javax.swing.JScrollPane();
        tablePacientes = new javax.swing.JTable();
        contentProfissional = new javax.swing.JPanel();
        headerProfissional = new javax.swing.JPanel();
        iconContentHomeProfissional = new javax.swing.JLabel();
        pathContentHomeProfissional = new javax.swing.JLabel();
        pathProfissional = new javax.swing.JLabel();
        navButtonsProfissional = new javax.swing.JPanel();
        bNovoProfissional = new javax.swing.JButton();
        bEditarProfissional = new javax.swing.JButton();
        lPesquisarProfissional = new javax.swing.JLabel();
        tBuscarProfissional = new javax.swing.JTextField();
        bBuscarProfissional = new javax.swing.JButton();
        bListarEspecialidades = new javax.swing.JButton();
        mainProfissional = new javax.swing.JPanel();
        scrollPanelProfissional = new javax.swing.JScrollPane();
        tableProfissionais = new javax.swing.JTable();
        contentUsuario = new javax.swing.JPanel();
        headerUsuario = new javax.swing.JPanel();
        iconContentHomeUsuario = new javax.swing.JLabel();
        pathContentHomeUsuario = new javax.swing.JLabel();
        pathUsuario = new javax.swing.JLabel();
        navButtonsUsuario = new javax.swing.JPanel();
        bNovoUsuario = new javax.swing.JButton();
        bEditarUsuario = new javax.swing.JButton();
        lPesquisarUsuario = new javax.swing.JLabel();
        tBuscarUsuario = new javax.swing.JTextField();
        bBuscarUsuario = new javax.swing.JButton();
        mainUsuario = new javax.swing.JPanel();
        scrollPanelUsuario = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        contentConsulta = new javax.swing.JPanel();
        headerFisioterapia = new javax.swing.JPanel();
        iconContentHomeFisioterapia = new javax.swing.JLabel();
        pathContentHomeFisioterapia = new javax.swing.JLabel();
        pathFisioterapia = new javax.swing.JLabel();
        navButtonsFisioterapia = new javax.swing.JPanel();
        bNovoConsulta = new javax.swing.JButton();
        bEditarConsulta = new javax.swing.JButton();
        lPesquisarFisioterapia = new javax.swing.JLabel();
        tBuscarConsulta = new javax.swing.JTextField();
        bBuscarConsulta = new javax.swing.JButton();
        bHistoricoConsulta = new javax.swing.JButton();
        mainFisioterapia = new javax.swing.JPanel();
        scrollPanelConsulta = new javax.swing.JScrollPane();
        tableConsultas = new javax.swing.JTable();
        contentAvaliacao = new javax.swing.JPanel();
        headerAvaliacao = new javax.swing.JPanel();
        iconContentHomeAvaliacao = new javax.swing.JLabel();
        pathContentHomeAvaliacao = new javax.swing.JLabel();
        pathAvaliacao = new javax.swing.JLabel();
        navButtonsAvaliacao = new javax.swing.JPanel();
        lPesquisarAvaliacao = new javax.swing.JLabel();
        tBuscarAvaliacao = new javax.swing.JTextField();
        bBuscarAvaliacao = new javax.swing.JButton();
        bNovoAvaliacao = new javax.swing.JButton();
        bEditarAvaliacao = new javax.swing.JButton();
        mainAvaliacao = new javax.swing.JPanel();
        scrollPanelAvaliacao = new javax.swing.JScrollPane();
        tableAvaliacoes = new javax.swing.JTable();
        contentProcedimento = new javax.swing.JPanel();
        headerProcedimento = new javax.swing.JPanel();
        iconContentHomeProcedimento = new javax.swing.JLabel();
        pathContentHomeProcedimento = new javax.swing.JLabel();
        pathProcedimento = new javax.swing.JLabel();
        navButtonsProcedimento = new javax.swing.JPanel();
        bNovoProcedimento = new javax.swing.JButton();
        bEditarProcedimento = new javax.swing.JButton();
        bRemoverProcedimento = new javax.swing.JButton();
        tBuscarProcedimento = new javax.swing.JTextField();
        bBuscarProcedimento = new javax.swing.JButton();
        lPesquisarProcedimento = new javax.swing.JLabel();
        mainProcedimento = new javax.swing.JPanel();
        scrollPanelProcedimento = new javax.swing.JScrollPane();
        tableProcedimentos = new javax.swing.JTable();
        sidebarScroll = new javax.swing.JScrollPane();
        sidenav = new javax.swing.JPanel();
        logo = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        pAgenda = new javax.swing.JPanel();
        iconAgenda = new javax.swing.JLabel();
        lAgenda = new javax.swing.JLabel();
        pPaciente = new javax.swing.JPanel();
        iconPaciente = new javax.swing.JLabel();
        lPaciente = new javax.swing.JLabel();
        pConsulta = new javax.swing.JPanel();
        iconConsulta = new javax.swing.JLabel();
        lConsulta = new javax.swing.JLabel();
        pAvaliacao = new javax.swing.JPanel();
        iconAvaliacao = new javax.swing.JLabel();
        lAvaliacao = new javax.swing.JLabel();
        pUsuario = new javax.swing.JPanel();
        iconUsuario = new javax.swing.JLabel();
        lUsuario = new javax.swing.JLabel();
        pSair = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lSair = new javax.swing.JLabel();
        pProfissional = new javax.swing.JPanel();
        iconProfissional = new javax.swing.JLabel();
        lProfissional = new javax.swing.JLabel();
        pProcedimento = new javax.swing.JPanel();
        iconProcedimento = new javax.swing.JLabel();
        lProcedimento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(920, 840));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(820, 640));
        bg.setPreferredSize(new java.awt.Dimension(820, 600));

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setMaximumSize(new java.awt.Dimension(600, 600));
        content.setMinimumSize(new java.awt.Dimension(600, 600));
        content.setName(""); // NOI18N
        content.setPreferredSize(new java.awt.Dimension(580, 600));
        content.setLayout(new java.awt.CardLayout());

        contentAgenda.setBackground(new java.awt.Color(255, 255, 255));
        contentAgenda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contentAgenda.setMaximumSize(new java.awt.Dimension(580, 600));
        contentAgenda.setPreferredSize(new java.awt.Dimension(580, 600));

        headerAgenda.setBackground(new java.awt.Color(255, 255, 255));

        iconContentHomeAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/house-black-building-shape.png"))); // NOI18N

        pathContentHomeAgenda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathContentHomeAgenda.setForeground(new java.awt.Color(0, 102, 52));
        pathContentHomeAgenda.setText("Agenda");

        javax.swing.GroupLayout headerAgendaLayout = new javax.swing.GroupLayout(headerAgenda);
        headerAgenda.setLayout(headerAgendaLayout);
        headerAgendaLayout.setHorizontalGroup(
            headerAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerAgendaLayout.createSequentialGroup()
                .addComponent(iconContentHomeAgenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathContentHomeAgenda)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerAgendaLayout.setVerticalGroup(
            headerAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconContentHomeAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathContentHomeAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        navButtonsAgenda.setBackground(new java.awt.Color(255, 255, 255));

        bNovoAgenda.setBackground(new java.awt.Color(0, 102, 52));
        bNovoAgenda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bNovoAgenda.setForeground(new java.awt.Color(255, 255, 255));
        bNovoAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/plus-black-symbol.png"))); // NOI18N
        bNovoAgenda.setText("Novo");
        bNovoAgenda.setBorder(null);
        bNovoAgenda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bNovoAgenda.setDoubleBuffered(true);
        bNovoAgenda.setFocusPainted(false);
        bNovoAgenda.setFocusable(false);
        bNovoAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNovoAgendaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bNovoAgendaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bNovoAgendaMouseEntered(evt);
            }
        });

        bEditarAgenda.setBackground(new java.awt.Color(0, 102, 52));
        bEditarAgenda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bEditarAgenda.setForeground(new java.awt.Color(255, 255, 255));
        bEditarAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/edit.png"))); // NOI18N
        bEditarAgenda.setText("Editar");
        bEditarAgenda.setBorder(null);
        bEditarAgenda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bEditarAgenda.setDoubleBuffered(true);
        bEditarAgenda.setFocusPainted(false);
        bEditarAgenda.setFocusable(false);
        bEditarAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditarAgendaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bEditarAgendaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bEditarAgendaMouseEntered(evt);
            }
        });

        lPesquisarAgenda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPesquisarAgenda.setText("Pesquisar: ");

        tBuscarAgenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tBuscarAgendaKeyPressed(evt);
            }
        });

        bBuscarAgenda.setBackground(new java.awt.Color(0, 102, 52));
        bBuscarAgenda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarAgenda.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        bBuscarAgenda.setBorder(null);
        bBuscarAgenda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bBuscarAgenda.setDoubleBuffered(true);
        bBuscarAgenda.setFocusPainted(false);
        bBuscarAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBuscarAgendaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bBuscarAgendaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBuscarAgendaMouseEntered(evt);
            }
        });

        lPesquisarAgenda1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPesquisarAgenda1.setText("Data:");

        tDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tDatePropertyChange(evt);
            }
        });

        bRemoverAgenda.setBackground(new java.awt.Color(0, 102, 52));
        bRemoverAgenda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bRemoverAgenda.setForeground(new java.awt.Color(255, 255, 255));
        bRemoverAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/trash.png"))); // NOI18N
        bRemoverAgenda.setText("Excluir");
        bRemoverAgenda.setBorder(null);
        bRemoverAgenda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bRemoverAgenda.setDoubleBuffered(true);
        bRemoverAgenda.setFocusPainted(false);
        bRemoverAgenda.setFocusable(false);
        bRemoverAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bRemoverAgendaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bRemoverAgendaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bRemoverAgendaMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout navButtonsAgendaLayout = new javax.swing.GroupLayout(navButtonsAgenda);
        navButtonsAgenda.setLayout(navButtonsAgendaLayout);
        navButtonsAgendaLayout.setHorizontalGroup(
            navButtonsAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsAgendaLayout.createSequentialGroup()
                .addComponent(bNovoAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditarAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRemoverAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPesquisarAgenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tBuscarAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bBuscarAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lPesquisarAgenda1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        navButtonsAgendaLayout.setVerticalGroup(
            navButtonsAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsAgendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navButtonsAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(navButtonsAgendaLayout.createSequentialGroup()
                        .addGroup(navButtonsAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tBuscarAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(navButtonsAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bNovoAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bEditarAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lPesquisarAgenda)
                                .addComponent(bRemoverAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bBuscarAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lPesquisarAgenda1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainAgenda.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanelAgenda.setBorder(null);
        scrollPanelAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrollPanelAgendaMouseClicked(evt);
            }
        });

        tableAgenda.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAgenda.setIntercellSpacing(new java.awt.Dimension(3, 3));
        tableAgenda.setRowHeight(30);
        tableAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAgendaMouseClicked(evt);
            }
        });
        scrollPanelAgenda.setViewportView(tableAgenda);

        javax.swing.GroupLayout mainAgendaLayout = new javax.swing.GroupLayout(mainAgenda);
        mainAgenda.setLayout(mainAgendaLayout);
        mainAgendaLayout.setHorizontalGroup(
            mainAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );
        mainAgendaLayout.setVerticalGroup(
            mainAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainAgendaLayout.createSequentialGroup()
                .addComponent(scrollPanelAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 153, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentAgendaLayout = new javax.swing.GroupLayout(contentAgenda);
        contentAgenda.setLayout(contentAgendaLayout);
        contentAgendaLayout.setHorizontalGroup(
            contentAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentAgendaLayout.createSequentialGroup()
                .addGroup(contentAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerAgenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navButtonsAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentAgendaLayout.setVerticalGroup(
            contentAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentAgendaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navButtonsAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );

        content.add(contentAgenda, "card2");

        contentPaciente.setBackground(new java.awt.Color(255, 255, 255));
        contentPaciente.setPreferredSize(new java.awt.Dimension(580, 600));

        headerPaciente.setBackground(new java.awt.Color(255, 255, 255));

        iconContentHomePaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/house-black-building-shape.png"))); // NOI18N

        pathContentHomePaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathContentHomePaciente.setForeground(new java.awt.Color(0, 102, 52));
        pathContentHomePaciente.setText("Home >");

        pathPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathPaciente.setText("Paciente");

        javax.swing.GroupLayout headerPacienteLayout = new javax.swing.GroupLayout(headerPaciente);
        headerPaciente.setLayout(headerPacienteLayout);
        headerPacienteLayout.setHorizontalGroup(
            headerPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPacienteLayout.createSequentialGroup()
                .addComponent(iconContentHomePaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathContentHomePaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathPaciente)
                .addGap(0, 436, Short.MAX_VALUE))
        );
        headerPacienteLayout.setVerticalGroup(
            headerPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconContentHomePaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathContentHomePaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        navButtonsPaciente.setBackground(new java.awt.Color(255, 255, 255));

        bNovoPaciente.setBackground(new java.awt.Color(0, 102, 52));
        bNovoPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bNovoPaciente.setForeground(new java.awt.Color(255, 255, 255));
        bNovoPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/plus-black-symbol.png"))); // NOI18N
        bNovoPaciente.setText("Novo");
        bNovoPaciente.setBorder(null);
        bNovoPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bNovoPaciente.setDoubleBuffered(true);
        bNovoPaciente.setFocusPainted(false);
        bNovoPaciente.setFocusable(false);
        bNovoPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNovoPacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bNovoPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bNovoPacienteMouseExited(evt);
            }
        });

        bEditarPaciente.setBackground(new java.awt.Color(0, 102, 52));
        bEditarPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bEditarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        bEditarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/edit.png"))); // NOI18N
        bEditarPaciente.setText("Editar");
        bEditarPaciente.setBorder(null);
        bEditarPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bEditarPaciente.setDoubleBuffered(true);
        bEditarPaciente.setFocusPainted(false);
        bEditarPaciente.setFocusable(false);
        bEditarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditarPacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bEditarPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bEditarPacienteMouseExited(evt);
            }
        });

        lPesquisarPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPesquisarPaciente.setText("Pesquisar: ");

        bBuscarPaciente.setBackground(new java.awt.Color(0, 102, 52));
        bBuscarPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        bBuscarPaciente.setText("Pesquisar");
        bBuscarPaciente.setBorder(null);
        bBuscarPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bBuscarPaciente.setDoubleBuffered(true);
        bBuscarPaciente.setFocusPainted(false);
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
        bBuscarPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bBuscarPacienteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout navButtonsPacienteLayout = new javax.swing.GroupLayout(navButtonsPaciente);
        navButtonsPaciente.setLayout(navButtonsPacienteLayout);
        navButtonsPacienteLayout.setHorizontalGroup(
            navButtonsPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsPacienteLayout.createSequentialGroup()
                .addComponent(bNovoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lPesquisarPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tBuscarPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        navButtonsPacienteLayout.setVerticalGroup(
            navButtonsPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navButtonsPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navButtonsPacienteLayout.createSequentialGroup()
                        .addGroup(navButtonsPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(navButtonsPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bNovoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bEditarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lPesquisarPaciente)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bBuscarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPaciente.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanelPaciente.setBorder(null);

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
        scrollPanelPaciente.setViewportView(tablePacientes);

        javax.swing.GroupLayout mainPacienteLayout = new javax.swing.GroupLayout(mainPaciente);
        mainPaciente.setLayout(mainPacienteLayout);
        mainPacienteLayout.setHorizontalGroup(
            mainPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelPaciente)
        );
        mainPacienteLayout.setVerticalGroup(
            mainPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentPacienteLayout = new javax.swing.GroupLayout(contentPaciente);
        contentPaciente.setLayout(contentPacienteLayout);
        contentPacienteLayout.setHorizontalGroup(
            contentPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPacienteLayout.createSequentialGroup()
                .addGroup(contentPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerPaciente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navButtonsPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPacienteLayout.setVerticalGroup(
            contentPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPacienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navButtonsPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );

        content.add(contentPaciente, "card2");

        contentProfissional.setBackground(new java.awt.Color(255, 255, 255));
        contentProfissional.setPreferredSize(new java.awt.Dimension(580, 600));

        headerProfissional.setBackground(new java.awt.Color(255, 255, 255));

        iconContentHomeProfissional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/house-black-building-shape.png"))); // NOI18N

        pathContentHomeProfissional.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathContentHomeProfissional.setForeground(new java.awt.Color(0, 102, 52));
        pathContentHomeProfissional.setText("Home >");

        pathProfissional.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathProfissional.setText("Profissional");

        javax.swing.GroupLayout headerProfissionalLayout = new javax.swing.GroupLayout(headerProfissional);
        headerProfissional.setLayout(headerProfissionalLayout);
        headerProfissionalLayout.setHorizontalGroup(
            headerProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerProfissionalLayout.createSequentialGroup()
                .addComponent(iconContentHomeProfissional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathContentHomeProfissional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathProfissional)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerProfissionalLayout.setVerticalGroup(
            headerProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconContentHomeProfissional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathContentHomeProfissional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathProfissional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        navButtonsProfissional.setBackground(new java.awt.Color(255, 255, 255));

        bNovoProfissional.setBackground(new java.awt.Color(0, 102, 52));
        bNovoProfissional.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bNovoProfissional.setForeground(new java.awt.Color(255, 255, 255));
        bNovoProfissional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/plus-black-symbol.png"))); // NOI18N
        bNovoProfissional.setText("Novo");
        bNovoProfissional.setBorder(null);
        bNovoProfissional.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bNovoProfissional.setDoubleBuffered(true);
        bNovoProfissional.setFocusPainted(false);
        bNovoProfissional.setFocusable(false);
        bNovoProfissional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNovoProfissionalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bNovoProfissionalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bNovoProfissionalMouseExited(evt);
            }
        });

        bEditarProfissional.setBackground(new java.awt.Color(0, 102, 52));
        bEditarProfissional.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bEditarProfissional.setForeground(new java.awt.Color(255, 255, 255));
        bEditarProfissional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/edit.png"))); // NOI18N
        bEditarProfissional.setText("Editar");
        bEditarProfissional.setBorder(null);
        bEditarProfissional.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bEditarProfissional.setDoubleBuffered(true);
        bEditarProfissional.setFocusPainted(false);
        bEditarProfissional.setFocusable(false);
        bEditarProfissional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditarProfissionalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bEditarProfissionalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bEditarProfissionalMouseExited(evt);
            }
        });

        lPesquisarProfissional.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPesquisarProfissional.setText("Pesquisar: ");

        bBuscarProfissional.setBackground(new java.awt.Color(0, 102, 52));
        bBuscarProfissional.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarProfissional.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarProfissional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        bBuscarProfissional.setBorder(null);
        bBuscarProfissional.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bBuscarProfissional.setDoubleBuffered(true);
        bBuscarProfissional.setFocusPainted(false);
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
        bBuscarProfissional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bBuscarProfissionalKeyPressed(evt);
            }
        });

        bListarEspecialidades.setBackground(new java.awt.Color(0, 102, 52));
        bListarEspecialidades.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bListarEspecialidades.setForeground(new java.awt.Color(255, 255, 255));
        bListarEspecialidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/portfolio_white.png"))); // NOI18N
        bListarEspecialidades.setText("Especialidades");
        bListarEspecialidades.setBorder(null);
        bListarEspecialidades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bListarEspecialidades.setDoubleBuffered(true);
        bListarEspecialidades.setFocusPainted(false);
        bListarEspecialidades.setFocusable(false);
        bListarEspecialidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bListarEspecialidadesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bListarEspecialidadesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bListarEspecialidadesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout navButtonsProfissionalLayout = new javax.swing.GroupLayout(navButtonsProfissional);
        navButtonsProfissional.setLayout(navButtonsProfissionalLayout);
        navButtonsProfissionalLayout.setHorizontalGroup(
            navButtonsProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsProfissionalLayout.createSequentialGroup()
                .addComponent(bNovoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditarProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bListarEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lPesquisarProfissional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tBuscarProfissional, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bBuscarProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        navButtonsProfissionalLayout.setVerticalGroup(
            navButtonsProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsProfissionalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navButtonsProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navButtonsProfissionalLayout.createSequentialGroup()
                        .addGroup(navButtonsProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(navButtonsProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tBuscarProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lPesquisarProfissional))
                            .addGroup(navButtonsProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bNovoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bEditarProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bListarEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bBuscarProfissional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainProfissional.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanelProfissional.setBorder(null);
        scrollPanelProfissional.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        tableProfissionais.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPanelProfissional.setViewportView(tableProfissionais);

        javax.swing.GroupLayout mainProfissionalLayout = new javax.swing.GroupLayout(mainProfissional);
        mainProfissional.setLayout(mainProfissionalLayout);
        mainProfissionalLayout.setHorizontalGroup(
            mainProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelProfissional)
        );
        mainProfissionalLayout.setVerticalGroup(
            mainProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelProfissional, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentProfissionalLayout = new javax.swing.GroupLayout(contentProfissional);
        contentProfissional.setLayout(contentProfissionalLayout);
        contentProfissionalLayout.setHorizontalGroup(
            contentProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentProfissionalLayout.createSequentialGroup()
                .addGroup(contentProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainProfissional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerProfissional, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navButtonsProfissional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentProfissionalLayout.setVerticalGroup(
            contentProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentProfissionalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navButtonsProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(mainProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );

        content.add(contentProfissional, "card2");

        contentUsuario.setBackground(new java.awt.Color(255, 255, 255));
        contentUsuario.setPreferredSize(new java.awt.Dimension(580, 600));

        headerUsuario.setBackground(new java.awt.Color(255, 255, 255));

        iconContentHomeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/house-black-building-shape.png"))); // NOI18N

        pathContentHomeUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathContentHomeUsuario.setForeground(new java.awt.Color(0, 102, 52));
        pathContentHomeUsuario.setText("Home >");

        pathUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathUsuario.setText("Usuário");

        javax.swing.GroupLayout headerUsuarioLayout = new javax.swing.GroupLayout(headerUsuario);
        headerUsuario.setLayout(headerUsuarioLayout);
        headerUsuarioLayout.setHorizontalGroup(
            headerUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerUsuarioLayout.createSequentialGroup()
                .addComponent(iconContentHomeUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathContentHomeUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathUsuario)
                .addGap(0, 440, Short.MAX_VALUE))
        );
        headerUsuarioLayout.setVerticalGroup(
            headerUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconContentHomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathContentHomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        navButtonsUsuario.setBackground(new java.awt.Color(255, 255, 255));

        bNovoUsuario.setBackground(new java.awt.Color(0, 102, 52));
        bNovoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bNovoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        bNovoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/plus-black-symbol.png"))); // NOI18N
        bNovoUsuario.setText("Novo");
        bNovoUsuario.setBorder(null);
        bNovoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bNovoUsuario.setDoubleBuffered(true);
        bNovoUsuario.setFocusPainted(false);
        bNovoUsuario.setFocusable(false);
        bNovoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNovoUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bNovoUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bNovoUsuarioMouseExited(evt);
            }
        });

        bEditarUsuario.setBackground(new java.awt.Color(0, 102, 52));
        bEditarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bEditarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        bEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/edit.png"))); // NOI18N
        bEditarUsuario.setText("Editar");
        bEditarUsuario.setBorder(null);
        bEditarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bEditarUsuario.setDoubleBuffered(true);
        bEditarUsuario.setFocusPainted(false);
        bEditarUsuario.setFocusable(false);
        bEditarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditarUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bEditarUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bEditarUsuarioMouseExited(evt);
            }
        });

        lPesquisarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPesquisarUsuario.setText("Pesquisar: ");

        bBuscarUsuario.setBackground(new java.awt.Color(0, 102, 52));
        bBuscarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        bBuscarUsuario.setText("Pesquisar");
        bBuscarUsuario.setBorder(null);
        bBuscarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bBuscarUsuario.setDoubleBuffered(true);
        bBuscarUsuario.setFocusPainted(false);
        bBuscarUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bBuscarUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bBuscarUsuarioFocusLost(evt);
            }
        });
        bBuscarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBuscarUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBuscarUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bBuscarUsuarioMouseExited(evt);
            }
        });
        bBuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bBuscarUsuarioKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout navButtonsUsuarioLayout = new javax.swing.GroupLayout(navButtonsUsuario);
        navButtonsUsuario.setLayout(navButtonsUsuarioLayout);
        navButtonsUsuarioLayout.setHorizontalGroup(
            navButtonsUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsUsuarioLayout.createSequentialGroup()
                .addComponent(bNovoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lPesquisarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tBuscarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        navButtonsUsuarioLayout.setVerticalGroup(
            navButtonsUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navButtonsUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navButtonsUsuarioLayout.createSequentialGroup()
                        .addGroup(navButtonsUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(navButtonsUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bNovoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lPesquisarUsuario)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bBuscarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainUsuario.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanelUsuario.setBorder(null);
        scrollPanelUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPanelUsuario.setViewportView(tableUsuarios);

        javax.swing.GroupLayout mainUsuarioLayout = new javax.swing.GroupLayout(mainUsuario);
        mainUsuario.setLayout(mainUsuarioLayout);
        mainUsuarioLayout.setHorizontalGroup(
            mainUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelUsuario)
        );
        mainUsuarioLayout.setVerticalGroup(
            mainUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainUsuarioLayout.createSequentialGroup()
                .addComponent(scrollPanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentUsuarioLayout = new javax.swing.GroupLayout(contentUsuario);
        contentUsuario.setLayout(contentUsuarioLayout);
        contentUsuarioLayout.setHorizontalGroup(
            contentUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentUsuarioLayout.createSequentialGroup()
                .addGroup(contentUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navButtonsUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentUsuarioLayout.setVerticalGroup(
            contentUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navButtonsUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(mainUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );

        content.add(contentUsuario, "card2");

        contentConsulta.setBackground(new java.awt.Color(255, 255, 255));
        contentConsulta.setPreferredSize(new java.awt.Dimension(580, 600));

        headerFisioterapia.setBackground(new java.awt.Color(255, 255, 255));

        iconContentHomeFisioterapia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/house-black-building-shape.png"))); // NOI18N

        pathContentHomeFisioterapia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathContentHomeFisioterapia.setForeground(new java.awt.Color(0, 102, 52));
        pathContentHomeFisioterapia.setText("Home >");

        pathFisioterapia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathFisioterapia.setText("Consulta");

        javax.swing.GroupLayout headerFisioterapiaLayout = new javax.swing.GroupLayout(headerFisioterapia);
        headerFisioterapia.setLayout(headerFisioterapiaLayout);
        headerFisioterapiaLayout.setHorizontalGroup(
            headerFisioterapiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerFisioterapiaLayout.createSequentialGroup()
                .addComponent(iconContentHomeFisioterapia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathContentHomeFisioterapia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathFisioterapia)
                .addGap(0, 412, Short.MAX_VALUE))
        );
        headerFisioterapiaLayout.setVerticalGroup(
            headerFisioterapiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconContentHomeFisioterapia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathContentHomeFisioterapia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathFisioterapia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        navButtonsFisioterapia.setBackground(new java.awt.Color(255, 255, 255));

        bNovoConsulta.setBackground(new java.awt.Color(0, 102, 52));
        bNovoConsulta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bNovoConsulta.setForeground(new java.awt.Color(255, 255, 255));
        bNovoConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/plus-black-symbol.png"))); // NOI18N
        bNovoConsulta.setText("Novo");
        bNovoConsulta.setBorder(null);
        bNovoConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bNovoConsulta.setDoubleBuffered(true);
        bNovoConsulta.setFocusPainted(false);
        bNovoConsulta.setFocusable(false);
        bNovoConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNovoConsultaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bNovoConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bNovoConsultaMouseExited(evt);
            }
        });

        bEditarConsulta.setBackground(new java.awt.Color(0, 102, 52));
        bEditarConsulta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bEditarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        bEditarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/edit.png"))); // NOI18N
        bEditarConsulta.setText("Editar");
        bEditarConsulta.setBorder(null);
        bEditarConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bEditarConsulta.setDoubleBuffered(true);
        bEditarConsulta.setFocusPainted(false);
        bEditarConsulta.setFocusable(false);
        bEditarConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditarConsultaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bEditarConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bEditarConsultaMouseExited(evt);
            }
        });

        lPesquisarFisioterapia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPesquisarFisioterapia.setText("Pesquisar: ");

        bBuscarConsulta.setBackground(new java.awt.Color(0, 102, 52));
        bBuscarConsulta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        bBuscarConsulta.setText("Pesquisar");
        bBuscarConsulta.setBorder(null);
        bBuscarConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        bHistoricoConsulta.setBackground(new java.awt.Color(0, 102, 52));
        bHistoricoConsulta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bHistoricoConsulta.setForeground(new java.awt.Color(255, 255, 255));
        bHistoricoConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/historico.png"))); // NOI18N
        bHistoricoConsulta.setText("Histórico");
        bHistoricoConsulta.setBorder(null);
        bHistoricoConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bHistoricoConsulta.setDoubleBuffered(true);
        bHistoricoConsulta.setFocusPainted(false);
        bHistoricoConsulta.setFocusable(false);
        bHistoricoConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bHistoricoConsultaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bHistoricoConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bHistoricoConsultaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout navButtonsFisioterapiaLayout = new javax.swing.GroupLayout(navButtonsFisioterapia);
        navButtonsFisioterapia.setLayout(navButtonsFisioterapiaLayout);
        navButtonsFisioterapiaLayout.setHorizontalGroup(
            navButtonsFisioterapiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsFisioterapiaLayout.createSequentialGroup()
                .addComponent(bNovoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bHistoricoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lPesquisarFisioterapia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tBuscarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bBuscarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        navButtonsFisioterapiaLayout.setVerticalGroup(
            navButtonsFisioterapiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsFisioterapiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navButtonsFisioterapiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navButtonsFisioterapiaLayout.createSequentialGroup()
                        .addGroup(navButtonsFisioterapiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tBuscarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(navButtonsFisioterapiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bNovoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bEditarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lPesquisarFisioterapia)
                                .addComponent(bHistoricoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bBuscarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainFisioterapia.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanelConsulta.setBorder(null);
        scrollPanelConsulta.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        scrollPanelConsulta.setMinimumSize(null);

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
        scrollPanelConsulta.setViewportView(tableConsultas);

        javax.swing.GroupLayout mainFisioterapiaLayout = new javax.swing.GroupLayout(mainFisioterapia);
        mainFisioterapia.setLayout(mainFisioterapiaLayout);
        mainFisioterapiaLayout.setHorizontalGroup(
            mainFisioterapiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainFisioterapiaLayout.setVerticalGroup(
            mainFisioterapiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentConsultaLayout = new javax.swing.GroupLayout(contentConsulta);
        contentConsulta.setLayout(contentConsultaLayout);
        contentConsultaLayout.setHorizontalGroup(
            contentConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentConsultaLayout.createSequentialGroup()
                .addGroup(contentConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainFisioterapia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerFisioterapia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navButtonsFisioterapia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentConsultaLayout.setVerticalGroup(
            contentConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentConsultaLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(headerFisioterapia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navButtonsFisioterapia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(mainFisioterapia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        content.add(contentConsulta, "card2");

        contentAvaliacao.setBackground(new java.awt.Color(255, 255, 255));
        contentAvaliacao.setPreferredSize(new java.awt.Dimension(580, 600));

        headerAvaliacao.setBackground(new java.awt.Color(255, 255, 255));

        iconContentHomeAvaliacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/house-black-building-shape.png"))); // NOI18N

        pathContentHomeAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathContentHomeAvaliacao.setForeground(new java.awt.Color(0, 102, 52));
        pathContentHomeAvaliacao.setText("Home >");

        pathAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathAvaliacao.setText("Avaliação");

        javax.swing.GroupLayout headerAvaliacaoLayout = new javax.swing.GroupLayout(headerAvaliacao);
        headerAvaliacao.setLayout(headerAvaliacaoLayout);
        headerAvaliacaoLayout.setHorizontalGroup(
            headerAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerAvaliacaoLayout.createSequentialGroup()
                .addComponent(iconContentHomeAvaliacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathContentHomeAvaliacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathAvaliacao)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerAvaliacaoLayout.setVerticalGroup(
            headerAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconContentHomeAvaliacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathContentHomeAvaliacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathAvaliacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        navButtonsAvaliacao.setBackground(new java.awt.Color(255, 255, 255));

        lPesquisarAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPesquisarAvaliacao.setText("Pesquisar: ");

        bBuscarAvaliacao.setBackground(new java.awt.Color(0, 102, 52));
        bBuscarAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarAvaliacao.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarAvaliacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        bBuscarAvaliacao.setText("Pesquisar");
        bBuscarAvaliacao.setBorder(null);
        bBuscarAvaliacao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bBuscarAvaliacao.setDoubleBuffered(true);
        bBuscarAvaliacao.setFocusPainted(false);
        bBuscarAvaliacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bBuscarAvaliacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bBuscarAvaliacaoFocusLost(evt);
            }
        });
        bBuscarAvaliacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBuscarAvaliacaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBuscarAvaliacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bBuscarAvaliacaoMouseExited(evt);
            }
        });
        bBuscarAvaliacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bBuscarAvaliacaoKeyPressed(evt);
            }
        });

        bNovoAvaliacao.setBackground(new java.awt.Color(0, 102, 52));
        bNovoAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bNovoAvaliacao.setForeground(new java.awt.Color(255, 255, 255));
        bNovoAvaliacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/plus-black-symbol.png"))); // NOI18N
        bNovoAvaliacao.setText("Novo");
        bNovoAvaliacao.setBorder(null);
        bNovoAvaliacao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bNovoAvaliacao.setDoubleBuffered(true);
        bNovoAvaliacao.setFocusPainted(false);
        bNovoAvaliacao.setFocusable(false);
        bNovoAvaliacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNovoAvaliacaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bNovoAvaliacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bNovoAvaliacaoMouseExited(evt);
            }
        });

        bEditarAvaliacao.setBackground(new java.awt.Color(0, 102, 52));
        bEditarAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bEditarAvaliacao.setForeground(new java.awt.Color(255, 255, 255));
        bEditarAvaliacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/edit.png"))); // NOI18N
        bEditarAvaliacao.setText("Editar");
        bEditarAvaliacao.setBorder(null);
        bEditarAvaliacao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bEditarAvaliacao.setDoubleBuffered(true);
        bEditarAvaliacao.setFocusPainted(false);
        bEditarAvaliacao.setFocusable(false);
        bEditarAvaliacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditarAvaliacaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bEditarAvaliacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bEditarAvaliacaoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout navButtonsAvaliacaoLayout = new javax.swing.GroupLayout(navButtonsAvaliacao);
        navButtonsAvaliacao.setLayout(navButtonsAvaliacaoLayout);
        navButtonsAvaliacaoLayout.setHorizontalGroup(
            navButtonsAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsAvaliacaoLayout.createSequentialGroup()
                .addComponent(bNovoAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditarAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lPesquisarAvaliacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tBuscarAvaliacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bBuscarAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        navButtonsAvaliacaoLayout.setVerticalGroup(
            navButtonsAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsAvaliacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navButtonsAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navButtonsAvaliacaoLayout.createSequentialGroup()
                        .addGroup(navButtonsAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(navButtonsAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bNovoAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bEditarAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lPesquisarAvaliacao))
                            .addComponent(tBuscarAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bBuscarAvaliacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainAvaliacao.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanelAvaliacao.setBorder(null);
        scrollPanelAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        scrollPanelAvaliacao.setMinimumSize(null);

        tableAvaliacoes.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPanelAvaliacao.setViewportView(tableAvaliacoes);

        javax.swing.GroupLayout mainAvaliacaoLayout = new javax.swing.GroupLayout(mainAvaliacao);
        mainAvaliacao.setLayout(mainAvaliacaoLayout);
        mainAvaliacaoLayout.setHorizontalGroup(
            mainAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelAvaliacao, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );
        mainAvaliacaoLayout.setVerticalGroup(
            mainAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelAvaliacao, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentAvaliacaoLayout = new javax.swing.GroupLayout(contentAvaliacao);
        contentAvaliacao.setLayout(contentAvaliacaoLayout);
        contentAvaliacaoLayout.setHorizontalGroup(
            contentAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentAvaliacaoLayout.createSequentialGroup()
                .addGroup(contentAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainAvaliacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerAvaliacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navButtonsAvaliacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentAvaliacaoLayout.setVerticalGroup(
            contentAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentAvaliacaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navButtonsAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(mainAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );

        content.add(contentAvaliacao, "card2");

        contentProcedimento.setBackground(new java.awt.Color(255, 255, 255));
        contentProcedimento.setPreferredSize(new java.awt.Dimension(580, 600));

        headerProcedimento.setBackground(new java.awt.Color(255, 255, 255));

        iconContentHomeProcedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/house-black-building-shape.png"))); // NOI18N

        pathContentHomeProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathContentHomeProcedimento.setForeground(new java.awt.Color(0, 102, 52));
        pathContentHomeProcedimento.setText("Home >");

        pathProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pathProcedimento.setText("Procedimento");

        javax.swing.GroupLayout headerProcedimentoLayout = new javax.swing.GroupLayout(headerProcedimento);
        headerProcedimento.setLayout(headerProcedimentoLayout);
        headerProcedimentoLayout.setHorizontalGroup(
            headerProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerProcedimentoLayout.createSequentialGroup()
                .addComponent(iconContentHomeProcedimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathContentHomeProcedimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathProcedimento)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerProcedimentoLayout.setVerticalGroup(
            headerProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconContentHomeProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathContentHomeProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pathProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        navButtonsProcedimento.setBackground(new java.awt.Color(255, 255, 255));

        bNovoProcedimento.setBackground(new java.awt.Color(0, 102, 52));
        bNovoProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bNovoProcedimento.setForeground(new java.awt.Color(255, 255, 255));
        bNovoProcedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/plus-black-symbol.png"))); // NOI18N
        bNovoProcedimento.setText("Novo");
        bNovoProcedimento.setBorder(null);
        bNovoProcedimento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bNovoProcedimento.setDoubleBuffered(true);
        bNovoProcedimento.setFocusPainted(false);
        bNovoProcedimento.setFocusable(false);
        bNovoProcedimento.setRequestFocusEnabled(false);
        bNovoProcedimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNovoProcedimentoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bNovoProcedimentoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bNovoProcedimentoMouseEntered(evt);
            }
        });

        bEditarProcedimento.setBackground(new java.awt.Color(0, 102, 52));
        bEditarProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bEditarProcedimento.setForeground(new java.awt.Color(255, 255, 255));
        bEditarProcedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/edit.png"))); // NOI18N
        bEditarProcedimento.setText("Editar");
        bEditarProcedimento.setBorder(null);
        bEditarProcedimento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bEditarProcedimento.setDoubleBuffered(true);
        bEditarProcedimento.setFocusPainted(false);
        bEditarProcedimento.setFocusable(false);
        bEditarProcedimento.setRequestFocusEnabled(false);
        bEditarProcedimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditarProcedimentoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bEditarProcedimentoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bEditarProcedimentoMouseEntered(evt);
            }
        });

        bRemoverProcedimento.setBackground(new java.awt.Color(0, 102, 52));
        bRemoverProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bRemoverProcedimento.setForeground(new java.awt.Color(255, 255, 255));
        bRemoverProcedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/trash.png"))); // NOI18N
        bRemoverProcedimento.setText("Excluir");
        bRemoverProcedimento.setBorder(null);
        bRemoverProcedimento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bRemoverProcedimento.setDoubleBuffered(true);
        bRemoverProcedimento.setFocusPainted(false);
        bRemoverProcedimento.setFocusable(false);
        bRemoverProcedimento.setRequestFocusEnabled(false);
        bRemoverProcedimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bRemoverProcedimentoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bRemoverProcedimentoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bRemoverProcedimentoMouseEntered(evt);
            }
        });

        bBuscarProcedimento.setBackground(new java.awt.Color(0, 102, 52));
        bBuscarProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bBuscarProcedimento.setForeground(new java.awt.Color(255, 255, 255));
        bBuscarProcedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        bBuscarProcedimento.setBorder(null);
        bBuscarProcedimento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bBuscarProcedimento.setDoubleBuffered(true);
        bBuscarProcedimento.setFocusPainted(false);
        bBuscarProcedimento.setRequestFocusEnabled(false);
        bBuscarProcedimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bBuscarProcedimentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bBuscarProcedimentoFocusLost(evt);
            }
        });
        bBuscarProcedimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBuscarProcedimentoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bBuscarProcedimentoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBuscarProcedimentoMouseEntered(evt);
            }
        });
        bBuscarProcedimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bBuscarProcedimentoKeyPressed(evt);
            }
        });

        lPesquisarProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPesquisarProcedimento.setText("Pesquisar: ");

        javax.swing.GroupLayout navButtonsProcedimentoLayout = new javax.swing.GroupLayout(navButtonsProcedimento);
        navButtonsProcedimento.setLayout(navButtonsProcedimentoLayout);
        navButtonsProcedimentoLayout.setHorizontalGroup(
            navButtonsProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navButtonsProcedimentoLayout.createSequentialGroup()
                .addComponent(bNovoProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditarProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRemoverProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(lPesquisarProcedimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tBuscarProcedimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bBuscarProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        navButtonsProcedimentoLayout.setVerticalGroup(
            navButtonsProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navButtonsProcedimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navButtonsProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bBuscarProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tBuscarProcedimento, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bNovoProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bEditarProcedimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(navButtonsProcedimentoLayout.createSequentialGroup()
                        .addGroup(navButtonsProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lPesquisarProcedimento)
                            .addComponent(bRemoverProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mainProcedimento.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanelProcedimento.setBorder(null);
        scrollPanelProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        scrollPanelProcedimento.setRequestFocusEnabled(false);

        tableProcedimentos.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPanelProcedimento.setViewportView(tableProcedimentos);

        javax.swing.GroupLayout mainProcedimentoLayout = new javax.swing.GroupLayout(mainProcedimento);
        mainProcedimento.setLayout(mainProcedimentoLayout);
        mainProcedimentoLayout.setHorizontalGroup(
            mainProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );
        mainProcedimentoLayout.setVerticalGroup(
            mainProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelProcedimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentProcedimentoLayout = new javax.swing.GroupLayout(contentProcedimento);
        contentProcedimento.setLayout(contentProcedimentoLayout);
        contentProcedimentoLayout.setHorizontalGroup(
            contentProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentProcedimentoLayout.createSequentialGroup()
                .addGroup(contentProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerProcedimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navButtonsProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentProcedimentoLayout.setVerticalGroup(
            contentProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentProcedimentoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navButtonsProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(mainProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );

        content.add(contentProcedimento, "card2");

        sidenav.setBackground(new java.awt.Color(255, 255, 255));
        sidenav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setBackground(new java.awt.Color(255, 255, 255));

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_side_nav.png"))); // NOI18N

        javax.swing.GroupLayout logoLayout = new javax.swing.GroupLayout(logo);
        logo.setLayout(logoLayout);
        logoLayout.setHorizontalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoLayout.createSequentialGroup()
                .addComponent(labelLogo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        logoLayout.setVerticalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelLogo)
        );

        sidenav.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pAgenda.setBackground(new java.awt.Color(255, 255, 255));
        pAgenda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pAgendaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pAgendaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pAgendaMouseExited(evt);
            }
        });

        iconAgenda.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iconAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/calendar.png"))); // NOI18N

        lAgenda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lAgenda.setText("Agenda");

        javax.swing.GroupLayout pAgendaLayout = new javax.swing.GroupLayout(pAgenda);
        pAgenda.setLayout(pAgendaLayout);
        pAgendaLayout.setHorizontalGroup(
            pAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAgendaLayout.createSequentialGroup()
                .addComponent(iconAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        pAgendaLayout.setVerticalGroup(
            pAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidenav.add(pAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 200, 50));

        pPaciente.setBackground(new java.awt.Color(255, 255, 255));
        pPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pPacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pPacienteMouseExited(evt);
            }
        });

        iconPaciente.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iconPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/team.png"))); // NOI18N

        lPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lPaciente.setText("Paciente");

        javax.swing.GroupLayout pPacienteLayout = new javax.swing.GroupLayout(pPaciente);
        pPaciente.setLayout(pPacienteLayout);
        pPacienteLayout.setHorizontalGroup(
            pPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPacienteLayout.createSequentialGroup()
                .addComponent(iconPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        pPacienteLayout.setVerticalGroup(
            pPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidenav.add(pPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 50));

        pConsulta.setBackground(new java.awt.Color(255, 255, 255));
        pConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pConsultaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pConsultaMouseExited(evt);
            }
        });

        iconConsulta.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iconConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/physiotherapy.png"))); // NOI18N

        lConsulta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lConsulta.setText("Consulta");

        javax.swing.GroupLayout pConsultaLayout = new javax.swing.GroupLayout(pConsulta);
        pConsulta.setLayout(pConsultaLayout);
        pConsultaLayout.setHorizontalGroup(
            pConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pConsultaLayout.createSequentialGroup()
                .addComponent(iconConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );
        pConsultaLayout.setVerticalGroup(
            pConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidenav.add(pConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 200, 50));

        pAvaliacao.setBackground(new java.awt.Color(255, 255, 255));
        pAvaliacao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pAvaliacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pAvaliacaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pAvaliacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pAvaliacaoMouseExited(evt);
            }
        });

        iconAvaliacao.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iconAvaliacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/check-form.png"))); // NOI18N

        lAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lAvaliacao.setText("Avaliação");

        javax.swing.GroupLayout pAvaliacaoLayout = new javax.swing.GroupLayout(pAvaliacao);
        pAvaliacao.setLayout(pAvaliacaoLayout);
        pAvaliacaoLayout.setHorizontalGroup(
            pAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAvaliacaoLayout.createSequentialGroup()
                .addComponent(iconAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 60, Short.MAX_VALUE))
        );
        pAvaliacaoLayout.setVerticalGroup(
            pAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconAvaliacao, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lAvaliacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidenav.add(pAvaliacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 200, 50));

        pUsuario.setBackground(new java.awt.Color(255, 255, 255));
        pUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pUsuarioMouseExited(evt);
            }
        });

        iconUsuario.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iconUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/user_24.png"))); // NOI18N

        lUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lUsuario.setText("Usuário");

        javax.swing.GroupLayout pUsuarioLayout = new javax.swing.GroupLayout(pUsuario);
        pUsuario.setLayout(pUsuarioLayout);
        pUsuarioLayout.setHorizontalGroup(
            pUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUsuarioLayout.createSequentialGroup()
                .addComponent(iconUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
        );
        pUsuarioLayout.setVerticalGroup(
            pUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidenav.add(pUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 200, 50));

        pSair.setBackground(new java.awt.Color(255, 255, 255));
        pSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pSairMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pSairMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pSairMouseEntered(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/sair.png"))); // NOI18N

        lSair.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lSair.setText("Sair");

        javax.swing.GroupLayout pSairLayout = new javax.swing.GroupLayout(pSair);
        pSair.setLayout(pSairLayout);
        pSairLayout.setHorizontalGroup(
            pSairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSairLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lSair, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
        );
        pSairLayout.setVerticalGroup(
            pSairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidenav.add(pSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 200, 50));

        pProfissional.setBackground(new java.awt.Color(255, 255, 255));
        pProfissional.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pProfissional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pProfissionalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pProfissionalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pProfissionalMouseExited(evt);
            }
        });

        iconProfissional.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iconProfissional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/doctor.png"))); // NOI18N

        lProfissional.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lProfissional.setText("Profissional");

        javax.swing.GroupLayout pProfissionalLayout = new javax.swing.GroupLayout(pProfissional);
        pProfissional.setLayout(pProfissionalLayout);
        pProfissionalLayout.setHorizontalGroup(
            pProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProfissionalLayout.createSequentialGroup()
                .addComponent(iconProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );
        pProfissionalLayout.setVerticalGroup(
            pProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconProfissional, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lProfissional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidenav.add(pProfissional, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, 50));

        pProcedimento.setBackground(new java.awt.Color(255, 255, 255));
        pProcedimento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pProcedimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pProcedimentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pProcedimentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pProcedimentoMouseExited(evt);
            }
        });

        iconProcedimento.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iconProcedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/list.png"))); // NOI18N

        lProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lProcedimento.setText("Procedimento");

        javax.swing.GroupLayout pProcedimentoLayout = new javax.swing.GroupLayout(pProcedimento);
        pProcedimento.setLayout(pProcedimentoLayout);
        pProcedimentoLayout.setHorizontalGroup(
            pProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProcedimentoLayout.createSequentialGroup()
                .addComponent(iconProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );
        pProcedimentoLayout.setVerticalGroup(
            pProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidenav.add(pProcedimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 200, 50));

        sidebarScroll.setViewportView(sidenav);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(sidebarScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(sidebarScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        getContentPane().add(bg, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pProcedimentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pProcedimentoMouseExited
        if(this.currentTela != 9) {
            pProcedimento.setBackground(Color.decode("#FFFFFF"));
            lProcedimento.setForeground(Color.decode("#000000"));
        }
    }//GEN-LAST:event_pProcedimentoMouseExited

    private void pProcedimentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pProcedimentoMouseEntered
        if(this.currentTela != 9) {
            pProcedimento.setBackground(Color.decode("#F0F0F0"));
            lProcedimento.setForeground(Color.decode("#006634"));
        }
    }//GEN-LAST:event_pProcedimentoMouseEntered

    private void pProcedimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pProcedimentoMouseClicked
        scrollPanelProcedimento.getViewport().setBackground(Color.WHITE);
        ProcedimentoController pc = new ProcedimentoController();
        List<Procedimento> profissionais = pc.procedimentos();
        if(profissionais!=null)
        tableModelProcedimentos.addLista(profissionais);
        tableProcedimentos.setModel(tableModelProcedimentos);
        // Change column size
        tableProcedimentos.getColumnModel().getColumn(0).setPreferredWidth(5);
        bNovoProcedimento.setModel(new FixedButtonModel());
        bNovoProcedimento.setBorder(BorderFactory.createEtchedBorder(0));
        bEditarProcedimento.setModel(new FixedButtonModel());
        bEditarProcedimento.setBorder(BorderFactory.createEtchedBorder(0));
        bBuscarProcedimento.setModel(new FixedButtonModel());
        bBuscarProcedimento.setBorder(BorderFactory.createEtchedBorder(0));
        bRemoverProcedimento.setModel(new FixedButtonModel());
        bRemoverProcedimento.setBorder(BorderFactory.createEtchedBorder(0));
        this.setTitle("Gerenciamento de Procedimentos");
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/list.png")).getImage());
        this.currentTela = 9;
        content.removeAll();
        content.repaint();
        content.revalidate();
        removeActiveItemMenu();
        pProcedimento.setBackground(Color.decode("#F0F0F0"));
        lProcedimento.setForeground(Color.decode("#006634"));
        content.add(contentProcedimento);
        this.tBuscarProcedimento.requestFocusInWindow();
    }//GEN-LAST:event_pProcedimentoMouseClicked

    private void pProfissionalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pProfissionalMouseExited
        if(this.currentTela != 8) {
            pProfissional.setBackground(Color.decode("#FFFFFF"));
            lProfissional.setForeground(Color.decode("#000000"));
        }
    }//GEN-LAST:event_pProfissionalMouseExited

    private void pProfissionalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pProfissionalMouseEntered
        if(this.currentTela != 8) {
            pProfissional.setBackground(Color.decode("#F0F0F0"));
            lProfissional.setForeground(Color.decode("#006634"));
        }
    }//GEN-LAST:event_pProfissionalMouseEntered

    private void pProfissionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pProfissionalMouseClicked
        scrollPanelProfissional.getViewport().setBackground(Color.WHITE);
        ProfissionalController pc = new ProfissionalController();
        List<Profissional> profissionais = pc.profissionais();
        if(profissionais!=null)
        tableModelProfissional.addLista(profissionais);
        tableProfissionais.setModel(tableModelProfissional);
        // Change column size
        tableProfissionais.getColumnModel().getColumn(0).setPreferredWidth(5);
        tableProfissionais.getColumnModel().getColumn(1).setPreferredWidth(400);
        tableProfissionais.getColumnModel().getColumn(2).setPreferredWidth(10);
        bNovoProfissional.setModel(new FixedButtonModel());
        bNovoProfissional.setBorder(BorderFactory.createEtchedBorder(0));
        bEditarProfissional.setModel(new FixedButtonModel());
        bEditarProfissional.setBorder(BorderFactory.createEtchedBorder(0));
        bBuscarProfissional.setModel(new FixedButtonModel());
        bBuscarProfissional.setBorder(BorderFactory.createEtchedBorder(0));
        bListarEspecialidades.setModel(new FixedButtonModel());
        bListarEspecialidades.setBorder(BorderFactory.createEtchedBorder(0));
        this.setTitle("Gerenciamento de Profissionais");
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/doctor.png")).getImage());
        this.currentTela = 8;
        content.removeAll();
        content.repaint();
        content.revalidate();
        removeActiveItemMenu();
        pProfissional.setBackground(Color.decode("#F0F0F0"));
        lProfissional.setForeground(Color.decode("#006634"));
        content.add(contentProfissional);
        this.tBuscarProfissional.requestFocusInWindow();
    }//GEN-LAST:event_pProfissionalMouseClicked

    private void pSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pSairMouseEntered
        if(this.currentTela != 8) {
            pSair.setBackground(Color.decode("#F0F0F0"));
            lSair.setForeground(Color.decode("#006634"));
        }
    }//GEN-LAST:event_pSairMouseEntered

    private void pSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pSairMouseExited
        if(this.currentTela != 8) {
            pSair.setBackground(Color.decode("#FFFFFF"));
            lSair.setForeground(Color.decode("#000000"));
        }
    }//GEN-LAST:event_pSairMouseExited

    private void pSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pSairMouseClicked
        int buttonOption = JOptionPane.YES_NO_OPTION;
        int option = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar logout ?", "Atenção", buttonOption);
        if(option == JOptionPane.YES_OPTION){
            dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_pSairMouseClicked

    private void pUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pUsuarioMouseExited
        if(this.currentTela != 7) {
            pUsuario.setBackground(Color.decode("#FFFFFF"));
            lUsuario.setForeground(Color.decode("#000000"));
        }
    }//GEN-LAST:event_pUsuarioMouseExited

    private void pUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pUsuarioMouseEntered
        if(this.currentTela != 7) {
            pUsuario.setBackground(Color.decode("#F0F0F0"));
            lUsuario.setForeground(Color.decode("#006634"));
        }
    }//GEN-LAST:event_pUsuarioMouseEntered

    private void pUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pUsuarioMouseClicked
        scrollPanelUsuario.getViewport().setBackground(Color.WHITE);
        // Created table
        UsuarioController uc = new UsuarioController();
        List<Usuario> usuarios = uc.usuarios();
        if(usuarios!=null)
        tableModelUsuario.addLista(usuarios);
        tableUsuarios.setModel(tableModelUsuario);
        // Change column size
        tableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(5);
        tableUsuarios.getColumnModel().getColumn(1).setPreferredWidth(400);
        tableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(10);
        // Fim created table
        bNovoUsuario.setModel(new FixedButtonModel());
        bNovoUsuario.setBorder(BorderFactory.createEtchedBorder(0));
        bEditarUsuario.setModel(new FixedButtonModel());
        bEditarUsuario.setBorder(BorderFactory.createEtchedBorder(0));
        bBuscarUsuario.setModel(new FixedButtonModel());
        bBuscarUsuario.setBorder(BorderFactory.createEtchedBorder(0));
        this.setTitle("Gerenciamento de Usuários");
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/user_24.png")).getImage());
        this.currentTela = 7;
        content.removeAll();
        content.repaint();
        content.revalidate();
        removeActiveItemMenu();
        pUsuario.setBackground(Color.decode("#F0F0F0"));
        lUsuario.setForeground(Color.decode("#006634"));
        content.add(contentUsuario);
        this.tBuscarUsuario.requestFocusInWindow();
    }//GEN-LAST:event_pUsuarioMouseClicked

    private void pAvaliacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pAvaliacaoMouseExited
        if(this.currentTela != 5) {
            pAvaliacao.setBackground(Color.decode("#FFFFFF"));
            lAvaliacao.setForeground(Color.decode("#000000"));
        }
    }//GEN-LAST:event_pAvaliacaoMouseExited

    private void pAvaliacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pAvaliacaoMouseEntered
        if(this.currentTela != 5) {
            pAvaliacao.setBackground(Color.decode("#F0F0F0"));
            lAvaliacao.setForeground(Color.decode("#006634"));
        }
    }//GEN-LAST:event_pAvaliacaoMouseEntered

    private void pAvaliacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pAvaliacaoMouseClicked
        scrollPanelConsulta.getViewport().setBackground(Color.WHITE);
        // Created table
        AvaliacaoController ac = new AvaliacaoController();
        List<Avaliacao> avaliacoes = ac.avaliacoes();
        if(avaliacoes!=null)
        tableModelAvaliacao.addLista(avaliacoes);
        tableAvaliacoes.setModel(tableModelAvaliacao);
        // Change column size
        tableAvaliacoes.getColumnModel().getColumn(0).setPreferredWidth(5);
        tableAvaliacoes.getColumnModel().getColumn(1).setPreferredWidth(300);
        tableAvaliacoes.getColumnModel().getColumn(2).setPreferredWidth(300);
        tableAvaliacoes.getColumnModel().getColumn(3).setPreferredWidth(10);
        // Fim created table
        //bNovoAvaliacao.setModel(new FixedButtonModel());
        //bNovoAvaliacao.setBorder(BorderFactory.createEtchedBorder(0));
        //bEditarAvaliacao.setModel(new FixedButtonModel());
        //bEditarAvaliacao.setBorder(BorderFactory.createEtchedBorder(0));
        bBuscarAvaliacao.setModel(new FixedButtonModel());
        bBuscarAvaliacao.setBorder(BorderFactory.createEtchedBorder(0));
        bNovoAvaliacao.setModel(new FixedButtonModel());
        bNovoAvaliacao.setBorder(BorderFactory.createEtchedBorder(0));
        bEditarAvaliacao.setModel(new FixedButtonModel());
        bEditarAvaliacao.setBorder(BorderFactory.createEtchedBorder(0));
        this.setTitle("Gerenciamento de Avaliações");
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/check-form.png")).getImage());
        this.currentTela = 5;
        content.removeAll();
        content.repaint();
        content.revalidate();
        removeActiveItemMenu();
        pAvaliacao.setBackground(Color.decode("#F0F0F0"));
        lAvaliacao.setForeground(Color.decode("#006634"));
        content.add(contentAvaliacao);
        this.tBuscarAvaliacao.requestFocusInWindow();
    }//GEN-LAST:event_pAvaliacaoMouseClicked

    private void pConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pConsultaMouseExited
        if(this.currentTela != 4) {
            pConsulta.setBackground(Color.decode("#FFFFFF"));
            lConsulta.setForeground(Color.decode("#000000"));
        }
    }//GEN-LAST:event_pConsultaMouseExited

    private void pConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pConsultaMouseEntered
        if(this.currentTela != 4) {
            pConsulta.setBackground(Color.decode("#F0F0F0"));
            lConsulta.setForeground(Color.decode("#006634"));
        }
    }//GEN-LAST:event_pConsultaMouseEntered

    private void pConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pConsultaMouseClicked
        scrollPanelConsulta.getViewport().setBackground(Color.WHITE);
        // Created table
        ConsultaController cc = new ConsultaController();
        List<Consulta> consultas = cc.consultas();
        if(consultas!=null)
        tableModelConsultas.addLista(consultas);
        tableConsultas.setModel(tableModelConsultas);
        // Change column size
        tableConsultas.getColumnModel().getColumn(0).setPreferredWidth(5);
        tableConsultas.getColumnModel().getColumn(1).setPreferredWidth(300);
        tableConsultas.getColumnModel().getColumn(2).setPreferredWidth(300);
        tableConsultas.getColumnModel().getColumn(3).setPreferredWidth(10);
        // Fim created table
        bNovoConsulta.setModel(new FixedButtonModel());
        bNovoConsulta.setBorder(BorderFactory.createEtchedBorder(0));
        bEditarConsulta.setModel(new FixedButtonModel());
        bEditarConsulta.setBorder(BorderFactory.createEtchedBorder(0));
        bBuscarConsulta.setModel(new FixedButtonModel());
        bBuscarConsulta.setBorder(BorderFactory.createEtchedBorder(0));
        bHistoricoConsulta.setModel(new FixedButtonModel());
        bHistoricoConsulta.setBorder(BorderFactory.createEtchedBorder(0));
        this.setTitle("Gerenciamento de consultas");
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/physiotherapy.png")).getImage());
        this.currentTela = 4;
        content.removeAll();
        content.repaint();
        content.revalidate();
        removeActiveItemMenu();
        pConsulta.setBackground(Color.decode("#F0F0F0"));
        lConsulta.setForeground(Color.decode("#006634"));
        content.add(contentConsulta);
        this.tBuscarConsulta.requestFocusInWindow();
    }//GEN-LAST:event_pConsultaMouseClicked

    private void pPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pPacienteMouseExited
        if(this.currentTela != 2) {
            pPaciente.setBackground(Color.decode("#FFFFFF"));
            lPaciente.setForeground(Color.decode("#000000"));
        }
    }//GEN-LAST:event_pPacienteMouseExited

    private void pPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pPacienteMouseEntered
        if(this.currentTela != 2) {
            pPaciente.setBackground(Color.decode("#F0F0F0"));
            lPaciente.setForeground(Color.decode("#006634"));
        }
    }//GEN-LAST:event_pPacienteMouseEntered

    private void pPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pPacienteMouseClicked
        scrollPanelPaciente.getViewport().setBackground(Color.WHITE);
        // Created table
        PacienteController pc = new PacienteController();
        List<Paciente> pacientes = pc.pacientes();
        if(pacientes != null) {
            tableModelPaciente.addLista(pacientes);
        }
        tablePacientes.setModel(tableModelPaciente);
        // Change column size
        tablePacientes.getColumnModel().getColumn(0).setPreferredWidth(5);
        tablePacientes.getColumnModel().getColumn(1).setPreferredWidth(400);
        tablePacientes.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablePacientes.getColumnModel().getColumn(3).setPreferredWidth(10);
        bNovoPaciente.setModel(new FixedButtonModel());
        bNovoPaciente.setBorder(BorderFactory.createEtchedBorder(0));
        bEditarPaciente.setModel(new FixedButtonModel());
        bEditarPaciente.setBorder(BorderFactory.createEtchedBorder(0));
        bBuscarPaciente.setModel(new FixedButtonModel());
        bBuscarPaciente.setBorder(BorderFactory.createEtchedBorder(0));
        this.setTitle("Gerenciamento de Pacientes");
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/team.png")).getImage());
        this.currentTela = 2;
        content.removeAll();
        content.repaint();
        content.revalidate();
        removeActiveItemMenu();
        pPaciente.setBackground(Color.decode("#F0F0F0"));
        lPaciente.setForeground(Color.decode("#006634"));
        content.add(contentPaciente);
        this.tBuscarPaciente.requestFocusInWindow();
    }//GEN-LAST:event_pPacienteMouseClicked

    private void pAgendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pAgendaMouseExited
        if(this.currentTela != 1) {
            pAgenda.setBackground(Color.decode("#FFFFFF"));
            lAgenda.setForeground(Color.decode("#000000"));
        }
    }//GEN-LAST:event_pAgendaMouseExited

    private void pAgendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pAgendaMouseEntered
        if(this.currentTela != 1) {
            pAgenda.setBackground(Color.decode("#F0F0F0"));
            lAgenda.setForeground(Color.decode("#006634"));
        }
    }//GEN-LAST:event_pAgendaMouseEntered

    private void pAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pAgendaMouseClicked
        this.setTitle("Agenda");
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/calendar.png")).getImage());
        this.currentTela = 1;
        setHorarios();
        updateAgendaConteudo();

        content.removeAll();
        content.repaint();
        content.revalidate();
        removeActiveItemMenu();
        pAgenda.setBackground(Color.decode("#F0F0F0"));
        lAgenda.setForeground(Color.decode("#006634"));
        content.add(contentAgenda);
    }//GEN-LAST:event_pAgendaMouseClicked

    private void bEditarAvaliacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarAvaliacaoMouseExited
        bEditarAvaliacao.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bEditarAvaliacaoMouseExited

    private void bEditarAvaliacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarAvaliacaoMouseEntered
        bEditarAvaliacao.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bEditarAvaliacaoMouseEntered

    private void bEditarAvaliacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarAvaliacaoMouseClicked
        int row = this.tableAvaliacoes.getSelectedRow();
        if(row > -1){
            Avaliacao a = this.tableModelAvaliacao.getAvaliacao(row);
            if (a != null) {
                EditarAvaliacao ea = new EditarAvaliacao(this, a);
                ea.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecione uma Avaliação da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma Avaliação da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bEditarAvaliacaoMouseClicked

    private void bNovoAvaliacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoAvaliacaoMouseExited
        bNovoAvaliacao.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bNovoAvaliacaoMouseExited

    private void bNovoAvaliacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoAvaliacaoMouseEntered
        bNovoAvaliacao.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bNovoAvaliacaoMouseEntered

    private void bNovoAvaliacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoAvaliacaoMouseClicked
        NovoAvaliacao tela = new NovoAvaliacao(this);
        tela.setVisible(true);
    }//GEN-LAST:event_bNovoAvaliacaoMouseClicked

    private void bBuscarAvaliacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bBuscarAvaliacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.searchAvaliacao();
        }
    }//GEN-LAST:event_bBuscarAvaliacaoKeyPressed

    private void bBuscarAvaliacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarAvaliacaoMouseExited
        bBuscarAvaliacao.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarAvaliacaoMouseExited

    private void bBuscarAvaliacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarAvaliacaoMouseEntered
        bBuscarAvaliacao.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarAvaliacaoMouseEntered

    private void bBuscarAvaliacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarAvaliacaoMouseClicked
        this.searchAvaliacao();
    }//GEN-LAST:event_bBuscarAvaliacaoMouseClicked

    private void bBuscarAvaliacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarAvaliacaoFocusLost
        bBuscarAvaliacao.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarAvaliacaoFocusLost

    private void bBuscarAvaliacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarAvaliacaoFocusGained
        bBuscarAvaliacao.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarAvaliacaoFocusGained

    private void bHistoricoConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bHistoricoConsultaMouseExited
        bHistoricoConsulta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bHistoricoConsultaMouseExited

    private void bHistoricoConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bHistoricoConsultaMouseEntered
        bHistoricoConsulta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bHistoricoConsultaMouseEntered

    private void bHistoricoConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bHistoricoConsultaMouseClicked
        int row = tableConsultas.getSelectedRow();
        if (row > -1) {
            Consulta f = tableModelConsultas.getConsulta(row);
            HistoricoAtendimento hf = new HistoricoAtendimento(this,f);
            hf.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma consulta da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bHistoricoConsultaMouseClicked

    private void bBuscarConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bBuscarConsultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.searchConsulta();
        }
    }//GEN-LAST:event_bBuscarConsultaKeyPressed

    private void bBuscarConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarConsultaMouseExited
        bBuscarConsulta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarConsultaMouseExited

    private void bBuscarConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarConsultaMouseEntered
        bBuscarConsulta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarConsultaMouseEntered

    private void bBuscarConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarConsultaMouseClicked
        this.searchConsulta();
    }//GEN-LAST:event_bBuscarConsultaMouseClicked

    private void bBuscarConsultaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarConsultaFocusLost
        bBuscarConsulta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarConsultaFocusLost

    private void bBuscarConsultaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarConsultaFocusGained
        bBuscarConsulta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarConsultaFocusGained

    private void bEditarConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarConsultaMouseExited
        bEditarConsulta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bEditarConsultaMouseExited

    private void bEditarConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarConsultaMouseEntered
        bEditarConsulta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bEditarConsultaMouseEntered

    private void bEditarConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarConsultaMouseClicked
        int row = this.tableConsultas.getSelectedRow();
        if(row > -1){
            Consulta f = this.tableModelConsultas.getConsulta(row);
            EditarConsulta ef = new EditarConsulta(this, f);
            ef.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma consulta da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bEditarConsultaMouseClicked

    private void bNovoConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoConsultaMouseExited
        bNovoConsulta.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bNovoConsultaMouseExited

    private void bNovoConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoConsultaMouseEntered
        bNovoConsulta.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bNovoConsultaMouseEntered

    private void bNovoConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoConsultaMouseClicked
        NovoConsulta nf = new NovoConsulta(this);
        nf.setVisible(true);
    }//GEN-LAST:event_bNovoConsultaMouseClicked

    private void bBuscarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bBuscarUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.searchUsuario();
        }
    }//GEN-LAST:event_bBuscarUsuarioKeyPressed

    private void bBuscarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarUsuarioMouseExited
        bBuscarUsuario.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarUsuarioMouseExited

    private void bBuscarUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarUsuarioMouseEntered
        bBuscarUsuario.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarUsuarioMouseEntered

    private void bBuscarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarUsuarioMouseClicked
        this.searchUsuario();
    }//GEN-LAST:event_bBuscarUsuarioMouseClicked

    private void bBuscarUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarUsuarioFocusLost
        bBuscarUsuario.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarUsuarioFocusLost

    private void bBuscarUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarUsuarioFocusGained
        bBuscarUsuario.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarUsuarioFocusGained

    private void bEditarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarUsuarioMouseExited
        bEditarUsuario.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bEditarUsuarioMouseExited

    private void bEditarUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarUsuarioMouseEntered
        bEditarUsuario.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bEditarUsuarioMouseEntered

    private void bEditarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarUsuarioMouseClicked
        int row = tableUsuarios.getSelectedRow();
        if(row > -1) {
            Usuario u = tableModelUsuario.getUsuario(row);
            EditarUsuario editar = new EditarUsuario(u, this);
            editar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um usuário da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bEditarUsuarioMouseClicked

    private void bNovoUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoUsuarioMouseExited
        bNovoUsuario.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bNovoUsuarioMouseExited

    private void bNovoUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoUsuarioMouseEntered
        bNovoUsuario.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bNovoUsuarioMouseEntered

    private void bNovoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoUsuarioMouseClicked
        NovoUsuario nu = new NovoUsuario(this);
        nu.setVisible(true);
    }//GEN-LAST:event_bNovoUsuarioMouseClicked

    private void bListarEspecialidadesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bListarEspecialidadesMouseExited
        bListarEspecialidades.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bListarEspecialidadesMouseExited

    private void bListarEspecialidadesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bListarEspecialidadesMouseEntered
        bListarEspecialidades.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bListarEspecialidadesMouseEntered

    private void bListarEspecialidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bListarEspecialidadesMouseClicked
        Especialidades tela = new Especialidades();
        tela.setVisible(true);
    }//GEN-LAST:event_bListarEspecialidadesMouseClicked

    private void bBuscarProfissionalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bBuscarProfissionalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.searchProfissional();
        }
    }//GEN-LAST:event_bBuscarProfissionalKeyPressed

    private void bBuscarProfissionalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProfissionalMouseExited
        bBuscarProfissional.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarProfissionalMouseExited

    private void bBuscarProfissionalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProfissionalMouseEntered
        bBuscarProfissional.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarProfissionalMouseEntered

    private void bBuscarProfissionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProfissionalMouseClicked
        this.searchProfissional();
    }//GEN-LAST:event_bBuscarProfissionalMouseClicked

    private void bBuscarProfissionalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarProfissionalFocusLost
        bBuscarProfissional.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarProfissionalFocusLost

    private void bBuscarProfissionalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarProfissionalFocusGained
        bBuscarProfissional.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarProfissionalFocusGained

    private void bEditarProfissionalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarProfissionalMouseExited
        bEditarProfissional.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bEditarProfissionalMouseExited

    private void bEditarProfissionalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarProfissionalMouseEntered
        bEditarProfissional.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bEditarProfissionalMouseEntered

    private void bEditarProfissionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarProfissionalMouseClicked
        int row = tableProfissionais.getSelectedRow();
        if(row > -1){
            Profissional f = this.tableModelProfissional.getFisioterapeuta(row);
            EditarProfissional ef = new EditarProfissional(this,f);
            ef.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um(a) profissional da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bEditarProfissionalMouseClicked

    private void bNovoProfissionalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoProfissionalMouseExited
        bNovoProfissional.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bNovoProfissionalMouseExited

    private void bNovoProfissionalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoProfissionalMouseEntered
        bNovoProfissional.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bNovoProfissionalMouseEntered

    private void bNovoProfissionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoProfissionalMouseClicked
        NovoProfissional nf = new NovoProfissional(this);
        nf.setVisible(true);
    }//GEN-LAST:event_bNovoProfissionalMouseClicked

    private void bBuscarPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bBuscarPacienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.searchPaciente();
        }
    }//GEN-LAST:event_bBuscarPacienteKeyPressed

    private void bBuscarPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarPacienteMouseExited
        bBuscarPaciente.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarPacienteMouseExited

    private void bBuscarPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarPacienteMouseEntered
        bBuscarPaciente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarPacienteMouseEntered

    private void bBuscarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarPacienteMouseClicked
        this.searchPaciente();
    }//GEN-LAST:event_bBuscarPacienteMouseClicked

    private void bBuscarPacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarPacienteFocusLost
        bBuscarPaciente.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarPacienteFocusLost

    private void bBuscarPacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarPacienteFocusGained
        bBuscarPaciente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarPacienteFocusGained

    private void bEditarPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarPacienteMouseExited
        bEditarPaciente.setBackground(Color.decode("#006643"));
    }//GEN-LAST:event_bEditarPacienteMouseExited

    private void bEditarPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarPacienteMouseEntered
        bEditarPaciente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bEditarPacienteMouseEntered

    private void bEditarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarPacienteMouseClicked
        int row = tablePacientes.getSelectedRow();
        if(row > -1){
            Paciente p = this.tableModelPaciente.getPaciente(row);
            EditarPaciente ep = new EditarPaciente(this, p);
            ep.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um paciente da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bEditarPacienteMouseClicked

    private void bNovoPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoPacienteMouseExited
        bNovoPaciente.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bNovoPacienteMouseExited

    private void bNovoPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoPacienteMouseEntered
        bNovoPaciente.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bNovoPacienteMouseEntered

    private void bNovoPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoPacienteMouseClicked
        NovoPaciente np = new NovoPaciente(this);
        np.setVisible(true);
    }//GEN-LAST:event_bNovoPacienteMouseClicked

    private void scrollPanelAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollPanelAgendaMouseClicked
        
    }//GEN-LAST:event_scrollPanelAgendaMouseClicked

    private void tableAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAgendaMouseClicked
        if(evt.getClickCount()==2){
            editar();
        }
    }//GEN-LAST:event_tableAgendaMouseClicked

    private void bRemoverAgendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverAgendaMouseEntered
        bRemoverAgenda.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bRemoverAgendaMouseEntered

    private void bRemoverAgendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverAgendaMouseExited
        bRemoverAgenda.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bRemoverAgendaMouseExited

    private void bRemoverAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverAgendaMouseClicked
        int row = this.tableAgenda.getSelectedRow();
        int column = this.tableAgenda.getSelectedColumn();
        if(row > -1 && column > -1) {
            Agenda a = this.tableModelAgenda.getAgendamento(row,column);
            if (a.getConsulta() == null) {
                JOptionPane.showMessageDialog(null, "Por favor, selecione um agendamento da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Object[] options = { "Sim", "Não" };
                int resp = JOptionPane.showOptionDialog(null, "Deseja realmente excluir este agendamento?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE , null, options, options[0]);
                AgendaController ac = new AgendaController();
                if (resp == 0) {
                    if (ac.excluir(a)) {
                        JOptionPane.showMessageDialog(null, "Agendamento excluído com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        if (this.getTDate().getDate() != null) {
                            List<Horario> lista = ac.agendamentos(Formatacao.date2StringScreen(this.getTDate().getDate()));
                            if(lista != null) {
                                this.tableModelAgenda.addLista(lista);
                                for(int i = 0; i<20; i++)
                                this.getTableAgenda().setRowHeight(i, 30);
                                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                                this.getTableAgenda().getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
                                this.getTableAgenda().getColumnModel().getColumn(0).setMinWidth(100);
                                this.getTableAgenda().getColumnModel().getColumn(0).setMaxWidth(100);
                            }
                        }
                    } else
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a exclusão do agendamento. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um agendamento da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bRemoverAgendaMouseClicked

    private void tDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tDatePropertyChange
        if (tDate.getDate() != null) {
            AgendaController ac = new AgendaController();
            List<Horario> lista = ac.agendamentos(Formatacao.date2StringScreen(tDate.getDate()));
            if(lista != null) {
                this.tableModelAgenda.addLista(lista);
                for(int i = 0; i<20; i++)
                this.tableAgenda.setRowHeight(i, 30);
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                this.tableAgenda.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
                this.tableAgenda.getColumnModel().getColumn(0).setMinWidth(100);
                this.tableAgenda.getColumnModel().getColumn(0).setMaxWidth(100);
            }
        }
    }//GEN-LAST:event_tDatePropertyChange

    private void bBuscarAgendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarAgendaMouseEntered
        bBuscarAgenda.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarAgendaMouseEntered

    private void bBuscarAgendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarAgendaMouseExited
        bBuscarAgenda.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarAgendaMouseExited

    private void bBuscarAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarAgendaMouseClicked
        this.searchAgendamentos();
    }//GEN-LAST:event_bBuscarAgendaMouseClicked

    private void tBuscarAgendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tBuscarAgendaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            searchAgendamentos();
        }
    }//GEN-LAST:event_tBuscarAgendaKeyPressed

    private void bEditarAgendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarAgendaMouseEntered
        bEditarAgenda.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bEditarAgendaMouseEntered

    private void bEditarAgendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarAgendaMouseExited
        bEditarAgenda.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bEditarAgendaMouseExited

    private void bEditarAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarAgendaMouseClicked
        editar();
    }//GEN-LAST:event_bEditarAgendaMouseClicked

    private void bNovoAgendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoAgendaMouseExited
        bNovoAgenda.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bNovoAgendaMouseExited

    private void bNovoAgendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoAgendaMouseEntered
        bNovoAgenda.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bNovoAgendaMouseEntered

    private void bNovoAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoAgendaMouseClicked
        int row = this.tableAgenda.getSelectedRow();
        int column = this.tableAgenda.getSelectedColumn();
        if (row >=0  && column > 0) {
            Agenda a = this.tableModelAgenda.getAgendamento(row, column);
            String dateTime = Formatacao.date2StringScreen(tDate.getDate()) + " " + Formatacao.time2String(horarios.get(row).getHora());
            a.setDataAgendamento(new java.sql.Timestamp(Formatacao.string2DateTime(dateTime).getTime()));
            if (a.getConsulta() != null) {
                JOptionPane.showMessageDialog(null, "Por favor, selecione um horário disponível.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            } else {
                NovoAgendamento na = new NovoAgendamento(this, a);
                na.setVisible(true);
            }
        }  else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um horário.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bNovoAgendaMouseClicked

    private void bBuscarProcedimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bBuscarProcedimentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.searchProcedimento();
        }
    }//GEN-LAST:event_bBuscarProcedimentoKeyPressed

    private void bBuscarProcedimentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProcedimentoMouseEntered
        bBuscarProcedimento.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarProcedimentoMouseEntered

    private void bBuscarProcedimentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProcedimentoMouseExited
        bBuscarProcedimento.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarProcedimentoMouseExited

    private void bBuscarProcedimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarProcedimentoMouseClicked
        this.searchProcedimento();
    }//GEN-LAST:event_bBuscarProcedimentoMouseClicked

    private void bBuscarProcedimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarProcedimentoFocusLost
        bBuscarProcedimento.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bBuscarProcedimentoFocusLost

    private void bBuscarProcedimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bBuscarProcedimentoFocusGained
        bBuscarProcedimento.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bBuscarProcedimentoFocusGained

    private void bRemoverProcedimentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverProcedimentoMouseEntered
        bRemoverProcedimento.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bRemoverProcedimentoMouseEntered

    private void bRemoverProcedimentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverProcedimentoMouseExited
        bRemoverProcedimento.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bRemoverProcedimentoMouseExited

    private void bRemoverProcedimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRemoverProcedimentoMouseClicked
        int row = this.tableProcedimentos.getSelectedRow();
        if (row>-1) {
            Object[] options = { "Sim", "Não" };
            int resp = JOptionPane.showOptionDialog(null, "Deseja realmente excluir este procedimento?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE , null, options, options[0]);
            if (resp == 0) {
                Procedimento p = this.tableModelProcedimentos.getProcedimento(row);
                ProcedimentoController pc = new ProcedimentoController();
                if(pc.remover(p)) {
                    List<Procedimento> profissionais = pc.procedimentos();
                    if(profissionais!=null)
                    tableModelProcedimentos.addLista(profissionais);
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a exclusão do procedimento. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um agendamento da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bRemoverProcedimentoMouseClicked

    private void bEditarProcedimentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarProcedimentoMouseEntered
        bEditarProcedimento.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bEditarProcedimentoMouseEntered

    private void bEditarProcedimentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarProcedimentoMouseExited
        bEditarProcedimento.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bEditarProcedimentoMouseExited

    private void bEditarProcedimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarProcedimentoMouseClicked
        int row = this.tableProcedimentos.getSelectedRow();
        if(row > -1){
            Procedimento p = this.tableModelProcedimentos.getProcedimento(row);
            if (p != null) {
                EditarProcedimento ea = new EditarProcedimento(this, p);
                ea.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecione um Procedimento da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um Procedimento da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bEditarProcedimentoMouseClicked

    private void bNovoProcedimentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoProcedimentoMouseEntered
        bNovoProcedimento.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bNovoProcedimentoMouseEntered

    private void bNovoProcedimentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoProcedimentoMouseExited
        bNovoProcedimento.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bNovoProcedimentoMouseExited

    private void bNovoProcedimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNovoProcedimentoMouseClicked
        NovoProcedimento np = new NovoProcedimento(this);
        np.setVisible(true);
    }//GEN-LAST:event_bNovoProcedimentoMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main(1, "Home").setVisible(true);
            }
        });
    }
    
    public void removeActiveItemMenu(){
        pAgenda.setBackground(Color.decode("#FFFFFF"));
        lAgenda.setForeground(Color.decode("#000000"));
        
        pAvaliacao.setBackground(Color.decode("#FFFFFF"));
        lAvaliacao.setForeground(Color.decode("#000000"));
        
        pPaciente.setBackground(Color.decode("#FFFFFF"));
        lPaciente.setForeground(Color.decode("#000000"));
        
        pProcedimento.setBackground(Color.decode("#FFFFFF"));
        lProcedimento.setForeground(Color.decode("#000000"));
        
        pProfissional.setBackground(Color.decode("#FFFFFF"));
        lProfissional.setForeground(Color.decode("#000000"));
        
        pConsulta.setBackground(Color.decode("#FFFFFF"));
        lConsulta.setForeground(Color.decode("#000000"));
        
        pUsuario.setBackground(Color.decode("#FFFFFF"));
        lUsuario.setForeground(Color.decode("#000000"));
    }
    
    public final void updateAgendaConteudo() {
        scrollPanelAgenda.getViewport().setBackground(Color.WHITE);
        bNovoAgenda.setModel(new FixedButtonModel());
        bNovoAgenda.setBorder(BorderFactory.createEtchedBorder(0));
        bEditarAgenda.setModel(new FixedButtonModel());
        bEditarAgenda.setBorder(BorderFactory.createEtchedBorder(0));
        bRemoverAgenda.setModel(new FixedButtonModel());
        bRemoverAgenda.setBorder(BorderFactory.createEtchedBorder(0));
        bBuscarAgenda.setModel(new FixedButtonModel());    
        bBuscarAgenda.setBorder(BorderFactory.createEtchedBorder(0));
        AgendaController ac = new AgendaController();
        List<Horario> agendamentos = ac.agendamentos(Formatacao.date2StringScreen(tDate.getDate()));
        if(agendamentos != null)
            tableModelAgenda.addLista(agendamentos);
        tableAgenda.setModel(tableModelAgenda);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tableAgenda.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        tableAgenda.getColumnModel().getColumn(0).setMinWidth(100);
        tableAgenda.getColumnModel().getColumn(0).setMaxWidth(100);
    }
    
    public JTable getTableAgenda() {
        return this.tableAgenda;
    }
    
    public com.toedter.calendar.JDateChooser getTDate() {
        return this.tDate;
    }
    
    public void setHorarios() {
        this.horarios = HorarioDAO.horarios();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscarAgenda;
    private javax.swing.JButton bBuscarAvaliacao;
    private javax.swing.JButton bBuscarConsulta;
    private javax.swing.JButton bBuscarPaciente;
    private javax.swing.JButton bBuscarProcedimento;
    private javax.swing.JButton bBuscarProfissional;
    private javax.swing.JButton bBuscarUsuario;
    private javax.swing.JButton bEditarAgenda;
    private javax.swing.JButton bEditarAvaliacao;
    private javax.swing.JButton bEditarConsulta;
    private javax.swing.JButton bEditarPaciente;
    private javax.swing.JButton bEditarProcedimento;
    private javax.swing.JButton bEditarProfissional;
    private javax.swing.JButton bEditarUsuario;
    private javax.swing.JButton bHistoricoConsulta;
    private javax.swing.JButton bListarEspecialidades;
    private javax.swing.JButton bNovoAgenda;
    private javax.swing.JButton bNovoAvaliacao;
    private javax.swing.JButton bNovoConsulta;
    private javax.swing.JButton bNovoPaciente;
    private javax.swing.JButton bNovoProcedimento;
    private javax.swing.JButton bNovoProfissional;
    private javax.swing.JButton bNovoUsuario;
    private javax.swing.JButton bRemoverAgenda;
    private javax.swing.JButton bRemoverProcedimento;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel content;
    private javax.swing.JPanel contentAgenda;
    private javax.swing.JPanel contentAvaliacao;
    private javax.swing.JPanel contentConsulta;
    private javax.swing.JPanel contentPaciente;
    private javax.swing.JPanel contentProcedimento;
    private javax.swing.JPanel contentProfissional;
    private javax.swing.JPanel contentUsuario;
    private javax.swing.JPanel headerAgenda;
    private javax.swing.JPanel headerAvaliacao;
    private javax.swing.JPanel headerFisioterapia;
    private javax.swing.JPanel headerPaciente;
    private javax.swing.JPanel headerProcedimento;
    private javax.swing.JPanel headerProfissional;
    private javax.swing.JPanel headerUsuario;
    private javax.swing.JLabel iconAgenda;
    private javax.swing.JLabel iconAvaliacao;
    private javax.swing.JLabel iconConsulta;
    private javax.swing.JLabel iconContentHomeAgenda;
    private javax.swing.JLabel iconContentHomeAvaliacao;
    private javax.swing.JLabel iconContentHomeFisioterapia;
    private javax.swing.JLabel iconContentHomePaciente;
    private javax.swing.JLabel iconContentHomeProcedimento;
    private javax.swing.JLabel iconContentHomeProfissional;
    private javax.swing.JLabel iconContentHomeUsuario;
    private javax.swing.JLabel iconPaciente;
    private javax.swing.JLabel iconProcedimento;
    private javax.swing.JLabel iconProfissional;
    private javax.swing.JLabel iconUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lAgenda;
    private javax.swing.JLabel lAvaliacao;
    private javax.swing.JLabel lConsulta;
    private javax.swing.JLabel lPaciente;
    private javax.swing.JLabel lPesquisarAgenda;
    private javax.swing.JLabel lPesquisarAgenda1;
    private javax.swing.JLabel lPesquisarAvaliacao;
    private javax.swing.JLabel lPesquisarFisioterapia;
    private javax.swing.JLabel lPesquisarPaciente;
    private javax.swing.JLabel lPesquisarProcedimento;
    private javax.swing.JLabel lPesquisarProfissional;
    private javax.swing.JLabel lPesquisarUsuario;
    private javax.swing.JLabel lProcedimento;
    private javax.swing.JLabel lProfissional;
    private javax.swing.JLabel lSair;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPanel logo;
    private javax.swing.JPanel mainAgenda;
    private javax.swing.JPanel mainAvaliacao;
    private javax.swing.JPanel mainFisioterapia;
    private javax.swing.JPanel mainPaciente;
    private javax.swing.JPanel mainProcedimento;
    private javax.swing.JPanel mainProfissional;
    private javax.swing.JPanel mainUsuario;
    private javax.swing.JPanel navButtonsAgenda;
    private javax.swing.JPanel navButtonsAvaliacao;
    private javax.swing.JPanel navButtonsFisioterapia;
    private javax.swing.JPanel navButtonsPaciente;
    private javax.swing.JPanel navButtonsProcedimento;
    private javax.swing.JPanel navButtonsProfissional;
    private javax.swing.JPanel navButtonsUsuario;
    private javax.swing.JPanel pAgenda;
    private javax.swing.JPanel pAvaliacao;
    private javax.swing.JPanel pConsulta;
    private javax.swing.JPanel pPaciente;
    private javax.swing.JPanel pProcedimento;
    private javax.swing.JPanel pProfissional;
    private javax.swing.JPanel pSair;
    private javax.swing.JPanel pUsuario;
    private javax.swing.JLabel pathAvaliacao;
    private javax.swing.JLabel pathContentHomeAgenda;
    private javax.swing.JLabel pathContentHomeAvaliacao;
    private javax.swing.JLabel pathContentHomeFisioterapia;
    private javax.swing.JLabel pathContentHomePaciente;
    private javax.swing.JLabel pathContentHomeProcedimento;
    private javax.swing.JLabel pathContentHomeProfissional;
    private javax.swing.JLabel pathContentHomeUsuario;
    private javax.swing.JLabel pathFisioterapia;
    private javax.swing.JLabel pathPaciente;
    private javax.swing.JLabel pathProcedimento;
    private javax.swing.JLabel pathProfissional;
    private javax.swing.JLabel pathUsuario;
    private javax.swing.JScrollPane scrollPanelAgenda;
    private javax.swing.JScrollPane scrollPanelAvaliacao;
    private javax.swing.JScrollPane scrollPanelConsulta;
    private javax.swing.JScrollPane scrollPanelPaciente;
    private javax.swing.JScrollPane scrollPanelProcedimento;
    private javax.swing.JScrollPane scrollPanelProfissional;
    private javax.swing.JScrollPane scrollPanelUsuario;
    private javax.swing.JScrollPane sidebarScroll;
    private javax.swing.JPanel sidenav;
    private javax.swing.JTextField tBuscarAgenda;
    private javax.swing.JTextField tBuscarAvaliacao;
    private javax.swing.JTextField tBuscarConsulta;
    private javax.swing.JTextField tBuscarPaciente;
    private javax.swing.JTextField tBuscarProcedimento;
    private javax.swing.JTextField tBuscarProfissional;
    private javax.swing.JTextField tBuscarUsuario;
    private com.toedter.calendar.JDateChooser tDate;
    private javax.swing.JTable tableAgenda;
    private javax.swing.JTable tableAvaliacoes;
    private javax.swing.JTable tableConsultas;
    private javax.swing.JTable tablePacientes;
    private javax.swing.JTable tableProcedimentos;
    private javax.swing.JTable tableProfissionais;
    private javax.swing.JTable tableUsuarios;
    // End of variables declaration//GEN-END:variables

    private void searchAvaliacao() {
        String busca = this.tBuscarAvaliacao.getText();
        AvaliacaoController ac = new AvaliacaoController();
        List<Avaliacao> lista;
        if(!Validacao.isEmpty(busca)) {
            if(Validacao.isDate(busca))
                busca = Formatacao.removeDateMask(busca);
            lista = ac.avaliacoes(busca);
        } else {
            lista = ac.avaliacoes();
        }
        if(lista != null)
           this.tableModelAvaliacao.addLista(lista);
        tBuscarAvaliacao.requestFocusInWindow();
        bBuscarAvaliacao.setBackground(Color.decode("#008542"));
    }
    
    private void searchPaciente() {
        String busca = this.tBuscarPaciente.getText();
        PacienteController pc = new PacienteController();
        List<Paciente> lista;
        if(!Validacao.isEmpty(busca)) {
            if(Validacao.isDate(busca))
                busca = Formatacao.removeDateMask(busca);
            lista = pc.pacientes(busca);
        } else {
            lista = pc.pacientes();
        }
        
        if(lista != null)
           this.tableModelPaciente.addLista(lista);
        this.tBuscarPaciente.requestFocusInWindow();
        bBuscarPaciente.setBackground(Color.decode("#008542"));
    }
    
    private void searchProcedimento() {
        String busca = this.tBuscarProcedimento.getText();
        ProcedimentoController pc = new ProcedimentoController();
        List<Procedimento> lista;
        lista = !Validacao.isEmpty(busca) ? pc.procedimentos(busca) : pc.procedimentos();
        if(lista != null) {
            this.tableModelProcedimentos.addLista(lista);
        }
        this.tBuscarProcedimento.requestFocusInWindow();
        bBuscarProcedimento.setBackground(Color.decode("#008542"));
    }
    
    private void searchProfissional() {
        String busca = this.tBuscarProfissional.getText();
        ProfissionalController fc = new ProfissionalController();
        List<Profissional> lista;
        lista = !Validacao.isEmpty(busca) ? fc.profissionais(busca) : fc.profissionais();
        if(lista != null)
           this.tableModelProfissional.addLista(lista);
        this.tBuscarProfissional.requestFocusInWindow();
        bBuscarProfissional.setBackground(Color.decode("#008542"));
    }

    private void searchUsuario() {
        String busca = this.tBuscarUsuario.getText();
        UsuarioController uc = new UsuarioController();
        List<Usuario> lista;
        lista = !Validacao.isEmpty(busca) ? uc.usuarios(busca) : uc.usuarios();
        if(lista != null)
            this.tableModelUsuario.addLista(lista);
        this.tBuscarUsuario.requestFocusInWindow();
    }

    private void searchConsulta() {
        String busca = this.tBuscarConsulta.getText();
        ConsultaController cc = new ConsultaController();
        List<Consulta> lista;
        lista = !Validacao.isEmpty(busca) ? cc.consultas(busca) : cc.consultas();
        if(lista != null)
            this.tableModelConsultas.addLista(lista);
        this.tBuscarConsulta.requestFocusInWindow();
    }

    private void searchAgendamentos() {
        String data = Formatacao.date2StringScreen(tDate.getDate());
        String busca = this.tBuscarAgenda.getText();
        AgendaController ag = new AgendaController();
        List<Horario> lista = null;
        if(!Validacao.isEmpty(data) && Validacao.isDate(data)) {
            if (!Validacao.isEmpty(busca)) {
                lista = ag.agendamentos(data, busca);
            } else {
                lista = ag.agendamentos(data);
            }
        }
        
        if(lista != null) {
            this.tableModelAgenda.addLista(lista);
            for(int i = 0; i<20; i++)
                this.tableAgenda.setRowHeight(i, 30);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            this.tableAgenda.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
            this.tableAgenda.getColumnModel().getColumn(0).setMinWidth(100);
            this.tableAgenda.getColumnModel().getColumn(0).setMaxWidth(100);
        }
        this.tBuscarAgenda.requestFocusInWindow();
        bBuscarAgenda.setBackground(Color.decode("#008542"));
    }
    
    private void editar(){
        int row = this.tableAgenda.getSelectedRow();
        int column = this.tableAgenda.getSelectedColumn();
        if(row > -1 && column > -1){
            Agenda a = this.tableModelAgenda.getAgendamento(row, column);
            if (a.getConsulta() != null) {
                EditarAgendamento ea = new EditarAgendamento(this, a);
                ea.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecione um agendamento da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um agendamento da tabela.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
