package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.SubjectGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Subject;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.SubjectEntity;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectGatewayAdapterImpl implements SubjectGatewayIntPort {

    private final SubjectRepository subjectRepository;
    private final ModelMapper mapper;

    public SubjectGatewayAdapterImpl(SubjectRepository subjectRepository, ModelMapper mapper){
        this.subjectRepository = subjectRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean subjectExists(Integer subjectId) {
        if(subjectId == null) return false;
        Optional<SubjectEntity> optionalSubject = subjectRepository.findById(subjectId);
        return optionalSubject.isEmpty();
    }

    @Override
    public Subject saveSubject(Subject newSubject) {
        SubjectEntity subject = this.mapper.map(newSubject, SubjectEntity.class);
        SubjectEntity savedSubject = subjectRepository.save(subject);
        return this.mapper.map(savedSubject, Subject.class);
    }

    @Override
    public List<Subject> listAllSubjects() {
        List<SubjectEntity> subjectEntities = this.subjectRepository.findAll();
        List<Subject> subjects = this.mapper.map(subjectEntities, new TypeToken<List<Subject>>(){}.getType());
        return subjects;
    }

    @Override
    public Subject findSubjectByIdGateway(Integer subjectId) {
        Optional<SubjectEntity> optionalSubject = this.subjectRepository.findById(subjectId);

        if(optionalSubject.isEmpty()) return null;

        return this.mapper.map(optionalSubject.get(), Subject.class);
    }
}
