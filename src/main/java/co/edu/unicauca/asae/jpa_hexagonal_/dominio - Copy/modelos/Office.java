package co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Office {
    private Integer id;
    private String name;
    private String location;
    private Teacher teacher;

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", teacher=" + (teacher != null ? teacher.getName() : "None") +
                '}';
    }
}
