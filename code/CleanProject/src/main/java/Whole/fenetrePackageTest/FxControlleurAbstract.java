package Whole.fenetrePackageTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FxControlleurAbstract {
    Node origin;

    /**
     * Permet de changer une scène
     * @param fxml le nom du fichier fxml sans l'extention
     * @throws IOException
     */
    void changeScene(String fxml) throws IOException {
        Stage window = (Stage) origin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/FXInterfaceTest/" +fxml+".fxml"));
        window.setScene(new Scene(root));

    }

}
