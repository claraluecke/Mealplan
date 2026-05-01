package com.clarillion.MealPlanAPI.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue
    private int id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;

    @Column
    private Double amount;

    public int getId() {
        return id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void setIngredient(Ingredient i) {
        this.ingredient = i;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }



    public Ingredient getIngredient() {
        return ingredient;
    }
}