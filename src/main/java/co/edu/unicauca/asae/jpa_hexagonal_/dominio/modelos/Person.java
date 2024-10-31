package co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
    private Integer id;
    private String name;
    private String lastname;
    private String email;

    public Person(String name, String lastname, String email) {
        this.email = email;
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
