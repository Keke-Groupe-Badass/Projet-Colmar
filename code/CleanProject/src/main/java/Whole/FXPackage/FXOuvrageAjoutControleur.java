package Whole.FXPackage;

import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class FXOuvrageAjoutControleur {
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
        if(!titreTextField.getText().isBlank()){
            o.setTitre(titreTextField.getText());
        }
        if(!creditPhotoTextField.getText().isBlank()){
            o.setCreditPhoto(creditPhotoTextField.getText());
        }
        o.setReechantillonage(reechantillonageCheckBox.isSelected());
        if(!copyrightTextField.getText().isBlank()){
            o.setCopyright(copyrightTextField.getText());
        }
        if(!nombrePageTextField.getText().isBlank()){
            o.setNbPage(Integer.parseInt(nombrePageTextField.getText()));
        }
        if(!lieuTextField.getText().isBlank()){
            o.setLieuImpression(lieuTextField.getText());
        }
        if(!imprimeurTextField.getText().isBlank()){
            o.setImprimeur(new Personne(Integer.parseInt(imprimeurTextField.getText())));
        }
        if(!libraireTextField.getText().isBlank()){
            o.setLibraire(new Personne(Integer.parseInt(libraireTextField.getText())));
        }
        if(!dateTextField.getText().isBlank()){
            o.setDateEdition(Integer.parseInt(dateTextField.getText()));
        }
        if(!formatTextField.getText().isBlank()){
            o.setFormat(dateTextField.getText());
        }
        if(!lienTextField.getText().isBlank()){
            o.setLien(lienTextField.getText());
        }
        if(!resolutionTextField.getText().isBlank()){
            o.setResolution(resolutionTextField.getText());
        }
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
