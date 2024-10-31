package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTORespuesta;

import java.util.List;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LocationDTORespuesta {

    private Integer id;
    private String name;
    private Integer capacity;
    private List<TimeSlot> timeSlots;

    public LocationDTORespuesta() {
    }

}
