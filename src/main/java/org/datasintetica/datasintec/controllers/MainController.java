package org.datasintetica.datasintec.controllers;

import java.util.ArrayList;
import java.util.List;

import org.datasintetica.datasintec.models.Template;
import org.datasintetica.datasintec.services.DataGenerationService;
import org.datasintetica.datasintec.utils.ComboBoxOption;
import org.datasintetica.datasintec.utils.CustomAlert;
import org.datasintetica.datasintec.utils.TextfieldNumber;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Clase que se encarga de controlar la vista principal
 */
public class MainController {

    public ComboBoxOption comboBox1;
    @FXML
    private TextfieldNumber textField2;
    public ComboBoxOption comboBox3;
    public ComboBoxOption comboBox4;
    @FXML
    protected Button generateDataFakerModal;
    public CheckBox checkBox1;
    public CheckBox checkBox2;
    public CheckBox checkBox3;
    public CheckBox checkBox4;
    public CheckBox checkBox5;
    public CheckBox checkBox6;
    public CheckBox checkBox7;
    public CheckBox checkBox8;
    public CheckBox checkBox9;
    public CheckBox checkBox10;
    public CheckBox checkBox11;
    public CheckBox checkBox12;
    public CheckBox checkBox13;
    public CheckBox checkBox14;
    public CheckBox checkBox15;
    public CheckBox checkBox16;
    public CheckBox checkBox17;
    public CheckBox checkBox18;
    public CheckBox checkBox19;
    public CheckBox checkBox20;
    public CheckBox checkBox21;
    public CheckBox checkBox22;
    public CheckBox checkBox23;
    public CheckBox checkBox24;
    public CheckBox checkBox25;
    public CheckBox checkBox26;
    public CheckBox checkBox27;
    public CheckBox checkBox28;
    public CheckBox checkBox29;
    public CheckBox checkBox30;
    public CheckBox checkBox31;
    public CheckBox checkBox32;
    public CheckBox checkBox33;
    public CheckBox checkBox34;
    public CheckBox checkBox35;
    public CheckBox checkBox36;
    public CheckBox checkBox37;
    public CheckBox checkBox38;

    // Instancias
    CustomAlert alertDialog = new CustomAlert();
    DataGenerationService data = new DataGenerationService(this);
    // Variables
    static List<CheckBox> allCheckBoxes;

    /**
     * Metodo para selecionar checkbox
     * 
     * @return allCheckBoxes
     */
    public static List<CheckBox> getAllCheckBoxes() {
        return allCheckBoxes;
    }

    public void initialize() {
        allCheckBoxes = List.of(
                checkBox1, checkBox2, checkBox3, checkBox4,
                checkBox5, checkBox6, checkBox7, checkBox8,
                checkBox9, checkBox10, checkBox11, checkBox12,
                checkBox13, checkBox14, checkBox15, checkBox16,
                checkBox17, checkBox18, checkBox19, checkBox20,
                checkBox21, checkBox22, checkBox23, checkBox24,
                checkBox25, checkBox26, checkBox27, checkBox28,
                checkBox29, checkBox30, checkBox31, checkBox32,
                checkBox33, checkBox34, checkBox35, checkBox36,
                checkBox37, checkBox38);
        comboBox1.comboBoxOptionOne();
        textField2.TextfieldNumberOne();
        comboBox3.comboBoxOptionTwo();
        comboBox4.comboBoxOptionThree();
    }

    /**
     * @param event activara evento de modalview para generar datos faker
     */
    @FXML
    protected void generateDataFakerModal(ActionEvent event) {
        
        String comboBoxone = comboBox1.getValue();
        if (comboBoxone == null || comboBoxone.isEmpty()) {
            alertDialog.customAlert("Modal Informativo", "Por favor selecionar el  tipo ft");
            return;
        }
        String tipo_ft = comboBoxone;

        String textField2Value = textField2.getText();
        if (textField2Value == null || textField2Value.isEmpty() || Integer.parseInt(textField2Value) == 0) {
            alertDialog.customAlert("Modal Informativo",
                "El campo de cantidad de registros no puede estar vacío o ser igual a 0");
            return;
        }
        int cantidad_registros = Integer.parseInt(textField2Value);

        String comboBoxthree = comboBox3.getValue();
        if (comboBoxthree == null || comboBoxthree.isEmpty()) {
            alertDialog.customAlert("Modal Informativo", "Por favor selecionar el tipo de cliente");
            return;
        }
        String tipo_cliente = comboBoxthree;

        String comboBoxfour = comboBox4.getValue();
        if (comboBoxfour == null || comboBoxfour.isEmpty()) {
            alertDialog.customAlert("Modal Informativo", "Por favor selecionar el tipo de archivo");
            return;
        }
        String tipo_archivo = comboBoxfour;


        ArrayList<Template> templates;

        try {
            // Generador
            templates = data.generateAndValidatorData(cantidad_registros);
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/org/datasintetica/datasintec/view/ModalView.fxml"));
            Parent root = loader.load();
            // Obtener instancia del controlador
            ModalView controller = loader.getController();
            // pasar parametros al controlador
            controller.recibirParametros(tipo_ft, tipo_cliente, tipo_archivo, templates);
            // Configuracion de la ventana modal
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());
            stage.setTitle("Modal");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            alertDialog.customAlert("Modal Informativo", "Por favor completar los campos requeridos");
        }
    }

}