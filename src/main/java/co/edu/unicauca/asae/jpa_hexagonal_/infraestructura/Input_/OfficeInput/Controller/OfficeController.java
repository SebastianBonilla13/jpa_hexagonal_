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
@RequestMapping("/api")
@RequiredArgsConstructor
public class OfficeController {

    private final OfficeCUIntPort officeService;
    private final OfficeDTOsMapper officeMapper;

    @PostMapping("/office")
    public ResponseEntity<OfficeResponseDTO> postOffice(@RequestBody @Valid OfficeRequestDTO officeRequest) {
        Office office = this.officeMapper.requestOfficeToResponseOffice(officeRequest);
        Office savedOffice = this.officeService.createOffice(office);
        ResponseEntity<OfficeResponseDTO> officeResponse = new ResponseEntity<OfficeResponseDTO>(
                officeMapper.officeDataResponseOffice(savedOffice), HttpStatus.CREATED);
        return officeResponse;
    }

    @GetMapping("/office")
    public ResponseEntity<List<OfficeResponseDTO>> listOffice() {
        ResponseEntity<List<OfficeResponseDTO>> officeResponse = new ResponseEntity<List<OfficeResponseDTO>>(
                officeMapper.officeListResponsesOfficeList(this.officeService.getAllOffices()), HttpStatus.CREATED);
        return officeResponse;
    }

}
