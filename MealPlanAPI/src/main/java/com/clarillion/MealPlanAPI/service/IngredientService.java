package com.clarillion.MealPlanAPI.service;

import com.clarillion.MealPlanAPI.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findall();
    public Ingredient save(Ingredient theIngredient);
    public Ingredient findbyId(int id);
    public void deleteById(int id);

}
