package co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.TeacherCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.ResultFormatterIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.TeacherGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;

public class TeacherCUAdapter implements TeacherCUIntPort {

    private final TeacherGatewayIntPort teacherGateway;
    private final ResultFormatterIntPort teacherFormatter;

    public TeacherCUAdapter(TeacherGatewayIntPort teacherGateway, ResultFormatterIntPort teacherFormatter) {
        this.teacherGateway = teacherGateway;
        this.teacherFormatter = teacherFormatter;
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

}
