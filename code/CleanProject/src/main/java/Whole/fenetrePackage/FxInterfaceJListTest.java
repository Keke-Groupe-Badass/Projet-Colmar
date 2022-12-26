package Whole.fenetrePackage;

import Whole.Metadonnee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FxInterfaceJListTest implements Initializable {
    ObservableList list = FXCollections.observableArrayList();
    ArrayList metaList= new ArrayList();
    @FXML
    private ListView<Metadonnee> listView;

    @FXML
    private void getSelection(){
        System.out.println(listView.getSelectionModel().getSelectedItem().toString());
    }
    public void loadData(){
        list.removeAll(list);
        Metadonnee m1 = new Metadonnee("couleur",0,"rouge",null,"yeux");
        Metadonnee m2 = new Metadonnee("taille",1,"10","cm","telephone");
        Metadonnee m3 = new Metadonnee("gout",2,"bon",null,"repas");
        list.addAll(m1,m2,m3);
        metaList.add(m1);
        metaList.add(m2);
        metaList.add(m3);

        listView.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
    }
}
