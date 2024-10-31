package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.configuracion;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.SubjectCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.SubjectGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.SubjectCUAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.GestionarLocationGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.LocationFormateadorResultadosIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.GestionarLocationCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;

@Configuration
public class BeanConfiguration {

    @Bean
    public GestionarLocationCUAdapter crearGestionLocationCUInt(
            GestionarLocationGatewayIntPort objGestionarLocationGateway,
            LocationFormateadorResultadosIntPort objLocationFormateadorResultados) {
        GestionarLocationCUAdapter Adapter = new GestionarLocationCUAdapter(objGestionarLocationGateway,
                objLocationFormateadorResultados);

        return Adapter;
    }

    @Bean
    public SubjectCUIntPort createSubjectCUIntPort(SubjectGatewayIntPort subjectGatewayIntPort ){
        return new SubjectCUAdapter(subjectGatewayIntPort);
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
