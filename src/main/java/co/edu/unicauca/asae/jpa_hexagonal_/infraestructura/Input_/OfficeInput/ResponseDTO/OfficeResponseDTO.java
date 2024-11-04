package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.OfficeInput.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfficeResponseDTO {
    private Integer id;
    private String name;
    private String location;

}
