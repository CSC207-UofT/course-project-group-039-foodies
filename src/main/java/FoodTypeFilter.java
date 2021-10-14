package main.java;

import java.util.HashMap;
import java.util.Map;

public class FoodTypeFilter implements Filter{
    private HashMap<Integer, Recipe> dataList;
    private String food_type;

    public FoodTypeFilter(HashMap<Integer, Recipe> map, String food_type) {
        this.dataList = map;
        this.food_type = food_type;
    }

    @Override
    public HashMap<Integer, Recipe> filter() {
        HashMap<Integer, Recipe> result = new HashMap<>();
        for (Map.Entry<Integer, Recipe> entry : this.dataList.entrySet()) {
            if (entry.getValue().getFoodType == food_type) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
