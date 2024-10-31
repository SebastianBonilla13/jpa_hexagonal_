package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.controladores;


import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.SubjectCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Subject;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTOPeticion.SubjectRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.DTORespuesta.SubjectResponseDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.input.controllerGestionarCursos.mappers.SubjectDTOsMapper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    private SubjectCUIntPort subjectService;
    private SubjectDTOsMapper subjectMapper;

    @PostMapping("")
    public ResponseEntity<SubjectResponseDTO> postSubject(@RequestBody @Valid SubjectRequestDTO subjectRequest){
        Subject subject = this.subjectMapper.requestSubjectToResponseSubject(subjectRequest);
        Subject savedSubject = this.subjectService.createSubject(subject);
        SubjectResponseDTO subjectResponse = this.subjectMapper.subjectDataToResponseSubject(savedSubject);
        return new ResponseEntity<>(subjectResponse, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<SubjectResponseDTO>> listSubjects(){
        List<Subject> subjects = this.subjectService.getAllSubjects();
        List<SubjectResponseDTO> subjectsResponse = this.subjectMapper.subjectListToResponsesSubjectList(subjects);
        return new ResponseEntity<>(subjectsResponse, HttpStatus.CREATED);
    }
}
