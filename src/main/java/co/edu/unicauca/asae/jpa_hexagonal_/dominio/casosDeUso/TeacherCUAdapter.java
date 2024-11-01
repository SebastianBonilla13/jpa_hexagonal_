package co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.TeacherCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.TeacherGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;

public class TeacherCUAdapter implements TeacherCUIntPort {

    private final TeacherGatewayIntPort teacherGateway;
    // private final TeacherResultFormatterIntPort objTeacherResultFormatter;

    public TeacherCUAdapter(TeacherGatewayIntPort teacherGateway) {
        this.teacherGateway = teacherGateway;
    }

    @Override
    public Teacher createTeacher(Teacher newTeacher) {

        Teacher objCreateTeacher = null;
        objCreateTeacher = this.teacherGateway.saveTeacher(newTeacher);

        return objCreateTeacher;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = this.teacherGateway.listAllTeachers();
        return teachers;
    }

}
