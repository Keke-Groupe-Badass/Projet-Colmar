package Whole.fenetrePackageTest;

import Whole.Controleur;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FXLoginControleur {



    FXInterface fx;
    TextField nameTextField;
    PasswordField passwordField;
    @FXML
    protected void handleConnection(ActionEvent event) {
        try {
            if(Controleur.Login(nameTextField.getText(),passwordField.getText())){
                fx.changeScene("FxInterfaceMain");
            }
            else{
                fx.afficherMessage(new String[] {"Erreur lors de la connection","Impossible de se connecter"});
            }
        } catch (IOException e) {
            fx.afficherMessage(new String[] {"Erreur lors de la connection","Impossible de se connecter"});
        }
    }
}
