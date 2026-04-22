package com.clarillion.MealPlanAPI.rest;

import com.clarillion.MealPlanAPI.dao.IngredientRepository;
import com.clarillion.MealPlanAPI.entity.Ingredient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    private final IngredientRepository repo;

    public IngredientController (IngredientRepository repo){
        this.repo = repo;
    }

    @GetMapping
    public List<Ingredient> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public Ingredient create(@RequestBody Ingredient theIngredient){
        return repo.save(theIngredient);
    }
}
