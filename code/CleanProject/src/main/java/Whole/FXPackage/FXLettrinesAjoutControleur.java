package Whole.FXPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FXLettrinesAjoutControleur {
    @FXML
    TextField ouvrageTextField;
    @FXML
    TextField pageTextField;
    @FXML
    TextField lienTextField;
    @FXML
    TextField graveurTextField;
    @FXML
    TextField identiqueTextField;
    public void confirmationLettrinesScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrinesValidation.fxml");
    }
}
