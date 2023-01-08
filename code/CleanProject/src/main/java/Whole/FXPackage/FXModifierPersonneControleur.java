package Whole.FXPackage;

import Whole.ccmsPackage.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class FXModifierPersonneControleur extends FXMenuBarAbstractControleur implements Initializable {
    public static Personne personne;
    @FXML TextField nomTextField;
    @FXML TextField prenomTextField;
    @FXML TextArea noteTextArea;
    @FXML
    Label idLabel;

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

        if (!noteTextArea.getText().isBlank()) {
            p.setNote(noteTextArea.getText());
        }

        if (ControleurFunctions.personneDAO.modifier(personne, p)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Personne modifiée");
            alert.setHeaderText(null);
            alert.setContentText("La personne à été modifiée.");
            alert.showAndWait();
            FXPagePersonneControleur.personne = p;
            p.setId(personne.getId());
            ControleurFunctions.changeScene(event, "FxInterfacePagePersonne.fxml");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Une erreur est survenue");
            alert.setHeaderText("Erreur est survenue lors de l'insertion dans la base");
            alert.show();
        }
    }
    @FXML
    protected void supprimer(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supprimer");
        alert.setHeaderText("Voulez-vous vraiment supprimer cette personne?");
        alert.setContentText("Cette action est irreversible");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            if(ControleurFunctions.personneDAO.supprimer(personne)){
                ControleurFunctions.changeScene(event, "FxInterfacePersonnes.fxml");
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nomTextField.setText(personne.getNom());
        prenomTextField.setText(personne.getPrenom());
        noteTextArea.setText(personne.getNote());
        idLabel.setText("Modifier personne n°"+personne.getId());
    }
}
