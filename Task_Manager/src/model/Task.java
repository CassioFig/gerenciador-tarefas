package model;

import java.util.Date;
import model.database.TaskDB;

/**
 *
 * @author Cássio Figueiredo
 */
public class Task {
    private final TaskDB taskDB = new TaskDB();
    private final String name, priority, situation, date;
    
    public Task(String name, String priority, String date) {
        this.name = name;
        this.priority = priority;
        this.situation = "To Do";
        this.date = date;
    }
    
    public void saveTask() {
        taskDB.registerTask(this);
    }

    public String getName() {
        return name;
    }

    public String getPriority() {
        return priority;
    }

    public String getSituation() {
        return situation;
    }

    public String getDate() {
        return date;
    }
    
}
