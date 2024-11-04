package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {

    @Query("SELECT t FROM TeacherEntity t WHERE t.email = :email")
    Optional<TeacherEntity> findByEmail(@Param("email") String email);

    @Query("SELECT t.courses FROM TeacherEntity t WHERE t.id = :teacherId")
    List<Course> findAllCoursesById(@Param("teacherId") Integer teacherId);

}
