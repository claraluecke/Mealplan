package com.clarillion.MealPlanAPI.entity.embedded;

import com.clarillion.MealPlanAPI.entity.Ingredient;
import com.clarillion.MealPlanAPI.entity.Recipe;
import com.clarillion.MealPlanAPI.entity.RecipeIngredient;

import java.util.List;
import java.util.Map;

public class Meal {
    private Recipe recipe;
    private int nrPeople;

    private List<RecipeIngredient> ingrList;

    public List<RecipeIngredient> getIngrList() {
        return List.copyOf(ingrList);
    }

    public int getNrPeople() {
        return nrPeople;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Meal(Recipe recipe, int nrPeople) {
        this.recipe = recipe;
        this.nrPeople = nrPeople;

        double quotient = (double)nrPeople/recipe.getNrPeople();
        ingrList= recipe.getIngredients();
        for (RecipeIngredient ingr : ingrList)
            ingr.setAmount(ingr.getAmount()*quotient);

    }
}
