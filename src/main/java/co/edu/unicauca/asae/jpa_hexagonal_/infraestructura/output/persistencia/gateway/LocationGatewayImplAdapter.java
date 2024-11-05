package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.gateway;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeToken;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.LocationGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.LocationEntity;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios.LocationRepository;

@Service
public class LocationGatewayImplAdapter implements LocationGatewayIntPort {
    private final LocationRepository objLocationRepository;
    private final ModelMapper LocationModelMapper;

    public LocationGatewayImplAdapter(LocationRepository objLocationRepository,
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
    public List<Location> listar(String pattern, Integer capacity) {
        Integer capacityCheck = capacity == null ? 0 : capacity;
        String patternCheck = pattern == null ? "" : pattern;
        Iterable<LocationEntity> lista = this.objLocationRepository.findAllLocationsCustom(patternCheck, capacityCheck);
        List<Location> listaObtenida = this.LocationModelMapper.map(lista, new TypeToken<List<Location>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public Location finLocationByIdGateway(Integer locationId) {
        Optional<LocationEntity> locationEntity = this.objLocationRepository.findById(locationId);
        if (locationEntity.isEmpty())
            return null;
        return this.LocationModelMapper.map(locationEntity.get(), Location.class);
    }

}
