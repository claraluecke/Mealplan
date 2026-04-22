package com.clarillion.MealPlanAPI.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="recipe")
public class Recipe {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @OneToMany( mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<RecipeIngredient> ingredients;
    @Column
    private String text;
    @Column
    private int nrPeople;
    @Column
    private List<String> tags;

    public List<String> getTags() {
        return List.copyOf(tags);
    }


    public List<RecipeIngredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public String getText() {
        return text;
    }

    public int getNrPeople() {
        return nrPeople;
    }
}
