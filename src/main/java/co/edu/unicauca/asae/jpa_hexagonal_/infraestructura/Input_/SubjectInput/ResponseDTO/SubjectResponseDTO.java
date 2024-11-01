package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.SubjectInput.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponseDTO {
    private Integer id;
    private String name;
    private String code;
}
