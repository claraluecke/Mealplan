package com.clarillion.MealPlanAPI.rest;

import com.clarillion.MealPlanAPI.dao.IngredientRepository;
import com.clarillion.MealPlanAPI.dao.RecipeRepository;
import com.clarillion.MealPlanAPI.entity.Ingredient;
import com.clarillion.MealPlanAPI.entity.Recipe;
import com.clarillion.MealPlanAPI.entity.RecipeIngredient;
import com.clarillion.MealPlanAPI.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/recipes")
public class RecipeController {
    private final RecipeRepository repo;
    private final IngredientRepository ingRepo;
    private final RecipeService rs;
    public RecipeController (RecipeRepository repo, IngredientRepository ingRepo, RecipeService rs){
        this.repo = repo; this.ingRepo = ingRepo; this.rs = rs;
    }

    @GetMapping
    public List<Recipe> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public Recipe create(@RequestBody Recipe req){

        return rs.save(req);
    }


}
