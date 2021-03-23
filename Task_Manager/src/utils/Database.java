package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cássio Figueiredo
 */
public class Database {
    private final String url = "jdbc:mysql://task-manager-db.cezy4juwft5j.us-east-1."
            + "rds.amazonaws.com:3306/task_manager_db";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String user = "admin";
    private final String password = "TaskDbsecurity";

    public Database() {
    }
    
    public Connection connection() {
        Connection connection = null;
        
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            
            System.out.println("Conexão efetuada com sucessso!");
            
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
