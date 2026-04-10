package com.clarillion.MealPlanAPI.Entity;

import com.clarillion.MealPlanAPI.Exceptions.ConversionAlreadyExistsException;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Ingredient {
    private int id;
    private String name;
   // private Map<Locale, String> translations;

    private List<String> tags;
    private nutriInfo nutrients;

    private String unit;
    private Map<String, Double> conversions;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getTags() {
        return List.copyOf(tags);
    }

    public nutriInfo getNutrients() {
        return nutrients;
    }

    public String getUnit() {
        return unit;
    }

    public Map<String, Double> getConversions() {
        return Map.copyOf(conversions);
    }

    public void addConversion(String unit, double factor){
        if (conversions.containsKey(unit)) throw new ConversionAlreadyExistsException();
    }
}
