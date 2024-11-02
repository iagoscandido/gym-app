package com.iago.gym_tracker.model;
import com.iago.gym_tracker.EquipmentEnum;
import com.iago.gym_tracker.MuscleEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exercise", schema = "public")
public class ExerciseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "muscles", nullable = false, columnDefinition = "varchar")
    private List<MuscleEnum> muscles;
    @Enumerated(EnumType.STRING)
    @Column(name = "equipment", nullable = false, columnDefinition = "varchar")
    private EquipmentEnum equipment;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "exercise_id", referencedColumnName = "id")
    private List<ExecutionModel> executions;
}
