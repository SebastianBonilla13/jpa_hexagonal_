package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.Controller;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.CourseCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.SubjectCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.TimeSlotCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.SubjectCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso.TimeSlotCUAdapter;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.Mapper.CourseDTOsMapper;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.RequestDTO.CourseRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.ResponseDTO.CourseResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final CourseCUIntPort courseService;
    private final CourseDTOsMapper dtOsMapper;
    private final TimeSlotCUIntPort timeSlotCUAdapter;
    private final SubjectCUIntPort subjectCUAdapter;

    public CourseController(CourseCUIntPort courseService, CourseDTOsMapper dtOsMapper,
            TimeSlotCUIntPort timeSlotCUAdapter, SubjectCUIntPort subjectCUAdapter) {
        this.courseService = courseService;
        this.dtOsMapper = dtOsMapper;
        this.timeSlotCUAdapter = timeSlotCUAdapter;
        this.subjectCUAdapter = subjectCUAdapter;
    }

    @PostMapping("")
    public ResponseEntity<CourseResponseDTO> postCourse(@RequestBody @Valid CourseRequestDTO courseRequestDTO) {
        Course course = this.dtOsMapper.courseRequestToCourseModel(courseRequestDTO, subjectCUAdapter,
                timeSlotCUAdapter);
        Course savedCourse = this.courseService.createCourse(course);
        CourseResponseDTO courseResponseDTO = this.dtOsMapper.courseDataToCourseResponse(savedCourse);
        return new ResponseEntity<>(courseResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses() {
        List<Course> list = this.courseService.listCourses();
        List<CourseResponseDTO> responseDTOList = this.dtOsMapper.cousesListToCourseReponseList(list);
        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
    }
}
