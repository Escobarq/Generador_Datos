package org.datasintetica.datasintec.services;

import org.datasintetica.datasintec.controllers.MainController;
import org.datasintetica.datasintec.models.Template;

/**
 * Clase que aplica la logica de los checkboxes seleccionados
 */
public class ApplyChexboxLogic {

    /**
     * Aplica la logica de checkboxes seleccionados desde el controlador
     * @param template Template
     */
    @SuppressWarnings("static-access")
    static void applyCheckboxLogic ( Template template , MainController MAINCONTROLLER) {

        if (!MAINCONTROLLER.getAllCheckBoxes().get(0).isSelected()) {
            template.setTipoDocumento("");
            template.setSeparator0("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(1).isSelected()) {
            template.setNumeroIdentificacion("");
            template.setSeparator2("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(2).isSelected()) {
            template.setDigitoVerificacion("");
            template.setSeparator1("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(3).isSelected()) {
            template.setRazonSocialPrimerNombre("");
            template.setSeparator3("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(4).isSelected()) {
            template.setSegundoNombre("");
            template.setSeparator4("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(5).isSelected()) {
            template.setPrimerApellido("");
            template.setSeparator5("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(6).isSelected()) {
            template.setSegundoApellido("");
            template.setSeparator6("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(7).isSelected()) {
            template.setNUI("");
            template.setSeparator7("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(8).isSelected()) {
            template.setNIC("");
            template.setSeparator8("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(9).isSelected()) {
            template.setMedidor("");
            template.setSeparator9("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(10).isSelected()) {
            template.setDireccionEnvioFactura("");
            template.setSeparator10("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(11).isSelected()) {
            template.setCiudadEnvioFactura("");
            template.setSeparator11("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(12).isSelected()) {
            template.setDireccionSuministroServicio("");
            template.setSeparator12("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(13).isSelected()) {
            template.setBarrioSuministro("");
            template.setSeparator13("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(14).isSelected()) {
            template.setCorregimientoSuministro("");
            template.setSeparator14("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(15).isSelected()) {
            template.setMunicipioSuministro("");
            template.setSeparator15("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(16).isSelected()) {
            template.setMercado("");
            template.setSeparator16("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(17).isSelected()) {
            template.setSector("");
            template.setSeparator17("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(18).isSelected()) {
            template.setDestinoEconomicoPredio("");
            template.setSeparator18("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(19).isSelected()) {
            template.setEstratoSocial("");
            template.setSeparator19("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(20).isSelected()) {
            template.setNumeroFactura("");
            template.setSeparator20("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(21).isSelected()) {
            template.setFechaIniPeriodoFacturado("");
            template.setSeparator21("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(22).isSelected()) {
            template.setFechaFinPeriodoFacturado("");
            template.setSeparator22("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(23).isSelected()) {
            template.setAnioVigencia("");
            template.setSeparator23("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(24).isSelected()) {
            template.setPeriodoMes("");
            template.setSeparator24("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(25).isSelected()) {
            template.setCicloFacturacion("");
            template.setSeparator25("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(26).isSelected()) {
            template.setFechaVencimientoFactura("");
            template.setSeparator26("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(27).isSelected()) {
            template.setConsumokwh("");
            template.setSeparator27("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(28).isSelected()) {
            template.setConsumoSubsidiokwh("");
            template.setSeparator28("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(29).isSelected()) {
            template.setConsumoEnergiaSinSubsidio("");
            template.setSeparator29("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(30).isSelected()) {
            template.setConsumoEnergiaConSubsidio("");
            template.setSeparator30("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(31).isSelected()) {
            template.setValorTarifaEnergiaAplicada("");
            template.setSeparator31("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(32).isSelected()) {
            template.setTarifaSubKwh("");
            template.setSeparator32("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(33).isSelected()) {
            template.setSeparator33("");
            template.setFichaCatrastal("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(34).isSelected()) {
            template.setSeparator34("");
            template.setCorreoElectronico("");
        }
        if (!MAINCONTROLLER.getAllCheckBoxes().get(35).isSelected()) {
            template.setOperador("");
            template.setSeparator35("");
        }
    }
}
