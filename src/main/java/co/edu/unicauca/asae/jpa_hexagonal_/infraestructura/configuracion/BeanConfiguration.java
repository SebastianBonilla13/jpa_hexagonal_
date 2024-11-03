package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.configuracion;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.CourseCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.CourseGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.SubjectGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.TeacherGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.TimeSlotGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.CourseCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.SubjectCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.TeacherCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.TimeSlotCUAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.GestionarLocationGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.ResultFormatterIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.OfficeGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.GestionarLocationCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.OfficeCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;

@Configuration
public class BeanConfiguration {

    @Bean
    public GestionarLocationCUAdapter crearGestionLocationCUInt(
            GestionarLocationGatewayIntPort objGestionarLocationGateway,
            ResultFormatterIntPort objLocationFormateadorResultados) {
        GestionarLocationCUAdapter Adapter = new GestionarLocationCUAdapter(objGestionarLocationGateway,
                objLocationFormateadorResultados);

        return Adapter;
    }

    @Bean
    public TimeSlotCUAdapter createTimeSlotAdapter(TimeSlotGatewayIntPort timeSlotGatewayIntPort,
            ResultFormatterIntPort objtimeSlotAdapter) {
        return new TimeSlotCUAdapter(timeSlotGatewayIntPort, objtimeSlotAdapter);
    }

    @Bean
    public SubjectCUAdapter createSubjectCUAdapter(SubjectGatewayIntPort objSubjectGateway) {
        SubjectCUAdapter AdapterSubject = new SubjectCUAdapter(objSubjectGateway);
        return AdapterSubject;
    }

    @Bean
    public TeacherCUAdapter createTeacherCUAdapter(TeacherGatewayIntPort objtTacherGateway,
            ResultFormatterIntPort objFormatterAdapter) {
        TeacherCUAdapter AdapterTeacher = new TeacherCUAdapter(objtTacherGateway, objFormatterAdapter);
        return AdapterTeacher;
    }

    @Bean
    public OfficeCUAdapter createOfficeCUAdapter(OfficeGatewayIntPort objOfficeGateway) {
        OfficeCUAdapter AdapterOffice = new OfficeCUAdapter(objOfficeGateway);
        return AdapterOffice;
    }

    @Bean
    public CourseCUIntPort createCourseCUIntPort(CourseGatewayIntPort courseGatewayIntPort) {
        return new CourseCUAdapter(courseGatewayIntPort);
    }

}
