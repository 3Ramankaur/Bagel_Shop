module com.example.javafx_application {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.javafx_application to javafx.fxml;
    exports com.example.javafx_application;
}