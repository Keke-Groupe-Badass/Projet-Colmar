package Whole.FXPackage;

import Whole.daoPackage.AdminDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class FXExporterDonneeControleur {
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
            ControleurFunctions.changeScene(event, "FxInterfaceMain.fxml");
        }
    }
}
