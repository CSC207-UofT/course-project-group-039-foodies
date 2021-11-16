# PHASE 1 : DESIGN DOCUMENT

## Summary of Specification

Our team aims to create a programme that is geared towards food lovers looking to make delicious, nutritious foods right in their kitchen.
The programme is able to match users to recipes based on a series of their preferences. Matches may be made based on likes/ dislikes, dietary restrictions and more. If no preferences are provided, these matches may also be made randomly.
Recommendations are done by filtering recipes from our database using the preferences provided to find the recipe that is the best match.
In the programme, users can :
* create subfolders of recipes that they would like to save, that is, create their own personal recipe book with different categories
* create groups where each group is assigned with a unique ID so they can add and remove users without any conflict
* create their own recipes and upload it to the database
* rate recipes that they have tried

The programme also has a feature where data from all users can be aggregated, analysed and be presented in the form of:
* most popular recipes in certain categories
* most highly rated recipes
* recipes rising in popularity


## UML MODEL
The UML model can be seen in the pdf in this directory.

## MAJOR DESIGN DECISIONS SUMMARY
There were several design decisions that had to be made during the development of this programme. The following is a summary of some of the design decisions we encountered:
* Removing the RecipeDatabase. _Why?_ Our programme was transitioning to a RecipeGateway that will be accessing recipes from an online database/source. In particular, we   isolated the following three main responsibilities of RecipeDatabase, replacing them with dedicated classes:
  * Creating a recipe object. This has been replaced with RecipeFactory. 
  * Holding a collection of recipes. This has been replaced with RecipeCollection. 
  * Accessing and modifying all the recipes in the database. This has been replaced with the RecipeCSVReader. 
  * _Why?_ RecipeDatabase was an entity when it should have been in the layer of Framework and Driver. Thus, the design was flawed. Furthermore, refactoring its responsibilities   out to other classes also makes the code more SOLID as it allows follows the Single Responsibility Principle.
* Using an interface rather than an abstract class for the filters and sorts. Implemented Filter interface, Sort interface, and several filtering/sorting algorithms (classes). _Why?_ Allows adding other filtering/sorting algorithms (classes) easily.
* Using adapter for filter/sort controllers. _Why?_ We can avoid changing the whole code that is related to the filtering and sorting whenever there is a change, eliminating a code smell.
* Using comparator classes for ServingsSort and RatingSort. _Why?_ to make code simple and easy to modify.
* Separating the storage or cumulative recipe ratings and individual recipe ratings. _Why?_ Initially, all rating information for a recipe could be accessed through a recipe object, and cumulative ratings were calculated by getting the average of the list of individual ratings. When storing the rating information in CSV files, we realized that the recipes.csv file would be too large to handle efficiently and if individual and cumulative ratings were linked, then deleting a user (thus deleting their individual ratings) would mess up the calculation of cumulative ratings.


## CLEAN ARCHITECTURE IN THE PROGRAM
All of our code dependencies only move from the outer levels inward. Code on the inner layers have no knowledge of methods on the outer layers. The variables, methods and classes that exist in the outer layers are not mentioned in the more inward levels. 
Our two external interfaces the GUI and the CLI only interact with our controller layer, which includes 34 commands and a number of gateways, as found in AdminCommands, GroupCommands, RecipeBookCommands, RecipeViewerCommands and UserPreferenceCommands, and the Gateways package. For the most part, every layer depends only on the layer below it, but there are some violations where entities are accessed directly from the controller and gateway layer in our code left to fix. Namely, the PreferenceBookCSVReader gateway uses the constructor for a PreferenceBook, which we can fix by creating a PreferenceBookFactory, and the RateRecipeCommand controller calls the getUsername getter method in the User entity.

As an example scenario walkthrough, we can look at what happens when the user decides to add a recipe to a subrecipe book. If either the CLI or GUI is used, the controller AddToSubRecipeBook would call its runAction method. Then, the RecipeCollectionFacade UseCase is used to find the recipe that the user inputted in the RecipeCollection of all recipes by calling findRecipe method within it. Internally, this calls the findRecipe method in the entity RecipeCollection, getting the appropriate recipe object, if it exists. 
We then create a recipeBookManager UseCase to be able to add to the user's recipeBook. Then, call the recipeBookManager.containsSubRecipeBook method to check if the subrecipebook inputted by the user exists, which then accesses the information within the entity from a UseCase. Then, RecipeBookManager.addRecipe method is called to add the recipe to the appropriate subrecipebook.
Finally, we store this information in the database by getting the singleton instance of the gateway RecipeBookCSVReader, and calling its updateRecipeBook method. This deletes the appropriate file line, then adds a new one without accessing any usecase or entity.
After all this executes, the User entity now stores an updated subrecipebook, and the database is updated accordingly as well.

## SOLID DESIGN PRINCIPLES IN THE PROGRAM
The following SOLID principles were used and some examples of its use are:

_Single-responsibility principle_:
  * The RecipeFactory class has only one responsibility, to create recipes and that responsibility has been taken out of other classes.
  * The GroupFactory also has only one responsibility– to create groups. We have taken out these responsibilities from Group class and added them to the GroupFactory to satisfy the single-responsibility principle.
  * However, a current flaw in the design is that the RecipeCollection class seems to have too many responsibilites, being responsible for adding, removing, finding, iterating, filtering, and sorting over a collection of recipes.

_Open–closed principle_:
  * It is easy to extend the functionality of our code while modifying very little of any of the existing source. For example:
  * It is easy to add new features that the user can interact with by simply creating a new class that inherits from the Command class.
  * Similarly, it is easy to add new pages in the CLI or GUI by simply creating a Page class, or a GUIPage respectively that implements this, then add references to these classes in the PageManager or appropriate GUIPage.
  * It is easy to add more ways to sort and filter all recipes by creating a new class that implements the Filter or Sort interfaces, as the strategy design pattern is used.
  * It is easy to extend the information stored in every user, every recipe, and every group without modifying any use case, we only need to add a place for this new data in the appropriate CSVReader, and add a handler in the appropriate factory.

_Liskov substitution principle_:
  * Filters and sorts can be interchanged safely, and the program would still run as intended.
  * Commands can all be interchanged with each other in the CLI, and the code would function as intended.
  * However, a current flaw in the design is that the GUI has no PageManager to manage how pages work, so running a command that uses the PageManager in the GUI would result in a NullPointerException, the Liskov substitution principle fails in this respect.

_Interface segregation principle_:
  * The filter and sort methods are segregated into separate interfaces instead of being placed in a general modifier interface.
  * The UserInterface abstract class enforces that its children only implement two methods, queryUser and displayMessage, the bare minimum a class responsible for interacting with the user must have.
  
_Dependency inversion principle_:
  * The code follows clean architecture strictly, and so abstractions never depend on how they are used.
  * Dependency injection is used, as described in the section on design patterns, to maintain this.


## PACKAGING STRATEGIES USED IN THE PROGRAM
We first _package by clean architecture layers_. This ensures that we follow the clean architecture structure as it is very easy to visualise the structure and find places where clean architecture is broken, and fix them. This also forces us to think about which layer a class is in before we even start coding. All in all, this makes it almost trivial to adhere to clean architecture.

Within each layer package, we _package by component_. This makes it very easy to find any class within a package and group together relevant classes. Moreover, in some places, we can use this to manage visibility and dependencies in our code. Components can be grouped together in a package and methods that should only be called internally can be protected. This is done in the JSONComponents package and the CLI package.


## SUMMARY OF DESIGN PATTERNS USED IN THE PROGRAM
The following design patterns were used in the programme:

_Strategy_:
* Used to create different types of filters with a filter method in the filter package
* Used to create different types of sorts with a sort method in the sort package
* Create different types of commands with a runAction method in the Commands package

_Factory_:
* Create recipes, in the RecipeFactory class, abstracting out the process of creating recipe codes
* Create groups, in the GroupFactory class, abstracting out the process of creating groups by assigning a unique group code
* Create user objects, in the UserFactory class
* Create a user representing a new account, in the AccountFactory class

_Dependency Injection_:
* The use case interfaces Sort and Filter are injected into the entity RecipeCollection so that it can use methods in a more concrete layer, without depending on their   implementation, allowing clean architecture to stay respected
* The UserInterface has setters to allow for the injection of RecipeCollections, PreferenceBook, etc.

_Facade_:
* The RecipeCollectionFacade is a facade Usecase that allows controllers to access methods in the entity without breaking clean architecture.
* The RecipeBook acts as a facade for the overall subrecipebook which contains all recipes the user adds to their individual subrecipebooks.
* The RecipeBookManager and SubRecipeBookManager act as facades, allowing controllers to access methods in the RecipeBook.
* The UserFactory is a facade for the User Constructor, allowing the code to respect clean architecture.

_Singleton_:
* This is used to create a single global instance of the children of CSVReader, namely the UserCSVReader, RecipeCSVReader, GroupCSVReader, and PreferenceCSVReader, RecipeBookCSVReader classes so that it can act as a static class while still having a state.
* Used in the Application class so that the GUI can have global access and a single state.

_Iterator_:
* Used in the RecipeCollection class so that the Recipes stored can be iterated over

_Composite_:
* To store and parse a json string in JSONObject. JSONObject is the component, with JSONList and JSONMap being composites, with JSONString being the leaf.

_State Pattern_:
* Used to parse a line of a csv file, in the CSVReader class, allowing for the csv file to store strings with commas that can be read easily and cleanly
* Used to parse a line of json in JSONParser

#### Design Patterns to be implemented in phase 2:

_Observer_:
* Make PrefenceBook and RecipeBook observers so that when a user rates a new recipe, both can be updated

#### Other Features to be added in phase 2:
Factories: 
* We currently have 4 factory classes, maybe we can create a factory interface.

PreferenceBook: 
* Add more preferences such as diet (ex, vegan, vegetarian, gluten free, halal, kosher)

## GITHUB FEATURES USED
* Extensive use of _pull requests_ to manage our main branch was made. All changes to the code base had to go through a pull request first and be reviewed by other team members before merging.
* _Reviews feature_ for some pull requests, like pull request #13, was used to highlight what specifically must be changed.
* _Github issues_ was used to highlight important problems with the code that must be discussed and fixed.


## TESTING DONE
* Almost every component has a test suite. For the most part, the code has been designed to be easily testable. Testing will continue to be done in Phase 2
* One way this is done is to utilize dependency injection wherever possible.
* An example of testing is the use of our own scanner object in the CLI, so that user input can be simulated.
* It is hard to test if the GUI displays and functions as intended, the only way currently would be either to test it indirectly through the CLI, or to run the code ourselves.


## REFACTORING OF CODE
A lot of the code was refactored in Phase 1. Some examples of these include the following: 
* The largest example of this is pull request #14 which completely replaces the incorrectly designed RecipeDatabase and DatabaseManager classes. As a consequence, we had to change many parts of the program such as test classes for filters and sorts.
* We exchanged any call of the Recipe constructor with a RecipeFactory in pull request #8, washing away a ‘duplicate code’ code smell.
* RecipeCollection is used instead of HashMap<Integer, Recipe> in the RecipeBook, and later the SubRecipeBook, washing away a ‘primitive obsession’ code smell. This is done in pull request #40.
* RecipeBook was refactored to store SubRecipeBooks, instead of directly storing Recipes in pull request #40.
* Pull request #45 fixes a bug that stopped RecipeBooks from being created when the user is, and fixes an issue with dependencies in the Command layer, as well as removing a bunch of dispensables.
* Pull request #35 refactors the CLI and GUI to both implement the same interface, allowing commands to be run on both of them.
* Pull request #49 refactors the code to fix a dependency issue by creating a UserFactory class.
* Pull request #48 refactors the code to fix a bug with removing recipes.
* Pull requests #49 and #50 refactor the code to fix dependency issues.
* However, there are still a few code smells in our code which we plan to solve in Phase 2:
  * Some code is repeated in the GUI and CLI, such as, the sign in code. This is done so that the display to the user is nicely formatted, and so the command isn’t called directly. In Phase 2, we could fix this by having each command specify how the output should look like, making it so that it doesn’t have to be rewritten for the GUI.
  * The Application class has a ‘refused bequest’ code smell, storing null for the PageManager. In Phase 2, we could fix this by removing the getPageManager class from the UserInterface, or by creating a PageManager for the GUI to manage the transition between pages and the creation of pages.
  * There is repeated code within the GUI for creating each page. In Phase 2, we could fix this by creating a class with methods that take in an array of Commands and automatically creates a GUI page.
  * There are also some antipatterns:The RecipeBook and PreferenceBook should both be updated when there is a change to the ratings, but there is no observer class doing this. This could be fixed in Phase 2 by utilising the design pattern of Observer.


## PROGRESS REPORT 

### OUTSTANDING QUESTIONS 
1. What is the best way of cleanly separating controllers from the GUI, so that all code can be shared between the CLI and GUI and the single responsibility principle can be maintained?
  * If we were to do this using commands, how do we get the GUI to have well formatted output?
2. Some of our methods take 4+ parameters, like the RecipeFactoryClass. What is the best way to deal with this?
3. Is there a better way for the controller and gateway classes to be able to access entities other than by creating facade usecases?

### WHAT HAS WORKED WELL THUS FAR?
* _Packaging by Layer followed by Components_ - This has worked in that we are more likely to adhere to the Clean Architecture while we develop the programme and it is easier to find and fix any areas where it was not followed. Furthermore, separating by components afterwards works well as it means that we can manage the visibility of parts of our code.
* The Command classes - In practice, this made it very easy for all of the team to add new functionality. Because the interface is the bare minimum required, and each command has exactly one responsibility, it was easy for the team to quickly add new features without needing to worry about the implementation of the user interface.
* The CSVReader class - By abstracting out the code for modifying csv files, it was very easy for the team to create their own databases simply by extending this CSVReader class without needing to worry about how it works internally. When bugs emerged in the CSVReader class, none of the other code had to be changed.

### Brief Summary of Tasks undertaken by each member and Next Steps to be taken

#### DOHYUN

* ##### TASKS DONE: 
   * Mainly focused on filtering and sorting algorithms of our program. Implemented AllergyFilter class, ServingsFilter class, ServingSort class and ServingComparator class, Sort interface, RatingSort class and RatingComparator class, test classes for all the classes that I implemented in Phase 1. Modified filter and sort tests to use RecipeCollection instead of DatabaseManager, filter and sort interfaces so that they get an array of recipes directly when calling filter/sort method not when initializing, and all codes that I implemented to work with modified filter and sort interfaces. Added Javadoc for all classes and interfaces that I implemented in Phase 0 and 1. Organized the test classes, using packaging by components (e.g. FilterTests and SortTests). Added design decisions and design patterns into the Design Document.

* ##### NEXT STEPS:
   * If our online database contains calories, modify the Recipe to store calories and implement CalorieFilter and CalorieSort. Since a database of recipes can have a huge amount of recipes, I will try to improve the runtime efficiency of filters and sorts. Improve dependency between the codes related to filters and sorts.

#### EMILY

* ##### TASKS DONE: 
   * Heavily focused on implementing Group related classes and commands including Group, GroupManager, GroupFactory (using the Factory Design Patt on implementing Group related classes and commands including Group, GroupManager, GroupFactory (using the Factory Design Pattern), Group tests and a number of commands. Group class and GroupFactory class were modified based on group member’s feedback. 

* ##### NEXT STEPS: 
   * I will continue to work on implementing a few more Group commands and add them to GUI. 


#### HAYUN

* ##### TASKS DONE: 
   * I have mostly worked on Group related classes for phase 1 (implemented Group, GroupManager, GroupCSVReader, GroupCSVReaderTest, and some groups.csv). I have also helped Michelle in implementing some of the Recipebook tests such as RecipeBookManager and SubRecipeBookManager tests. For the last two days, I have worked on refactoring GroupCommands so that we can use CSV methods in the GroupCommands. 

* ##### NEXT STEPS:
   * For phase 2, I will be working on refactoring existing Group Commands.
   * I also plan on working to implement the methods to connect Recipebook to the group entities. 
   * I will help my teammates with any outstanding work.


#### HELENA

* ##### TASKS DONE: 
   * My main task was setting up a GUI that thoroughly represents our program. Using Java’s SwingX framework. I was the primary contributor for all design decisions revolving around the UI and UX in the GUI by formatting and adding different components to maximize the usability and visual aspect of our program. I also implemented a “Top Picks'' algorithm that would predict a series of recipes that a user would like based on the user’s previous recipe choices. I did some basic bug fixes and resolved remaining IntelliJ warnings at the end.

* ##### NEXT STEPS:
   * I plan on continuing to add to the GUI and improving our UI and UX design(increasing functionality and visual apealness, maintaining a certain style), elaborating on the implementation of the Top Picks algorithm and am thinking about adding new methods for data analytics/stats on food trends found in individuals and across all users.


#### MARK

* ##### TASKS DONE: 
  * Starting by refactoring the RecipeDatabase and DatabaseManager out, building the RecipeFactory, RecipeCollection, and RecipeCSVReader to replace them.
  * Built the CSVReader class to read CSV files, and the UserCSVReader to store users permanently.
  * Built the RecipeGateway and JSON classes to allow recipes to be added to the recipes.csv file automatically.
  * Built commands to interact with sorts and filters.
  * Refactored the GUI and CLI to extend a UserInterface abstract class so that they can both execute Commands.
  * Did some basic refactoring and bug fixes at the end, fixing code smells and dependency issues, notably creating a RecipeCollectionFacade to help fix this.

* ##### NEXT STEPS:
  * I plan to refactor how the GUI and CLI operate internally to make the implementation more SOLID, so that a nice looking GUI can be created while having all code be shared and seperated.
  * Fix the bugs in the issues tab.
  * Fix the remaining dependency issues.
  * Implement an observer design pattern to allow RecipeBook and PreferenceBook to coordinate on rating recipes.

#### MICHELLE

* ##### TASKS DONE: 
  * I created, updated and refactored the following classes RecipeBook, SubRecipeBook, RecipeBookManager, SubRecipeBookManager, RecipeBookCSVReader and RecipeCommands. 
  * I wrote tests for RecipeBook and SubRecipeBook
  * I participated in some of the design decisions.
  * I worked on the MarkDown file for the Design Document.
  * I also worked on some of sectons of the Design Document with team members.

* ##### NEXT STEPS: 
  * I plan to continue testing the classes that I have written above and offer help to my other members.
  * I plan on potentially helping with the GUI. 
  * I plan to work on reviewing my teammates pull requests

#### MILICA

* ##### TASKS DONE:
  * I created and added updates to PreferenceBook, PreferenceBookCSVReader, the UserPreferencesCommands, 
  * I added rating functionality to Recipe and RecipeCSVReader
  * I made some minor changes to a few other CLI commands
  * I made a powerpoint for the presentation

* ##### NEXT STEPS:
  * I will add more preference options to PreferenceBook (UpdateDietCommand)
  * I will create comprehensive tests for PreferenceBook related methods
  * I will help my teammates with any outstanding work


