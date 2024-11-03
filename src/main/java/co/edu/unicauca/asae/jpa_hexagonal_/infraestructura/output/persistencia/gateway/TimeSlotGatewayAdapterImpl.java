package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.TimeSlotGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.SubjectEntity;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios.TimeSlotRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class TimeSlotGatewayAdapterImpl implements TimeSlotGatewayIntPort {
    private final TimeSlotRepository timeSlotRepository;
    private final ModelMapper mapper;

    public TimeSlotGatewayAdapterImpl(TimeSlotRepository timeSlotRepository, ModelMapper mapper) {
        this.mapper = mapper;
        this.timeSlotRepository = timeSlotRepository;
    }

    @Override
    public TimeSlot saveTimeSlot(TimeSlot newTimeSlot) {
        return null;
    }

    @Override
    public boolean checkTeacherAvailability(String dia, String horaInicio, String horaFin, Integer idDocente) {
        Optional<TimeSlot> optionalSubject = timeSlotRepository.checkTeacherAvailability(dia, horaInicio, horaFin,
                idDocente);
        return optionalSubject.isEmpty();
    }

    @Override
    public List<TimeSlot> findAllTimeSlots() {
        return null;
    }
}
