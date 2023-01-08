package Whole.FXPackage;

import Whole.ccmsPackage.Personne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FXPagePersonneControleur extends FXMenuBarAbstractControleur implements Initializable {
    public static Personne personne;
    @FXML Button modifier;
    @FXML
    Label identifiantLabel;
    @FXML
    Label nomLabel;
    @FXML
    Label prenomLabel;
    @FXML
    Label noteLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(ControleurFunctions.statut.equals("chercheur")){
            modifier.setDisable(true);
        }
        identifiantLabel.setText("Personne n°"+personne.getId());
        noteLabel.setText(personne.getNote());
        prenomLabel.setText(personne.getPrenom());
        nomLabel.setText(personne.getNom());
    }
    @FXML
    public void modifier(ActionEvent event) {
        FXModifierPersonneControleur.personne = personne;
        ControleurFunctions.changeScene(event, "FxInterfaceModifierPersonne.fxml");
    }
    @FXML
    public void retour(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePersonnes.fxml");
    }
}
