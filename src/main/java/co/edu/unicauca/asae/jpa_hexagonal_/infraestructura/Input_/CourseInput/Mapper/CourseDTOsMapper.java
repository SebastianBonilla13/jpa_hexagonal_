package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.Mapper;


import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTORespuesta.CourseResponseDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.controladores.CourseRequestDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Mapper(componentModel = "spring")
public interface CourseDTOsMapper {
    Course courseRequestToCourseModel(CourseRequestDTO courseRequestDTO);

    CourseResponseDTO courseDataToCourseResponse(Course course);

    List<CourseResponseDTO> cousesListToCourseReponseList(List<Course> courses);
}