package Whole.FXPackage;

import Whole.ccmsPackage.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXModifierPersonneControleur {
    private static Personne personne = new Personne();
    @FXML TextField nomTextField;
    @FXML TextField prenomTextField;
    @FXML TextArea noteTextArea;
    public void confirmer(ActionEvent event) {
        Personne p = new Personne();
        if(!nomTextField.getText().isBlank()) {
            p.setNom(nomTextField.getText());
        }

        if(!prenomTextField.getText().isBlank()) {
            p.setPrenom(prenomTextField.getText());
        }

        if(!noteTextArea.getText().isBlank()) {
            p.setNote(noteTextArea.getText());
        }

        if (ControleurFunctions.personneDAO.modifier(personne, p)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Personne Crée");
            alert.setHeaderText(null);
            alert.setContentText("La personne à été crée.");
            alert.showAndWait();
            ControleurFunctions.changeScene(event, "FxInterfacePagePersonne.fxml");
            FXPagePersonneControleur.personne = p;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Une erreur est survenue");
            alert.setHeaderText("Erreur est survenue lors de l'insertion dans la base");
            alert.show();
        }
    }
}
