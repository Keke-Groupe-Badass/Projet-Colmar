package Whole.FXPackage;

import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class FXModifierOuvrageControleur extends FXMenuBarAbstractControleur implements Initializable {
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
    Label labelModifier;
    ArrayList<Personne> newPersonne = new ArrayList<>();
    ArrayList<Personne> removePersonne = new ArrayList<>();
    ObservableList<Personne> listPersonne = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelModifier.setText("Modifier Ouvrage n°:"+ouvrage.getId());
        lienTextField.setText(ouvrage.getLien());
        lieuTextField.setText(ouvrage.getLieuImpression());
        pageTextField.setText(""+ouvrage.getNbPage());
        copyrightTextField.setText(ouvrage.getCopyright());
        reechantillonageCheckBox.setSelected(ouvrage.getReechantillonage());
        creditPhotoTextField.setText(ouvrage.getCreditPhoto());
        resolutionTextField.setText(ouvrage.getResolution());
        formatTextField.setText(ouvrage.getFormat());
        titreTextField.setText(ouvrage.getTitre());
        dateTextField.setText(""+ouvrage.getDateEdition());

        if(ouvrage.getLibraire()!=null){
            libraireTextField.setText(ouvrage.getLibraire().toString());
        }
        if(ouvrage.getImprimeur()!=null){
            imprimeurTextField.setText(ouvrage.getImprimeur().toString());
        }
        for(Personne p:ouvrage.getAuteurs()){
            listPersonne.add(p);
        }
        listView.setItems(listPersonne);
        listView.refresh();
    }
    @FXML
    protected void ajouterAuteur(ActionEvent event){
        if(addAuteurTextField.getText()!=null){
            Personne p = new Personne(Integer.parseInt(addAuteurTextField.getText()));
            newPersonne.add(p);
            listPersonne.add(p);
            listView.refresh();
        }
    }

    @FXML
    protected void clickListAuteur(MouseEvent event){
        if(supprimerCheckBox.isSelected()){
            Personne p = listView.getSelectionModel().getSelectedItem();
            if(newPersonne.contains(p)){
                newPersonne.remove(p);
            }
            else{
                removePersonne.add(p);
            }
            listPersonne.remove(p);
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
        newOuvrage.setTitre(titreTextField.getText());
        newOuvrage.setFormat(formatTextField.getText());
        newOuvrage.setResolution(resolutionTextField.getText());
        newOuvrage.setCreditPhoto(creditPhotoTextField.getText());
        newOuvrage.setReechantillonage(reechantillonageCheckBox.isSelected());
        newOuvrage.setCopyright(copyrightTextField.getText());
        newOuvrage.setLieuImpression(lieuTextField.getText());
        newOuvrage.setLien(lienTextField.getText());
        if(dateTextField.getText()!=null) {
            newOuvrage.setDateEdition(Integer.parseInt(dateTextField.getText()));
        }else{
            newOuvrage.setDateEdition(-1);
        }
        if(pageTextField.getText()!=null) {
            newOuvrage.setNbPage(Integer.parseInt(pageTextField.getText()));
        }else{
            newOuvrage.setNbPage(-1);
        }
        if(imprimeurTextField.getText()==null){
            newOuvrage.setImprimeur(null);
        }else{
            newOuvrage.setImprimeur(new Personne(Integer.parseInt(imprimeurTextField.getText())));
        }
        if(libraireTextField.getText()==null){
            newOuvrage.setLibraire(null);
        }else{
            newOuvrage.setLibraire(new Personne(Integer.parseInt(libraireTextField.getText())));
        }

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
    @FXML
    protected void supprimer(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supprimer");
        alert.setHeaderText("Voulez-vous vraiment supprimer cet ouvrage?");
        alert.setContentText("Cette action est irreversible");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            if(ControleurFunctions.ouvrageDAO.supprimer(ouvrage)){
                ControleurFunctions.changeScene(event, "FxInterfaceOuvrages.fxml");
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }
}
