package com.clarillion.MealPlanAPI.dao;

import com.clarillion.MealPlanAPI.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
