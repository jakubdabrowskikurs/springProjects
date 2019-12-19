package org.restaurant.models;

public class UserRequest {

    private String name;
    private String mealName;

    public UserRequest() {
    }

    public UserRequest(String name, String mealName) {
        this.name = name;
        this.mealName = mealName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }
}