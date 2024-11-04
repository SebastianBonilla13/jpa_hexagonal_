package co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.CourseCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.CourseGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;

import java.util.List;

public class CourseCUAdapter implements CourseCUIntPort {
    private final CourseGatewayIntPort courseGateway;

    public CourseCUAdapter(CourseGatewayIntPort courseGateway){
        this.courseGateway = courseGateway;
    }

    @Override
    public Course createCourse(Course newCourse) {
        boolean exist = this.courseGateway.courseExistGateway(newCourse.getId());
        if(exist) throw new EntidadYaExisteException(CodigoError.ENTIDAD_YA_EXISTE);
        return this.courseGateway.saveCourseGateway(newCourse);
    }

    @Override
    public List<Course> listCourses() {
        return this.courseGateway.findAllCoursesGateway();
    }

    @Override
    public Course getCourseById(Integer courseId) {
        Course course = this.courseGateway.findCourseByIdGateway(courseId);
        if(course == null) throw new EntidadNoExisteException(CodigoError.ENTIDAD_NO_ENCONTRADA);
        return course;
    }
}