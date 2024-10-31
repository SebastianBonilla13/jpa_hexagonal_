package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.mappers;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTOPeticion.TeacherRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTORespuesta.TeacherResponseDTO;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherDTOsMapper {
    Teacher requestTeacherToResponseTeacher(TeacherRequestDTO requestDTO);

    TeacherResponseDTO teacherDataResponseTeacher(Teacher teacher);

    List<TeacherResponseDTO> teacherListResponsesTeacherList(List<Teacher> teacherList);
}
