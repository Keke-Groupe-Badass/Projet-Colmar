package Whole.FXPackage;

import javafx.event.ActionEvent;


public class FXLettrinesControleur extends FXMenuBarAbstractControleur{

    public void accueilScene(ActionEvent event) {
        /**
         *         Parent root = FXMLLoader.load(FXMain.class.getResource("/FXPackage/"+filename));
         *         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         *         Scene scene = new Scene(root);
         *         stage.setScene(scene);
         *         stage.show();
         */

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
