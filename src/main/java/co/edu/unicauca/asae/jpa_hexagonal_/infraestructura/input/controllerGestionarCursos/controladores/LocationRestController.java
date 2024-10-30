package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.GestionarLocationCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTOPeticion.LocationDTOPeticion;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTORespuesta.LocationDTORespuesta;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.mappers.LocationMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LocationRestController {
    private final GestionarLocationCUIntPort objGestionarLocateCUInt;
    private final LocationMapperInfraestructuraDominio objMapeador;

    @PostMapping("/locations")
    public ResponseEntity<LocationDTORespuesta> create(@RequestBody @Valid LocationDTOPeticion objLocation) {
        Location objLocationCrear = objMapeador.mappearDePeticionALocation(objLocation); // Peticion to objLocation
        Location objLocationCreado = objGestionarLocateCUInt.crear(objLocationCrear); // crear objLocation en Dominio
        ResponseEntity<LocationDTORespuesta> objRespuesta = new ResponseEntity<LocationDTORespuesta>(
                objMapeador.mappearDeLocationARespuesta(objLocationCreado), HttpStatus.CREATED); // Responder(objLocation_creado,HttpStatus)
        return objRespuesta;
    }

    @GetMapping("/locations")
    public ResponseEntity<List<LocationDTORespuesta>> listar() {
        ResponseEntity<List<LocationDTORespuesta>> objRespuesta = new ResponseEntity<List<LocationDTORespuesta>>(
                objMapeador.mappearDeLocationsARespuesta(this.objGestionarLocateCUInt.listar()), HttpStatus.CREATED);
        return objRespuesta;
    }

}
