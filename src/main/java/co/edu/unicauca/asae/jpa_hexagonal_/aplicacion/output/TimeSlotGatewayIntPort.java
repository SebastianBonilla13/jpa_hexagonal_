package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;

import java.util.List;

public interface TimeSlotGatewayIntPort {
    public TimeSlot saveTimeSlotGateway(TimeSlot newTimeSlot);
    public List<TimeSlot> findAllTimeSlots();
}
