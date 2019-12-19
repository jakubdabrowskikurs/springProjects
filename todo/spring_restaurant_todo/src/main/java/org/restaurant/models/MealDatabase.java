package org.restaurant.models;

import java.util.ArrayList;
import java.util.List;

public class MealDatabase {

    public List<Meal> getMeals(){
        List<Meal> mealList = new ArrayList<>();
        mealList.add(new Meal("Spagetti", 14));
        mealList.add(new Meal("Rizotto", 12));
        mealList.add(new Meal("Naleśniki", 8));
        mealList.add(new Meal("Schabowy", 14));
        mealList.add(new Meal("Pieczeń", 18));
        mealList.add(new Meal("Zupa",6));
        mealList.add(new Meal("Barszcz",7));
        mealList.add(new Meal("Kluski",9));
        mealList.add(new Meal("Zapiekanka",5));
        mealList.add(new Meal("Gulasz",19));
        mealList.add(new Meal("Sok",4));
        mealList.add(new Meal("Kapuśniak",5));
        mealList.add(new Meal("Rosół",5));
        mealList.add(new Meal("Knedle",9));
        mealList.add(new Meal("Pizza",22));
        mealList.add(new Meal("Kompot",2));
        return mealList;
    }

}