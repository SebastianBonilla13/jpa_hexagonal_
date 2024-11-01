package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.gateway;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeToken;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.OfficeGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Office;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.OfficeEntity;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios.OfficeRepository;

@Service
public class OfficeGatewayAdapterImpl implements OfficeGatewayIntPort {

    private final OfficeRepository officeRepository;
    private final ModelMapper mapper;

    public OfficeGatewayAdapterImpl(OfficeRepository officeRepository, ModelMapper mapper) {
        this.officeRepository = officeRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean officeExists(Integer officeId) {
        Optional<OfficeEntity> optionalOffice = officeRepository.findById(officeId);
        return optionalOffice.isEmpty();
    }

    @Override
    public Office saveOffice(Office newOffice) {
        OfficeEntity office = this.mapper.map(newOffice, OfficeEntity.class);
        OfficeEntity saveOffice = officeRepository.save(office);
        return this.mapper.map(saveOffice, Office.class);
    }

    @Override
    public List<Office> listAllOffices() {
        List<OfficeEntity> officeEntities = this.officeRepository.findAll();
        List<Office> offices = this.mapper.map(officeEntities, new TypeToken<List<Office>>() {
        }.getType());
        return offices;
    }
}
