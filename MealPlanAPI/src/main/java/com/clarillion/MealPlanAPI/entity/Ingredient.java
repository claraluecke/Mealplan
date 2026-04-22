package com.clarillion.MealPlanAPI.entity;

import com.clarillion.MealPlanAPI.exception.ConversionAlreadyExistsException;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

   // private Map<Locale, String> translations;
    //private nutriInfo nutrients;

    @Column
    private String unit;

    @OneToMany(mappedBy = "ingredient",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<UnitConversion> conversions;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //public List<String> getTags() { return List.copyOf(tags);}

    //public nutriInfo getNutrients() {return nutrients; }

    public String getUnit() {
        return unit;
    }
// todo: rewrite for new type
//    public Map<String, Double> getConversions() {
//        return Map.copyOf(conversions);
//    }

//    public void addConversion(String unit, double factor){
//        if (conversions.containsKey(unit)) throw new ConversionAlreadyExistsException();
//    }
}
