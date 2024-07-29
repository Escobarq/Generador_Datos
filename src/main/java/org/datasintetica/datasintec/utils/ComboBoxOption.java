package org.datasintetica.datasintec.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import org.datasintetica.datasintec.controllers.MainController;
import java.util.List;

/**
 * Clase que se encarga de llenar los combobox con las opciones necesarias
 */
public class ComboBoxOption extends ComboBox<String> {

    /**
     * Llenar combobox de opciones del ft
     */
    public void comboBoxOptionOne(){
        ObservableList<String> options = FXCollections.observableArrayList(
                "FT-01","FT-06","FT-11","FT-12"
        );
        this.setItems(options);
        this.setOnAction(event -> {
            String selectedValue = this.getSelectionModel().getSelectedItem();
            if ("FT-01".equals(selectedValue)) {
                CheckboxManager.activateAllCheckboxes(MainController.getAllCheckBoxes());
            } else if ("FT-06".equals(selectedValue)) {
                CheckboxManager.activateAllCheckboxes(MainController.getAllCheckBoxes());
            }else if("FT-11".equals(selectedValue)){
                CheckboxManager.activateAllCheckboxes(MainController.getAllCheckBoxes(), List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,33,34));
            }
            else if("FT-12".equals(selectedValue)) {
                CheckboxManager.activateAllCheckboxes(MainController.getAllCheckBoxes(), List.of(0, 1,7,8,9,15,20,21,22,23,24,25,26,27,28,29,30,31,32,35));
            }else{
                CheckboxManager.deactivateAllCheckboxes(MainController.getAllCheckBoxes());
            }
        });
    }
    /**
     * Llenar combobox de opciones del cliente
     */
    public void comboBoxOptionTwo() {
        ObservableList<String> options = FXCollections.observableArrayList(
                "G-Valle", "Tulua", "Palmira","Antioquia"
        );
        this.setItems(options);
    }
    /**
     * Llenar combobox de opciones para tipo de archivo
     */
    public void comboBoxOptionThree() {
        ObservableList<String> options = FXCollections.observableArrayList(
                "Ordinario", "Calendario"
        );
        this.setItems(options);
    }
}
