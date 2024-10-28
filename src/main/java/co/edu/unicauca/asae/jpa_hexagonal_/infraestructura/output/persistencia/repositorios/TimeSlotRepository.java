package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Integer> {
    Optional<TimeSlot> findByCourseId(Integer courseId);
}
