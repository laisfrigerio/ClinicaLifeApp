/**
 * @author Lais Frigério da Silva
 */

package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConectionFactory {
    public Connection getConnection() throws SQLException, ClassNotFoundException, IOException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Properties prop = new Properties();
            InputStream in = getClass().getClassLoader().getResourceAsStream("resources/config.properties");
            prop.load(in);
            in.close();
            String URL = prop.getProperty("url");
            String USUARIO = prop.getProperty("usuario");
            String SENHA = prop.getProperty("senha");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e){
            throw new SQLException("ERROR : SQL " + e);
        } catch (ClassNotFoundException e){
            throw new ClassNotFoundException("ERROR : MYSQL JAR NOT FOUND " + e);
        } catch (IOException e){
            throw new IOException("ERROR:  IO - PROPERTIES FILE NOT FOUND " + e);
        }
    }
}
