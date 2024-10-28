package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTORespuesta;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

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
