package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.ResponseDTO;

import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.SubjectInput.ResponseDTO.SubjectResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDTO {
    private Integer id;
    private String name;
    private SubjectResponseDTO subject;
}
