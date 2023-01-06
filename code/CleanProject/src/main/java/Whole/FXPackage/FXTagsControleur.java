package Whole.FXPackage;

import Whole.wordCloud.cloudWordGenerator;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;


public class FXTagsControleur {

    public void accueilScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceMain.fxml");
    }

    public void lettrinesScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrines.fxml");
    }

    public void ouvragesScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceOuvrages.fxml");
    }

    public void personnesScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePersonnes.fxml");
    }

    public void nuageAction(ActionEvent event) {
        String[] args = new String[0];
        cloudWordGenerator.main(args);
        ControleurFunctions.changeScene(event, "FxInterfaceNuage.fxml");
    }
    @FXML
    public void tagsRechercheFormScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceTagRecherche.fxml");

    }
    @FXML
    public void tagsAjoutFormControleur(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceTagAjout.fxml");

    }
}
