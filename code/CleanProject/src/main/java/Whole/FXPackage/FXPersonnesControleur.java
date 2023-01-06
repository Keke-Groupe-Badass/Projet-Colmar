package Whole.FXPackage;

import javafx.event.ActionEvent;

public class FXPersonnesControleur {

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

    public void personnesAjoutFormControleur(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePersonneAjout.fxml");
    }

    public void personnesRechercheFormScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePersonneRecherche.fxml");
    }
}
