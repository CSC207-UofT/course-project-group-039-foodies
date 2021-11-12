package main.java.Gateways.RecipeAPI.JSONComponents;

import main.java.Gateways.RecipeAPI.JSONObject;

import java.util.Arrays;
import java.util.Iterator;

public class JSONString extends JSONObject {
    String element;
    public JSONString(String element) {
        this.element = element;
    }

    /**
     * Return the number of elements stored
     * @return The number 1
     */
    @Override
    protected int size() {
        return 1;
    }

    /**
     * Return the JSONObject stored at index i, which is null
     * @param i The index to check
     * @return The element at index i, null
     */
    @Override
    protected JSONObject index(int i) {
        return null;
    }

    /**
     * Return the JSONObject corresponding to a header, which is always null
     * @param header The key to check
     * @return The corresponding value, null
     */
    @Override
    protected JSONObject get(String header) {
        return null;
    }

    /**
     * Return a string representing the object stored
     * @return A string representation of the JSONObject
     */
    @Override
    public String toString() {
        return element;
    }

    /**
     * Return an iterator over the one string stored
     * @return An iterator over the stored elements
     */
    @Override
    public Iterator<JSONObject> iterator() {
        JSONObject[] arr = new JSONObject[]{this};
        return Arrays.stream(arr).iterator();
    }
}

