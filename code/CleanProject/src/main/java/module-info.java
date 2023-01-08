module com.example.cleanproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.junit.jupiter.api;
    requires java.desktop;
    requires mysql.connector.java;
    requires java.naming; //rajouté


    //opens com.example.cleanproject to javafx.fxml;
    //exports com.example.cleanproject;
    exports Whole.exportPackage;
    opens Whole.exportPackage to javafx.fxml;
    //exports Whole.fenetrePackageTest;
    //opens Whole.fenetrePackageTest to javafx.fxml;
    opens Whole.FXPackage to javafx.fxml;
    exports Whole.FXPackage;
    exports Whole.wordCloud;
    opens Whole.wordCloud to javafx.fxml;

}
