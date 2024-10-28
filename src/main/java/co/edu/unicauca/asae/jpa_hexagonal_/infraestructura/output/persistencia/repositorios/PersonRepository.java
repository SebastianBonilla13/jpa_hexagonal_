package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Person;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

}
