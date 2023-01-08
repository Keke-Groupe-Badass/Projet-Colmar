package Whole.FXPackage;

import Whole.ccmsPackage.Personne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class FXPagePersonneControleur extends FXMenuBarAbstractControleur implements Initializable {
    public static Personne personne = new Personne();
    @FXML Button modifier;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(ControleurFunctions.statut.equals("chercheur")){
            modifier.setDisable(true);
        }
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
