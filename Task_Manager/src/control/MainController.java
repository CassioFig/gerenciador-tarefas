package control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Task;
import utils.TaskIterator;

/**
 *
 * @author Cássio Figueiredo
 */
public class MainController implements Initializable {
    
    private Task task;
    private TaskIterator it;

    @FXML
    private TableView<Task> tblToDo;
    @FXML
    private TableView<Task> tblInProgress;
    @FXML
    private TableView<Task> tblDone;
    @FXML
    private Button btnNewTask;
    @FXML
    private TableColumn<Task, String> idToDo;
    @FXML
    private TableColumn<Task, String> nameToDo;
    @FXML
    private TableColumn<Task, String> dateToDo;
    @FXML
    private TableColumn<Task, String> idProgress;
    @FXML
    private TableColumn<Task, String> nameProgress;
    @FXML
    private TableColumn<Task, String> dateProgress;
    @FXML
    private TableColumn<Task, String> idDone;
    @FXML
    private TableColumn<Task, String> nameDone;
    @FXML
    private TableColumn<Task, String> dateDone;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeToDoTable();
        
    }
    
    private void initializeToDoTable() {
        idToDo.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameToDo.setCellValueFactory(new PropertyValueFactory<>("Name"));
        dateToDo.setCellValueFactory(new PropertyValueFactory<>("Date"));
        
        tblToDo.setItems(getTasksToDo());
    }
    
    private ObservableList<Task> getTasksToDo() {
        ObservableList<Task> tasks = FXCollections.observableArrayList();
        
        task = new Task();
        it = new TaskIterator(task.getTasks());
        
        while (it.hasNext()) {
            Task tsk = (Task) it.next();
            
            if (isTaskToDo(tsk.getSituation())) {
                tasks.add(tsk);
            }
        }
        
        return tasks;
    }
    
    private boolean isTaskToDo(String situation) {
        if (situation.endsWith("To Do")) {
            return true;
            
        } else {
            return false;
        }
    }

    @FXML
    private void btnNewTaskAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        
        Parent register = FXMLLoader.load(getClass()
                .getResource("../view/RegisterTask.fxml"));
        
        Scene scene = new Scene(register);
        
        
        stage.setScene(scene);
        stage.setWidth(440);
        stage.setHeight(322);
        stage.setResizable(false);
        stage.show();
    }
    
}
