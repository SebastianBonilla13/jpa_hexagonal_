package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.mappers;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Subject;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTOPeticion.SubjectRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTORespuesta.SubjectResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectDTOsMapper {
    Subject requestSubjectToResponseSubject(SubjectRequestDTO requestDTO);
    SubjectResponseDTO subjectDataToResponseSubject(Subject subject);
    List<SubjectResponseDTO> subjectListToResponsesSubjectList(List<Subject> subjectList);
}
