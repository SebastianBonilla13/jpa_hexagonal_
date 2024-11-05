package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TimeSlotInput.ResponseDTO;

import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.ResponseDTO.CourseResponseDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.LocationInput.ResponseDTO.LocationResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlotResponseDTO {
    private Integer id;
    private String day;
    private LocalTime startTime;
    private LocalTime endTime;
    private CourseResponseDTO course;
    private LocationResponseDTO location;
}
