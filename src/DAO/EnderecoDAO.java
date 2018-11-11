/**
 * @author Lais Frigério da Silva
 */

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Endereco;

/**
 *
 * @author Lais Frigério da Silva | 27/10/2018
 */
public class EnderecoDAO {
    
    private final static String CADASTRAR_ENDERECO = "INSERT INTO endereco (CEP, rua, bairro, "
            + "cidade, estado, numero) values (?, ?, ?, ?, ?, ?)";
    private final static String EDITAR_ENDERECO = "UPDATE endereco SET CEP = ?, rua = ?, bairro = ?,"
            + "cidade = ?, estado = ?, numero = ? WHERE id_endereco = ?";
    private final static String REMOVER_ENDERECO = "DELETE FROM endereco WHERE id_endereco = ?";
    
    public int cadastrar(Connection conn, PreparedStatement stmt, ResultSet rs, Endereco endereco) throws SQLException {
        stmt = conn.prepareStatement(CADASTRAR_ENDERECO, PreparedStatement.RETURN_GENERATED_KEYS);
        stmt.setString(1, endereco.getCEP());
        stmt.setString(2, endereco.getRua());
        stmt.setString(3, endereco.getBairro());
        stmt.setString(4, endereco.getCidade());
        stmt.setString(5, endereco.getEstado());
        stmt.setInt(6, endereco.getNumero());
        stmt.executeUpdate();
        rs = stmt.getGeneratedKeys();
        if(rs.next())
            return rs.getInt(1);
        return 0;
    }
    
    public int editar(Connection conn, PreparedStatement stmt, Endereco endereco) throws SQLException {
        stmt = conn.prepareStatement(EDITAR_ENDERECO);
        stmt.setString(1, endereco.getCEP());
        stmt.setString(2, endereco.getRua());
        stmt.setString(3, endereco.getBairro());
        stmt.setString(4, endereco.getCidade());
        stmt.setString(5, endereco.getEstado());
        stmt.setInt(6, endereco.getNumero());
        stmt.setInt(7, endereco.getId());
        stmt.executeUpdate();
        return endereco.getId();
    }
    
    public void remover(Connection conn, PreparedStatement stmt, int endereco_id) throws SQLException {
        stmt = conn.prepareStatement(REMOVER_ENDERECO);
        stmt.setInt(1,endereco_id);
        stmt.executeUpdate();
    }
}
