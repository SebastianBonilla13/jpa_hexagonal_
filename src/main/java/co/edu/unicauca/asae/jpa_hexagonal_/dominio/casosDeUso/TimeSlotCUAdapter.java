package co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.TimeSlotCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.ResultFormatterIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.TimeSlotGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;

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
        TimeSlot objCreateTimeSlot = null;

        objCreateTimeSlot = this.timeSlotGateway.saveTimeSlot(newTimeSlot);

        return objCreateTimeSlot;
    }

    @Override
    public List<TimeSlot> listTimeSlots() {
        List<TimeSlot> timeSlots = this.timeSlotGateway.findAllTimeSlots();
        return timeSlots;
    }

    @Override
    public TimeSlot createTimeSlot2(TimeSlot newTimeSlot, Integer idTeacher) {
        TimeSlot objCreateTimeSlot = null;

        if (!this.timeSlotGateway.checkTeacherAvailability(newTimeSlot.getDay(), newTimeSlot.getStartTime().toString(),
                newTimeSlot.getEndTime().toString(), idTeacher)) {
            this.timeSlotFormatter
                    .returnResponseErrorBusinessRule("Error, el docente se encuentra ocupado en dicha franja horaria");
        } else {
            objCreateTimeSlot = this.timeSlotGateway.saveTimeSlot(newTimeSlot);
        }

        return objCreateTimeSlot;
    }

}
