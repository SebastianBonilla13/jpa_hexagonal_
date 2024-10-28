package co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos;

import java.util.List;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Location {
    private Integer id;
    private String name;
    private Integer capacity;
    private List<TimeSlot> timeSlots;

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", timeSlotsCount=" + (timeSlots != null ? timeSlots.size() : 0) +
                '}';
    }

}
