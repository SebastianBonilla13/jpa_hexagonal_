package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Subject;

import java.util.List;

public interface SubjectCUIntPort {
    public Subject createSubject(Subject newSubject);
    public List<Subject> getAllSubjects();
    public Subject getSubjectById(Integer subjectId);
}
