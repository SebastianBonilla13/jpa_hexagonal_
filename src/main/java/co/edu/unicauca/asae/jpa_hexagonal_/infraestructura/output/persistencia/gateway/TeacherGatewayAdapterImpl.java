package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.gateway;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeToken;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.TeacherGatewayIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Teacher;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.TeacherEntity;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios.TeacherRepository;

@Service
public class TeacherGatewayAdapterImpl implements TeacherGatewayIntPort {

    private final TeacherRepository teacherRepository;
    private final ModelMapper mapper;

    public TeacherGatewayAdapterImpl(TeacherRepository teacherRepository, ModelMapper mapper) {
        this.teacherRepository = teacherRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean teacherExists(Integer teacherId) {
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
    public List<Teacher> listAllTeachers() {
        List<TeacherEntity> teacherEntities = this.teacherRepository.findAll();
        List<Teacher> teachers = this.mapper.map(teacherEntities, new TypeToken<List<Teacher>>() {
        }.getType());
        return teachers;
    }

}