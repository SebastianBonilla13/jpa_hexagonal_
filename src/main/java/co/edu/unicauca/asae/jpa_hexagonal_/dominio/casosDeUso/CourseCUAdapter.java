package co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.CourseCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.CourseGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;

import java.util.List;

public class CourseCUAdapter implements CourseCUIntPort {

    private final CourseGatewayIntPort courseGateway;

    public CourseCUAdapter(CourseGatewayIntPort courseGateway){
        this.courseGateway = courseGateway;
    }

    @Override
    public Course createCourse(Course newCourse) {
        return null;
    }

    @Override
    public List<Course> listCourses() {
        return null;
    }

    @Override
    public Course getCourseById(Integer courseId) {
        return null;
    }
}
