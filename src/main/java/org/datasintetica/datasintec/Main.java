package org.datasintetica.datasintec;

import java.io.IOException;
import java.util.Objects;

import javafx.scene.image.Image;
import org.kordamp.bootstrapfx.BootstrapFX;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Generador Data Sintetica!");

        String ruta = "/org/datasintetica/datasintec/assets/images/nuevo.jpg";

        stage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream(ruta))));
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
}