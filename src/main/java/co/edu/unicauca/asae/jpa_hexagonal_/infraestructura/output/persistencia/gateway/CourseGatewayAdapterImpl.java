package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.CourseGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.CourseEntity;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.SubjectEntity;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios.CourseRepository;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseGatewayAdapterImpl implements CourseGatewayIntPort {

    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;
    private final ModelMapper mapper;

    public CourseGatewayAdapterImpl(CourseRepository courseRepository, ModelMapper mapper, SubjectRepository subjectRepository){
        this.mapper = mapper;
        this.courseRepository = courseRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public boolean courseExistGateway(Integer courseId) {
        if(courseId == null) return false;
        Optional<CourseEntity> course = this.courseRepository.findById(courseId);
        return course.isPresent();
    }

    @Override
    public Course saveCourseGateway(Course newCourse) {
        CourseEntity courseEntity = this.mapper.map(newCourse, CourseEntity.class);

        SubjectEntity subject = this.subjectRepository.findById(newCourse.getSubject().getId())
                        .orElseThrow(() -> new ReglaNegocioExcepcion("Revise la asignatura que desea registrar en este curso"));

        courseEntity.setSubject(subject);

        CourseEntity savedCourse = this.courseRepository.save(courseEntity);
        Course course = this.mapper.map(savedCourse, Course.class);
        return course;
    }

    @Override
    public List<Course> findAllCoursesGateway() {
        List<CourseEntity> courseEntities = this.courseRepository.findAll();
        List<Course> courses = this.mapper.map(courseEntities, new TypeToken<List<Course>>(){}.getType());
        return courses;
    }

    @Override
    public Course findCourseByIdGateway(Integer courseId) {
        Optional<CourseEntity> courseEntity = this.courseRepository.findById(courseId);
        if(courseEntity.isEmpty()) return null;
        return this.mapper.map(courseEntity.get(), Course.class);
    }
}
