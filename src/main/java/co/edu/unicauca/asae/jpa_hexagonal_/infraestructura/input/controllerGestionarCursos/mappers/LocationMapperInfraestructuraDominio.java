package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTOPeticion.LocationDTOPeticion;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTORespuesta.LocationDTORespuesta;

@Mapper(componentModel = "spring")
public interface LocationMapperInfraestructuraDominio {

    Location mappearDePeticionALocation(LocationDTOPeticion peticion);

    LocationDTORespuesta mappearDeLocationARespuesta(Location objLocation);

    List<LocationDTORespuesta> mappearDeLocationsARespuesta(List<Location> locations);
}
