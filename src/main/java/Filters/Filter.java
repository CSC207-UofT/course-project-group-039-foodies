package main.java.Filters;

import main.java.Entities.Recipe;

import java.util.HashMap;

public interface Filter {
    HashMap<Integer, Recipe> filter();
}