package Whole.FXPackage;

import Whole.Controleur;
import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.daoPackage.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMain extends Application {
    static AdminDAO adminDAO;
    static OuvrageDAO ouvrageDAO;
    static LettrineDAO lettrineDAO;
    static TagDAO tagDAO;
    static PersonneDAO personneDAO;
    static Controleur controleur; //= new Controleur();
    static String name;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(FXMain.class.getResource("/FxPackage/FxInterfaceLogin.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Lettrine");
        stage.setScene(scene);
        stage.show();



    }
    public static Boolean connect(String login, String pwd){
        /**
        if(Controleur.Login(login,pwd)){
            name = login;
            return true;
        }
        return false;**/
        return true;
    }
    public static void main(String[] args) {
        launch();
    }

}