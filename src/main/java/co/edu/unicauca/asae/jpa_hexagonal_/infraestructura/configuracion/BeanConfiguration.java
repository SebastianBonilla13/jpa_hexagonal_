package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.configuracion;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.CourseCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.CourseGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.SubjectGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.TeacherGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.TimeSlotGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.CourseCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.SubjectCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.TeacherCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.TimeSlotCUAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.LocationGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.resultFormatters.LocationFormateadorResultadosIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.OfficeGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.LocationCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.OfficeCUAdapter;

@Configuration
public class BeanConfiguration {

    @Bean
    public LocationCUAdapter crearGestionLocationCUInt(
            LocationGatewayIntPort objGestionarLocationGateway,
            LocationFormateadorResultadosIntPort objLocationFormateadorResultados) {
        LocationCUAdapter Adapter = new LocationCUAdapter(objGestionarLocationGateway,
                objLocationFormateadorResultados);

        return Adapter;
    }

    @Bean
    public TimeSlotCUAdapter createTimeSlotAdapter(TimeSlotGatewayIntPort timeSlotGatewayIntPort) {
        return new TimeSlotCUAdapter(timeSlotGatewayIntPort);
    }

    @Bean
    public SubjectCUAdapter createSubjectCUAdapter(SubjectGatewayIntPort objSubjectGateway) {
        SubjectCUAdapter AdapterSubject = new SubjectCUAdapter(objSubjectGateway);
        return AdapterSubject;
    }

    @Bean
    public TeacherCUAdapter createTeacherCUAdapter(TeacherGatewayIntPort objtTacherGateway) {
        TeacherCUAdapter AdapterTeacher = new TeacherCUAdapter(objtTacherGateway);
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

    /*
     * @Bean
     * public Location location1() {
     * return new Location(null, "Auditorio 1", 20, null);
     * }
     * 
     * @Bean
     * public Location location2() {
     * return new Location(null, "Salón de Conferencias", 50, null);
     * }
     * 
     * @Bean
     * public Location location3() {
     * return new Location(null, "Sala de Reuniones", 10, null);
     * }
     */

}
