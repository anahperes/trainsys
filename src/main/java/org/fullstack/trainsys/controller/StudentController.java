package org.fullstack.trainsys.controller;

import lombok.extern.slf4j.Slf4j;
import org.fullstack.trainsys.entity.StudentEntity;
import org.fullstack.trainsys.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("students")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/api/students")
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity student){
        StudentEntity newStudent = studentService.createStudent(student);
        logger.debug("Novo estudante adicionado: {}", newStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    @GetMapping("/api/students")
    public  ResponseEntity<List<StudentEntity>> readStudent() {
        List<StudentEntity> students = studentService.readStudent();
        logger.debug("Total de estudantes encontrados: {}", students.size());
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/api/students/{id}")
    public ResponseEntity<Optional<StudentEntity>> readStudentById(@PathVariable Long id) {
        Optional<StudentEntity> student = studentService.readStudentById(id);
        logger.debug("Estudante encontrado: {}", id, student);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PutMapping("/api/students/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Long id, @RequestBody StudentEntity updatedStudent) {
        StudentEntity student = studentService.updateStudent(id, updatedStudent);
        logger.debug("Estudante atualizado com o id {}", id, student);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @DeleteMapping("/api/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        logger.debug("Estudante deletado com sucesso com o id {}", id);
        return ResponseEntity.noContent().build();
    }

}
