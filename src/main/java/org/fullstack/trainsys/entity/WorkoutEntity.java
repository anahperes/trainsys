package org.fullstack.trainsys.entity;

import jakarta.persistence.*;
import lombok.Data;
import enums.

@Data
@Entity
@Table(name = "workouts")
public class WorkoutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    private StudentEntity student;

    @Column(name = "exercise_id", nullable = false)
    private ExerciseEntity exercise;

    @Column(name = "repetitions", nullable = false)
    private Integer repetitions;

    @Column(name = "weight", nullable = false)
    private Float weight;

    @Column(name = "break_time", nullable = false)
    private Integer break_time;

    //@Enumerated(EnumType.STRING)
    private WeekDay day;

    @Column(name = "observations")
    private String observations;

    @Column(name = "time", nullable = false)
    private Integer time;
}
