package Whole.FXPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FXCreerUtilisateur implements Initializable {
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
        if(passwordField.getText()!=null&confirmPasswordField.getText()!=null){
            if(passwordField.getText().equals(confirmPasswordField.getText())){
                if(ControleurFunctions.utilisateurDAO.mdpValide(passwordField.getText())){
                    ControleurFunctions.utilisateurDAO.creerUtilisateur(emailTextField.getText(), passwordField.getText(), statutChoiceBox.getValue());
                    ControleurFunctions.adminDAO.ecrireLog("à créer personne utilisateur "+emailTextField.getText());
                    ControleurFunctions.changeScene(event, "FxInterfaceMain.fxml");
                }
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> options = FXCollections.observableArrayList("chercheur","modérateur","admin");
        statutChoiceBox.setValue("chercheur");
        statutChoiceBox.setItems(options);
    }
}
