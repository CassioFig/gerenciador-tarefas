package control;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Task;
import utils.TaskIterator;

/**
 *
 * @author Cássio Figueiredo
 */
public class MainController implements Initializable {
    
    private String lastSelection = "";
    private Task task;
    private TaskIterator it;
    private UpdateTaskController update;

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
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeToDoTable();
        initializeInProgressTable();
        initializeDoneTable();
        
    }
    
    private void initializeToDoTable() {
        idToDo.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameToDo.setCellValueFactory(new PropertyValueFactory<>("Name"));
        dateToDo.setCellValueFactory(new PropertyValueFactory<>("Date"));
        
        tblToDo.setItems(getTasks("To Do"));
    }
    
    private void initializeInProgressTable() {
        idProgress.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameProgress.setCellValueFactory(new PropertyValueFactory<>("Name"));
        dateProgress.setCellValueFactory(new PropertyValueFactory<>("Date"));
        
        tblInProgress.setItems(getTasks("In Progress"));
    }
    
    private void initializeDoneTable() {
        idDone.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameDone.setCellValueFactory(new PropertyValueFactory<>("Name"));
        dateDone.setCellValueFactory(new PropertyValueFactory<>("Date"));
        
        tblDone.setItems(getTasks("Done"));
    }
    
    private ObservableList<Task> getTasks(String situation) {
        ObservableList<Task> tasks = FXCollections.observableArrayList();
        
        task = new Task();
        it = new TaskIterator(task.getTasks());
        
        while (it.hasNext()) {
            Task tsk = (Task) it.next();
            
            if (tsk.getSituation().equals(situation)) {
                tasks.add(tsk);
            }
        }
        
        return tasks;
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

    @FXML
    private void btnUpdateAction(ActionEvent event) throws IOException {
        Task tsk = this.getSelectionModel();
        Stage stage = new Stage();
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/UpdateTask.fxml"));
        Parent updateController = loader.load();
        
        Scene scene = new Scene(updateController);
        UpdateTaskController controller = loader.getController();
        controller.initData(tsk);
        
        stage.setScene(scene);
        stage.setWidth(440);
        stage.setHeight(322);
        stage.setResizable(false);
        stage.show();
    }
    
    private Task getSelectionModel() {      
        if (this.lastSelection.equals("To Do")) {
            return tblToDo.getSelectionModel().getSelectedItem();
            
        } else if (this.lastSelection.equals("In Progress")) {
            return tblInProgress.getSelectionModel().getSelectedItem();
            
        } else if (this.lastSelection.equals("Done")) {
            return tblDone.getSelectionModel().getSelectedItem();
        }
        
        return null;
    }
    
    @FXML
    private void tblToDoClicked(MouseEvent event) {
        Task tsk = tblToDo.getSelectionModel().getSelectedItem();
        
        if (tsk != null) {
            btnUpdate.setDisable(false);
            btnDelete.setDisable(false);
            this.lastSelection = "To Do";
        }
    }

    @FXML
    private void tblInProgressClicked(MouseEvent event) {
        Task tsk = tblInProgress.getSelectionModel().getSelectedItem();
        
        if (tsk != null) {
            btnUpdate.setDisable(false);
            btnDelete.setDisable(false);
            this.lastSelection = "In Progress";
        }
    }
    
    @FXML
    private void tblDoneClicked(MouseEvent event) {
        Task tsk = tblDone.getSelectionModel().getSelectedItem();
        
        if (tsk != null) {
            btnUpdate.setDisable(false);
            btnDelete.setDisable(false);
            this.lastSelection = "Done";
        }
    }    
    
    @FXML
    private void btnDeleteAction(ActionEvent event) {
        Task tsk = this.getSelectionModel();
        
        if (confirmDelete()) {
            tsk.deleteTask();
        }
    }
    
    private boolean confirmDelete() {
        ButtonType btnYes = new ButtonType("Yes");
        ButtonType btnNo = new ButtonType("No");
        
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        
        confirmation.getButtonTypes().setAll(btnYes, btnNo);
        confirmation.setTitle("Delete Task");
        confirmation.setHeaderText("Are you sure you want to delete this task?");
        
        Optional<ButtonType> result = confirmation.showAndWait();
        
        if (result.get().equals(btnYes)) {
            return true;
        }
        
        return false;
    }
}
