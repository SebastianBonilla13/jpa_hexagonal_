package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "franja_horaria")
public class TimeSlotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dia", length = 100, nullable = false)
    private String day;

    @Column(name = "hora_inicio")
    private LocalTime startTime;

    @Column(name = "hora_fin")
    private LocalTime endTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id", nullable = false)
    private CourseEntity course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "espacio_fisico_id", nullable = false)
    private LocationEntity location;

    @Override
    public String toString() {
        return "TimeSlotEntity{" +
                "id=" + id +
                ", day='" + day + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", course=" + (course != null ? course.getName() : "null") +
                ", location=" + (location != null ? location.getName() : "null") +
                '}';
    }
}
