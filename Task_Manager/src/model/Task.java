package model;

import java.util.Date;
//import model.database.Tbtask;

/**
 *
 * @author Cássio Figueiredo
 */
public class Task {
//    private Tbtask taskDB;
    private String name, priority, situation;
    private Date date;
    
    public Task(String name, String priority, Date date) {
        this.name = name;
        this.priority = priority;
        this.situation = "To Do";
        this.date = date;
    }
    
    public void saveTask() {
    }
    
}
