package Whole.FXPackage;

import javafx.event.ActionEvent;

public class FXLettrinesControleur {

    public void accueilScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceMain.fxml");
    }

    public void ouvragesScene(ActionEvent event) {

        ControleurFunctions.changeScene(event, "FxInterfaceOuvrages.fxml");
    }

    public void personnesScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePersonnes.fxml");
    }

    public void tagsScene(ActionEvent event) {

        ControleurFunctions.changeScene(event, "FxInterfaceTags.fxml");
    }

    public void lettrinesRechercheFormScene(ActionEvent event) {
       ControleurFunctions.changeScene(event, "FxInterfaceLettrinesRecherche.fxml");
    }

    public void lettrinesAjoutFormScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrinesAjout.fxml");
    }

    public void pageLettrineScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePageLettrine.fxml");
    }
}
