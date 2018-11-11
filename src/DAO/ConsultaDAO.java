/**
 * @author Lais Frigério da Silva
 */

package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Consulta;
import model.Paciente;
import model.Procedimento;
import model.Validacao;

public class ConsultaDAO {
    private final static String CADASTRAR = "INSERT INTO consulta (qntd, "
            + "valor,paciente_id, procedimento_id) values (?, ?, ?, ?)";
    
    private final static String EDITAR = "UPDATE consulta SET qntd = ?,  valor = ?,"
            + " paciente_id = ? , procedimento_id = ? WHERE id = ?";

    private final static String CONSULTAS = "SELECT c.qntd, c.valor,"
            + "c.paciente_id, p.nome_paciente, "
            + "c.id, proc.id, proc.nome FROM consulta c  INNER JOIN"
            + " paciente p on p.id_paciente = c.paciente_id "
            + " LEFT JOIN procedimento proc ON proc.id = c.procedimento_id"
            + " ORDER BY c.id DESC";
    
    private final static String PESQUISAR = "SELECT c.qntd, c.valor,"
            + "c.paciente_id, p.nome_paciente, "
            + " c.id, proc.id, proc.nome FROM consulta c INNER JOIN"
            + " paciente p on p.id_paciente = c.paciente_id "
            + " LEFT JOIN procedimento proc ON proc.id = c.procedimento_id"
            + " WHERE c.id = ? OR p.nome_paciente LIKE ? OR proc.nome LIKE ?"
            + " ORDER BY c.id DESC";
    
    public boolean cadastrar(Consulta c){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(CADASTRAR);
            stmt.setInt(1, c.getQntdSessao());
            stmt.setDouble(2, c.getValor());
            stmt.setInt(3,c.getPaciente().getId());
            if (c.getProcedimento() == null) {
                stmt.setInt(4,java.sql.Types.NULL);
            } else {
                stmt.setInt(4,c.getProcedimento().getId());
            }
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if(conn!=null)
                    conn.close();
                if(stmt!=null)
                    stmt.close();
            } catch (Exception ex){
                System.out.println("ERROR - (Cadastrar Fisioterapia) | Try close "
                        + "prepared statement or conection \n " + ex);
            }
        }       
        return false;
    }
    
    public boolean editar(Consulta c){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(EDITAR);
            stmt.setInt(1, c.getQntdSessao());
            stmt.setDouble(2, c.getValor());
            stmt.setInt(3,c.getPaciente().getId());
            if (c.getProcedimento() == null) {
                stmt.setInt(4,java.sql.Types.NULL);
            } else {
                stmt.setInt(4,c.getProcedimento().getId());
            }
            stmt.setInt(5, c.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
            } catch (Exception ex){
                System.out.println("ERROR - (Editar Fisioterapia) | Try close "
                        + "prepared statement or conection \n " + ex);
            }
        }       
        return false;
    }
    
    public List<Consulta> consultas(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Consulta> lista = new ArrayList();
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(CONSULTAS);
            rs = stmt.executeQuery();
            while(rs.next()){
                Consulta consulta = new Consulta(); 
                Paciente p = new Paciente();
                p.setNome(rs.getString(4));
                p.setId(rs.getInt(3));
                consulta.setPaciente(p);
                consulta.setId(rs.getInt(5));
                consulta.setQntdSessao(rs.getInt(1));
                consulta.setValor(rs.getDouble(2));
                
                if (rs.getInt(6) != 0) {
                    Procedimento procedimento = new Procedimento();
                    procedimento.setId(rs.getInt(6));
                    procedimento.setNome(rs.getString(7));
                    consulta.setProcedimento(procedimento);
                }
                
                lista.add(consulta);
            }
            return lista;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
                if(rs!=null) rs.close();
            } catch (Exception ex){
                System.out.println("ERROR - (Lista Fisioterapeuta) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        return null;
    }
    
    public List<Consulta> consultas(String busca){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Consulta> lista = new ArrayList();
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(PESQUISAR);
            if(Validacao.isNumeric(busca))
                stmt.setInt(1, Integer.parseInt(busca));
            else
                stmt.setInt(1, 0);
            stmt.setString(2, "%" + busca + "%");
            stmt.setString(3, "%" + busca + "%");
            rs = stmt.executeQuery();
            while(rs.next()){
                Consulta consulta = new Consulta(); 
                Paciente p = new Paciente();
                p.setNome(rs.getString(4));
                p.setId(rs.getInt(3));
                consulta.setPaciente(p);
                consulta.setId(rs.getInt(5));
                consulta.setQntdSessao(rs.getInt(1));
                consulta.setValor(rs.getDouble(2));
                
                if (rs.getInt(6) != 0) {
                    Procedimento procedimento = new Procedimento();
                    procedimento.setId(rs.getInt(6));
                    procedimento.setNome(rs.getString(7));
                    consulta.setProcedimento(procedimento);
                }
                
                lista.add(consulta);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try{
                if(conn!=null)
                    conn.close();
                if(stmt!=null)
                    stmt.close();
                if(rs!=null)
                    rs.close();
            } catch (Exception ex){
                System.out.println("ERROR - (Lista Consulta) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        return null;
    }
}
