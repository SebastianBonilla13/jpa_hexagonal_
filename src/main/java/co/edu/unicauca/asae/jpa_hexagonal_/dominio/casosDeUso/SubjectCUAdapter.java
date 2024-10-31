package co.edu.unicauca.asae.jpa_hexagonal_.dominio.casosDeUso;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input.SubjectCUIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.SubjectGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Subject;

import java.util.List;

public class SubjectCUAdapter implements SubjectCUIntPort {

    private final SubjectGatewayIntPort subjectGateway;

    public SubjectCUAdapter(SubjectGatewayIntPort subjectGateway) {
        this.subjectGateway = subjectGateway;
    }

    @Override
    public Subject createSubject(Subject newSubject) {
        boolean exists = subjectGateway.subjectExists(newSubject.getId());

        if (exists) {
            // TODO... Manejar exepcion
        }

        return subjectGateway.saveSubject(newSubject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        List<Subject> subjects = this.subjectGateway.listAllSubjects();

        if (subjects.isEmpty()) {
            // TODO... Manejar exepcion
        }

        return subjects;
    }
}
