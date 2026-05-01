package com.clarillion.MealPlanAPI.dto;

import com.clarillion.MealPlanAPI.entity.Ingredient;
import com.clarillion.MealPlanAPI.entity.Recipe;
import com.clarillion.MealPlanAPI.entity.RecipeIngredient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MealRequest {
    private int nrPeople;
    private List<Ingredient> includeIngr;
    private List<Ingredient> excludeIngr;
    private List<String> includeTags = new ArrayList<>();
    private List<String> excludeTags = new ArrayList<>();

    public List<Ingredient> getExcludeIngr() {
        return List.copyOf(excludeIngr);
    }
    public List<Ingredient> getIncludeIngr() {
        return List.copyOf(includeIngr);
    }
    public int getNrPeople() {
        return nrPeople;
    }

//    public boolean checkRecipe(Recipe r){
//        for (Ingredient i: includeIngr){
//            if (!r.getIngredients().stream().map(RecipeIngredient::getIngredient)
//                    .collect(Collectors.toSet()).contains(i)) return false;
//        }
//        for (Ingredient i: excludeIngr){
//            if (r.getIngredients().stream().map(RecipeIngredient::getIngredient)
//                    .collect(Collectors.toSet()).contains(i)) return false;
//        }
//        for (String tag: includeTags){
//            if (!r.getTags().contains(tag)) return false;
//        }
//        for (String tag: excludeTags){
//            if (r.getTags().contains(tag)) return false;
//        }
//        return true;
//    }

    public MealRequest(int nrPeople, List<Ingredient> includeIngr, List<Ingredient> exclude) {
        this.nrPeople = nrPeople;
        this.includeIngr = includeIngr;
        this.excludeIngr = exclude;
    }

}
