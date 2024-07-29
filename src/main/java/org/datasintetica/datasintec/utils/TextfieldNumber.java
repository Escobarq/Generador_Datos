package org.datasintetica.datasintec.utils;

import javafx.scene.control.TextField;

/**
 * Clase que se encarga de validar que el campo de texto solo acepte numeros
 */
public class TextfieldNumber extends TextField {

    /**
     * Validar que el campo de textfield solo acepte números
     */
    public void TextfieldNumberOne() {
        this.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                this.setText(newValue.replaceAll("\\D", ""));
            }
        });
    }
}
