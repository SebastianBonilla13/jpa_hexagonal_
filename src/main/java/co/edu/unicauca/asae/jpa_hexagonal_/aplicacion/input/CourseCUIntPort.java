package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;

import java.util.List;

public interface CourseCUIntPort {
    Course createCourse(Course newCourse);
    List<Course> listCourses();
    Course getCourseById(Integer courseId);
}
