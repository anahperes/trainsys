package org.fullstack.trainsys.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_birth", nullable = false)
    private Date date_birth;

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private  String cpf;

    @Column(name = "contact", length = 20, nullable = false)
    private String contact;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "neighborhood", length = 50)
    private String neighborhood;

    @Column(name = "number", length = 30)
    private String number;

    @Column(name = "street", length = 30)
    private String street;

    @Column(name = "state", length = 2)
    private String state;

    @Column(name = "cep", length = 20)
    private String cep;

    @ManyToMany(mappedBy = "students")
    private List<WorkoutEntity> workouts;
}