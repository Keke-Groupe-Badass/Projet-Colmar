package Whole.FXPackage;

import Whole.ccmsPackage.Lettrine;
import javafx.event.ActionEvent;

public class FXPageLettrineControleur {
    Lettrine lettrine;
    public void modifierScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceModifierLettrine.fxml");
    }

    public void retour(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrines.fxml");
    }

    public void afficheLettrinesParTagname(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrines.fxml");
    }

    public void personnePage(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePagePersonne.fxml");
    }
}
