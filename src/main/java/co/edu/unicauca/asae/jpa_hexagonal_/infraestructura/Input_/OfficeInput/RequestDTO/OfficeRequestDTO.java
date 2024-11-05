package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.OfficeInput.RequestDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfficeRequestDTO {

    @NotBlank(message = "{generic.not_empty}")
    @NotNull(message = "{generic.not_null}")
    @Size(min = 2, max = 50, message = "{office.name.length}")
    private String name;

    @Size(min = 2, max = 50, message = "{office.location.length}")
    private String location;

}
