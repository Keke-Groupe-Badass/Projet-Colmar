module com.example.cleanproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cleanproject to javafx.fxml;
    exports com.example.cleanproject;
}