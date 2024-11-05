package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts;

import java.util.List;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;

public interface LocationGatewayIntPort { // Acciones de la APP al Repositorio (impl. Infraestructura)
    public boolean existeLocationPorCodigo(String codigo);

    public Location guardar(Location objLocation);

    public List<Location> listar(String pattern, Integer capacity);

    public Location finLocationByIdGateway(Integer locationId);
}
