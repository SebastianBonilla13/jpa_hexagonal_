package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequestDTO {

    @NotBlank(message = "{generic.not_empty}")
    @NotNull(message = "{generic.not_null}")
    @Size(min = 2, max = 50, message = "{subject.name.length}")
    private String name;

    @NotBlank(message = "{generic.not_empty}")
    @NotNull(message = "{generic.not_null}")
    @Size(min = 3, max = 100)
    private String codigo;

}
