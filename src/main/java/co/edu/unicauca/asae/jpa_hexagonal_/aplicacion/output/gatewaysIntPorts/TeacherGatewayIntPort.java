package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts;

import java.util.List;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;

public interface TeacherGatewayIntPort {
    public boolean teacherExists(Integer teacherId);

    public Teacher saveTeacher(Teacher newTeacher);

    public boolean findByEmail(String teacherEmail);

    public List<Teacher> listAllTeachers();

    public Teacher updateTeacherOffice(Integer teacherId, Integer officeId);

    public List<Course> findAllCoursesByTeacherGateway(Integer teacherId);

    public Teacher updateTeacherCoursesGateway(Integer teacherId, List<Course> courses);

    public List<TimeSlot> findAllTimeSlotsByTeacherIdGateway(Integer teacherId);
}
