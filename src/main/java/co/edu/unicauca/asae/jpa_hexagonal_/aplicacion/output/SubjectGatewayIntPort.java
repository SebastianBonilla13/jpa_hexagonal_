package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Subject;

import java.util.List;

public interface SubjectGatewayIntPort {
    public boolean subjectExists(Integer subjectId);
    public Subject saveSubject(Subject newSubject);
    public List<Subject> listAllSubjects();
}
