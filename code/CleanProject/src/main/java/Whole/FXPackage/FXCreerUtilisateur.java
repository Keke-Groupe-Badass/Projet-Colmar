package Whole.FXPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXCreerUtilisateur {
    @FXML
    TextField emailTextField;
    @FXML
    PasswordField passwordField;
    @FXML
    PasswordField confirmPasswordField;
    @FXML
    ChoiceBox<String> statutChoiceBox;

    @FXML
    protected void annuler(ActionEvent event){
        ControleurFunctions.changeScene(event, "FxInterfaceMain.fxml");
    }
    @FXML
    protected void valider(ActionEvent event) {
        if(passwordField.getText().equals(confirmPasswordField.getText())){
            if(ControleurFunctions.utilisateurDAO.mdpValide(passwordField.getText())){
                ControleurFunctions.utilisateurDAO.creerUtilisateur(emailTextField.getText(), passwordField.getText(), statutChoiceBox.getValue());
                ControleurFunctions.changeScene(event, "FxInterfaceMain.fxml");
            }
        }
    }
}
