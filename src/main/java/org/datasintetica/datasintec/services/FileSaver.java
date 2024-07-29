package org.datasintetica.datasintec.services;

import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.datasintetica.datasintec.models.Template;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileSaver {
    String extension = "";
    String demilitador = "";

    /**
     * Determina la extensión del archivo en función de las banderas booleanas proporcionadas.
     *
     * @param isTxt   una bandera booleana que indica si el archivo es un archivo de texto
     * @param isCsv   una bandera booleana que indica si el archivo es un archivo CSV
     * @param isXlsx  una bandera booleana que indica si el archivo es un archivo de Excel
     */
    private void determineFileExtension(boolean isTxt, boolean isCsv, boolean isXlsx) {
        if (isCsv) {
            extension = ".csv";
        } else if (isTxt) {
            extension = ".txt";
        } else if (isXlsx) {
            extension = ".xlsx";
        }
    }

    /**
     * Determina el delimitador en función de las banderas booleanas proporcionadas.
     *
     * @param demilitadorComa       bandera que indica si el delimitador debe ser una coma (',')
     * @param demilitadorPuntoComa  bandera que indica si el delimitador debe ser un punto y coma (';')
     * @param demilitadorPipe       bandera que indica si el delimitador debe ser una barra vertical ('|')
     * @param demilitadorDoublePipe bandera que indica si el delimitador debe ser una doble barra vertical ('¦')
     */
    private void determineDelimiter(boolean demilitadorComa, boolean demilitadorPuntoComa, boolean demilitadorPipe,
            boolean demilitadorDoublePipe) {
        if (demilitadorComa) {
            demilitador = ",";
        } else if (demilitadorPuntoComa) {
            demilitador = ";";
        } else if (demilitadorPipe) {
            demilitador = "|";
        } else if (demilitadorDoublePipe) {
            demilitador = "¦";
        }
    }

    /**
     * @param stage Obtener la escena actual
     * @param tipoft obtener valor de tipoft
     * @param cliente obtener valor de cliente
     * @param tipo obtener valor de tipo
     * @param isTxt obtener valor de checkbox activado
     * @param isCsv si es txt o csv
     * @param isXlsx si es archivo excel
     * @return retornar el archivo
     */
    public File saveFile(Window stage, 
                        String tipoft, 
                        String cliente, 
                        String tipo, 
                        ArrayList<Template> templates,
                        boolean isTxt, 
                        boolean isCsv,
                        boolean isXlsx ,
                        boolean demilitadorComa,
                        boolean demilitadorPuntoComa, 
                        boolean demilitadorPipe ,
                        boolean demilitadorDoublePipe) throws IOException {
        
        determineFileExtension(isTxt, isCsv, isXlsx);
        //Demilitadores
        determineDelimiter(demilitadorComa, demilitadorPuntoComa, demilitadorPipe, demilitadorDoublePipe);
        //Nombre archivo
        String nombreArchivo = tipoft + "_" + cliente + "_" + tipo + extension;
        //Generar archivo
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar archivo");
        fileChooser.setInitialFileName(nombreArchivo);
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try {
                FileWriter fileWriter = new FileWriter(file);
                StringBuilder content = new StringBuilder();
                for(Template template : templates){
                    String formated_data = template.toString().replace("_", demilitador).trim();
                    content.append(formated_data).append("\n");
                }
                fileWriter.write(content.toString());
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
   
}
