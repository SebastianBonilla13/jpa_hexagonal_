package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.GestionarLocationGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.LocationFormateadorResultadosIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.GestionarLocationCUAdapter;

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

}
