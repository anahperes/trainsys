package org.fullstack.trainsys.service.impl;

import org.fullstack.trainsys.entity.StudentEntity;
import org.fullstack.trainsys.exceptions.NotFoundException;
import org.fullstack.trainsys.repository.StudentRepository;
import org.fullstack.trainsys.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity createStudent(StudentEntity student) {
        logger.info("Adicionado novo estudante: {}", student);
        return studentRepository.save(student);
    }

    @Override
    public List<StudentEntity> readStudent() {
        logger.info("Listando todos os estudantes");
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity updateStudent(Long id, StudentEntity updatedStudent) {
        logger.info("Atualizando estudante com o id: {}", id);
        return studentRepository.save(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        logger.info("Deletando estudante com o id: {}", id);
        if(!studentRepository.existsById(id)) {
            logger.warn("Estudante não encontrado com o id: {}", id);
            throw new NotFoundException("Estudante não encontrado com o id " + id);
        } else {
            studentRepository.deleteById(id);
            logger.info("Estudante deletado com o id: {}", id);
        }
    }
}
