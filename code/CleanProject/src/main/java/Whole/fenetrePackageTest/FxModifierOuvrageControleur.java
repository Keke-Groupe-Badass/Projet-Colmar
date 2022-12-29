package Whole.fenetrePackageTest;

import Whole.ccmsPackage.Ouvrage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FxModifierOuvrageControleur implements Initializable {
    static Ouvrage ouvrage;
    @FXML
    Label labelOuvrageTest;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelOuvrageTest.setText(ouvrage.getTitre());
    }
}
