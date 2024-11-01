package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.TimeSlotGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios.TimeSlotRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public List<TimeSlot> findAllTimeSlots() {
        return null;
    }
}
