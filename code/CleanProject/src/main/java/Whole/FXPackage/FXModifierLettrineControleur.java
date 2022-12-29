package Whole.FXPackage;

import javafx.event.ActionEvent;

public class FXModifierLettrineControleur {
    public void valider(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrinesModifierValidation.fxml");
    }
}
