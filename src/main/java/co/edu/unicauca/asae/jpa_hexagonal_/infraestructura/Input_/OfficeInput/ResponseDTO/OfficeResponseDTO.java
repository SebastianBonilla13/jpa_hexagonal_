package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.OfficeInput.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OfficeResponseDTO {

    private String name;
    private String location;

    public OfficeResponseDTO() {
    }

}
