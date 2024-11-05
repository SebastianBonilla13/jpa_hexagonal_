package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;

import java.util.List;

public interface CourseGatewayIntPort {
    boolean courseExistGateway(Integer courseId);
    Course saveCourseGateway(Course newCourse);
    List<Course> findAllCoursesGateway();
    Course findCourseByIdGateway(Integer courseId);
}