package org.datasintetica.datasintec.utils;

import javafx.scene.control.CheckBox;

import java.awt.*;
import java.util.Arrays;

public class SelectCheckboxOne {
    /**
     * Metodo para solo poder selecionar nuevo checkbopx
     * @param checkboxes Lista de checkboxes
     */
    public void selectCheckboxOne( CheckBox... checkboxes) {
        for (CheckBox checkbox : checkboxes) {
            // Añade un listener a la propiedad 'selected' de cada CheckBox
            checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    Arrays.stream(checkboxes)
                            // Filtra el CheckBox actual del stream
                            .filter(otherCheckbox -> otherCheckbox != checkbox)
                            // Para cada CheckBox restante en el stream, establece su propiedad 'selected' en falso
                            .forEach(otherCheckbox -> otherCheckbox.setSelected(false));
                }
            });
        }
    }
}
