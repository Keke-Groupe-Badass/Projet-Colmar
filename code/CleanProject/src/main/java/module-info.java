module com.example.cleanproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.cleanproject to javafx.fxml;
    exports com.example.cleanproject;
}