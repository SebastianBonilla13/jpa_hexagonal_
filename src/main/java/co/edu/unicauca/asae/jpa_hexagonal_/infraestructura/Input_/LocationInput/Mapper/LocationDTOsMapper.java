package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.LocationInput.Mapper;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.LocationInput.ResponseDTO.LocationResponseDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTOPeticion.LocationDTOPeticion;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTORespuesta.LocationDTORespuesta;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Mapper(componentModel = "spring")
public interface LocationDTOsMapper {
    Location mappearDePeticionALocation(LocationDTOPeticion peticion);

    LocationResponseDTO mappearDeLocationARespuesta(Location objLocation);

    List<LocationResponseDTO> mappearDeLocationsARespuesta(List<Location> locations);
}
