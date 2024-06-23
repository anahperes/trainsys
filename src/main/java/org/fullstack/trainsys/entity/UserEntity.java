package org.fullstack.trainsys.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

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
    @Column(name = "date_birth")
    private Date date_birth;

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private  String cpf;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @ManyToOne(optional = false)
    private PlanEntity plan_id;
}
