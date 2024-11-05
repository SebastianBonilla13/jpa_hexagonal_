package co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.TimeSlotCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.ResultFormatterIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.TimeSlotGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;

import java.time.LocalTime;
import java.util.List;

public class TimeSlotCUAdapter implements TimeSlotCUIntPort {

    private final TimeSlotGatewayIntPort timeSlotGateway;
    private final ResultFormatterIntPort timeSlotFormatter;

    public TimeSlotCUAdapter(TimeSlotGatewayIntPort timeSlotGateway, ResultFormatterIntPort timeSlotFormatter) {
        this.timeSlotGateway = timeSlotGateway;
        this.timeSlotFormatter = timeSlotFormatter;
    }

    @Override
    public TimeSlot createTimeSlot(TimeSlot newTimeSlot, Integer idTeacher) {
        boolean isTeacherAvailable = this.timeSlotGateway.checkTeacherAvailability(newTimeSlot.getDay(),
                newTimeSlot.getStartTime(), newTimeSlot.getEndTime(), idTeacher);
        if (!isTeacherAvailable)
            throw new ReglaNegocioExcepcion("El docente se encuentra ocupado en este espacio");

        boolean isTiemSlotavailable = this.timeSlotGateway.isTimeSlotAvailableGateway(newTimeSlot.getDay(),
                newTimeSlot.getStartTime(), newTimeSlot.getEndTime(), newTimeSlot.getLocation().getId());
        if (!isTiemSlotavailable)
            throw new ReglaNegocioExcepcion("La franja horaria que desea crear ya esta ocupada");

        return this.timeSlotGateway.saveTimeSlotGateway(newTimeSlot);
    }

    @Override
    public List<TimeSlot> listTimeSlots() {
        return this.timeSlotGateway.findAllTimeSlots();
    }

    @Override
    public TimeSlot getTimeSlotById(Integer timeSlotId) {
        TimeSlot timeSlot = this.timeSlotGateway.findTimeSlotByIdGateway(timeSlotId);
        if (timeSlot == null)
            throw new EntidadNoExisteException(CodigoError.ENTIDAD_NO_ENCONTRADA);
        return timeSlot;
    }

    @Override
    public boolean isTimeSlotAvailable(String day, LocalTime startTime, LocalTime endTime, Integer locationId) {
        return this.timeSlotGateway.isTimeSlotAvailableGateway(day, startTime, endTime, locationId);
    }

    @Override
    public boolean isTeacherAvailable(TimeSlot timeSlot, Integer teacherId) {
        boolean isTeacherAvailable = this.timeSlotGateway.checkTeacherAvailability(timeSlot.getDay(),
                timeSlot.getStartTime(), timeSlot.getEndTime(), teacherId);
        return isTeacherAvailable;
    }

}
