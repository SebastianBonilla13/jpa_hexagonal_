package co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.CourseCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.TeacherCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.ResultFormatterIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.TeacherGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;

public class TeacherCUAdapter implements TeacherCUIntPort {
    private final TeacherGatewayIntPort teacherGateway;
    private final ResultFormatterIntPort teacherFormatter;
    private final CourseCUIntPort courseAdapter;

    public TeacherCUAdapter(TeacherGatewayIntPort teacherGateway, ResultFormatterIntPort teacherFormatter, CourseCUIntPort courseAdapter) {
        this.teacherGateway = teacherGateway;
        this.teacherFormatter = teacherFormatter;
        this.courseAdapter = courseAdapter;
    }

    @Override
    public Teacher createTeacher(Teacher newTeacher) {

        Teacher objCreateTeacher = null;

        if (!this.teacherGateway.findByEmail(newTeacher.getEmail())) {
            this.teacherFormatter
                    .returnResponseErrorBusinessRule("Error, ya existe un docente con el mismo correo electrónico");
        } else {
            objCreateTeacher = this.teacherGateway.saveTeacher(newTeacher);
        }

        return objCreateTeacher;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = this.teacherGateway.listAllTeachers();
        return teachers;
    }

    @Override
    public Teacher allocateTeacherIntoOffice(Integer teacherId, Integer officeId) {
        Teacher updatedTeacher = this.teacherGateway.updateTeacherOffice(teacherId, officeId);
        if(updatedTeacher == null) throw new EntidadNoExisteException(CodigoError.ENTIDAD_NO_ENCONTRADA);
        return updatedTeacher;
    }

    @Override
    public List<Course> getAllCoursesByTeacher(Integer teacherId) {
        return this.teacherGateway.findAllCoursesByTeacherGateway(teacherId);
    }

    @Override
    public Teacher assignCourseToTeacher(Integer teacherId, Integer courseId) {
        Course course = this.courseAdapter.getCourseById(courseId);
        List<Course> courseList = this.getAllCoursesByTeacher(teacherId);
        courseList.add(course);
        return this.teacherGateway.updateTeacherCoursesGateway(teacherId, courseList);
    }

}
