package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.Mapper;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.SubjectCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.TimeSlotCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.SubjectCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.TimeSlotCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Subject;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.RequestDTO.CourseRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.ResponseDTO.CourseResponseDTO;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@Mapper(componentModel = "spring")
public interface CourseDTOsMapper {
    @Mapping(target = "subject", source = "subjectId", qualifiedByName = "mapSubject")
    @Mapping(target = "timeSlots", source = "timeSlotIds", qualifiedByName = "mapTimeSlots")
    Course courseRequestToCourseModel(CourseRequestDTO courseRequestDTO, @Context SubjectCUIntPort subjectCUAdapter, @Context TimeSlotCUIntPort timeSlotCUAdapter);

    CourseResponseDTO courseDataToCourseResponse(Course course);
    List<CourseResponseDTO> cousesListToCourseReponseList(List<Course> courses);


    /**
     * METODO AUXILIARES PARA HACER MAPEO EN BASE A IDs
     * */

    @Named("mapSubject")
    default Subject mapSubject(Integer subjectId, @Context SubjectCUIntPort subjectCUAdapter) {
        return subjectCUAdapter.getSubjectById(subjectId);
    }

    @Named("mapTimeSlots")
    default List<TimeSlot> mapTimeSlots(List<Integer> timeSlotIds, @Context TimeSlotCUIntPort timeSlotCUAdapter) {
        // Verificar si la lista está vacía
        if (timeSlotIds == null || timeSlotIds.isEmpty()) {
            return List.of(); // Devolver una lista vacía
        }
        // Itera sobre cada ID y llama a timeSlotCUAdapter para obtener cada TimeSlot
        return timeSlotIds.stream()
                .map(timeSlotCUAdapter::getTimeSlotById)  // Obtener TimeSlot por ID
                .collect(Collectors.toList());             // Recoger en una lista
    }
}