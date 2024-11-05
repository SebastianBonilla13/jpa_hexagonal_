package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TimeSlotInput.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlotRequestDTO {

    @NotBlank(message = "{generic.not_empty}")
    @NotNull(message = "{generic.not_null}")
    @Pattern(regexp = "^(LUNES|MARTES|MIERCOLES|JUEVES|VIERNES|SABADO|DOMINGO)$", message = "{timeslot.day.format}")
    private String day;

    @NotNull(message = "{generic.not_null}")
    private LocalTime startTime;

    @NotNull(message = "{generic.not_null}")
    private LocalTime endTime;

    /* @NotNull(message = "{generic.not_null}") */
    private Integer courseId;

    /* @NotNull(message = "{generic.not_null}") */
    private Integer locationId;
}
