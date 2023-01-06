package Whole.FXPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class FXMenuBarAbstractControleur {
    @FXML
    MenuBar myMenuBar;
    @FXML
    protected void changeUtilisateur(ActionEvent event){
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        changeScene(stage,"FxInterfaceModifierUtilisateur.fxml");
    }
    public static void changeScene(Stage stage, String filename) {
        try {
            Parent root = FXMLLoader.load(FXMain.class.getResource("/FXPackage/"+filename));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Une erreur est survenue");
            alert.setHeaderText("Erreur lors du chargement de la page");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
