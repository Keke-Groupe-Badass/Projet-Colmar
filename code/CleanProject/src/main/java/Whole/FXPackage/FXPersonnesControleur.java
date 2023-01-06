package Whole.FXPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class FXPersonnesControleur extends FXMenuBarAbstractControleur implements Initializable {
    @FXML
    Button ajouterBtn;
    public void accueilScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceMain.fxml");
    }
    public void lettrinesScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrines.fxml");
    }

    public void ouvragesScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceOuvrages.fxml");
    }

    public void tagsScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceTags.fxml");
    }

    public void pagePersonne(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePagePersonne.fxml");
    }

    public void lettrinesRechercheFormScene(ActionEvent event) {
    }

    public void lettrinesAjoutFormControleur(ActionEvent event) {
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(ControleurFunctions.statut.equals("chercheur")){
            ajouterBtn.setDisable(true);
        }
    }
}
