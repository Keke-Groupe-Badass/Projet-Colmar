package Whole.FXPackage;

import Whole.ccmsPackage.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class FXPersonneAjoutControleur {

    public static Personne personne;
    @FXML
    TextField nomTextField;
    @FXML
    TextField prenomTextField;
    @FXML
    TextField noteTextField;

    public void annuler(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePersonnes.fxml");
    }

    public void valider(ActionEvent event) {
        Personne p = new Personne();
        if (!nomTextField.getText().isBlank()) {
            p.setNom(nomTextField.getText());
        }

        if (!prenomTextField.getText().isBlank()) {
            p.setPrenom(prenomTextField.getText());
        }

        if (!noteTextField.getText().isBlank()) {
            p.setNote(noteTextField.getText());
        }

        if (ControleurFunctions.personneDAO.modifier(personne, p)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Personne modifiée");
            alert.setHeaderText(null);
            alert.setContentText("La personne à été modifiée.");
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
