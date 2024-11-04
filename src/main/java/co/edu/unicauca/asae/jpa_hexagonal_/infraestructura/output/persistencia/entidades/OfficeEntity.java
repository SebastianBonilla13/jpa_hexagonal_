package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oficina")
public class OfficeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", length = 100, nullable = false)
    private String name;
    @Column(name = "ubicacion", length = 100, nullable = false)
    private String location;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "office", cascade = { CascadeType.PERSIST })
    private TeacherEntity teacher;

    @Override
    public String toString() {
        return "OfficeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", teacher=" + (teacher != null ? teacher.getName() : "None") +
                '}';
    }
}
