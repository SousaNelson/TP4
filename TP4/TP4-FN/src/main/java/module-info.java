module com.example.tpc9 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.sql.rowset;
    requires mysql.connector.j;
    requires java.desktop;

    opens com.example.tpc9 to javafx.fxml;
    exports com.example.tpc9;


}