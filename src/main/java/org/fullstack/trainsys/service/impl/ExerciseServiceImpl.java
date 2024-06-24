package org.fullstack.trainsys.service.impl;

import org.fullstack.trainsys.entity.ExerciseEntity;
import org.fullstack.trainsys.exceptions.NotFoundException;
import org.fullstack.trainsys.repository.ExerciseRepository;
import org.fullstack.trainsys.service.ExerciseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private static final Logger logger = LoggerFactory.getLogger(ExerciseServiceImpl.class);
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public ExerciseEntity createExercise(ExerciseEntity exercise) {
        logger.info("Adicionado novo exercício: {}", exercise);
        return exerciseRepository.save(exercise);
    }

    @Override
    public List<ExerciseEntity> readExercise() {
        logger.info("Listando todos os exercícios");
        return exerciseRepository.findAll();
    }

    @Override
    public void deleteExercise(Long id) {
        logger.info("Deletando exercício com o id: {}", id);
        if(!exerciseRepository.existsById(id)) {
            logger.warn("Exercício não encontrado com o id: {}", id);
            throw new NotFoundException("Exercício não encontrado com o id " + id);
        } else {
            exerciseRepository.deleteById(id);
            logger.info("Exercício deletado com o id: {}", id);
        }
    }
}
