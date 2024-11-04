package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TimeSlotInput.Mapper;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.CourseCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.LocationCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.CourseCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.LocationCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.SubjectCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.LocationInput.ResponseDTO.LocationResponseDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TimeSlotInput.RequestDTO.TimeSlotRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TimeSlotInput.ResponseDTO.TimeSlotResponseDTO;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;
import java.util.List;

@Configuration
@Mapper(componentModel = "spring")
public interface TimeSlotDTOsMapper {

    @Mapping(target = "course", source = "courseId", qualifiedByName = "mapCourse")
    @Mapping(target = "location", source = "locationId", qualifiedByName = "mapLocation")
    TimeSlot timeSlotRequestToTimeSlotModel(TimeSlotRequestDTO timeSlotRequestDTO, @Context CourseCUIntPort courseCUAdapter, @Context LocationCUIntPort locationCUAdapter);

    @Mapping(target = "location", source = "location", qualifiedByName = "mapLocationToResponseDTO")
    TimeSlotResponseDTO map(TimeSlot value);

    List<TimeSlotResponseDTO> timeSlostToTimeSlotsResponse(List<TimeSlot> timeSlots);

    /**
     * METODO AUXILIARES PARA HACER MAPEO EN BASE A IDs
     * */

    @Named("mapCourse")
    default Course mapCourse(Integer courseId, @Context CourseCUIntPort courseCUAdapter){
        return courseCUAdapter.getCourseById(courseId);
    }

    @Named("mapLocation")
    default Location mapLocation(Integer locationId, @Context LocationCUIntPort locationCUAdapter){
        return locationCUAdapter.getLocationById(locationId);
    }

    @Named("mapLocationToResponseDTO")
    default LocationResponseDTO mapLocationToResponseDTO(Location location) {
        if (location == null) {
            return null;
        }
        // Mapea de Location a LocationResponseDTO
        return new LocationResponseDTO(location.getId(), location.getName(), location.getCapacity());
    }
}
