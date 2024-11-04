package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TeacherInput.ResponseDTO;

import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.ResponseDTO.CourseResponseDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.OfficeInput.ResponseDTO.OfficeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherReponseDTO {
    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private OfficeResponseDTO office;
    private List<CourseResponseDTO> courses;
}
