package co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos;

import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subject {
    private Integer id;
    private String name;
    private String code;
    private List<Course> courses;

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
