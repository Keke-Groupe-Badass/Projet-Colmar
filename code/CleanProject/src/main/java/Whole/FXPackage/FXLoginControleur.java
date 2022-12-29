package Whole.FXPackage;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FXLoginControleur {

    @FXML
    TextField mailTextField;
    @FXML
    PasswordField passwordTextField;

    @FXML
    public void changementDeScene(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(FXMain.class.getResource("/FXPackage/FxInterfaceMain.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
