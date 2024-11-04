package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.SubjectInput.Mapper;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Subject;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.SubjectInput.RequestDTO.SubjectRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.SubjectInput.ResponseDTO.SubjectResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Mapper(componentModel = "spring")
public interface SubjectDTOsMapper {
    Subject requestSubjectToResponseSubject(SubjectRequestDTO requestDTO);
    SubjectResponseDTO subjectDataToResponseSubject(Subject subject);
    List<SubjectResponseDTO> subjectListToResponsesSubjectList(List<Subject> subjectList);
}