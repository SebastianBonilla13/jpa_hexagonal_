package co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.GestionarLocationGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.ResultFormatterIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.GestionarLocationCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import java.util.List;

public class GestionarLocationCUAdapter implements GestionarLocationCUIntPort { // Acciones a la APP

    private final GestionarLocationGatewayIntPort objGestionarLocationGateway;
    private final ResultFormatterIntPort objLocationFormateadorResultados;

    public GestionarLocationCUAdapter(GestionarLocationGatewayIntPort objGestionarLocationGateway,
            ResultFormatterIntPort objLocationFormateadorResultados) {
        this.objGestionarLocationGateway = objGestionarLocationGateway;
        this.objLocationFormateadorResultados = objLocationFormateadorResultados;
    }

    @Override
    public Location crear(Location objLocation) { // guarda en repositorio
        Location objLocationCreado = null;

        if (this.objGestionarLocationGateway.existeLocationPorCodigo(objLocation.getId().toString())) {
            this.objLocationFormateadorResultados.returnResponseErrorEntityExists(
                    "Error, ya se encuentra en el sistema una Espacio Fisico con el código");
        } else {
            objLocationCreado = this.objGestionarLocationGateway.guardar(objLocation);
        }
        objLocationCreado = this.objGestionarLocationGateway.guardar(objLocation);

        return objLocationCreado;
    }

    @Override
    public List<Location> listar() {
        List<Location> listaLocations = objGestionarLocationGateway.listar();
        return listaLocations;
    }

}
