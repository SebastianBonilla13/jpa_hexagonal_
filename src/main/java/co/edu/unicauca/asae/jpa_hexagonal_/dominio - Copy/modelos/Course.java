package co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {
    private Integer id;
    private String name;
    private Subject subject;
    private List<TimeSlot> timeSlots;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", subject=" + (subject != null ? subject.getName() : "null") +
                '}';
    }

}
