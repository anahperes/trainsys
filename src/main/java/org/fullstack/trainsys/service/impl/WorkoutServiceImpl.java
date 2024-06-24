package org.fullstack.trainsys.service.impl;

import org.fullstack.trainsys.entity.WorkoutEntity;
import org.fullstack.trainsys.repository.WorkoutRepository;
import org.fullstack.trainsys.service.WorkoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    private static final Logger logger = LoggerFactory.getLogger(WorkoutServiceImpl.class);

    private final WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public WorkoutEntity createWorkout(WorkoutEntity workout) {
        logger.info("Cadastrado novo treino: {}", workout);
        return workoutRepository.save(workout);
    }
}
