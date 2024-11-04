package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;

public interface TeacherCUIntPort {
    public Teacher createTeacher(Teacher newTeacher);

    public List<Teacher> getAllTeachers();
    public Teacher allocateTeacherIntoOffice(Integer teacherId, Integer officeId);
    public List<Course> getAllCoursesByTeacher(Integer teacherId);
    public Teacher assignCourseToTeacher(Integer teacherId, Integer courseId);
}
