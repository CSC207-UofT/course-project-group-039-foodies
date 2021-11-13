package main.java.Filters;

import main.java.Entities.Recipe;

public interface Filter {
    Recipe[] filter(Recipe[] recipes);
}
