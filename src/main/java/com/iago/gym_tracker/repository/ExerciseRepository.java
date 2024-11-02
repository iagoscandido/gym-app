package com.iago.gym_tracker.repository;

import com.iago.gym_tracker.model.ExerciseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseModel, Long> {

}
