# PHASE 1 : DESIGN DOCUMENT

## Summary of Specification

Our team aims to create a programme that is geared towards food lovers looking to make delicious, nutritious foods right in their kitchen.
The programme is able to match users to recipes based on a series of their preferences. Matches may be made based on likes/ dislikes, dietary restrictions and more. If no preferences are provided, these matches may also be made randomly.
Recommendations are done by filtering recipes from our database using the preferences provided to find the recipe that is the best match.
In the programme, users can :
* create subfolders of recipes that they would like to save, that is, create their own personal recipe book with different categories.
* create groups where each group is assigned with a unique ID so they can add and remove users without any conflict.
* create their own recipes and upload it to the database
* rate recipes that they have tried

The programme also has a feature where data from all users can be aggregated, analysed and be presented in the form of:
* most popular recipes in certain categories
* most highly rated recipes
* recipes rising in popularity


## UML MODEL
The following images show the UML for various aspects of our programme: 
* UML of everything
* High Level UML showing the dependencies


## MAJOR DESIGN DECISIONS SUMMARY
There were several design decisions that had to be made during the development of this programme. The following is a summary of some of the design decisions we encountered:
* Removing the RecipeDatabase. _Why?_ Our programme was transitioning to a RecipeGateway that will be accessing recipes from an online database/source. In particular, we   isolated the following three main responsibilities of RecipeDatabase, replacing them with dedicated classes:
  * Creating a recipe object. This has been replaced with RecipeFactory. 
  * Holding a collection of recipes. This has been replaced with RecipeCollection. 
  * Accessing and modifying all the recipes in the database. This has been replaced with the RecipeCSVReader. 
  * _Why?_ RecipeDatabase was an entity when it should have been in the layer of Framework and Driver. Thus, the design was flawed. Furthermore, refactoring its responsibilities   out to other classes also makes the code more SOLID as it allows follows the Single Responsibility Principle
* Using an interface rather than an abstract class for the filters and sorts. Implemented Filter interface, Sort interface, and several filtering/sorting algorithms (classes). _Why?_ Allows adding other filtering/sorting algorithms (classes) easily.
* Using adapter for filter/sort controllers. _Why?_ We can avoid changing the whole code that is related to the filtering and sorting whenever there is a change, eliminating a code smell.
* Using comparator classes for ServingsSort and RatingSort. _Why?_ to make code simple and easy to modify.
* Separating the storage or cumulative recipe ratings and individual recipe ratings. _Why?_ Initially, all rating information for a recipe could be accessed through a recipe object, and cumulative ratings were calculated by getting the average of the list of individual ratings. When storing the rating information in CSV files, we realized that the recipes.csv file would be too large to handle efficiently and if individual and cumulative ratings were linked, then deleting a user (thus deleting their individual ratings) would mess up the calculation of cumulative ratings.


## CLEAN ARCHITECTURE IN THE PROGRAMME
All of our code dependencies only move from the outer levels inward. Code on the inner layers have no knowledge of methods on the outer layers. The variables, methods and classes that exist in the outer layers are not mentioned in the more inward levels. 
Our two external interfaces the GUI and the CLI only interact with our controller layer, which includes 34 commands and a number of gateways, as found in AdminCommands, GroupCommands, RecipeBookCommands, RecipeViewerCommands and UserPreferenceCommands, and the Gateways package. For the most part, every layer depends only on the layer below it, but there are some violations in our code. Namely, we call initializers for entities in gateways, like the User initializer in the UserCSVReader. To fix this we can create a UserFactory UseCase that returns a User object, which we can use instead of the User initializer directly in the UserCSVReader.

## SOLID DESIGN PRINCIPLES IN THE PROGRAMME
The following SOLID principles were used and some examples of its use are:

_Single-responsibility principle_:
  * The RecipeFactory class has only one responsibility, to create recipes and that responsibility has been taken out of other classes.
  * The GroupFactory also has only one responsibility– to create groups. We have taken out these responsibilities from Group class and added them to the GroupFactory to satisfy the single-responsibility principle.

_Open–closed principle_:
  * It is easy to extend the functionality of our code while modifying very little of any of the existing source. For example:
  * It is easy to add new features that the user can interact with by simply creating a new class that inherits from the Command class.
  * Similarly, it is easy to add new pages in the CLI or GUI by simply creating a Page class, or a GUIPage respectively that implements this, then add references to these classes in the PageManager or appropriate GUIPage.
  * It is easy to add more ways to sort and filter all recipes by creating a new class that implements the Filter or Sort interfaces, as the strategy design pattern is used.
  * It is easy to extend the information stored in every user, every recipe, and every group without modifying any use case, we only need to add a place for this new data in the appropriate CSVReader, and add a handler in the appropriate factory.

_Liskov substitution principle_:
  * Filters and sorts can be interchanged safely, and the program would still run as intended.
  * Commands can all be interchanged with each other in the CLI, and the code would function as intended
  * However, a current flaw in the design is that the GUI has no PageManager to manage how pages work, so running a command that uses the PageManager in the GUI would result in a NullPointerException, the Liskov substitution principle fails in this respect.

_Interface segregation principle_:
  * The filter and sort methods are segregated into separate interfaces instead of being placed in a general modifier interface.
  * The UserInterface abstract class enforces that its children only implement two methods, queryUser and displayMessage, the bare minimum a class responsible for interacting with the user must have.
  
_Dependency inversion principle_:
  * The code follows clean architecture strictly, and so abstractions never depend on how they are used.
  * Dependency injection is used, as described in the section on design patterns, to maintain this.


## PACKAGING STRATEGIES USED IN PROGRAMME
We first _package by clean architecture layers_. This ensures that we follow the clean architecture structure as it is very easy to visualise the structure and find places where clean architecture is broken, and fix them. This also forces us to think about which layer a class is in before we even start coding. All in all, this makes it almost trivial to adhere to clean architecture.

Within each layer package, we _package by component_. This makes it very easy to find any class within a package and group together relevant classes. Moreover, in some places, we can use this to manage visibility and dependencies in our code. Components can be grouped together in a package and methods that should only be called internally can be protected. This is done in the JSONComponents package and the CLI package.


## SUMMARY OF DESIGN PATTERNS USED IN PROGRAMME
The following design patterns were used in the programme:

_Strategy_:
* Used to create different types of filters with a filter method in the filter package
* Used to create different types of sorts with a sort method in the sort package
* Create different types of commands with a runAction method in the Commands package

_Factory_:
* Create recipes, in the RecipeFactory class, abstracting out the process of creating recipe codes
* Create groups, in the GroupFactory class, abstracting out the process of creating groups by assigning a unique group code
* Create a user representing a new account, in the AccountFactory class

_Dependency Injection_:
* The use case interfaces Sort and Filter are injected into the entity RecipeCollection so that it can use methods in a more concrete layer, without depending on their   implementation, allowing clean architecture to stay respected.
* The UserInterface has setters to allow for the injection of RecipeCollections, PreferenceBook, etc.

_Facade_:
* The RecipeBook acts as a facade for the overall subrecipebook which contains all recipes the user adds to their individual subrecipebooks

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
_Factory_:
* A factory for users to resolve the dependency issue in the gateway layer

_Observer_:
* Make PrefenceBook and RecipeBook observers so that when a user rates a new recipe, both can be updated


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
* We exchanged any call of the Recipe constructor with a RecipeFactory in pull request #8, washing away a ‘duplicate code’ code smell
* RecipeCollection is used instead of HashMap<Integer, Recipe> in the RecipeBook, and later the SubRecipeBook, washing away a ‘primitive obsession’ code smell. This is done in pull request #40
* RecipeBook was refactored to store SubRecipeBooks, instead of directly storing Recipes in pull request #40
* Pull request #45 fixes a bug that stopped RecipeBooks from being created when the user is, and fixes an issue with dependencies in the Command layer, as well as removing a bunch of dispensables.
* Pull request #35 refactors the CLI and GUI to both implement the same interface, allowing commands to be run on both of them.
* However, there are still a few code smells in our code which we plan to solve in Phase 2:
  * Some code is repeated in the GUI and CLI, such as, the sign in code. This is done so that the display to the user is nicely formatted, and so the command isn’t called directly. In Phase 2, we could fix this by having each command specify how the output should look like, making it so that it doesn’t have to be rewritten for the GUI.
  * The Application class has a ‘refused bequest’ code smell, storing null for the PageManager. In Phase 2, we could fix this by removing the getPageManager class from the UserInterface, or by creating a PageManager for the GUI to manage the transition between pages and the creation of pages.
  * There is repeated code within the GUI for creating each page. In Phase 2, we could fix this by creating a class with methods that take in an array of Commands and automatically creates a GUI page.
  * There are also some antipatterns:The RecipeBook and PreferenceBook should both be updated when there is a change to the ratings, but there is no observer class doing this. This could be fixed in Phase 2 by utilising the design pattern of Observer.


## PROGRESS REPORT 

### OUTSTANDING QUESTIONS 
1. How do we cleanly separate controllers from the GUI, to maintain the single responsibility principle?
  * If we were to do this using commands, how do we get the GUI to have well formatted output?
2. Some of our methods take 4+ parameters, what is the best way to deal with this?


### WHAT HAS WORKED WELL THUS FAR?
* _Packaging by Layer followed by Components_ - This has worked in that we are more likely to adhere to the Clean Architecture while we develop the programme and it is easier to find and fix any areas where it was not followed. Furthermore, separating by components afterwards works well as it means that we can manage the visibility of parts of our code.


### Brief Summary of Tasks undertaken by each member and Next Steps to be taken

#### DOHYUN

* ##### TASKS DONE: 


* ##### NEXT STEPS:


#### EMILY

* ##### TASKS DONE: 

* ##### NEXT STEPS:


#### HAYUN

* ##### TASKS DONE: 

* ##### NEXT STEPS:


#### HELENA

* ##### TASKS DONE: 


* ##### NEXT STEPS:


#### MARK

* ##### TASKS DONE: 
  * Starting by refactoring the RecipeDatabase and DatabaseManager out, building the RecipeFactory, RecipeCollection, and RecipeCSVReader to replace them. Built the CSVReader class to read CSV files, and the UserCSVReader to store users permanently. Built the RecipeGateway and JSON classes to allow recipes to be added to the recipes.csv file automatically. Built commands to interact with sorts and filters. Refactored the GUI and CLI to extend a UserInterface abstract class so that they can both execute Commands. Did some basic refactoring and bug fixes at the end.

* ##### NEXT STEPS:
  * I plan to refactor how the GUI and CLI operate internally to make the implementation more SOLID, create a UserFactory to solve dependency issues, and implement an observer design pattern to allow RecipeBook and PreferenceBook to coordinate

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


* ##### NEXT STEPS:


