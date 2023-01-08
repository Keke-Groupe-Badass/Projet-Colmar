package Whole.FXPackage;

import Whole.ccmsPackage.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXPersonneAjoutControleur extends FXMenuBarAbstractControleur{

    @FXML
    TextField nomTextField;
    @FXML
    TextField prenomTextField;
    @FXML
    TextArea noteTextArea;

    public void confirmer(ActionEvent event) {
        Personne p = new Personne();
        if(nomTextField.getText() != null) {
            if(!nomTextField.getText().isBlank())
                p.setNom(nomTextField.getText());
        }

        if(prenomTextField.getText()!=null) {
            if(!prenomTextField.getText().isBlank())
                p.setPrenom(prenomTextField.getText());
        }
        if(noteTextArea.getText() != null) {
            if (!noteTextArea.getText().isBlank()) {
                p.setNote(noteTextArea.getText());
            }
        }

        if (ControleurFunctions.personneDAO.creer(p)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Personne Crée");
            alert.setHeaderText(null);
            alert.setContentText("La personne à été crée.");
            alert.showAndWait();
            FXPagePersonneControleur.personne = p;
            ControleurFunctions.adminDAO.ecrireLog("à créer personne"+p.getId());

            ControleurFunctions.changeScene(event, "FxInterfacePagePersonne.fxml");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Une erreur est survenue");
            alert.setHeaderText("Erreur est survenue lors de l'insertion dans la base");
            alert.show();
        }
    }

    public void retour(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePersonnes.fxml");
    }



}
