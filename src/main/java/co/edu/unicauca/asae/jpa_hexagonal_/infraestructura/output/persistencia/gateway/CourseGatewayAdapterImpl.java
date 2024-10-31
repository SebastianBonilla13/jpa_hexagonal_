package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.CourseGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.CourseEntity;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios.CourseRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseGatewayAdapterImpl implements CourseGatewayIntPort {

    private final CourseRepository courseRepository;
    private final ModelMapper mapper;

    public CourseGatewayAdapterImpl(CourseRepository courseRepository, ModelMapper mapper){
        this.mapper = mapper;
        this.courseRepository = courseRepository;
    }

    @Override
    public boolean courseExistGateway(Integer courseId) {
        Optional<CourseEntity> course = this.courseRepository.findById(courseId);
        return course.isPresent();
    }

    @Override
    public Course saveCourseGateway(Course newCourse) {
        CourseEntity courseEntity = this.mapper.map(newCourse, CourseEntity.class);
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
}
