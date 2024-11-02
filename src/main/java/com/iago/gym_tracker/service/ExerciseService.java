package com.iago.gym_tracker.service;

import com.iago.gym_tracker.enums.EquipmentEnum;
import com.iago.gym_tracker.dto.ExecutionDto;
import com.iago.gym_tracker.dto.ExerciseDto;
import com.iago.gym_tracker.dto.MuscleDto;
import com.iago.gym_tracker.model.ExecutionEntity;
import com.iago.gym_tracker.model.ExerciseEntity;
import com.iago.gym_tracker.model.MuscleEntity;
import com.iago.gym_tracker.repository.ExerciseRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository repository;

    public ExerciseEntity create(@Valid ExerciseDto dto) {

        log.info("{}", dto);

        ExerciseEntity entity = new ExerciseEntity();
        entity.setName(dto.getName());
        entity.setEquipment(EquipmentEnum.valueOf(dto.getEquipment()));
        entity.setName(dto.getName());
        List<MuscleEntity> muscles = dto.getMuscles().stream().map(this::mapToMuscleModel).toList();
        entity.setMuscles(muscles);
        List<ExecutionEntity> executions = dto.getExecutions().stream().map(this::mapToExecutionModel).toList();
        entity.setExecutions(executions);

        return repository.save(entity);
    }


    private ExecutionEntity mapToExecutionModel(ExecutionDto dto) {
        ExecutionEntity model = new ExecutionEntity();
        model.setWeight(dto.getWeight());
        model.setRepetitions(dto.getRepetitions());
        model.setRestTime(dto.getRestTime());
        model.setSets(dto.getSets());

        return model;
    }

    private MuscleEntity mapToMuscleModel(MuscleDto dto) {
        MuscleEntity model = new MuscleEntity();
        model.setName(dto.getName());
        return model;
    }


}
