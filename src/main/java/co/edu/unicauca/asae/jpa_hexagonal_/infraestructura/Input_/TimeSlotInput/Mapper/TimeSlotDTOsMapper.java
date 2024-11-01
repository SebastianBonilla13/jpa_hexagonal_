package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TimeSlotInput.Mapper;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TimeSlotInput.RequestDTO.TimeSlotRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TimeSlotInput.ResponseDTO.TimeSlotResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;
import java.util.List;

@Configuration
@Mapper(componentModel = "spring")
public interface TimeSlotDTOsMapper {
    TimeSlot timeSlotRequestToTimeSlotModel(TimeSlotRequestDTO timeSlotRequestDTO);
    TimeSlotResponseDTO map(TimeSlot value);

    List<TimeSlotResponseDTO> timeSlostToTimeSlotsResponse(List<TimeSlot> timeSlots);
}
