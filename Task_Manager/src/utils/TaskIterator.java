package utils;

import java.util.List;
import model.Task;

/**
 *
 * @author Cássio Figueiredo
 */
public class TaskIterator implements Iterator {
    List<Task> tasks;
    int position = 0;

    public TaskIterator(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean hasNext() {
        if (position >= tasks.size() || tasks.get(position) == null) {
            return false;
            
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Task task = this.tasks.get(position);
        position++;
        
        return task;
    }
    
    
}
