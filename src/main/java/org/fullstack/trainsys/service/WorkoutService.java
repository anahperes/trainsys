package org.fullstack.trainsys.service;

import org.fullstack.trainsys.entity.WorkoutEntity;

import java.util.List;


public interface WorkoutService {
    WorkoutEntity createWorkout(WorkoutEntity workout);

    // List<WorkoutEntity> readStudentWorkout (Long student_id);
}
