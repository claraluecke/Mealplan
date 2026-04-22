package com.clarillion.MealPlanAPI.entity;

import jakarta.persistence.*;

@Entity
public class UnitConversion {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;

    @Column
    String unit;

    @Column
    double quotient;

}
