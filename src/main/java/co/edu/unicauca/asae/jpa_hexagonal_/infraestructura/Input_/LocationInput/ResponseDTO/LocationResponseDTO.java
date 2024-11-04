package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.LocationInput.ResponseDTO;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class LocationResponseDTO {
    private Integer id;
    private String name;
    private Integer capacity;
}
