package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
