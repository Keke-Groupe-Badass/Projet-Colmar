package Whole.FXPackage;

import Whole.ccmsPackage.Tag;

import Whole.daoPackage.TagDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Optional;

public class FXModifierTagsControleur extends FXMenuBarAbstractControleur{
    public static Tag tag;
    @FXML
    TextField nomTextField;
    @FXML
    TextArea descriptionTextArea;
    @FXML
    protected void annuler(ActionEvent event){
        ControleurFunctions.changeScene(event, "FxInterfacePageTag.fxml");
    }
    @FXML
    protected void supprimer(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supprimer");
        alert.setHeaderText("Voulez-vous vraiment supprimer ce tag?");
        alert.setContentText("Cette action est irreversible");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            if(ControleurFunctions.tagDAO.supprimer(tag)){
                ControleurFunctions.changeScene(event, "FxInterfaceTags.fxml");
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }
    @FXML
    public void valider(ActionEvent event) {
        Tag t = new Tag();
        if(!nomTextField.getText().isBlank()){
            t.setNom(nomTextField.getText());
        }
        if(!descriptionTextArea.getText().isBlank()){
            t.setDescription(descriptionTextArea.getText());
        }
        if(ControleurFunctions.tagDAO.modifier(tag,t)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Tag Modifiée");
            alert.setHeaderText(null);
            alert.setContentText("Le tag à été modifié.");
            alert.showAndWait();
            ControleurFunctions.changeScene(event, "FxInterfacePageTag.fxml");
        }else{

        }
    }
}
