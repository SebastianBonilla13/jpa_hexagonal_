package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.OfficeInput.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.OfficeCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Office;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.OfficeInput.Mapper.OfficeDTOsMapper;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.OfficeInput.RequestDTO.OfficeRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.OfficeInput.ResponseDTO.OfficeResponseDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/office")
@RequiredArgsConstructor
public class OfficeController {

    private final OfficeCUIntPort officeService;
    private final OfficeDTOsMapper officeMapper;

    @PostMapping("")
    public ResponseEntity<OfficeResponseDTO> postOffice(@RequestBody @Valid OfficeRequestDTO officeRequest) {
        Office office = this.officeMapper.requestOfficeToResponseOffice(officeRequest);
        Office savedOffice = this.officeService.createOffice(office);
        ResponseEntity<OfficeResponseDTO> officeResponse = new ResponseEntity<OfficeResponseDTO>(
                officeMapper.officeDataResponseOffice(savedOffice), HttpStatus.CREATED);
        return officeResponse;
    }

    @GetMapping("")
    public ResponseEntity<List<OfficeResponseDTO>> listOffice() {
        List<Office> officeList = this.officeService.getAllOffices();
        List<OfficeResponseDTO> officeResponseDTOS = this.officeMapper.officeModelsToOfficeRequestDTOList(officeList);
        return new ResponseEntity<>(officeResponseDTOS, HttpStatus.OK);
    }

}
