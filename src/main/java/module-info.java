module org.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens org.example.demo2 to javafx.fxml;
    exports org.example.demo2;
    opens org.example.demo2.controllers to javafx.fxml;
    exports org.example.demo2.controllers;
}