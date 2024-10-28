package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.GestionarLocationGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios.LocationRepository;

@Service
public class GestionarLocationGatewayImplAdapter implements GestionarLocationGatewayIntPort {

    private final LocationRepository objLocationRepository;
    private final ModelMapper LocationModelMapper;

    public GestionarLocationGatewayImplAdapter(LocationRepository objLocationRepository,
            ModelMapper locationModelMapper) {
        this.objLocationRepository = objLocationRepository;
        LocationModelMapper = locationModelMapper;
    }

    @Override
    public boolean existeLocationPorCodigo(String codigo) {
        return this.objLocationRepository.existeLocationPorCodigo(codigo) == 1;
    }

    @Override
    public Location guardar(Location objLocation) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Location> listar() {
        // TODO Auto-generated method stub
        return null;
    }

}
