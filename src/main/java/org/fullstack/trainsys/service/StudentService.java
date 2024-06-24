package org.fullstack.trainsys.service;

import org.fullstack.trainsys.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity createStudent(StudentEntity student);
    List<StudentEntity> readStudent();
    void deleteStudent(Long id);
}
