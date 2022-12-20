package Whole.fenetrePackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * @see Application
 */
public class FXInterface extends Application implements FenetreInterface {
    public static void main(String[] args) {
        launch(args);
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
        return null;
    }

    /**
     * Permet d'afficher à l'utilisateur un message
     *
     *
     * @param message le message à afficher à l'utilisateur
     */
    @Override
    public void afficherMessage(String message) {

    }


    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        stage.setScene(new Scene(root, 300, 250));
        stage.show();

    }
}
