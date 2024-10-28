package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocationMapper {
    @Bean
    public ModelMapper crearLocationMapper() {
        return new ModelMapper();
    }
}
