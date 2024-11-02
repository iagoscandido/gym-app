package com.iago.gym_tracker.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

public class ExerciseDto {
    @NotBlank(message = "a name must be provided")
    private String name;
    private List<String> muscles;
    private String equipment;
    private List<ExecutionDto> executions;
}

