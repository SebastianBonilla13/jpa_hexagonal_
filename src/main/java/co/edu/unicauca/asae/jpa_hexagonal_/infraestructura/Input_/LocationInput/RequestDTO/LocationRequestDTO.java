package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.LocationInput.RequestDTO;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class LocationRequestDTO {
    private Integer id;

    @NotBlank(message = "{generic.not_empty}")
    @NotNull(message = "{generic.not_null}")
    @Size(min = 5, max = 45, message = "{location.name.length}")
    private String name;

    @NotNull(message = "{generic.not_null}")
    @PositiveOrZero(message = "{location.capacity.positive}")
    @Max(value = 30, message = "{location.capacity.max}")
    private Integer capacity;

    /* @Valid */
    private List<TimeSlot> timeSlots;
}
