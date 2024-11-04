package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TeacherInput.Controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.TeacherCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TeacherInput.Mapper.TeacherDTOsMapper;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TeacherInput.RequestDTO.TeacherRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.TeacherInput.ResponseDTO.TeacherReponseDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherCUIntPort teacherService;
    private final TeacherDTOsMapper teacherMapper;

    @PostMapping("")
    public ResponseEntity<TeacherReponseDTO> postTeacher(@RequestBody @Valid TeacherRequestDTO teacherRequest) {
        Teacher teacher = this.teacherMapper.requestTeacherToResponseTeacher(teacherRequest); // Peticion to objLocation
        Teacher savedTeacher = this.teacherService.createTeacher(teacher); // crear objLocation en Dominio
        ResponseEntity<TeacherReponseDTO> teacherResponse = new ResponseEntity<TeacherReponseDTO>(
                teacherMapper.teacherDataResponseTeacher(savedTeacher), HttpStatus.CREATED);
        return teacherResponse;
    }

    @PutMapping("/allocateOffice")
    public ResponseEntity<TeacherReponseDTO> allocateOffice(
            @RequestParam Integer teacherId,
            @RequestParam Integer officeId) {
        Teacher teacher = this.teacherService.allocateTeacherIntoOffice(teacherId, officeId);
        TeacherReponseDTO teacherReponseDTO = this.teacherMapper.teacherDataResponseTeacher(teacher);
        return new ResponseEntity<>(teacherReponseDTO, HttpStatus.ACCEPTED);
    }

    @PutMapping("/assignCourse")
    public ResponseEntity<TeacherReponseDTO> assignCourse(@RequestParam Integer courseId, @RequestParam Integer teacherId){
        Teacher teacher = this.teacherService.assignCourseToTeacher(teacherId, courseId);
        TeacherReponseDTO teacherReponseDTO = this.teacherMapper.teacherDataResponseTeacher(teacher);
        return new ResponseEntity<>(teacherReponseDTO, HttpStatus.OK);
    }



    @GetMapping("")
    public ResponseEntity<List<TeacherReponseDTO>> listTeachers() {
        ResponseEntity<List<TeacherReponseDTO>> teacherResponse = new ResponseEntity<List<TeacherReponseDTO>>(
                teacherMapper.teacherListResponsesTeacherList(this.teacherService.getAllTeachers()),
                HttpStatus.CREATED);
        return teacherResponse;
    }

}
