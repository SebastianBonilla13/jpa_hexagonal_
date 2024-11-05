package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.List;

public interface TimeSlotCUIntPort {
    public TimeSlot createTimeSlot(TimeSlot newTimeSlot, Integer idTeacher);

    public List<TimeSlot> listTimeSlots();

    public TimeSlot getTimeSlotById(Integer timeSlotId);

    public boolean isTimeSlotAvailable(String day, LocalTime startTime, LocalTime endTime, Integer locationId);
}
