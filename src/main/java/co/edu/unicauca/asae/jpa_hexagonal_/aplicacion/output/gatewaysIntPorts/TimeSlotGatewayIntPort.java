package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;

import java.time.LocalTime;
import java.util.List;

public interface TimeSlotGatewayIntPort {
    public TimeSlot saveTimeSlotGateway(TimeSlot newTimeSlot);

    public List<TimeSlot> findAllTimeSlots();

    public List<TimeSlot> findTimeSlotsByLocationAndDay(Location location, String day);

    public boolean isTimeSlotOverlaped(List<TimeSlot> timeSlotList, TimeSlot newTimeSlot);

    public TimeSlot findTimeSlotByIdGateway(Integer timeSlotId);

    public boolean checkTeacherAvailability(String dia, LocalTime horaInicio, LocalTime horaFin, Integer idDocente);

    public boolean isTimeSlotAvailableGateway(String day, LocalTime startTime, LocalTime endTime, Integer locationId);
}
