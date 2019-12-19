package org.restaurant.models;

import java.util.ArrayList;
import java.util.List;

public class OrderR {

    private String orderOwner;
    private List<Meal> mealList;

    public OrderR() {
        mealList = new ArrayList<>();
    }

    public OrderR(String orderOwner, List<Meal> mealList) {
        this.orderOwner = orderOwner;
        this.mealList = mealList;
    }

    public String getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(String orderOwner) {
        this.orderOwner = orderOwner;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

}

