package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cássio Figueiredo
 */
public class Database {
    private final String url = "jdbc:mysql://localhost:3306/task-db";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String user = "root";
    private final String password = "";

    public Database() {
    }
    
    public Connection connection() {
        Connection connection = null;
        
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não foi possível conectar!");
        }
        
        return connection;
    }
    
    public void closeConnection(Connection con) {
        try {
            con.close();
            System.out.println("Conexão fechada com sucesso!");
            
        } catch (SQLException e) {
            System.out.println("Não foi possível desconectar!");
        }
    }
}
