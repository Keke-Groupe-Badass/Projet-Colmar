package Whole.FXPackage;

import javafx.event.ActionEvent;

public class FXLettrinesAjoutControleur {

    public void confirmationLettrinesScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrinesValidation.fxml");
    }
}
