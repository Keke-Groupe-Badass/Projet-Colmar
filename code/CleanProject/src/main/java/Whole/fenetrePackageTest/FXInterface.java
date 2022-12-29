package Whole.fenetrePackageTest;

import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;
import Whole.ccmsPackage.Tag;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


/**
 * @see Application
 */
public class FXInterface extends Application implements FenetreInterface {
    private static Stage mainStage;


    @Override
    public void start(Stage stage) throws IOException {
        mainStage=stage;
        //Parent root = FXMLLoader.load(getClass().getResource("/FXInterface/FxInterfaceLogin.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/FXInterfaceTest/FxInterfaceMain.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


        //demo transferer valeur;
        Ouvrage ouvrage = new Ouvrage("toki",1);
        FxModifierOuvrageControleur.ouvrage=ouvrage;



        //Scene mainScene = new Scene(stage);

        //POPUP
        Popup popup = new Popup();
        Label lb = new Label("ceci est un popup");
        lb.setStyle("-fx-background-color: green;");
        lb.setMinSize(50,50);
        popup.getContent().add(lb);
        VBox boxPop = new VBox(500);
        popup.setWidth(500);
        popup.setWidth(500);

        Button b1 = new Button("ouis ");
        boxPop.getChildren().add(b1);
        popup.getContent().add(boxPop);
        popup.show(scene.getWindow());


        /**Scene chercheLettrine = new Scene(root);
        Scene chercheOuvrage = new Scene(root);
        Scene chercheTag = new Scene(root);
        Scene cherchePersonne = new Scene(root);
        Scene creerLettrine = new Scene(root);
        Scene creerOuvrage = new Scene(root);
        Scene creerTag = new Scene(root);
        Scene creerPersonne = new Scene(root);
        Scene pageLettrine = new Scene(root);
        Scene pageOuvrage = new Scene(root);
        Scene pageTag = new Scene(root);
        Scene pagePersonne = new Scene(root);**/
    }
    private static void setPagePersonne(Personne p){

    }
    private static void setPageTag(Tag t){

    }
    private static void setPageLettrine(Lettrine l){

    }
    private static void setPageOuvrage(Ouvrage o){

    }
    public void init(String[] args) {
        launch();
    }

    /**
     * Permet de changer la scène
     *
     * @param s une scène
     * @see Scene
     */
    @Override
    public void afficher(Scene s) {

    }

    /**
     * @return l'emplacement du fichier où sera sauvegarder un contenu.
     */
    @Override
    public String savePopUp() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(mainStage);
        if(selectedFile==null){
            return null;
        }
        return selectedFile.getAbsolutePath();
    }

    public void changeScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXInterfaceTestTest/" +fxml));
        mainStage.getScene().setRoot(root);
    }

    /**
     * Permet d'afficher à l'utilisateur un message
     *
     * @param message le message à afficher à l'utilisateur
     */
    @Override
    public void afficherMessage(String[] message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message[1]);
        alert.setTitle(message[0]);
        alert.show();
    }




}
