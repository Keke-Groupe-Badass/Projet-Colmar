package Whole.FXPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FXExporterLogControleur {
    @FXML
    TextField dossierTextField;
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
}
