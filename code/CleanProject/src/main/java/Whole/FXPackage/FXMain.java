package Whole.FXPackage;

import Whole.Controleur;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMain extends Application {

    static Controleur controleur; //= new Controleur();

    @Override
    public void start(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(FXMain.class.getResource("/FxPackage/FxInterfaceLogin.fxml"));
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("/css/colmar.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setTitle("Projet Colmar");
            stage.setScene(scene);
            stage.show();
            try {
                stage.getIcons().add(new Image("/lettrine.png"));
            }
            catch (Exception e){
            }
            if(controleur==null){
                controleur = new Controleur();
            }
            FXLoginControleur.dbName=Controleur.getConfigList().get(0);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Une erreur est survenue");
            alert.setHeaderText("Erreur lors du chargement de la page");

            alert.setContentText(System.err.toString());
            alert.show();
        }



    }
    public static Boolean connect(String login, String pwd){

        if(Controleur.Login(login,pwd)){
            ControleurFunctions.nom = login;
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        launch();
    }

}