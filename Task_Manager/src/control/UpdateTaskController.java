package control;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Task;

/**
 * FXML Controller class
 *
 * @author Cássio Figueiredo
 */
public class UpdateTaskController implements Initializable {
    
    private Task selectedTask;
    
    @FXML
    private TextField txtName;
    @FXML
    private DatePicker txtDate;
    @FXML
    private ComboBox<String> cbxSituation;
    @FXML
    private Button btnUpdate;
    @FXML
    private TextField txtId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxSituation.setItems(getOptions());
    }    
    
    private ObservableList<String> getOptions() {
        ObservableList<String> options = FXCollections.observableArrayList();
        
        options.add("To Do");
        options.add("In Progress");
        options.add("Done");
        
        return options;
    }
    
    public void initData(Task task) {
        selectedTask = task;
        setFields(selectedTask);
    }
    
    private void setFields(Task task) {
        LocalDate localDate = null;
        
        txtId.setText(String.valueOf(task.getId()));
        txtName.setText(task.getName());
        txtDate.setValue(LocalDate.parse(task.getDate()));
        cbxSituation.setValue(task.getSituation());
    }
    
    @FXML
    private void btnUpdateAction(ActionEvent event) {
    }
    
}
