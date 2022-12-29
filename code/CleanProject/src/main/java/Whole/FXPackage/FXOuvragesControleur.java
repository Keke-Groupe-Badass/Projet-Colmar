package Whole.FXPackage;

import javafx.event.ActionEvent;

public class FXOuvragesControleur {

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
}
