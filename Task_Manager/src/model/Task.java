package model;

import java.util.List;
import model.database.TaskDB;

/**
 *
 * @author Cássio Figueiredo
 */
public class Task {
    private final TaskDB taskDB = new TaskDB();
    private String name, priority, situation, date;

    public Task() {
    }
    
    public Task(String name, String priority, String date) {
        this.name = name;
        this.priority = priority;
        this.situation = "To Do";
        this.date = date;
    }
    
    public void saveTask() {
        taskDB.registerTask(this);
    }
    
    public List<Task> getTasks() {
        return taskDB.getTasks();
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
