package org.fullstack.trainsys.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.fullstack.trainsys.enums.WeekDay;

import java.util.List;


@Data
@Entity
@Table(name = "workouts")
public class WorkoutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "workoutStudent", joinColumns = @JoinColumn(name = "workout_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    @Column(nullable = false)
    private List<StudentEntity> students;

    @ManyToMany
    @JoinTable(name = "workoutExecise", joinColumns = @JoinColumn(name = "workout_id"), inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    @Column(nullable = false)
    private List<ExerciseEntity> exercises;

    @Column(name = "repetitions", nullable = false)
    private Integer repetitions;

    @Column(name = "weight", nullable = false)
    private Float weight;

    @Column(name = "break_time", nullable = false)
    private Integer break_time;

    @Enumerated(EnumType.STRING)
    private WeekDay day;

    @Column(name = "observations")
    private String observations;

    @Column(name = "time", nullable = false)
    private Integer time;
}
