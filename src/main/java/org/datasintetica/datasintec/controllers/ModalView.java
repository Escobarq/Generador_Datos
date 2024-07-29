package org.datasintetica.datasintec.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.datasintetica.datasintec.models.Template;
import org.datasintetica.datasintec.services.FileSaver;
import org.datasintetica.datasintec.utils.Excellent;
import org.datasintetica.datasintec.utils.SelectCheckboxOne;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Clase que se encarga de controlar la vista modal para exportar los datos
 * generados con faker
 */
public class ModalView  {

    @FXML
    private CheckBox exportTxt;
    @FXML
    private CheckBox exportCsv;
    @FXML
    private CheckBox exportXlsx;
    @FXML
    private CheckBox demilitadorComa;
    @FXML
    private CheckBox demilitadorPuntoComa;
    @FXML
    private CheckBox demilitadorPipe;
    @FXML
    private CheckBox demilitadorDoublePipe;
    @FXML
    private TextField rutaArchivo;
    @FXML
    private Button showFile;
    @FXML
    protected Button quitModal;

    //Instancias de clasees
    SelectCheckboxOne selectCheckboxOne = new SelectCheckboxOne();
    // Variables de instancia
    private String tipoft;
    private String cliente;
    private String tipo;
    private ArrayList<Template> templates;
    Excellent excellent = new Excellent ();

    public void initialize() {
        selectCheckboxOne.selectCheckboxOne(exportTxt, exportCsv);
        selectCheckboxOne.selectCheckboxOne(demilitadorComa, demilitadorPuntoComa, demilitadorPipe, demilitadorDoublePipe);
        quitModal.setOnAction(event -> {
            quitModal();
        });
        showFile.setOnAction(event -> {
            try {
                showFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Metodo para recibir los parametros de la vista principal
     * @param tipoft tipoft
     * @param tipocliente cliente
     * @param tipoarchivo tipo
     */
    public void recibirParametros ( String tipoft, String tipocliente, String tipoarchivo, ArrayList<Template> templates) {
        this.tipoft = tipoft;
        this.cliente = tipocliente;
        this.tipo = tipoarchivo;
        this.templates = templates;
    }
    /**
     * Metodo para cerrar la vista modal
     */
    protected void quitModal (){
        //remover el modal de la escena
        quitModal.getScene().getWindow().hide();
        excellent.showMessageExcellent ();
    }

    /**
     * Metodo para mostrar el dialogo de guardado de archivo
     */
    private void showFile() throws IOException {
        FileSaver fileSaver = new FileSaver();
        Window stage = showFile.getScene().getWindow();
        File file = fileSaver.saveFile(stage,
                                     tipoft, 
                                     cliente, 
                                     tipo,
                                     templates, 
                                     exportTxt.isSelected(), 
                                     exportCsv.isSelected(),
                                     exportXlsx.isSelected(),
                                     demilitadorComa.isSelected(),
                                    demilitadorPuntoComa.isSelected(), 
                                    demilitadorPipe.isSelected(), 
                                    demilitadorDoublePipe.isSelected());
        if (file != null) {
            rutaArchivo.setText(file.getAbsolutePath());
        }
    }

}
