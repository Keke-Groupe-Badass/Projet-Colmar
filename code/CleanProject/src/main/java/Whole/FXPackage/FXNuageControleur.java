package Whole.FXPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;

import java.net.URL;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ResourceBundle;

public class FXNuageControleur implements Initializable {
    @FXML ImageView img;

    public void retour(ActionEvent event) throws IOException {
        Path path = Path.of("src/main/wordcloud/cloud.png");
        Files.delete(path);
        ControleurFunctions.changeScene(event, "FxInterfaceTags.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/wordcloud/cloud.png");
        Image image = new Image(file.toURI().toString());
        img.setImage(image);
    }
}
