package Whole.FXPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class FXOuvragesControleur extends FXMenuBarAbstractControleur implements Initializable {
    @FXML
    Button ajouterBtn;
    public void accueilScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceMain.fxml");
    }

    public void lettrinesScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrines.fxml");
    }

    public void personnesScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePersonnes.fxml");
    }

    public void tagsScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceTags.fxml");
    }
    @FXML
    public void ouvrageRechercheFormScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceOuvrageRecherche.fxml");
    }
    @FXML
    public void ouvrageAjoutFormScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceOuvrageAjout.fxml");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(ControleurFunctions.statut.equals("chercheur")){
            ajouterBtn.setDisable(true);
        }
    }
}
