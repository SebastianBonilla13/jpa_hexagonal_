package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts;

import java.util.List;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;

public interface TeacherGatewayIntPort {
    public boolean teacherExists(Integer teacherId);

    public Teacher saveTeacher(Teacher newTeacher);

    public List<Teacher> listAllTeachers();
}
