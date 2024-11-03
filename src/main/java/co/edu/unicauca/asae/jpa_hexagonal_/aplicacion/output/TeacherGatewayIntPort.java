package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;

public interface TeacherGatewayIntPort {

    public boolean teacherExists(Integer teacherId);

    public Teacher saveTeacher(Teacher newTeacher);

    public boolean findByEmail(String teacherEmail);

    public List<Teacher> listAllTeachers();
}
