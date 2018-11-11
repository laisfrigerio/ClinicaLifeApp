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
import model.Horario;

/**
 *
 * @author Lais Frigério da Silva
 */
public class HorarioDAO {
    private static final String HORARIOS = "SELECT id, hora FROM horario ORDER BY hora ASC";
    
    public static List<Horario> horarios() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Horario> horarios = new ArrayList();
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(HORARIOS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Horario h = new Horario();
                h.setId(rs.getInt(1));
                h.setHora(rs.getTime(2));
                horarios.add(h);
            }
            return horarios;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
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
                System.out.println("ERROR - (Lista Horario - Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        return null;
    }
}
