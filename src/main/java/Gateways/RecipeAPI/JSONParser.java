package main.java.Gateways.RecipeAPI;

import main.java.Gateways.RecipeAPI.JSONComponents.JSONList;
import main.java.Gateways.RecipeAPI.JSONComponents.JSONMap;
import main.java.Gateways.RecipeAPI.JSONComponents.JSONString;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Parses a string into a JSONObject using a state design pattern
 */
public class JSONParser {
    String json;
    int index = 0;  // The current index being checked

    public JSONParser(String json) {
        this.json = json;
    }

    /**
     * Parse the beginning of a string representing a JSONObject
     * This is the start state
     * @return A JSONObject representing the string
     */
    public JSONObject parseLine() {
        char characterRead = json.charAt(index);
        switch (characterRead) {
            case '{':
                index ++;
                return new JSONMap(parseMap());
            case '[':
                index ++;
                return new JSONList(parseArray());
            case ' ':
            case ':':
            case ',':
                index ++;
                return parseLine();
            default:
                return new JSONString(parseString());
        }
    }

    /**
     * Parse the beginning of a map until the end of the map
     * @return A JSONObject representing the string
     */
    private HashMap<String, JSONObject> parseMap() {
        if (json.charAt(index) == '}') {
            index ++;
            return new HashMap<>();
        }

        if (json.charAt(index) == '"') {
            String key = parseString();
            JSONObject value = parseLine();
            HashMap<String, JSONObject> rest = parseMap();
            rest.put(key, value);

            return rest;
        } else {
            index ++;
            return parseMap();
        }
    }

    /**
     * Parse the beginning of an array until the end of the array
     * @return A JSONObject representing the array
     */
    private ArrayList<JSONObject> parseArray() {
        if (json.charAt(index) == ']') {
            index ++;
            return new ArrayList<>();
        }
        JSONObject entry = parseLine();
        ArrayList<JSONObject> rest = parseArray();
        rest.add(0, entry);

        return rest;
    }

    /**
     * Parse a string literal within the JSON
     * @return A JSONObject representing the string
     */
    private String parseString() {
        if (json.charAt(index) == '"') {
            index ++;
            return parseStringWithQuotes();
        }
        return parseStringWithoutQuotes();
    }

    /**
     * Parse a string literal within the JSON covered by double quotes
     * @return A JSONObject representing the string
     */
    private String parseStringWithQuotes() {
        if (json.charAt(index) == '"') {
            index ++;
            return "";
        }
        if (json.charAt(index) == '\\') {
            index ++;
            if (json.charAt(index) == '\"') {
                index ++;
                return "\"" + parseStringWithQuotes();
            } else if (json.charAt(index) == 'n') {
                index ++;
                return "\n" + parseStringWithQuotes();
            }
        }
        char characterRead = json.charAt(index);
        index ++;
        return characterRead + parseStringWithQuotes();
    }

    /**
     * Parse a string literal within the JSON not covered by double quotes
     * @return A JSONObject representing the string
     */
    private String parseStringWithoutQuotes() {
        if (json.charAt(index) == ',' || json.charAt(index) == ' ') {
            index ++;
            return "";
        }
        if (json.charAt(index) == '}' || json.charAt(index) == ']') {
            return "";
        }
        char characterRead = json.charAt(index);
        index ++;
        return characterRead + parseStringWithoutQuotes();
    }
}
