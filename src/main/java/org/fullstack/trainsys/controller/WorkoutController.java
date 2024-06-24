package org.fullstack.trainsys.controller;

import lombok.extern.slf4j.Slf4j;
import org.fullstack.trainsys.entity.WorkoutEntity;
import org.fullstack.trainsys.service.WorkoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("workouts")
public class WorkoutController {
    private static final Logger logger = LoggerFactory.getLogger(WorkoutController.class);

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping("/api/workouts")
    public ResponseEntity<WorkoutEntity> createWorkout(@RequestBody WorkoutEntity workout){
        WorkoutEntity newWorkout = workoutService.createWorkout(workout);
        logger.debug("Novo treino adicionado: {}", newWorkout);
        return ResponseEntity.status(HttpStatus.CREATED).body(newWorkout);
    }
}
