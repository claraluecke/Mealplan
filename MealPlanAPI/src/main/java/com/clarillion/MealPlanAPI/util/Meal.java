package com.clarillion.MealPlanAPI.util;

import com.clarillion.MealPlanAPI.Entity.Ingredient;
import com.clarillion.MealPlanAPI.Entity.Recipe;

import java.util.Map;

public class Meal {
    private Recipe recipe;
    private int nrPeople;

    public Map<Ingredient, Double> getIngrList() {
        return ingrList;
    }

    public int getNrPeople() {
        return nrPeople;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    Map<Ingredient, Double> ingrList;

    public Meal(Recipe recipe, int nrPeople) {
        this.recipe = recipe;
        this.nrPeople = nrPeople;

        double quotient = (double)nrPeople/recipe.getNrPeople();
        ingrList= recipe.getIngredients();
        for (Ingredient ingr : ingrList.keySet())
            ingrList.put(ingr,ingrList.get(ingr)*quotient);

    }
}
