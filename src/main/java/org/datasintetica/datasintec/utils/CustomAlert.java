package org.datasintetica.datasintec.utils;


import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * Clase que se encarga de mostrar un alerta personalizada
 */
public class CustomAlert  {

    public void customAlert(String title ,String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
