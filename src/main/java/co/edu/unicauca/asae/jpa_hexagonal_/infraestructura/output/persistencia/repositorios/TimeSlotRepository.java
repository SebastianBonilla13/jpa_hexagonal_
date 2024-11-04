package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios;

import java.util.Optional;

import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.TimeSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TimeSlotRepository extends JpaRepository<TimeSlotEntity, Integer> {
    Optional<TimeSlotEntity> findByCourseId(Integer courseId);
}
