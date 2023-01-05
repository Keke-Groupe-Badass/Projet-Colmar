package Whole.FXPackage;

import Whole.Metadonnee;
import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;

import Whole.ccmsPackage.Tag;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FXModifierOuvrageControleur implements Initializable {
    public static Ouvrage ouvrage;
    @FXML
    TextField titreTextField;
    @FXML
    TextField dateTextField;
    @FXML
    TextField formatTextField;
    @FXML
    TextField resolutionTextField;
    @FXML
    TextField creditPhotoTextField;
    @FXML
    CheckBox reechantillonageCheckBox;
    @FXML
    TextField copyrightTextField;
    @FXML
    TextField pageTextField;
    @FXML
    TextField lieuTextField;
    @FXML
    TextField imprimeurTextField;
    @FXML
    TextField libraireTextField;
    @FXML
    TextField lienTextField;
    @FXML
    TextField addAuteurTextField;
    @FXML
    CheckBox supprimerCheckBox;
    @FXML
    ListView<Personne> listView;
    @FXML
    Label idLabel;

    ArrayList<Personne> newPersonne = new ArrayList<>();

    ArrayList<Personne> removePersonne = new ArrayList<>();

    ObservableList<Personne> listPersonne = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idLabel.setText(idLabel.getText()+ouvrage.getId());
        lienTextField.setText(ouvrage.getLien());
        libraireTextField.setText(ouvrage.getLibraire().toString());
        imprimeurTextField.setText(ouvrage.getImprimeur().toString());
        lieuTextField.setText(ouvrage.getLieuImpression());
        pageTextField.setText(""+ouvrage.getNbPage());
        copyrightTextField.setText(ouvrage.getCopyright());
        reechantillonageCheckBox.setSelected(ouvrage.getReechantillonage());
        creditPhotoTextField.setText(ouvrage.getCreditPhoto());
        resolutionTextField.setText(ouvrage.getResolution());
        formatTextField.setText(ouvrage.getFormat());
        titreTextField.setText(ouvrage.getTitre());
        dateTextField.setText(""+ouvrage.getDateEdition());

        for(Personne p:ouvrage.getAuteurs()){
            listPersonne.add(p);
        }
        listView.setItems(listPersonne);
        listView.refresh();
    }


    @FXML
    protected void ajouterAUteur(ActionEvent event){
        if(addAuteurTextField.getText()!=null){
            Personne p = new Personne(Integer.parseInt(addAuteurTextField.getText()));
            newPersonne.add(p);
            listPersonne.add(p);
            listView.refresh();
        }
    }

    @FXML
    protected void clickListAuteur(ActionEvent event){
        if(supprimerCheckBox.isSelected()){
            Personne p = listView.getSelectionModel().getSelectedItem();
            newPersonne.remove(p);
            listPersonne.remove(p);
            removePersonne.add(p);
            listView.refresh();
        }
    }
    @FXML
    protected void annuler(ActionEvent event){
        ControleurFunctions.changeScene(event, "FxInterfacePageOuvrage.fxml");
    }
    @FXML
    public void valider(ActionEvent event) {
        Ouvrage newOuvrage = new Ouvrage();
        if(ControleurFunctions.ouvrageDAO.modifier(ouvrage,newOuvrage)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ouvrage Modifiée");
            alert.setHeaderText(null);
            alert.setContentText("L'ouvrage à été modifié.");
            alert.showAndWait();
            ControleurFunctions.changeScene(event, "FxInterfacePageOuvrage.fxml");
        }else{

        }
    }
}
