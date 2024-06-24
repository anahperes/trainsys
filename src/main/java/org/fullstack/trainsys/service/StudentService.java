package org.fullstack.trainsys.service;

import org.fullstack.trainsys.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity createStudent(StudentEntity student);
    List<StudentEntity> readStudent();
    StudentEntity updateStudent(Long id, StudentEntity updatedStudent);
    void deleteStudent(Long id);
}
