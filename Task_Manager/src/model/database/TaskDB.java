package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import model.Task;
import utils.Database;

/**
 *
 * @author Cássio Figueiredo
 */
public class TaskDB {
    private final Database database = new Database();
    private final Connection connection;

    public TaskDB() {
        this.connection = database.connection();
    }
    
    public void registerTask(Task task) {
        String sql = "insert into tbtask(name, priority, situation, date) "
                + "values (?, ?, ?, ?)";
        
        PreparedStatement pst;
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, task.getName());
            pst.setString(2, task.getPriority());
            pst.setString(3, task.getSituation());
            pst.setString(4, task.getDate());
            
            pst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Erro ao executar o comando!");
        }
        
    }
    
}
