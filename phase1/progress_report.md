# PROGRESS REPORT

## Open Questions that our group needs assistance with
1) How do we cleanly separate controllers from the GUI, to maintain the single responsibility principle?
- If we were to do this using commands, how do we get the GUI to have well formatted output?

2) Some of our methods take 4+ parameters, what is the best way to deal with this?

## What has worked well so far with the design?
1) Packaging by Layer followed by Components
- This has worked in that we are more likely to adhere to the Clean Architecture while we develop the programme and it is easier to find and fix any areas where it was not followed. Furthermore, separating by components afterwards works well as it means that we can manage the visibility of parts of our code.

## A summary of what each group member has been working on and plans to work on next
Judy
- I have mostly worked on Group related classes for phase 1 (implemented Group, GroupManager, GroupCSVReader, GroupCSVReaderTest, and some groups.csv). I have also helped Michelle in implementing some of the Recipebook tests such as RecipeBookManager and SubRecipeBookManager tests. For the last two days, I have worked on refactoring GroupCommands so that we can use CSV methods in the GroupCommands.
- For phase 2, I will be working on refactoring existing Group Commands and implementing the methods to connect Recipebook to the group entities. 

Dohyun
- In Phase 1: Mainly focused on filtering and sorting algorithms of our program. Implemented AllergyFilter class, ServingsFilter class, ServingSort class and ServingComparator class, Sort interface, RatingSort class and RatingComparator class, test classes for all the classes that I implemented in Phase 1. Modified filter and sort tests to use RecipeCollection instead of DatabaseManager, filter and sort interfaces so that they get an array of recipes directly when calling filter/sort method not when initializing, and all codes that I implemented to work with modified filter and sort interfaces. Added Javadoc for all classes and interfaces that I implemented in Phase 0 and 1. Organized the test classes, using packaging by components (e.g. FilterTests and SortTests). Added design decisions and design patterns into the Design Document.
- In Phase 2: If our online database contains calories, modify the Recipe to store calories and implement CalorieFilter and CalorieSort. Since a database of recipes can have a huge amount of recipes, I will try to improve the runtime efficiency of filters and sorts. Improve dependency between the codes related to filters and sorts.

Mark
- Starting by refactoring the RecipeDatabase and DatabaseManager out, building the RecipeFactory, RecipeCollection, and RecipeCSVReader to replace them. Built the CSVReader class to read CSV files, and the UserCSVReader to store users permanently. Built the RecipeGateway and JSON classes to allow recipes to be added to the recipes.csv file automatically. Built commands to interact with sorts and filters. Refactored the GUI and CLI to extend a UserInterface abstract class so that they can both execute Commands. Did some basic refactoring and bug fixes at the end.
- I plan to refactor how the GUI and CLI operate internally to make the implementation more SOLID, create a UserFactory to solve dependency issues, and implement an observer design pattern to allow RecipeBook and PreferenceBook to coordinate.

Emily 
- Heavily focused on implementing Group related classes and commands including Group, GroupManager, GroupFactory (using the Factory Design Pattern), Group tests and a number of commands. Group class and GroupFactory class were modified based on group member’s feedback. 
- I will continue to work on implementing a few more Group commands with Recipebook and add them to GUI. 

Helena

Michelle

Milica
* ##### TASKS DONE:
  * I created and added updates to PreferenceBook, PreferenceBookCSVReader, the UserPreferencesCommands, 
  * I added rating functionality to Recipe and RecipeCSVReader
  * I made some minor changes to a few other CLI commands
  * I made a powerpoint for the presentation

* ##### NEXT STEPS:
  * I will add more preference options to PreferenceBook (UpdateDietCommand)
  * I will create comprehensive tests for PreferenceBook related methods
  * I will help my teammates with any outstanding work
