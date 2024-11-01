package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.Controller;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.CourseCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.Mapper.CourseDTOsMapper;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.RequestDTO.CourseRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.CourseInput.ResponseDTO.CourseResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final CourseCUIntPort courseService;
    private final CourseDTOsMapper dtOsMapper;

    public CourseController(CourseCUIntPort courseService, CourseDTOsMapper dtOsMapper){
        this.courseService = courseService;
        this.dtOsMapper = dtOsMapper;
    }

    @PostMapping("")
    public ResponseEntity<CourseResponseDTO> postCourse(@RequestBody CourseRequestDTO courseRequestDTO){
        Course course = this.dtOsMapper.courseRequestToCourseModel(courseRequestDTO);
        Course savedCourse = this.courseService.createCourse(course);
        CourseResponseDTO courseResponseDTO = this.dtOsMapper.courseDataToCourseResponse(savedCourse);
        return new ResponseEntity<>(courseResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses(){
        List<Course> list = this.courseService.listCourses();
        List<CourseResponseDTO> responseDTOList = this.dtOsMapper.cousesListToCourseReponseList(list);
        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
    }
}
