package Whole.FXPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class FXExporterLogControleur implements Initializable {
    @FXML
    TextField dossierTextField;
    @FXML
    Button confirm;
    @FXML
    protected void annuler(ActionEvent event){
        ControleurFunctions.changeScene(event, "FxInterfaceMain.fxml");
    }
    @FXML
    protected void explorer(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
        if(file == null){
        }else{
            dossierTextField.setText(file.getAbsolutePath());
        }
    }
    @FXML
    protected void valider(ActionEvent event){
        ControleurFunctions.changeScene(event, "FxInterfaceMain.fxml");
        if(!dossierTextField.getText().isBlank()){
            if(ControleurFunctions.adminDAO.exportLog(new File(dossierTextField.getText()))){
                ControleurFunctions.changeScene(event, "FxInterfaceMain.fxml");
                ControleurFunctions.adminDAO.ecrireLog("à exporter les logs");

            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(!ControleurFunctions.statut.equals("admin")){
            confirm.setDisable(true);
        }
    }
}
