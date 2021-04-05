package control;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Task;

/**
 * FXML Controller class
 *
 * @author Cássio Figueiredo
 */
public class RegisterTaskController implements Initializable {
    
    @FXML
    private TextField txtName;
    @FXML
    private DatePicker txtDate;
    @FXML
    private ComboBox<String> cbxPriority;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxPriority.setItems(getOptions());
    }  
    
    private ObservableList<String> getOptions() {
        ObservableList<String> options = FXCollections.observableArrayList();
        
        options.add("Low");
        options.add("Medium");
        options.add("High");
        
        return options;
    }

    @FXML
    private void btnRegisterAction(ActionEvent event) {
        Task task = new Task(txtName.getText(), cbxPriority.getValue(), 
                String.valueOf(txtDate.getValue()));
        
        task.saveTask();
        reset();
    }
    
    private void reset() {
        txtName.setText(null);
        cbxPriority.setValue(null);
        txtDate.setValue(null);
    }
    
    @FXML
    private void btnCancelAction(ActionEvent event) {
        reset();
    }
    
    private void resetMain() throws IOException {
        Stage stage = new Stage();
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Main.fxml"));
        Parent main = loader.load();
        
        Scene scene = new Scene(main);

        stage.setScene(scene);
        stage.setWidth(908);
        stage.setHeight(625);
        stage.setResizable(false);
        stage.show();

    }
    
}
