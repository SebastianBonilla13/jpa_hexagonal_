package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Office;
import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "docente")
public class TeacherEntity extends PersonEntity {
    @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "oficina_id")
    /* @JoinColumn(name = "oficina_id", nullable = false) */
    private OfficeEntity office;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "curso_docente", joinColumns = @JoinColumn(name = "docente_id"), inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<CourseEntity> courses;

    public TeacherEntity() {
        super();
    }

    public TeacherEntity(String name, String lastname, String email, OfficeEntity office, List<CourseEntity> courses) {
        super(name, lastname, email);
        this.office = office;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "office=" + (office != null ? office.getName() : "null") +
                ", courses=" + (courses != null ? courses.stream().map(CourseEntity::getName).toList() : "null") +
                ", name='" + getName() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
