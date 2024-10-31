package co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos;

import java.util.List;

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
