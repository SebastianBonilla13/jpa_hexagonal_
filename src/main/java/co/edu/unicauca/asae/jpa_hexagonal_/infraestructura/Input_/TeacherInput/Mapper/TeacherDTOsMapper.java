package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TeacherInput.Mapper;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TeacherInput.RequestDTO.TeacherRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TeacherInput.ResponseDTO.TeacherReponseDTO;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper(componentModel = "spring")
public interface TeacherDTOsMapper {
    Teacher requestTeacherToResponseTeacher(TeacherRequestDTO requestDTO);

    TeacherReponseDTO teacherDataResponseTeacher(Teacher teacher);

    List<TeacherReponseDTO> teacherListResponsesTeacherList(List<Teacher> teacherList);
}
