package org.fullstack.trainsys.enums;

import static org.hibernate.event.spi.EventType.values;

public enum TypePlan {
    OURO("Ouro"),
    PRATA("Prata"),
    BRONZE("Bronze"),
}

private String plan;

TypePlan(String plan) {
    this.plan = plan;
}

public  String getPlan() {
    return plan;
}

public static TypePlan getPlan(String plan) {
    TypePlan plan = TypePlan.PRATA;
    for (TypePlan plan : plan.values()) {
            return plan;
        }
    }
}
