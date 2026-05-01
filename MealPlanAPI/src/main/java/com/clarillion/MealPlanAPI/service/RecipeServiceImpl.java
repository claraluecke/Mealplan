package com.clarillion.MealPlanAPI.service;

import com.clarillion.MealPlanAPI.dao.IngredientRepository;
import com.clarillion.MealPlanAPI.dao.RecipeRepository;
import com.clarillion.MealPlanAPI.entity.Ingredient;
import com.clarillion.MealPlanAPI.entity.Recipe;
import com.clarillion.MealPlanAPI.entity.RecipeIngredient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{
    private final RecipeRepository repo;
    private final IngredientRepository ingRepo;
    public RecipeServiceImpl (RecipeRepository repo, IngredientRepository ingRepo){
        this.repo = repo; this.ingRepo = ingRepo;
    }


    @Override
    public List<Recipe> findall() {
        return List.of();
    }

    @Override
    public Recipe save(Recipe req) {
        Recipe recipe = new Recipe();
        recipe.setName(req.getName());
        recipe.setInstructions(req.getInstructions());
        recipe.setServings(req.getServings());

        List<RecipeIngredient> ingrs = new ArrayList<>();

        for (RecipeIngredient ri : req.getIngredients()){

            RecipeIngredient link = new RecipeIngredient();
            link.setRecipe(recipe);
            link.setAmount(ri.getAmount());
            link.setIngredient(ri.getIngredient());
            ingrs.add(link);
        }
        recipe.setIngredients(ingrs);
        return repo.save(recipe);
    }

    @Override
    public Recipe findbyId(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
