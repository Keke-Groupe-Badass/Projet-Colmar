package Whole.FXPackage;

import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class FXOuvrageAjoutControleur extends FXMenuBarAbstractControleur{
    @FXML
    TextField titreTextField;
    @FXML
    TextField creditPhotoTextField;
    @FXML
    CheckBox reechantillonageCheckBox;
    @FXML
    TextField copyrightTextField;
    @FXML
    TextField nombrePageTextField;
    @FXML
    TextField lieuTextField;
    @FXML
    TextField imprimeurTextField;
    @FXML
    TextField libraireTextField;
    @FXML
    TextField dateTextField;
    @FXML
    TextField formatTextField;
    @FXML
    TextField lienTextField;
    @FXML
    TextField resolutionTextField;
    @FXML
    Button annulerBtn;
    @FXML
    Button validerBtn;

    @FXML
    protected void valider(ActionEvent event){
        Ouvrage o = new Ouvrage();
        o.setTitre(titreTextField.getText());
        o.setCreditPhoto(creditPhotoTextField.getText());
        o.setReechantillonage(reechantillonageCheckBox.isSelected());
        o.setCopyright(copyrightTextField.getText());
        if(nombrePageTextField.getText()!=null){
            o.setNbPage(Integer.parseInt(nombrePageTextField.getText()));
        }else{
            o.setNbPage(-1);
        }
        o.setLieuImpression(lieuTextField.getText());
        if(imprimeurTextField.getText()==null){
            o.setImprimeur(null);
        }else{
            o.setImprimeur(new Personne(Integer.parseInt(imprimeurTextField.getText())));
        }
        if(libraireTextField.getText()==null){
            o.setLibraire(null);
        }else{
            o.setLibraire(new Personne(Integer.parseInt(libraireTextField.getText())));
        }
        if(dateTextField.getText()!=null){
            o.setDateEdition(Integer.parseInt(dateTextField.getText()));
        }else{
            o.setDateEdition(-1);
        }
        o.setLien(lienTextField.getText());
        o.setResolution(resolutionTextField.getText());
        if(ControleurFunctions.ouvrageDAO.creer(o)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ouvrage crée");
            alert.setHeaderText(null);
            alert.setContentText("L'ouvrage à été crée.");
            alert.showAndWait();
            ControleurFunctions.changeScene(event, "FxInterfacePageOuvrage.fxml");
            FXPageOuvrageControleur.ouvrage = o;
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Une erreur est survenue");
            alert.setHeaderText("Erreur est survenue durant l'insertion dans la base");
            alert.show();
        }
    }
    @FXML
    protected void annuler(ActionEvent event){
        ControleurFunctions.changeScene(event, "FxInterfaceOuvrages.fxml");
    }


}
