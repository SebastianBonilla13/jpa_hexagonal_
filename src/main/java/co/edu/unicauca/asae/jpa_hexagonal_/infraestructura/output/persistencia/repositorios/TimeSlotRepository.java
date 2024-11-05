package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios;

import java.time.LocalTime;
import java.util.Optional;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.SubjectEntity;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.TimeSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TimeSlotRepository extends JpaRepository<TimeSlotEntity, Integer> {

  @Query(value = """
      SELECT CASE WHEN COUNT(f.id) > 0 THEN true ELSE false END AS ocupado
      FROM franja_horaria f
      JOIN curso c ON f.curso_id = c.id
      JOIN curso_docente cd ON c.id = cd.curso_id
      JOIN docente d ON cd.docente_id = d.id
      WHERE d.id = :idDocente
        AND f.dia = :dia
        AND (
              (f.hora_inicio <= :horaInicio AND f.hora_fin > :horaInicio) OR
              (f.hora_inicio < :horaFin AND f.hora_fin >= :horaFin) OR
              (f.hora_inicio >= :horaInicio AND f.hora_fin <= :horaFin)
            )
      """, nativeQuery = true)
  Optional<TimeSlot> checkTeacherAvailability(
      @Param("dia") String dia,
      @Param("horaInicio") String horaInicio,
      @Param("horaFin") String horaFin,
      @Param("idDocente") Integer idDocente);

  @Query("""
  SELECT CASE WHEN COUNT(ts) > 0 THEN true ELSE false END
  FROM TimeSlotEntity ts
  JOIN ts.location loc
  WHERE loc.id = :locationId
    AND ts.day = :day
    AND (
          (ts.endTime <= :startTime) OR
          (ts.startTime >= :endTime)
        )
  """)
  boolean timeSlotAvailability(
          @Param("day") String day,
          @Param("startTime") LocalTime startTime,
          @Param("endTime") LocalTime endTime,
          @Param("locationId") Integer locationId);

}
