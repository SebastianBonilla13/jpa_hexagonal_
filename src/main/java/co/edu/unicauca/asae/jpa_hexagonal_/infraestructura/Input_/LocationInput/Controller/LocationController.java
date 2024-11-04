package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.LocationInput.Controller;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.LocationCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.LocationInput.Mapper.LocationDTOsMapper;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.LocationInput.RequestDTO.LocationRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.LocationInput.ResponseDTO.LocationResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationCUIntPort objGestionarLocateCUInt;
    private final LocationDTOsMapper objMapeador;

    @PostMapping("")
    public ResponseEntity<LocationResponseDTO> create(@RequestBody @Valid LocationRequestDTO objLocation) {
        Location objLocationCrear = objMapeador.mappearDePeticionALocation(objLocation); // Peticion to objLocation
        Location objLocationCreado = objGestionarLocateCUInt.crear(objLocationCrear); // crear objLocation en Dominio
        ResponseEntity<LocationResponseDTO> objRespuesta = new ResponseEntity<LocationResponseDTO>(
                objMapeador.mappearDeLocationARespuesta(objLocationCreado), HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("")
    public ResponseEntity<List<LocationResponseDTO>> listar() {
        ResponseEntity<List<LocationResponseDTO>> objRespuesta = new ResponseEntity<List<LocationResponseDTO>>(
                objMapeador.mappearDeLocationsARespuesta(this.objGestionarLocateCUInt.listar()),
                HttpStatus.CREATED);
        return objRespuesta;
    }

}
