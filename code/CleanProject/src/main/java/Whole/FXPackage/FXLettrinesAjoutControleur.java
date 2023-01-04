package Whole.FXPackage;

import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class FXLettrinesAjoutControleur {
    @FXML
    TextField ouvrageTextField;
    @FXML
    TextField pageTextField;
    @FXML
    TextField lienTextField;
    @FXML
    TextField graveurTextField;
    @FXML
    TextField identiqueTextField;
    public void confirmationLettrinesScene(ActionEvent event) {
        Ouvrage o = new Ouvrage();
        int nbPage = -1;
        String lien = null;
        Personne p = new Personne();
        int identique = -1;
        if(!ouvrageTextField.getText().isBlank()){
            o.setId(Integer.parseInt(ouvrageTextField.getText()));
        }
        if(!pageTextField.getText().isBlank()){
            nbPage = Integer.parseInt(pageTextField.getText());
        }
        if(!lienTextField.getText().isBlank()){
            lien = lienTextField.getText();
        }
        if(!graveurTextField.getText().isBlank()){
            p.setId(Integer.parseInt(graveurTextField.getText()));
        }
        if(!identiqueTextField.getText().isBlank()){
            identique = Integer.parseInt(identiqueTextField.getText());
        }
        Lettrine l = new Lettrine(o,nbPage,lien,p,identique);
        if(ControleurFunctions.lettrineDAO.creer(l)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Lettrine Modifiée");
            alert.setHeaderText(null);
            alert.setContentText("La lettrine à été modifiée.");
            alert.showAndWait();
            ControleurFunctions.changeScene(event, "FxInterfacePageLettrine.fxml");
            FXPageLettrineControleur.lettrine = l;
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Une erreur est survenue");
            alert.setHeaderText("Erreur est survenue dans l'insertion de la base");
            alert.show();
        }
    }
}
