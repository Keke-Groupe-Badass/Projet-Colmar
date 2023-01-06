package Whole.FXPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FXNuageControleur {
    @FXML ImageView img;

    public void retour(ActionEvent event) throws IOException {
        Path path = Path.of("src/main/wordcloud/cloud.png");
        Files.delete(path);
        ControleurFunctions.changeScene(event, "FxInterfaceTags.fxml");
    }

    public void displayImg(ActionEvent event) {
        File file = new File("src/main/wordcloud/cloud.png");
        Image image = new Image(file.toURI().toString());
        img.setImage(image);
    }
}
