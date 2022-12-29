package Whole.FXPackage;

import javafx.event.ActionEvent;

public class FXPagePersonneControleur {
    public void retourPersonnes(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePersonnes.fxml");
    }
}
