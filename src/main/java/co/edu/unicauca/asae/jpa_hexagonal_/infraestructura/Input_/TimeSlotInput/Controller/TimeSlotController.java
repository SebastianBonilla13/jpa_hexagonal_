package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TimeSlotInput.Controller;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.TimeSlotCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TimeSlotInput.Mapper.TimeSlotDTOsMapper;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TimeSlotInput.RequestDTO.TimeSlotRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TimeSlotInput.ResponseDTO.TimeSlotResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timeSlot")
public class TimeSlotController {
    private final TimeSlotCUIntPort timeSlotService;
    private final TimeSlotDTOsMapper dtOsMapper;

    public TimeSlotController(TimeSlotCUIntPort timeSlotService, TimeSlotDTOsMapper dtOsMapper) {
        this.dtOsMapper = dtOsMapper;
        this.timeSlotService = timeSlotService;
    }

    @PostMapping("")
    public ResponseEntity<TimeSlotResponseDTO> postTimeSlot(@RequestBody TimeSlotRequestDTO timeSlotRequestDTO) {
        TimeSlot timeSlot = this.dtOsMapper.timeSlotRequestToTimeSlotModel(timeSlotRequestDTO);
        TimeSlot savedSlot = this.timeSlotService.createTimeSlot(timeSlot);
        TimeSlotResponseDTO timeSlotResponseDTO = this.dtOsMapper.map(savedSlot);
        return new ResponseEntity<>(timeSlotResponseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/{idTeacher}")
    public ResponseEntity<TimeSlotResponseDTO> postTimeSlot2(@RequestBody TimeSlotRequestDTO timeSlotRequestDTO,
            @PathVariable Integer idTeacher) {
        TimeSlot timeSlot = this.dtOsMapper.timeSlotRequestToTimeSlotModel(timeSlotRequestDTO);

        TimeSlot savedSlot = this.timeSlotService.createTimeSlot2(timeSlot, idTeacher);

        TimeSlotResponseDTO timeSlotResponseDTO = this.dtOsMapper.map(savedSlot);
        return new ResponseEntity<>(timeSlotResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<TimeSlotResponseDTO>> getAllTimeSlots() {
        List<TimeSlot> timeSlots = this.timeSlotService.listTimeSlots();
        List<TimeSlotResponseDTO> timeSlotResponseDTOS = this.dtOsMapper.timeSlostToTimeSlotsResponse(timeSlots);
        return new ResponseEntity<>(timeSlotResponseDTOS, HttpStatus.OK);
    }
}
