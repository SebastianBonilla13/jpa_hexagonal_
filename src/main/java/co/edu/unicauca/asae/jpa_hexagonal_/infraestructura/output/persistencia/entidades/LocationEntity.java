package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "espacio_fisico")
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String name;

    @Column(name = "capacidad")
    private Integer capacity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "location")
    private List<TimeSlotEntity> timeSlots;

    @Override
    public String toString() {
        return "LocationEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", timeSlotsCount=" + (timeSlots != null ? timeSlots.size() : 0) +
                '}';
    }
}
