package co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
public class Teacher extends Person {
    private Office office;
    private List<Course> courses;

    public Teacher() {
        super();
    }

    public Teacher(String name, String lastname, String email, Office office, List<Course> courses) {
        super(name, lastname, email);
        this.office = office;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "office=" + (office != null ? office.getName() : "null") +
                ", courses=" + (courses != null ? courses.stream().map(Course::getName).toList() : "null") +
                ", name='" + getName() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
