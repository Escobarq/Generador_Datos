package org.datasintetica.datasintec.utils;

import java.util.List;

import javafx.scene.control.CheckBox;

/**
 * Clase que se encarga de manejar los checkbox
 */
public class CheckboxManager {


    /**
     * Desactiva todos los CheckBox en la lista dada.
     * @param allCheckBoxes lista de CheckBox
     */
    public static void deactivateAllCheckboxes(List<CheckBox> allCheckBoxes) {
        for (CheckBox checkBox : allCheckBoxes) {
            checkBox.setSelected(false);
        }
    }
    /**
     * Activa todos los CheckBox excepto los dos últimos en la lista dada.
     * @param allCheckBoxes lista de CheckBox
     */
    public static void activateAllCheckboxes(List<CheckBox> allCheckBoxes) {
        deactivateAllCheckboxes(allCheckBoxes);
        // Activar todos los CheckBox excepto los dos últimos
        for (int i = 0; i < allCheckBoxes.size() - 2; i++) {
            CheckBox checkBox = allCheckBoxes.get(i);
            checkBox.setSelected(true);
        }
    }
    public static void activateAllCheckboxes(@SuppressWarnings("exports") List<CheckBox> allCheckBoxes ,List<Integer> indicesActivados) {
        deactivateAllCheckboxes(allCheckBoxes);
        for (int index : indicesActivados) {
            if (index >= 0 && index < allCheckBoxes.size()) {
                CheckBox checkBox = allCheckBoxes.get(index);
                checkBox.setSelected(true);
            }
        }
    }
}