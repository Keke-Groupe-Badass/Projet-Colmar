package Whole.FXPackage;

import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;


public class FXOuvrageRechercheControleur extends FXMenuBarAbstractControleur{
    @FXML
    TextField imprimeurTextField;
    @FXML
    TextField libraireTextField;
    @FXML
    TextField titreTextField;
    @FXML
    TextField lieuTextField;
    @FXML
    Button retourBtn;
    @FXML
    Button validerBtn;
    @FXML
    ListView<Ouvrage> listView;
    @FXML
    protected void valider(ActionEvent event){
        Ouvrage o = new Ouvrage();
        if(imprimeurTextField.getText()!=null){
            try{
                o.setImprimeur(new Personne(Integer.parseInt(imprimeurTextField.getText())));
            }catch(Exception e){
                System.err.println(e);
                o.setImprimeur(null);
            }
        }else{
            o.setImprimeur(null);
        }
        if(libraireTextField.getText()!=null){
            try{
                o.setLibraire(new Personne(Integer.parseInt(libraireTextField.getText())));
            }catch(Exception e){
                System.err.println(e);
                o.setLibraire(null);
            }
        }else{
            o.setLibraire(null);
        }

        o.setTitre(titreTextField.getText());
        o.setDateEdition(-1);
        o.setNbPage(-1);

        System.out.println(o);
        ArrayList<Ouvrage> listOuvrage = ControleurFunctions.ouvrageDAO.chercher(o);
        listView.getItems().clear();
        listView.getItems().addAll(listOuvrage);
        listView.refresh();
    }
    @FXML
    protected void annuler(ActionEvent event){
        ControleurFunctions.changeScene(event, "FxInterfaceOuvrages.fxml");
    }
    @FXML
    protected void itemCLick(MouseEvent event){
        Ouvrage o = listView.getSelectionModel().getSelectedItem();
        FXPageOuvrageControleur.ouvrage=o;
        ControleurFunctions.changeScene(event,"FxInterfacePageOuvrage.fxml");
    }

}
