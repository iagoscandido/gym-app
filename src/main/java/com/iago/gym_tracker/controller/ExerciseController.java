package com.iago.gym_tracker.controller;

import com.iago.gym_tracker.dto.ExerciseDto;
import com.iago.gym_tracker.model.ExerciseModel;
import com.iago.gym_tracker.service.ExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/exercise")
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService service;

    @PostMapping("/")
    public Long createExercise(@Valid @RequestBody ExerciseDto requestBody) {
        ExerciseModel exercise = service.create(requestBody);
        return exercise.getId();
    }
}