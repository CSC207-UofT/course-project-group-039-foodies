package main.java.Gateways.RecipeAPI;

import java.util.Iterator;

/**
 * A composite that represents a parsed JSON string
 * The components can be an array, a map, or a string
 */
public abstract class JSONObject implements Iterable<JSONObject> {
    protected abstract int size();
    protected abstract JSONObject index(int i);
    protected abstract JSONObject get(String header);
    public abstract Iterator<JSONObject> iterator();
}

