package co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.OfficeCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.OfficeGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Office;

public class OfficeCUAdapter implements OfficeCUIntPort {

    private final OfficeGatewayIntPort officeGateway;

    public OfficeCUAdapter(OfficeGatewayIntPort officeGateway) {
        this.officeGateway = officeGateway;
    }

    @Override
    public Office createOffice(Office newOffice) {

        Office objCreateOffice = null;
        objCreateOffice = this.officeGateway.saveOffice(newOffice);

        return objCreateOffice;
    }

    @Override
    public List<Office> getAllOffices() {
        List<Office> offices = this.officeGateway.listAllOffices();
        return offices;
    }

}
