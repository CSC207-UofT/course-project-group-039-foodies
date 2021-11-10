package main.java.Gateways.RecipeAPI.JSONComponents;

import main.java.Gateways.RecipeAPI.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

public class JSONMap extends JSONObject {
    HashMap<String, JSONObject> elements;
    public JSONMap(HashMap<String, JSONObject> elements) {
        this.elements = elements;
    }

    /**
     * Return the number of JSONObjects stored in the JSONObject
     * @return The number of elements stored
     */
    @Override
    protected int size() {
        return elements.size();
    }

    /**
     * Return the element stored at index i, which is null as a map is unordered
     * @param i The index to check
     * @return The element at index i, which is null
     */
    @Override
    protected JSONObject index(int i) {
        return null;
    }

    /**
     * Return the JSONObject corresponding to a certain header
     * @param header The name of the key
     * @return The corresponding value
     */
    @Override
    protected JSONObject get(String header) {
        return this.elements.get(header);
    }

    /**
     * Return an iterator over all JSONObjects stored
     * @return An iterator over the elements
     */
    @Override
    public Iterator<JSONObject> iterator() {
        return elements.values().iterator();
    }
}
