package com.clarillion.MealPlanAPI.entity;

import jakarta.persistence.*;

@Entity
public class Tag {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    @Column
    String tag;

}
