package org.fullstack.trainsys.service;

import org.fullstack.trainsys.entity.ExerciseEntity;

import java.util.List;

public interface ExerciseService {
    ExerciseEntity createExercise(ExerciseEntity exercise);
    List<ExerciseEntity> readExercise();
    void deleteExercise(Long id);
}
