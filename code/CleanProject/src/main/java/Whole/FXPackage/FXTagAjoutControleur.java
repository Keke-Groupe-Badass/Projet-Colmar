package Whole.FXPackage;

import Whole.ccmsPackage.Tag;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXTagAjoutControleur {
    @FXML
    TextField nomTextField;
    @FXML
    TextArea descriptionTextArea;
    @FXML
    public void valider(ActionEvent event) {
        Tag t = new Tag();
        if(!descriptionTextArea.getText().isBlank()){
            t.setDescription(descriptionTextArea.getText());
        }
        if(!nomTextField.getText().isBlank()){
            t.setNom(nomTextField.getText());
        }
        if(ControleurFunctions.tagDAO.creer(t)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Tag Crée");
            alert.setHeaderText(null);
            alert.setContentText("Le tag à été crée.");
            alert.showAndWait();
            ControleurFunctions.changeScene(event, "FxInterfacePageTag.fxml");
            FXPageTagControleur.tag = t;
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Une erreur est survenue");
            alert.setHeaderText("Erreur est survenue durant la modification de la base");
            alert.show();
        }
    }
    @FXML
    public void retourForm(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceTags.fxml");
    }
}
