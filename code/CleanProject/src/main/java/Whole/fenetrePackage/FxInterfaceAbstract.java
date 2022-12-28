package Whole.fenetrePackage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class FxInterfaceAbstract {
    Node origin;

    void changeScene(String fxml) throws IOException {
        Stage window = (Stage) origin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/FXInterface/"+fxml));
        window.setScene(new Scene(root));

    }

}
