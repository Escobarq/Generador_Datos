module org.datasintetica.datasintec {
//    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires junit;
    requires java.desktop;
    requires net.datafaker;
    requires javafx.controls;
    requires kotlin.stdlib;

    opens org.datasintetica.datasintec to javafx.fxml;
    exports org.datasintetica.datasintec.utils to javafx.fxml;
    exports org.datasintetica.datasintec;
    exports org.datasintetica.datasintec.controllers;
    opens org.datasintetica.datasintec.controllers to javafx.fxml;
    exports org.datasintetica.datasintec.services to javafx.fxml;
    exports org.datasintetica.datasintec.models to javafx.fxml;
}