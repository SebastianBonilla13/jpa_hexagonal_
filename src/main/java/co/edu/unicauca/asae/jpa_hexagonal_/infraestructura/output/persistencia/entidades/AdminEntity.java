package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "administrativo")
public class AdminEntity extends PersonEntity {
    @Column(name = "rol", length = 255, nullable = false)
    private String rol;

    public AdminEntity() {
        super();
    }

    public AdminEntity(String name, String lastname, String email, String rol) {
        super(name, lastname, email);
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "name='" + getName() + '\'' + // Llamada a getName() de la clase Person
                ", lastname='" + getLastname() + '\'' + // Llamada a getLastname() de la clase Person
                ", email='" + getEmail() + '\'' + // Llamada a getEmail() de la clase Person
                ", rol='" + rol + '\'' + // Propiedad específica de Administrator
                '}';
    }
}
