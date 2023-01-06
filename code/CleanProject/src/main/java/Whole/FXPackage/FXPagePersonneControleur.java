package Whole.FXPackage;

import Whole.ccmsPackage.Personne;

import javafx.event.ActionEvent;

public class FXPagePersonneControleur extends FXMenuBarAbstractControleur{
    public static Personne personne;
    public void retourPersonnes(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePersonnes.fxml");
    }
}
