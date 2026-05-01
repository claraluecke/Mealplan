package com.clarillion.MealPlanAPI.service;

import com.clarillion.MealPlanAPI.entity.Ingredient;
import com.clarillion.MealPlanAPI.entity.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> findall();
    public Recipe save(Recipe theRecipe);
    public Recipe findbyId(int id);
    public void deleteById(int id);
}
