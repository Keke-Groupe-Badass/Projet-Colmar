package Whole.FXPackage;

import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class FXLettrinesAjoutControleur extends FXMenuBarAbstractControleur{
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
    @FXML
    public void confirmationLettrinesScene(ActionEvent event) {
        Ouvrage o = new Ouvrage();
        int nbPage = -1;
        String lien = null;
        Personne p = new Personne();
        int identique = -1;
        if(ouvrageTextField.getText()!=null){
            if(!ouvrageTextField.getText().isBlank()){
                o.setId(Integer.parseInt(ouvrageTextField.getText()));
            }
        }
        if(pageTextField!=null){
            if(!pageTextField.getText().isBlank()){
                nbPage = Integer.parseInt(pageTextField.getText());
            }
        }

        if(lienTextField!=null){
            if(!lienTextField.getText().isBlank()){
                lien = lienTextField.getText();
            }
        }

        if(graveurTextField!=null){
            if(!graveurTextField.getText().isBlank()){
                p.setId(Integer.parseInt(graveurTextField.getText()));
            }
        }
        if(identiqueTextField!=null){
            if(!identiqueTextField.getText().isBlank()){
                identique = Integer.parseInt(identiqueTextField.getText());
            }
        }
        Lettrine l = new Lettrine(o,nbPage,lien,p,identique);
        if(ControleurFunctions.lettrineDAO.creer(l)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Lettrine Crée");
            alert.setHeaderText(null);
            alert.setContentText("La lettrine à été crée.");
            alert.showAndWait();
            ControleurFunctions.changeScene(event, "FxInterfacePageLettrine.fxml");
            FXPageLettrineControleur.lettrine = l;
        }
        else{

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Une erreur est survenue");
            alert.setHeaderText("Erreur est survenue durant la modification de la base");
            alert.show();
        }
    }
    @FXML
    public void retourForm(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrines.fxml");
    }
}
