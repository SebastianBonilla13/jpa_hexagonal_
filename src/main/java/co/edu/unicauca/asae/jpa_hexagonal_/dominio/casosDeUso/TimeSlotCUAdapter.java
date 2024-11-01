package co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.TimeSlotCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.TimeSlotGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;

import java.util.List;

public class TimeSlotCUAdapter implements TimeSlotCUIntPort {
    private final TimeSlotGatewayIntPort timeSlotGateway;

    public TimeSlotCUAdapter(TimeSlotGatewayIntPort timeSlotGateway){
        this.timeSlotGateway = timeSlotGateway;
    }

    @Override
    public TimeSlot createTimeSlot(TimeSlot newTimeSlot) {
        return null;
    }

    @Override
    public List<TimeSlot> listTimeSlots() {
        return null;
    }
}
