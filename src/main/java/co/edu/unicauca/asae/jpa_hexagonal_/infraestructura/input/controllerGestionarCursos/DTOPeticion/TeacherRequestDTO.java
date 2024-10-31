package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTOPeticion;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequestDTO {

    @Size(min = 5, max = 50)
    private String name;

    @Size(min = 5, max = 50)
    private String lastname;

    @Size(min = 5, max = 50)
    private String email;
}
