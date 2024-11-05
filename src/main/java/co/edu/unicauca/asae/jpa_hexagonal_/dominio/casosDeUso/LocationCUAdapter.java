package co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.ResultFormatterIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.LocationGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.LocationCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;

import java.util.List;

public class LocationCUAdapter implements LocationCUIntPort { // Acciones a la APP
    private final LocationGatewayIntPort objGestionarLocationGateway;
    private final ResultFormatterIntPort objLocationFormateadorResultados;

    public LocationCUAdapter(LocationGatewayIntPort objGestionarLocationGateway,
            ResultFormatterIntPort objLocationFormateadorResultados) {
        this.objGestionarLocationGateway = objGestionarLocationGateway;
        this.objLocationFormateadorResultados = objLocationFormateadorResultados;
    }

    @Override
    public Location crear(Location objLocation) { // guarda en repositorio
        Location objLocationCreado = null;

        /*
         * if
         * (this.objGestionarLocationGateway.existeLocationPorCodigo(objLocation.getId()
         * .toString())) {
         * this.objLocationFormateadorResultados.returnResponseErrorEntityExists(
         * "Error, ya se encuentra en el sistema una Espacio Fisico con el código");
         * } else {
         * objLocationCreado = this.objGestionarLocationGateway.guardar(objLocation);
         * }
         */
        objLocationCreado = this.objGestionarLocationGateway.guardar(objLocation);

        return objLocationCreado;
    }

    @Override
    public List<Location> listar(String pattern, Integer capacity) {
        List<Location> listaLocations = objGestionarLocationGateway.listar(pattern, capacity);
        return listaLocations;
    }

    @Override
    public Location getLocationById(Integer locationId) {
        Location location = this.objGestionarLocationGateway.finLocationByIdGateway(locationId);
        if (location == null)
            throw new EntidadNoExisteException(CodigoError.ENTIDAD_NO_ENCONTRADA);
        return location;
    }

}
