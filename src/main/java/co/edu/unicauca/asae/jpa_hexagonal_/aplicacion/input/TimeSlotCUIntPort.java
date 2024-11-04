package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;

import java.util.List;

public interface TimeSlotCUIntPort {
    public TimeSlot createTimeSlot(TimeSlot newTimeSlot);
    public List<TimeSlot> listTimeSlots();
    public TimeSlot getTimeSlotById(Integer timeSlotId);
}
