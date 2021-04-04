package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao executar o comando!");
        }
    }
    
    public List<Task> getTasks() {
        List<Task> list = new ArrayList<>();
        String sql = "select * from tbtask";
        Statement statement;
        
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {                
                Task task = new Task();
                
                task.setId(rs.getInt("id"));
                task.setName(rs.getString("name"));
                task.setPriority(rs.getString("priority"));
                task.setSituation(rs.getString("situation"));
                task.setDate(rs.getString("date"));
                
                list.add(task);
            }
            
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public void updateTask(Task task) {
        String sql = "update tbtask set name = ?, date = ?, situation = ? "
                + "where id = ?";
        
        PreparedStatement pst;
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, task.getName());
            pst.setString(2, task.getDate());
            pst.setString(3, task.getSituation());
            pst.setInt(4, task.getId());
            
            pst.executeUpdate();
            pst.close();
            
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao executar o comando!");
        }
    }
    
}
