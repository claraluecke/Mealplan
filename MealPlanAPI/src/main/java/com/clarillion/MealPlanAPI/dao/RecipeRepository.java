package com.clarillion.MealPlanAPI.dao;

import com.clarillion.MealPlanAPI.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Integer> {
}
