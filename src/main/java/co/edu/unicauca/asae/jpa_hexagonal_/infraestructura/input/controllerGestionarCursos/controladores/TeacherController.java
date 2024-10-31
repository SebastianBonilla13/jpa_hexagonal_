package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.TeacherCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTOPeticion.TeacherRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTORespuesta.TeacherResponseDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.mappers.TeacherDTOsMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherCUIntPort teacherService;
    private final TeacherDTOsMapper teacherMapper;

    @PostMapping("/teacher")
    public ResponseEntity<TeacherResponseDTO> postTeacher(@RequestBody @Valid TeacherRequestDTO teacherRequest) {
        Teacher teacher = this.teacherMapper.requestTeacherToResponseTeacher(teacherRequest); // Peticion to objLocation
        Teacher savedTeacher = this.teacherService.createTeacher(teacher); // crear objLocation en Dominio
        ResponseEntity<TeacherResponseDTO> teacherResponse = new ResponseEntity<TeacherResponseDTO>(
                teacherMapper.teacherDataResponseTeacher(savedTeacher), HttpStatus.CREATED);
        return teacherResponse;
    }

    @GetMapping("/teacher")
    public ResponseEntity<List<TeacherResponseDTO>> listTeachers() {
        ResponseEntity<List<TeacherResponseDTO>> teacherResponse = new ResponseEntity<List<TeacherResponseDTO>>(
                teacherMapper.teacherListResponsesTeacherList(this.teacherService.getAllTeachers()),
                HttpStatus.CREATED);
        return teacherResponse;
    }

}
