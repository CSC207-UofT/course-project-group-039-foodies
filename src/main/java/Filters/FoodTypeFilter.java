package main.java.Filters;

import main.java.Entities.Recipe;

import java.util.HashMap;
import java.util.Map;

public class FoodTypeFilter implements Filter{
    private final HashMap<Integer, Recipe> dataMap;
    private final String foodType;

    public FoodTypeFilter(HashMap<Integer, Recipe> map, String foodType) {
        this.dataMap = map;
        this.foodType = foodType;
    }

    @Override
    public HashMap<Integer, Recipe> filter() {
        HashMap<Integer, Recipe> result = new HashMap<>();
        for (Map.Entry<Integer, Recipe> entry : this.dataMap.entrySet()) {
            if (entry.getValue().getFoodType().equals(foodType)) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}