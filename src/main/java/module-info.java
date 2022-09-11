module com.java.mvs.mvs_rgb_filter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.java.mvs.mvs_rgb_filter to javafx.fxml;
    exports com.java.mvs.mvs_rgb_filter;
}