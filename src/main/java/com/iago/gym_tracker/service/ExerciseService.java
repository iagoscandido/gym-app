package com.iago.gym_tracker.service;

import com.iago.gym_tracker.EquipmentEnum;
import com.iago.gym_tracker.MuscleEnum;
import com.iago.gym_tracker.dto.ExecutionDto;
import com.iago.gym_tracker.dto.ExerciseDto;
import com.iago.gym_tracker.model.ExecutionModel;
import com.iago.gym_tracker.model.ExerciseModel;
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

    public ExerciseModel create(@Valid ExerciseDto dto) {

        log.info("{}", dto);

        ExerciseModel entity = new ExerciseModel();
        entity.setName(dto.getName());
        entity.setEquipment(EquipmentEnum.valueOf(dto.getEquipment()));
        entity.setMuscles(dto.getMuscles().stream().map(MuscleEnum::valueOf).toList());
        entity.setName(dto.getName());

        List<ExecutionModel> executions = dto.getExecutions().stream().map(this::mapToExecutionModel).toList();
        entity.setExecutions(executions);

        return repository.save(entity);
    }


    private ExecutionModel mapToExecutionModel(ExecutionDto dto) {
        ExecutionModel model = new ExecutionModel();
        model.setWeight(dto.getWeight());
        model.setRepetitions(dto.getRepetitions());
        model.setRestTime(dto.getRestTime());
        model.setSets(dto.getSets());

        return model;
    }


}
