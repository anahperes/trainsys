package org.fullstack.trainsys.service;

import org.fullstack.trainsys.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentEntity createStudent(StudentEntity student);
    List<StudentEntity> readStudent();
    Optional<StudentEntity> readStudentById(Long id);
    StudentEntity updateStudent(Long id, StudentEntity updatedStudent);
    void deleteStudent(Long id);
}
