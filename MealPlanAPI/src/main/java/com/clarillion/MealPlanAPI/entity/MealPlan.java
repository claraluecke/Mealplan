package com.clarillion.MealPlanAPI.entity;

import com.clarillion.MealPlanAPI.exception.NoValidRecipeException;
import com.clarillion.MealPlanAPI.entity.embedded.Meal;
import com.clarillion.MealPlanAPI.dto.MealRequest;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class MealPlan {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    List<RecipeIngredient> ingrList;

    List<Meal> MealList;
    // todo: rework as sql query class?
    Set<Recipe> mpCookBook;
    List<Recipe> recipeList;

//    MealPlan(List<MealRequest> mealInfo, Set<Recipe>... cookbooks){
//        mpCookBook = new HashSet<Recipe>();
//        for (Set<Recipe> cb : cookbooks) mpCookBook.addAll(cb);
//        for (MealRequest mr : mealInfo){
//            Meal currmeal = findRecipe(mr);
//            MealList.add(currmeal);
//        }
//    }


//    public Meal replaceMeal(Meal m, MealRequest mr){
//        removeFromIngrList(m);
//        int idx = MealList.indexOf(m);
//        Meal newMeal = findRecipe(mr);
//        addToIngrList(newMeal);
//        MealList.set(idx, newMeal);
//        return newMeal;
//    }
// todo: rewrite for correct type
//    private void removeFromIngrList(Meal m) {
//        List<RecipeIngredient> mealIngr = m.getIngrList();
//        for (RecipeIngredient i : mealIngr){
//            ingrList.put(i,ingrList.get(i)-mealIngr.get(i));
//            if (ingrList.get(i)==0) ingrList.remove(i);
//        }
//    }

//    private void addToIngrList(Meal m) {
//        List<RecipeIngredient> mealIngr = m.getIngrList();
//        for (RecipeIngredient i : mealIngr){
//            if (ingrList.contains(i.getIngredient())) ingrList.setAmount(ingrList.getAmount(i.getIngredient)+mealIngr.get(i));
//            else ingrList.put(i, mealIngr.get(i));
//        }
//    }

//    private Meal findRecipe(MealRequest mealInfo) {
//        // todo : randomize
//        for (Recipe r : mpCookBook){
//            if (mealInfo.checkRecipe(r) && !recipeList.contains(r)) {
//                recipeList.add(r);
//                Meal m = new Meal(r, mealInfo.getNrPeople());
//                //addToIngrList(m);
//                return m;
//            }
//        }
//        throw new NoValidRecipeException();
//    }


}
