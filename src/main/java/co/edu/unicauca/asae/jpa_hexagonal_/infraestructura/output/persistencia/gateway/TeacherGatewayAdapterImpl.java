package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Course;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Office;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.CourseEntity;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.OfficeEntity;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios.OfficeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeToken;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.gatewaysIntPorts.TeacherGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.TimeSlot;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.TeacherEntity;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.TimeSlotEntity;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios.TeacherRepository;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios.TimeSlotRepository;

@Service
public class TeacherGatewayAdapterImpl implements TeacherGatewayIntPort {

    private final TeacherRepository teacherRepository;
    private final OfficeRepository officeRepository;
    private final TimeSlotRepository timeSlotRepository;
    private final ModelMapper mapper;

    public TeacherGatewayAdapterImpl(TeacherRepository teacherRepository, ModelMapper mapper,
            OfficeRepository officeRepository,
            TimeSlotRepository timeSlotRepository) {
        this.teacherRepository = teacherRepository;
        this.officeRepository = officeRepository;
        this.mapper = mapper;
        this.timeSlotRepository = timeSlotRepository;
    }

    @Override
    public boolean teacherExists(Integer teacherId) {
        /* if (teacherId == null) return false; */
        Optional<TeacherEntity> optionalTeacher = teacherRepository.findById(teacherId);
        return optionalTeacher.isEmpty();
    }

    @Override
    public Teacher saveTeacher(Teacher newTeacher) {
        TeacherEntity teacher = this.mapper.map(newTeacher, TeacherEntity.class);
        TeacherEntity savedTeacher = teacherRepository.save(teacher);
        return this.mapper.map(savedTeacher, Teacher.class);
    }

    @Override
    public boolean findByEmail(String teacherEmail) {
        Optional<TeacherEntity> optionalTeacher = teacherRepository.findByEmail(teacherEmail);
        return optionalTeacher.isEmpty();
    }

    @Override
    public List<Teacher> listAllTeachers() {
        List<TeacherEntity> teacherEntities = this.teacherRepository.findAll();
        List<Teacher> teachers = this.mapper.map(teacherEntities, new TypeToken<List<Teacher>>() {
        }.getType());
        return teachers;
    }

    @Override
    public Teacher updateTeacherOffice(Integer teacherId, Integer officeId) {
        Optional<OfficeEntity> office = this.officeRepository.findById(officeId);
        if (office.isEmpty())
            return null;

        Optional<TeacherEntity> teacher = this.teacherRepository.findById(teacherId);
        if (teacher.isEmpty())
            return null;

        // Actualizar la oficina del docente & guardarlo en la base de datos actualizado
        teacher.get().setOffice(office.get());
        TeacherEntity savedTeacher = this.teacherRepository.save(teacher.get());

        Teacher teacherModel = this.mapper.map(savedTeacher, Teacher.class);
        return teacherModel;
    }

    @Override
    public List<Course> findAllCoursesByTeacherGateway(Integer teacherId) {
        List<CourseEntity> courseEntities = this.teacherRepository.findAllCoursesById(teacherId);
        List<Course> courses = this.mapper.map(courseEntities, new TypeToken<List<Course>>() {
        }.getType());
        return courses;
    }

    @Override
    public Teacher updateTeacherCoursesGateway(Integer teacherId, List<Course> courses) {
        Optional<TeacherEntity> teacher = this.teacherRepository.findById(teacherId);
        if (teacher.isEmpty())
            return null;

        TeacherEntity teacherEntity = teacher.get();
        List<CourseEntity> courseEntities = this.mapper.map(courses, new TypeToken<List<CourseEntity>>() {
        }.getType());
        teacherEntity.setCourses(courseEntities);

        return this.mapper.map(this.teacherRepository.save(teacherEntity), Teacher.class);
    }

    @Override
    public List<TimeSlot> findAllTimeSlotsByTeacherIdGateway(Integer teacherId) {
        List<CourseEntity> courseList = this.teacherRepository.findAllCoursesById(teacherId);
        List<TimeSlotEntity> timeSlots = new ArrayList<>();

        for (CourseEntity course : courseList) {
            Optional<TimeSlotEntity> timeSlot = this.timeSlotRepository.findByCourseId(course.getId());
            if (timeSlot.isPresent()) {
                timeSlots.add(timeSlot.get());
            }

        }

        return this.mapper.map(timeSlots, new TypeToken<List<TimeSlot>>() {
        }.getType());
    }

}
