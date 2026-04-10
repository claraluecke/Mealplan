package com.clarillion.MealPlanAPI.Entity;

import com.clarillion.MealPlanAPI.Exceptions.NoValidRecipeException;
import com.clarillion.MealPlanAPI.util.Meal;
import com.clarillion.MealPlanAPI.util.MealRequest;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class MealPlan {
    Map<Ingredient, Double> ingrList;
    List<Meal> MealList;
    // todo: rework as sql query class?
    Set<Recipe> mpCookBook;
    List<Recipe> recipeList;

    MealPlan(List<MealRequest> mealInfo, Set<Recipe>... cookbooks){
        mpCookBook = new HashSet<Recipe>();
        for (Set<Recipe> cb : cookbooks) mpCookBook.addAll(cb);
        for (MealRequest mr : mealInfo){
            Meal currmeal = findRecipe(mr);
            MealList.add(currmeal);
        }
    }


    public Meal replaceMeal(Meal m, MealRequest mr){
        removeFromIngrList(m);
        int idx = MealList.indexOf(m);
        Meal newMeal = findRecipe(mr);
        addToIngrList(newMeal);
        MealList.set(idx, newMeal);
        return newMeal;
    }

    private void removeFromIngrList(Meal m) {
        Map<Ingredient,Double> mealIngr = m.getIngrList();
        for (Ingredient i : mealIngr.keySet()){
            ingrList.put(i,ingrList.get(i)-mealIngr.get(i));
            if (ingrList.get(i)==0) ingrList.remove(i);
        }
    }

    private void addToIngrList(Meal m) {
        Map<Ingredient,Double> mealIngr = m.getIngrList();
        for (Ingredient i : mealIngr.keySet()){
            if (ingrList.containsKey(i)) ingrList.put(i,ingrList.get(i)+mealIngr.get(i));
            else ingrList.put(i, mealIngr.get(i));
        }
    }

    private Meal findRecipe(MealRequest mealInfo) {
        // todo : randomize
        for (Recipe r : mpCookBook){
            if (mealInfo.checkRecipe(r) && !recipeList.contains(r)) {
                recipeList.add(r);
                Meal m = new Meal(r, mealInfo.getNrPeople());
                addToIngrList(m);
                return m;
            }
        }
        throw new NoValidRecipeException();
    }


}
