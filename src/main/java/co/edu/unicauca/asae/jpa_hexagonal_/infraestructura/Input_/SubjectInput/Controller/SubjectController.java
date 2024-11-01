package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.SubjectInput.Controller;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.SubjectCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Subject;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.SubjectInput.Mapper.SubjectDTOsMapper;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.SubjectInput.RequestDTO.SubjectRequestDTO;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.Input_.SubjectInput.ResponseDTO.SubjectResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    private final SubjectCUIntPort subjectService;
    private final SubjectDTOsMapper subjectMapper;

    public SubjectController(SubjectCUIntPort subjectService, SubjectDTOsMapper subjectMapper){
        this.subjectMapper = subjectMapper;
        this.subjectService = subjectService;
    }

    @PostMapping("")
    public ResponseEntity<SubjectResponseDTO> postSubject(@RequestBody @Valid SubjectRequestDTO subjectRequest){
        Subject subject = this.subjectMapper.requestSubjectToResponseSubject(subjectRequest);
        System.out.println(subject);
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

