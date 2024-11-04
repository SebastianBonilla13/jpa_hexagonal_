package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.OfficeInput.Mapper;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Office;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.OfficeInput.RequestDTO.OfficeRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.OfficeInput.ResponseDTO.OfficeResponseDTO;

import java.util.List;

@Configuration
@Mapper(componentModel = "spring")
public interface OfficeDTOsMapper {
    Office requestOfficeToResponseOffice(OfficeRequestDTO requestDTO);

    OfficeResponseDTO officeDataResponseOffice(Office office);

    List<OfficeResponseDTO> officeModelsToOfficeRequestDTOList(List<Office> officeList);
}
