package Whole.FXPackage;

import Whole.daoPackage.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class ControleurFunctions {
    public static AdminDAO adminDAO;
    public static OuvrageDAO ouvrageDAO;
    public static LettrineDAO lettrineDAO;
    public static TagDAO tagDAO;
    public static PersonneDAO personneDAO;
    public static UtilisateurDAO utilisateurDAO;

    public static void changeScene(ActionEvent event, String filename) {
        try {
            Parent root = FXMLLoader.load(FXMain.class.getResource("/FXPackage/"+filename));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
