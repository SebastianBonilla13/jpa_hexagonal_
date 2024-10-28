package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
}
