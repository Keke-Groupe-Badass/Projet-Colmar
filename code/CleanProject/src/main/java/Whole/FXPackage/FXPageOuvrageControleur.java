package Whole.FXPackage;

import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;

import java.util.ResourceBundle;

public class FXPageOuvrageControleur extends FXMenuBarAbstractControleur implements Initializable {
    public static Ouvrage ouvrage;
    @FXML
    Label titreLabel;
    @FXML
    Label idLabel;
    @FXML
    Label dateLabel;
    @FXML
    Label formatLabel;
    @FXML
    Label resolutionLabel;
    @FXML
    Label creditPhotoLabel;
    @FXML
    Label reechantillonageLabel;
    @FXML
    Label copyrightLabel;
    @FXML
    Label nombrePageLabel;
    @FXML
    Label lieuLabel;
    @FXML
    Button imprimeurBtn;
    @FXML
    Button libraireBtn;
    @FXML
    Label lienLabel;
    @FXML
    ListView<Personne> personneListView;
    @FXML
    Button modifierBtn;
    public void modifierScene(ActionEvent event) {
        FXModifierOuvrageControleur.ouvrage=ouvrage;
        ControleurFunctions.changeScene(event, "FxInterfaceModifierOuvrage.fxml");
    }

    public void retour(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceOuvrages.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lienLabel.setText(ouvrage.getLien());
        titreLabel.setText(ouvrage.getTitre());
        dateLabel.setText(""+ouvrage.getDateEdition());
        formatLabel.setText(ouvrage.getFormat());
        resolutionLabel.setText(ouvrage.getResolution());
        creditPhotoLabel.setText(ouvrage.getCreditPhoto());
        reechantillonageLabel.setText(""+ouvrage.getReechantillonage());
        copyrightLabel.setText(ouvrage.getCopyright());
        nombrePageLabel.setText(""+ouvrage.getNbPage());
        lieuLabel.setText(ouvrage.getLieuImpression());
        idLabel.setText(""+ouvrage.getId());
        if(ouvrage.getImprimeur()!=null){
            imprimeurBtn.setText(ouvrage.getImprimeur().toString());
        }
        if(ouvrage.getLibraire()!=null){
            libraireBtn.setText(ouvrage.getLibraire().toString());
        }
        if(ControleurFunctions.statut.equals("chercheur")){
            modifierBtn.setDisable(true);
        }
    }
    @FXML
    protected void clickOnPersonne(MouseEvent event) {
        Personne p = personneListView.getSelectionModel().getSelectedItem();
        if(p!=null){
            FXPagePersonneControleur.personne = p;
            ControleurFunctions.changeScene(event, "FxInterfacePagePersonne.fxml");
        }
    }
    @FXML
    protected void clickOnLibraireBtn(ActionEvent event) {
        Personne p = ouvrage.getLibraire();
        if(p!=null){
            FXPagePersonneControleur.personne = p;
            ControleurFunctions.changeScene(event, "FxInterfacePagePersonne.fxml");
        }
    }
    @FXML
    protected void clickOnImprimeurBtn(ActionEvent event) {
        Personne p = ouvrage.getImprimeur();
        if(p!=null){
            if(p.getId()>-1){
                FXPagePersonneControleur.personne = p;
                ControleurFunctions.changeScene(event, "FxInterfacePagePersonne.fxml");
            }
        }
    }

}
