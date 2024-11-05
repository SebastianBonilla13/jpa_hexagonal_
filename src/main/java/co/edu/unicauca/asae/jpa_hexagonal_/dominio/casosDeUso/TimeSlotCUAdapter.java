package co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.TimeSlotCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.ResultFormatterIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.TimeSlotGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;

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
    public TimeSlot createTimeSlot(TimeSlot newTimeSlot) {
        // *
        // VALIDAR SI LA FRANJA HORARIA NO SE SOLAPA CON OTRA
        // USAR FUNCIONES DEL GATEWAY
        // *//
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
    public TimeSlot createTimeSlot2(TimeSlot newTimeSlot, Integer idTeacher) {
        TimeSlot objCreateTimeSlot = null;

        if (!this.timeSlotGateway.checkTeacherAvailability(newTimeSlot.getDay(), newTimeSlot.getStartTime().toString(),
                newTimeSlot.getEndTime().toString(), idTeacher)) {
            this.timeSlotFormatter
                    .returnResponseErrorBusinessRule("Error, el docente se encuentra ocupado en dicha franja horaria");
        } else {
            objCreateTimeSlot = this.timeSlotGateway.saveTimeSlotGateway(newTimeSlot);
        }

        return objCreateTimeSlot;
    }

    @Override
    public boolean isTimeSlotAvailable(String day, LocalTime startTime, LocalTime endTime, Integer locationId) {
        return this.timeSlotGateway.isTimeSlotAvailableGateway(day, startTime, endTime, locationId);
    }

}
