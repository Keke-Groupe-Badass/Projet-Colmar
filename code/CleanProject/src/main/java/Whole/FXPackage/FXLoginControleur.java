package Whole.FXPackage;

import Whole.Controleur;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXLoginControleur implements Initializable {
    static String dbName;
    @FXML
    TextField mailTextField;
    @FXML
    PasswordField passwordTextField;
    @FXML
    TextField dbTextField;



    @FXML
    public void changementDeScene(ActionEvent event) {
        try {
            Controleur.getConfigList().set(0,dbTextField.getText());
            if(FXMain.connect(mailTextField.getText(),passwordTextField.getText())){
                Parent root = FXMLLoader.load(FXMain.class.getResource("/FXPackage/FxInterfaceMain.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
            else{

            }
            //TODO MESSAGE MAUVAIS DE MOT DE PASSE
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbTextField.setText(dbName);
    }
}
