package Whole.FXPackage;

import javafx.event.ActionEvent;

public class FXPageLettrineControleur {

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
