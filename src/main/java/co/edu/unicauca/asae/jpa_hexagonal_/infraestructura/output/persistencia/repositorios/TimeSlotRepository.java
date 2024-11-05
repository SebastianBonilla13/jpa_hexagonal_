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
            SELECT COUNT(*)
            FROM franja_horaria f
            JOIN curso c ON f.curso_id = c.id
            JOIN curso_docente cd ON c.id = cd.curso_id
            JOIN docente d ON cd.docente_id = d.id
            WHERE d.id = :teacherId
            AND f.dia = :day
            AND (
                (f.hora_inicio < :endTime AND f.hora_fin > :startTime)
                AND (f.hora_inicio <> f.hora_fin)
            )
            """, nativeQuery = true)
    Integer isTeacherAvailableAtTimeSlot(
            @Param("day") String day,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime,
            @Param("teacherId") Integer teacherId);

    @Query("""
            SELECT CASE WHEN COUNT(ts) = 0 THEN true ELSE false END
            FROM TimeSlotEntity ts
            JOIN ts.location loc ON ts.location.id = loc.id
            WHERE loc.id = :locationId
              AND ts.day = :day
              AND (
                    (:startTime BETWEEN ts.startTime AND ts.endTime) OR
                    (:endTime BETWEEN ts.startTime AND ts.endTime) AND
                    (ts.startTime BETWEEN :startTime AND :endTime) OR
                    (ts.endTime BETWEEN :startTime AND :endTime)
              )
            """)
    boolean timeSlotAvailability(
            @Param("day") String day,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime,
            @Param("locationId") Integer locationId);

    Optional<TimeSlotEntity> findByCourseId(Integer courseId);
}
