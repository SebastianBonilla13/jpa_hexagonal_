package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String name;

    @Column(name = "apellido", length = 100, nullable = false)
    private String lastname;

    @Column(name = "correo", length = 100, nullable = false)
    private String email;

    public PersonEntity(String name, String lastname, String email) {
        this.email = email;
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}