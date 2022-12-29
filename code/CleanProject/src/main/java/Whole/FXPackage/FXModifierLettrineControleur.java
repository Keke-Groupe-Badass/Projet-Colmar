package Whole.FXPackage;

import Whole.ccmsPackage.Lettrine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FXModifierLettrineControleur implements Initializable {

    public Lettrine lettrine;

    @FXML
    Label labelModifier;
    @FXML
    TextField pageTextField;
    @FXML
    TextField lienTextField;
    @FXML
    TextField ouvrageTextField;
    @FXML
    TextField createurTextField;
    @FXML
    TextField plagiatTextField;
    @FXML
    Button annulerBtn;
    @FXML
    Button confirmerBtn;

    public void valider(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrinesModifierValidation.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
