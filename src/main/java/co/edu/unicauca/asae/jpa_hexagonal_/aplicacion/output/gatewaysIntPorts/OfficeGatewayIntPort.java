package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts;

import java.util.List;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Office;

public interface OfficeGatewayIntPort {
    public boolean officeExists(Integer officeId);

    public Office saveOffice(Office newOffice);

    public List<Office> listAllOffices();
}
