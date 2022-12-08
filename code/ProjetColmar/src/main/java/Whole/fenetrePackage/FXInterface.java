package Whole.fenetrePackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @see Application
 */
public class FXInterface extends Application implements FenetreInterface {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     * @param primaryStage
     *
     */
    @Override
    public void start(Stage primaryStage) {

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


}
