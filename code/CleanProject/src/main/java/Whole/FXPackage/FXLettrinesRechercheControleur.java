package Whole.FXPackage;

import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class FXLettrinesRechercheControleur {
    @FXML
    TextField idTextField;
    @FXML
    TextField ouvargeTextField;
    @FXML
    TextField personneTextField;
    @FXML
    TextField groupeTextField;
    @FXML
    Button validerBtn;
    @FXML
    Button retourBtn;
    @FXML
    ListView<Lettrine> listView;
    public void retourForm(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrines.fxml");
    }
    @FXML
    protected void chercher(ActionEvent event){
        Ouvrage o = new Ouvrage();
        if(!ouvargeTextField.getText().isBlank()){
            o = new Ouvrage(Integer.parseInt(ouvargeTextField.getText()));
        }
        Personne p = new Personne();
        if(!personneTextField.getText().isBlank()){
            p = new Personne(Integer.parseInt(personneTextField.getText()));
        }
        Lettrine l = new Lettrine();
        if(!idTextField.getText().isBlank()){
            l.setId(Integer.parseInt(idTextField.getText()));
        }
        if(!groupeTextField.getText().isBlank()){
            l.setIdentique(Integer.parseInt(groupeTextField.getText()));
        }
        l.setOuvrage(o);
        l.setCreateur(p);
        ArrayList<Lettrine> list = ControleurFunctions.lettrineDAO.chercher(l);
        ObservableList observableList = listView.getItems();
        observableList.clear();
        observableList.addAll(list);
        listView.refresh();
    }
    @FXML
    protected void itemCLick(ActionEvent event){
        Lettrine l = listView.getSelectionModel().getSelectedItem();
        FXPageLettrineControleur.lettrine=l;
        ControleurFunctions.changeScene(event,"FxInterfacePageLettrine.fxml");
    }


}
