package com.clarillion.MealPlanAPI.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe {
    private Map<Ingredient, Double> ingredients;
    private String text;
    private int nrPeople;
    private List<String> tags;

    public List<String> getTags() {
        return List.copyOf(tags);
    }


    public Map<Ingredient, Double> getIngredients() {
        return new HashMap<>(ingredients);
    }

    public String getText() {
        return text;
    }

    public int getNrPeople() {
        return nrPeople;
    }
}
