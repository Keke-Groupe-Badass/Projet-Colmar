package Whole.FXPackage;

import javafx.event.ActionEvent;

public class FXMainControleur extends FXMenuBarAbstractControleur{

    public void lettrinesScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrines.fxml");
        /*
        try {
            Parent root = FXMLLoader.load(FXMain.class.getResource("FxInterfaceLettrines.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

         */
    }

    public void ouvragesScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceOuvrages.fxml");
        /*
        try {
            Parent root = FXMLLoader.load(FXMain.class.getResource("FxInterfaceOuvrages.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

         */
    }

    public void personnesScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePersonnes.fxml");
        /*
        try {
            Parent root = FXMLLoader.load(FXMain.class.getResource("FxInterfacePersonnes.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        */

    }

    public void tagsScene(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceTags.fxml");
        /*
        try {
            Parent root = FXMLLoader.load(FXMain.class.getResource("FxInterfaceTags.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

         */
    }
}
