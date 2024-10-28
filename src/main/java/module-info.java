module com.example.slider1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.slider1 to javafx.fxml;
    exports com.example.slider1;
}