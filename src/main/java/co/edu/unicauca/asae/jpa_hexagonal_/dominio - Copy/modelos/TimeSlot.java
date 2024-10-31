package co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos;

import java.time.LocalTime;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TimeSlot {
    private Integer id;
    private String day;
    private LocalTime startTime;
    private LocalTime endTime;
    private Course course;
    private Location location;

    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", day='" + day + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                //", course=" + (course != null ? course.getName() : "null") +
                //", location=" + (location != null ? location.getName() : "null") +
                '}';
    }
}
