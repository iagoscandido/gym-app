package com.iago.gym_tracker.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
    @Table(name = "execution", schema = "public")
public class ExecutionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "weight", nullable = false)
    private Integer weight;
    @Column(name = "repetitions", nullable = false)
    private Integer repetitions;
    @Column(name = "sets", nullable = false)
    private Integer sets;
    @Column(name = "rest_time", nullable = false)
    private Integer restTime;
    @ManyToOne
    private ExerciseModel exercise;
}
