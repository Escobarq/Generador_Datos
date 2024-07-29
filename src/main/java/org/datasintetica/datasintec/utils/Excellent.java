package org.datasintetica.datasintec.utils;

import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Excellent extends TextFlow {

    public void showMessageExcellent () {
        this.setStyle("-fx-background-color: #4CAF50; -fx-padding: 20px;");

        Text message = new Text("Excelente!\n");
        message.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");

        Text label = new Text("Se han generado correctamente los datos 👍");
        label.setStyle("-fx-font-size: 16px; -fx-text-fill: white;");

        this.getChildren().addAll(message, label);

        // Crear una nueva escena y stage para mostrar el mensaje
        Stage stage = new Stage();
        Scene scene = new Scene(this, 500, 100);
        stage.setScene(scene);
        stage.resizableProperty ().setValue (false);
        stage.setMaximized ( false );
        stage.setFullScreen ( false );
        stage.setTitle("Excelente!");
        stage.show();
    }
}
