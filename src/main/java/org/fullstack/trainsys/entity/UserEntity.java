package org.fullstack.trainsys.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_birth", nullable = false)
    private Date date_birth;

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private  String cpf;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "plan_id", referencedColumnName = "id")
    private PlanEntity plan;

    @OneToMany(mappedBy = "users")
    @JsonManagedReference
    private List<ExerciseEntity> exercises;

    @OneToMany(mappedBy = "users")
    @JsonManagedReference
    private List<StudentEntity> students;
}
