package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeToken;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.GestionarLocationGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.LocationEntity;
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
        LocationEntity objLocationEntity = this.LocationModelMapper.map(objLocation, LocationEntity.class);
        LocationEntity ObjLocationEntityRegistrado = this.objLocationRepository.save(objLocationEntity);
        Location objLocationRespuesta = this.LocationModelMapper.map(ObjLocationEntityRegistrado, Location.class);
        return objLocationRespuesta;
    }

    @Override
    public List<Location> listar() {
        Iterable<LocationEntity> lista = this.objLocationRepository.findAll();
        List<Location> listaObtenida = this.LocationModelMapper.map(lista, new TypeToken<List<Location>>() {
        }.getType());
        return listaObtenida;
    }

}
