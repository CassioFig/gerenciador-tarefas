package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Cássio Figueiredo
 */
public class UpdateTaskController implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private DatePicker txtDate;
    @FXML
    private ComboBox<String> cbxSituation;
    @FXML
    private Button btnUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnUpdateAction(ActionEvent event) {
    }
    
}
