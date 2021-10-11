package com.ledzion.jobofferservice.model;

public enum Category {

    IT("IT"),
    FOOD_DRINKS ("Food & Drinks"),
    OFFICE ("Office"),
    COURIER ("Courier"),
    SHOP_ASSISTANT("Shop assistant");

    private String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
