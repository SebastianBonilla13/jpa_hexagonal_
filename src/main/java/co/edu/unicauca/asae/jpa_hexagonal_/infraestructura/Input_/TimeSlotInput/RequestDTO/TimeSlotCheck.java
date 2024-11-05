package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TimeSlotInput.RequestDTO;

import java.time.LocalTime;

public record TimeSlotCheck(String day, LocalTime startTime, LocalTime endTime, Integer locationId) {
}
