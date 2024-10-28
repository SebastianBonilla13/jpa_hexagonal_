package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import java.util.List;

public interface GestionarLocationCUIntPort { // Acciones a la APP (impl. Dominio)

    public Location crear(Location objLocation);

    public List<Location> listar();

}
