package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TeacherInput.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeacherReponseDTO {

    private String name;
    private String lastname;
    private String email;

    public TeacherReponseDTO() {
    }
}
