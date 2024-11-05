package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import java.util.List;

public interface LocationCUIntPort { // Acciones a la APP (impl. Dominio)
    public Location crear(Location objLocation);

    public List<Location> listar(String pattern, Integer capacity);

    public Location getLocationById(Integer locationId);
}
