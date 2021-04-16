package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Cássio Figueiredo
 */
public class Database {
    private final String url = "jdbc:mysql://35.199.73.82:3306/TaskManager";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String user = "user";
    private final String password = "taskManagerSecurity";

    public Database() {
    }
    
    public Connection connection() {
        Connection connection = null;
        
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException | SQLException e) {
            error();
        }
        
        return connection;
    }
    
    public void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    private void error() {
        Alert erro = new Alert(Alert.AlertType.ERROR);
        
        erro.setTitle("Error");
        erro.setHeaderText("Database connection error!");
        erro.showAndWait();
    }
}
