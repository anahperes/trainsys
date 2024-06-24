package org.fullstack.trainsys.controller;

import lombok.extern.slf4j.Slf4j;
import org.fullstack.trainsys.entity.ExerciseEntity;
import org.fullstack.trainsys.service.ExerciseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("exercises")
public class ExerciseController {

    private  static  final Logger logger = LoggerFactory.getLogger(ExerciseController.class);

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/api/exercises")
    public ResponseEntity<ExerciseEntity> createExercise(@RequestBody ExerciseEntity exercise){
        ExerciseEntity newExercise = exerciseService.createExercise(exercise);
        logger.debug("Novo exercício adicionado: {}", newExercise);
        return ResponseEntity.status(HttpStatus.CREATED).body(newExercise);
    }
    @GetMapping("/api/exercises")
    public  ResponseEntity<List<ExerciseEntity>> readExercise() {
        List<ExerciseEntity> exercises = exerciseService.readExercise();
        logger.debug("Total de exercícios encontrados: {}", exercises.size());
        return ResponseEntity.status(HttpStatus.OK).body(exercises);
    }


    @DeleteMapping("/api/exercises/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
        logger.debug("Exercício deletado com sucesso com o id {}", id);
        return ResponseEntity.noContent().build();
    }
}
