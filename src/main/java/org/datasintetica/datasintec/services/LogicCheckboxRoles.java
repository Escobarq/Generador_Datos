package org.datasintetica.datasintec.services;

import net.datafaker.Faker;
import org.datasintetica.datasintec.controllers.MainController;
import org.datasintetica.datasintec.models.Template;

/**
 * Clase que contiene la logica de negocio para los checkbox
 */
public class LogicCheckboxRoles {

    private static final Faker FAKER = new Faker();

    /**
     * metodo para aplicar reglas de negocio a los checkbox
     *
     * @param template objeto de la clase template
     */
     static void logicCheckboxRules ( Template template , MainController MAINCONTROLLER) {

        String numero_documento = template.getNumeroIdentificacion();
        if (numero_documento.startsWith("8") || numero_documento.startsWith("9")) {
            template.setTipoDocumento("NIT");
            template.setSeparator0("_");
            template.setDigitoVerificacion(String.valueOf(FAKER.number().numberBetween(1, 9)));
            template.setSeparator1("_");
        } else {
            template.setSeparator0("_");
            template.setDigitoVerificacion("");
            template.setSeparator1("_");
        }

        String destinoEconomico = template.getDestinoEconomicoPredio();
        if (destinoEconomico.equals("RESIDENCIAL")) {
            template.setEstratoSocial(String.valueOf(FAKER.number().numberBetween(1, 6)));
            template.setSeparator19("_");
        } else {
            template.setEstratoSocial("99");
            template.setSeparator19("_");
        }
        if (MAINCONTROLLER.comboBox3.getValue().equals("G-Valle")) {
            template.setMunicipioSuministro(FAKER.options().option("76001"));
        } else if (MAINCONTROLLER.comboBox3.getValue().equals("Tulua")) {
            template.setMunicipioSuministro(FAKER.options().option("76834"));
        } else if (MAINCONTROLLER.comboBox3.getValue().equals("Palmira")) {
            template.setMunicipioSuministro(FAKER.options().option("76520"));
        } else if (MAINCONTROLLER.comboBox3.getValue().equals("Antioquia")) {
            template.setMunicipioSuministro(FAKER.options().option("05001"));
        }
    }
}
