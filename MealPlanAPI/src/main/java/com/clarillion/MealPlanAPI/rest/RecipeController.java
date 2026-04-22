package com.clarillion.MealPlanAPI.rest;

import com.clarillion.MealPlanAPI.dao.IngredientRepository;
import com.clarillion.MealPlanAPI.dao.RecipeRepository;
import com.clarillion.MealPlanAPI.entity.Ingredient;
import com.clarillion.MealPlanAPI.entity.Recipe;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/recipes")
public class RecipeController {
    private final RecipeRepository repo;

    public RecipeController (RecipeRepository repo){
        this.repo = repo;
    }

    @GetMapping
    public List<Recipe> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public Recipe create(@RequestBody Recipe theRecipe){
        return repo.save(theRecipe);
    }

}
