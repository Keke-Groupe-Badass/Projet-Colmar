package Whole.FXPackage;

import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FXLettrinesRechercheControleur extends FXMenuBarAbstractControleur implements Initializable {
    @FXML
    TextField idTextField;
    @FXML
    TextField ouvargeTextField;
    @FXML
    TextField personneTextField;
    @FXML
    TextField groupeTextField;
    @FXML
    ListView<Lettrine> listView;
    public void retourForm(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrines.fxml");
    }
    @FXML
    protected void chercher(ActionEvent event){

        Ouvrage o = new Ouvrage();
        if(ouvargeTextField.getText()!=null){
            try{
                o = new Ouvrage(Integer.parseInt(ouvargeTextField.getText()));
            }catch (NumberFormatException exception){

            }

        }
        Personne p = new Personne();

        if(personneTextField.getText()!=null){
            try{
                p = new Personne(Integer.parseInt(personneTextField.getText()));
            }catch (NumberFormatException exception){

            }

        }

        Lettrine l = new Lettrine();

        if(idTextField.getText()!=null){
            try{
                l.setId(Integer.parseInt(idTextField.getText()));
            }catch (NumberFormatException exception){

            }
        }
        if(groupeTextField.getText()!=null){
            try{
                l.setIdentique(Integer.parseInt(groupeTextField.getText()));
            }catch (NumberFormatException exception){

            }
        }

        l.setOuvrage(o);
        l.setCreateur(p);
        ArrayList<Lettrine> list = ControleurFunctions.lettrineDAO.chercher(l);
        System.out.println(list.size());
        ObservableList observableList = listView.getItems();
        observableList.clear();
        observableList.addAll(list);
        listView.refresh();
    }
    @FXML
    protected void itemCLick(MouseEvent event){
        //listView.getSelectionModel();
        //int id = listView.getSelectionModel().getSelectedIndex();
        //System.out.println(id);
        Lettrine l = listView.getSelectionModel().getSelectedItem();
        //Lettrine l = listView.getItems().get(id);
        System.out.println(l);
        FXPageLettrineControleur.lettrine=l;
        ControleurFunctions.changeScene(event,"FxInterfacePageLettrine.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.setOrientation(Orientation.VERTICAL);
    }
}
