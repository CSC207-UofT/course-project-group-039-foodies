package main.java.UseCases.Filters;

import main.java.Entities.Recipe;

public interface Filter {
    Recipe[] filter(Recipe[] recipes);
}
