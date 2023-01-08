package Whole.FXPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class FXExporterDonneeControleur implements Initializable {
    @FXML
    ChoiceBox<String> choiceBox;
    @FXML
    TextField dossierTextField;
    @FXML
    protected void annuler(ActionEvent event){
        ControleurFunctions.changeScene(event, "FxInterfaceMain.fxml");
    }
    @FXML
    protected void explorer(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
        if(selectedDirectory == null){
        }else{
            dossierTextField.setText(selectedDirectory.getAbsolutePath());
        }
    }
    @FXML
    protected void valider(ActionEvent event){
        if(ControleurFunctions.adminDAO.exportDonnee(choiceBox.getValue(),dossierTextField.getText())){
            ControleurFunctions.adminDAO.ecrireLog("à exporter les données au format "+choiceBox.getValue());
            ControleurFunctions.changeScene(event, "FxInterfaceMain.fxml");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll("SQL","CSV");
        choiceBox.setValue("CSV");
    }
}
