package co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.TimeSlotCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.TimeSlotGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;

import java.util.List;

public class TimeSlotCUAdapter implements TimeSlotCUIntPort {
    private final TimeSlotGatewayIntPort timeSlotGateway;

    public TimeSlotCUAdapter(TimeSlotGatewayIntPort timeSlotGateway){
        this.timeSlotGateway = timeSlotGateway;
    }

    @Override
    public TimeSlot createTimeSlot(TimeSlot newTimeSlot) {
        //*
        // VALIDAR SI LA FRANJA HORARIA NO SE SOLAPA CON OTRA
        // USAR FUNCIONES DEL GATEWAY
        // *//
        return this.timeSlotGateway.saveTimeSlotGateway(newTimeSlot);
    }

    @Override
    public List<TimeSlot> listTimeSlots() {
        return this.timeSlotGateway.findAllTimeSlots() ;
    }

    @Override
    public TimeSlot getTimeSlotById(Integer timeSlotId) {
        TimeSlot timeSlot = this.timeSlotGateway.findTimeSlotByIdGateway(timeSlotId);
        if(timeSlot == null) throw new EntidadNoExisteException(CodigoError.ENTIDAD_NO_ENCONTRADA);
        return timeSlot;
    }
}
