package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.RequestDTO;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Subject;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDTO {

    @NotBlank(message = "{generic.not_empty}")
    @NotNull(message = "{generic.not_null}")
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank(message = "{generic.not_empty}")
    @NotNull(message = "{generic.not_null}")
    private Subject subject;

    private List<TimeSlot> timeSlots;
}
