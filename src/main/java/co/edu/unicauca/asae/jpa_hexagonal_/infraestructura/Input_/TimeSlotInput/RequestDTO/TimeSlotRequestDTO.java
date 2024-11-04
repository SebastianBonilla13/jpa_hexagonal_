package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TimeSlotInput.RequestDTO;


import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.RequestDTO.CourseRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.LocationInput.RequestDTO.LocationRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlotRequestDTO {
    private String day;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer courseId;
    private Integer locationId;
}
