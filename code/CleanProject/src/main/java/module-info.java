module com.example.cleanproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.junit.jupiter.api;
    requires java.desktop;


    opens com.example.cleanproject to javafx.fxml;
    exports com.example.cleanproject;
}