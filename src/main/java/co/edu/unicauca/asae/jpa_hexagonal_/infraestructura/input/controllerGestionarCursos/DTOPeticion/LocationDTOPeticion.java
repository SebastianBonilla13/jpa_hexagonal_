package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTOPeticion;

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
public class LocationDTOPeticion {
    @NotNull(message = "{location.id.empty}")
    @PositiveOrZero(message = "{location.id.positive}")
    private Integer id;

    @NotNull(message = "{location.name.empty}")
    @Size(min = 5, max = 45, message = "{location.name.length}")
    private String name;

    @NotNull(message = "{location.capacity.empty}")
    @Size(min = 1, max = 30, message = "{location.capacity.length}")
    @PositiveOrZero(message = "{location.capacity.positive}")
    private Integer capacity;

    @Valid
    @NotNull(message = "{location.timeSlots.empty}")
    // @Size(min = 1, message = "{location.timeSlots.length}")
    private List<TimeSlot> timeSlots;
}
