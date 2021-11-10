package main.java.Gateways.RecipeAPI.JSONComponents;

import main.java.Gateways.RecipeAPI.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class JSONList extends JSONObject {
    ArrayList<JSONObject> elements;
    public JSONList(ArrayList<JSONObject> elements) {
        this.elements = elements;
    }

    /**
     * @return The number of elements in the JSON list
     */
    @Override
    protected int size() {
        return elements.size();
    }

    /**
     * Gets the object at index i
     * @param i The index to check
     * @return The JSONObject stored at index i
     */
    @Override
    protected JSONObject index(int i) {
        return elements.get(i);
    }

    /**
     * Returns the JSONObject corresponding to a key. This is null as we are in an array.
     * @param header The header we are checking
     * @return null, as an array doesn't store headers
     */
    @Override
    protected JSONObject get(String header) {
        return null;
    }

    /**
     * Returns an iterator over all the JSONObjects stored
     * @return An iterator
     */
    @Override
    public Iterator<JSONObject> iterator() {
        return elements.iterator();
    }
}
