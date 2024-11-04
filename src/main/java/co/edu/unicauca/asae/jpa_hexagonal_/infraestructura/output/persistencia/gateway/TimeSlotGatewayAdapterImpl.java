package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.TimeSlotGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.TimeSlotEntity;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios.TimeSlotRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
    public TimeSlot saveTimeSlotGateway(TimeSlot newTimeSlot) {
        TimeSlotEntity timeSlot = this.mapper.map(newTimeSlot, TimeSlotEntity.class);
        TimeSlotEntity savedEntity = this.timeSlotRepository.save(timeSlot);
        return this.mapper.map(savedEntity, TimeSlot.class);
    }

    @Override
    public boolean checkTeacherAvailability(String dia, String horaInicio, String horaFin, Integer idDocente) {
        Optional<TimeSlot> optionalSubject = timeSlotRepository.checkTeacherAvailability(dia, horaInicio, horaFin,
                idDocente);
        return optionalSubject.isEmpty();
    }

    @Override
    public List<TimeSlot> findAllTimeSlots() {
        List<TimeSlotEntity> timeSlotEntities = this.timeSlotRepository.findAll();
        return this.mapper.map(timeSlotEntities, new TypeToken<List<TimeSlot>>() {
        }.getType());
    }

    @Override
    public List<TimeSlot> findTimeSlotsByLocationAndDay(Location location, String day) {
        return null;
    }

    @Override
    public boolean isTimeSlotOverlaped(List<TimeSlot> timeSlotList, TimeSlot newTimeSlot) {
        return false;
    }

    @Override
    public TimeSlot findTimeSlotByIdGateway(Integer timeSlotId) {
        Optional<TimeSlotEntity> timeSlotEntity = this.timeSlotRepository.findById(timeSlotId);
        if (timeSlotEntity.isEmpty())
            return null;
        return this.mapper.map(timeSlotEntity, TimeSlot.class);
    }
}
