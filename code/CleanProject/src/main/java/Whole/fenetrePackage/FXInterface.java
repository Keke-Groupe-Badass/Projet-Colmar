package Whole.fenetrePackage;

import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;
import Whole.ccmsPackage.Tag;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
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
        Parent root = FXMLLoader.load(getClass().getResource("/FXInterface/FxInterfaceMain.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        //Scene mainScene = new Scene(stage);



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
    public static void main(String[] args) {
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
        Parent root = FXMLLoader.load(getClass().getResource("/FXInterface/"+fxml));
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
    @FXML
    protected void handleModifierOuvrageAction(ActionEvent event) {
        try {
            changeScene("FxInterfaceModifierOuvrage");
        } catch (IOException e) {
            afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleModifierTagAction(ActionEvent event) {
        try {
            changeScene("FxInterfaceModifierTag");
        } catch (IOException e) {
            afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleModifierPersonneAction(ActionEvent event) {
        try {
            changeScene("FxInterfaceModifierPersonne");
        } catch (IOException e) {
            afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleModifierLettrineAction(ActionEvent event) {
        try {
            changeScene("FxInterfaceModifierLettrine");
        } catch (IOException e) {
            afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleCreerOuvrageAction(ActionEvent event) {
        try {
            changeScene("FxInterfaceCreerOuvrage");
        } catch (IOException e) {
            afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleCreerTagAction(ActionEvent event) {
        try {
            changeScene("FxInterfaceCreerTag");
        } catch (IOException e) {
            afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleCreerPersonneAction(ActionEvent event) {
        try {
            changeScene("FxInterfaceCreerPersonne");
        } catch (IOException e) {
            afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleCreerLettrineAction(ActionEvent event) {
        try {
            changeScene("FxInterfaceCreerLettrine");
        } catch (IOException e) {
            afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleProfilOuvrageAction(ActionEvent event) {
        try {
            changeScene("FxInterfaceProfilOuvrage");
        } catch (IOException e) {
            afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleProfilTagAction(ActionEvent event) {
        try {
            changeScene("FxInterfaceProfilTag");
        } catch (IOException e) {
            afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleProfilPersonneAction(ActionEvent event) {
        try {
            changeScene("FxInterfaceProfilPersonne");
        } catch (IOException e) {
            afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleProfilLettrineAction(ActionEvent event) {
        try {
            changeScene("FxInterfaceProfilLettrine");
        } catch (IOException e) {
            afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }


}
