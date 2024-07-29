package org.datasintetica.datasintec.services;

import net.datafaker.Faker;
import org.datasintetica.datasintec.controllers.MainController;
import org.datasintetica.datasintec.models.Template;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase que se encarga de generar los datos de FAKER
 */
public class DataGenerationService {

    // Importacion de FAKER con local en colombia
    private final Faker FAKER = new Faker(new Locale("es-CO"));
    private final String[] CORREGIMIENTOS = { "Pance", "Navarro", "Montebello", "Buitrera", "Golondrinas" };
    private final String[] DESTINOS = { "RESIDENCIAL", "COMERCIAL", "INDUSTRIAL", "OFICIAL", "ESPECIAL", "OTROS" };
    private final String[] BARRIOS = { "Caney", "Lilí", "Cañaverales", "Cataya", "CiudadMelendez", "MulticentroCali" };
    int valor_nui = Integer.parseInt(FAKER.number().digits(7));
    int ciudad = Integer.parseInt(FAKER.address().postcode());
    String direction_factura = "CRA" + FAKER.address().streetAddressNumber();
    ArrayList<String> tipo = new ArrayList<>();
    ArrayList<String> numero = new ArrayList<>();
    private final MainController MAINCONTROLLER;

    // Generar una fecha aleatoria entre 2020 y 2024
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate startDate = LocalDate.of(2020, 1, 1);
    LocalDate endDate = LocalDate.of(2024, 1, 31);
    long startEpochDay = startDate.toEpochDay();
    long endEpochDay = endDate.toEpochDay();
    long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);
    LocalDate fechaIniPeriodo = LocalDate.ofEpochDay(randomDay);
    LocalDate fechafinperiodo = fechaIniPeriodo.plusYears(1);
    String fechaIniPeriodoFormatted = fechaIniPeriodo.format(formatter);
    String fechafinperiodoFormatted = fechafinperiodo.format(formatter);

    /**
     * Obteniedo instancia del controlador principal
     *
     * @param mainController controlador principal
     */
    public DataGenerationService(MainController mainController) {
        this.MAINCONTROLLER = mainController;
    }

    /**
     * metodo para generar los datos falsos
     *
     * @param valorNumeroRegistros cantidad de registros a generar
     * @return retornar de mi clase témplate para todos los elementos del ft
     */
    public ArrayList<Template> generateDataFaker(int valorNumeroRegistros) {

        ArrayList<Template> templates = new ArrayList<>();

        // Obtener valores de tipo y número para el ft-12

        for (int i = 0; i < valorNumeroRegistros; i++) {
            Template template = new Template();
            // generar los datos de faker
            if (MAINCONTROLLER.comboBox1.getValue().equals("FT-01")
                    || MAINCONTROLLER.comboBox1.getValue().equals("FT-06")) {
                template.setTipoDocumento(FAKER.options().option("CC", "CE", "P"));
                template.setSeparator0("_");
                template.setDigitoVerificacion("");
                template.setSeparator1("_");
                template.setNumeroIdentificacion(String.valueOf(FAKER.number().numberBetween(100000000L, 9999999999L)));
                template.setSeparator2("_");
                template.setRazonSocialPrimerNombre(FAKER.name().firstName().trim());
                template.setSeparator3("_");
                template.setSegundoNombre(FAKER.name().firstName().trim());
                template.setSeparator4("_");
                template.setPrimerApellido(FAKER.name().lastName().trim());
                template.setSeparator5("_");
                template.setSegundoApellido(FAKER.name().lastName().trim());
                template.setSeparator6("_");
                template.setNUI(String.valueOf(valor_nui));
                template.setSeparator7("_");
                template.setNIC(String.valueOf(valor_nui));
                template.setSeparator8("_");
                template.setMedidor(FAKER.number().digits(8));
                template.setSeparator9("_");
                template.setDireccionEnvioFactura(direction_factura);
                template.setSeparator10("_");
                template.setCiudadEnvioFactura(String.valueOf(ciudad));
                template.setSeparator11("_");
                template.setDireccionSuministroServicio(direction_factura);
                template.setSeparator12("_");
                template.setBarrioSuministro(FAKER.options().option(BARRIOS));
                template.setSeparator13("_");
                template.setCorregimientoSuministro(FAKER.options().option(CORREGIMIENTOS));
                template.setSeparator14("_");
                template.setMunicipioSuministro(FAKER.options().option("1"));
                template.setSeparator15("_");
                template.setMercado(FAKER.options().option("R", "NR"));
                template.setSeparator16("_");
                template.setSector(FAKER.options().option("Urbano", "Rural"));
                template.setSeparator17("_");
                template.setDestinoEconomicoPredio(FAKER.options().option(DESTINOS));
                template.setSeparator18("_");
                template.setEstratoSocial(String.valueOf(FAKER.number().numberBetween(1, 6)));
                template.setNumeroFactura((FAKER.number().digits(7)));
                template.setSeparator20("_");
                template.setFechaIniPeriodoFacturado(fechaIniPeriodoFormatted);
                template.setSeparator21("_");
                template.setFechaFinPeriodoFacturado(fechafinperiodoFormatted);
                template.setSeparator22("_");
                template.setAnioVigencia(String.valueOf(fechaIniPeriodo.getYear()));
                template.setSeparator23("_");
                template.setPeriodoMes(String.valueOf(fechaIniPeriodo.getMonthValue()));
                template.setSeparator24("_");
                template.setCicloFacturacion(String.valueOf(fechaIniPeriodo.getDayOfMonth()));
                template.setSeparator25("_");
                template.setFechaVencimientoFactura(fechafinperiodo.plusDays(1).format(formatter));
                template.setSeparator26("_");
                template.setConsumokwh(String.valueOf(FAKER.number().randomDouble(2, 0, 1000)));
                template.setSeparator27("_");
                template.setConsumoSubsidiokwh(String.valueOf(FAKER.number().randomDouble(2, 0, 0)));
                template.setSeparator28("_");
                template.setConsumoEnergiaSinSubsidio(String.valueOf(FAKER.number().randomDouble(2, 0, 9999999)));
                template.setSeparator29("_");
                template.setConsumoEnergiaConSubsidio(String.valueOf(FAKER.number().randomDouble(2, 0, 9999999)));
                template.setSeparator30("_");
                template.setValorTarifaEnergiaAplicada(String.valueOf(FAKER.number().randomDouble(2, 0, 999)));
                template.setSeparator31("_");
                template.setTarifaSubKwh(String.valueOf(FAKER.number().randomDouble(2, 0, 0)));
                template.setSeparator32("_");
                template.setFichaCatrastal(FAKER.options().option(" "));
                template.setSeparator33("_");
                template.setCorreoElectronico(FAKER.internet().emailAddress());
                template.setSeparator34("_");
                template.setOperador(FAKER.options().option("EPSA"));
                template.setSeparator35("_");
                // template.setExcluido(FAKER.number().numberBetween(0, 1));
                // template.setFirma(FAKER.options().option("SI", "NO"));

            } else if (MAINCONTROLLER.comboBox1.getValue().equals("FT-11")) {
                tipo.add(FAKER.options().option("CC", "CE", "P"));
                template.setTipoDocumento("CC");
                template.setSeparator0("_");
                template.setDigitoVerificacion("");
                template.setSeparator1("_");
                numero.add( String.valueOf(FAKER.number().numberBetween(100000000L, 9999999999L)));
                template.setNumeroIdentificacion(numero.get(i));
                template.setSeparator2("_");
                template.setRazonSocialPrimerNombre(FAKER.name().firstName().trim());
                template.setSeparator3("_");
                template.setSegundoNombre(FAKER.name().firstName().trim());
                template.setSeparator4("_");
                template.setPrimerApellido(FAKER.name().lastName().trim());
                template.setSeparator5("_");
                template.setSegundoApellido(FAKER.name().lastName().trim());
                template.setSeparator6("_");
                template.setNUI(String.valueOf(valor_nui));
                template.setSeparator7("_");
                template.setNIC(String.valueOf(valor_nui));
                template.setSeparator8("_");
                template.setMedidor(FAKER.number().digits(8));
                template.setSeparator9("_");
                template.setDireccionEnvioFactura(direction_factura);
                template.setSeparator10("_");
                template.setCiudadEnvioFactura(String.valueOf(ciudad));
                template.setSeparator11("_");
                template.setDireccionSuministroServicio(direction_factura);
                template.setSeparator12("_");
                template.setBarrioSuministro(FAKER.options().option(BARRIOS));
                template.setSeparator13("_");
                template.setCorregimientoSuministro(FAKER.options().option(CORREGIMIENTOS));
                template.setSeparator14("_");
                template.setMunicipioSuministro(FAKER.options().option("1"));
                template.setSeparator15("_");
                template.setMercado(FAKER.options().option("R", "NR"));
                template.setSeparator16("_");
                template.setSector(FAKER.options().option("Urbano", "Rural"));
                template.setSeparator17("_");
                template.setDestinoEconomicoPredio(FAKER.options().option(DESTINOS));
                template.setSeparator18("_");
                template.setEstratoSocial(String.valueOf(FAKER.number().numberBetween(1, 6)));
                template.setSeparator19("_");
                template.setFichaCatrastal(FAKER.options().option(" "));
                template.setSeparator33("_");
                template.setCorreoElectronico(FAKER.internet().emailAddress());
                template.setSeparator34("");

            } else if (MAINCONTROLLER.comboBox1.getValue().equals("FT-12")) {
                template.setTipoDocumento(tipo.get(i));
                template.setSeparator0("_");
                template.setNumeroIdentificacion(numero.get(i));
                template.setSeparator1("");
                template.setDigitoVerificacion("");
                template.setSeparator2("");
                template.setSeparator14("_");
                template.setMunicipioSuministro(FAKER.options().option("1"));
                template.setSeparator15("_");
                template.setNUI(String.valueOf(valor_nui));
                template.setSeparator7("_");
                template.setNIC(String.valueOf(valor_nui));
                template.setSeparator8("_");
                template.setMedidor(FAKER.number().digits(8));
                template.setSeparator9("_");
                template.setNumeroFactura((FAKER.number().digits(7)));
                template.setSeparator20("_");
                template.setFechaIniPeriodoFacturado(fechaIniPeriodoFormatted);
                template.setSeparator21("_");
                template.setFechaFinPeriodoFacturado(fechafinperiodoFormatted);
                template.setSeparator22("_");
                template.setAnioVigencia(String.valueOf(fechaIniPeriodo.getYear()));
                template.setSeparator23("_");
                template.setPeriodoMes(String.valueOf(fechaIniPeriodo.getMonthValue()));
                template.setSeparator24("_");
                template.setCicloFacturacion(String.valueOf(fechaIniPeriodo.getDayOfMonth()));
                template.setSeparator25("_");
                template.setFechaVencimientoFactura(fechafinperiodo.plusDays(1).format(formatter));
                template.setSeparator26("_");
                template.setConsumokwh(String.valueOf(FAKER.number().randomDouble(2, 0, 1000)));
                template.setSeparator27("_");
                template.setConsumoSubsidiokwh(String.valueOf(FAKER.number().randomDouble(2, 0, 0)));
                template.setSeparator28("_");
                template.setConsumoEnergiaSinSubsidio(String.valueOf(FAKER.number().randomDouble(2, 0, 9999999)));                                                                                  // separator
                template.setSeparator29("_");
                template.setConsumoEnergiaConSubsidio(String.valueOf(FAKER.number().randomDouble(2, 0, 9999999)));
                template.setSeparator30("_");
                template.setValorTarifaEnergiaAplicada(String.valueOf(FAKER.number().randomDouble(2, 0, 999)));
                template.setSeparator31("_");
                template.setTarifaSubKwh(String.valueOf(FAKER.number().randomDouble(2, 0, 0)));
                template.setSeparator32("_");
                template.setOperador(FAKER.options().option("EPSA"));
                template.setSeparator34("");
            }
            templates.add(template);
        }
        return templates;
    }

    /**
     * @param valorNumeroRegistros cantidad de registros a generar
     * @return retorna la lista de los datos generados
     */
    public ArrayList<Template> generateAndValidatorData(int valorNumeroRegistros) {
        ArrayList<Template> templates = generateDataFaker(valorNumeroRegistros);
        for (Template template : templates) {
            ApplyChexboxLogic.applyCheckboxLogic(template , MAINCONTROLLER);
            LogicCheckboxRoles.logicCheckboxRules(template , MAINCONTROLLER);
        }
        return templates;
    }
}
