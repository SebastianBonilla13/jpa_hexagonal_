package co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin extends Person{
    private String rol;

    public Admin() {
        super();
    }

    public Admin(String name, String lastname, String email, String rol) {
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
