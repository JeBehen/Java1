module com.example.transformapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.transformapp to javafx.fxml;
    exports com.example.transformapp;
}