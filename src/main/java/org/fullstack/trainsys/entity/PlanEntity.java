package org.fullstack.trainsys.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.fullstack.trainsys.enums.TypePlan;

import java.util.List;

@Data
@Entity
@Table(name = "plans")
public class PlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypePlan plan;

    @OneToMany(mappedBy = "plans")
    private List<UserEntity> users;

}
