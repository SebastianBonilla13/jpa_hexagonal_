package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTORespuesta;

import java.util.List;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;;

@Getter
@Setter
@AllArgsConstructor
public class SubjectResponseDTO {

    private String name;
    private String codigo;
    private List<Teacher> teachers;

    public SubjectResponseDTO() {
    }

}
