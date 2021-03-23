package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 *
 * @author Cássio Figueiredo
 */
public class MainController implements Initializable {

    @FXML
    private TableView<?> tblToDo;
    @FXML
    private TableView<?> tblInProgress;
    @FXML
    private TableView<?> tblDone;
    @FXML
    private Button btnNewTask;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
