package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query("SELECT t.courses FROM Teacher t WHERE t.id = :teacherId")
    List<Course> findAllCoursesById(@Param("teacherId") Integer teacherId);
}
