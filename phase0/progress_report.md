# PROGRESS REPORT

## Summary of Specification

In our programme, users can :
  * create an individual account to access a personalized feed of recipes based on their preferences
  * create folders of recipes that they would like to save, that is, create their own personal recipe book.
  * create groups where they can view recipes that fit everyones' preferences, as well as, share the recipes they like to members of a group.
  * create their own recipes and upload it to the database
  * rate recipes that they have tried 

In addition, our recipes can be ranked as :
* most popular recipes in certain categories
* most highly rated recipes
* recipes rising in popularity

## Summary of CRC model
We have created an interface adapter, seven entities, six use cases, one gateway, and fifteen controllers. The interface adapter CommandLineInterface is built based on controllers and entities to take control in handling inputs and outputs. The package of entities in our CRC model contains various data-based classes such as User, Recipe, recipeBook. Use cases consist of a group of managers that are able to identify, organize and accomplish different tasks. The one gateway class we have is RecipeGateway which plays a role as a gateway in converting raw recipe files to Recipe objects.

## Summary of Scenario Walk-Through
The goal of our scenario walk-through is to provide a rough overview of our application by demonstrating how a user might use the application. The scenario starts with a user logging onto the programme. The user creates an individual account then signs into his account. The user chooses to explore available recipes and get some recipe recommendations. The user is now able to see different recipes and add ones that he would like to save for later. The user views recipes and adds a recipe that he likes to his personal recipe book and exits the programme by signing out of the account. This completes our scenario walk-through.

## Summary of the Skeleton Programme
* The main function is in the CommandLineInterface
* The CLI package stores all classes required for the program to parse user input and call the use cases. All interface adapters can be found here.
Commands are stored here and sorted by functionality
* The Entities class stores the entities used by the program
* The classes that filter recipes and the filter interface are stored in the filters package
* The gateways that will interact with the web and internet APIs are stored in the gateway package
* The UseCases package stores all the use cases, and an internal package stores the utilities
* Tests are in the test.java package


## Open Questions that our group needs assistance with
1) Is having an entire class containing only static methods good design? Is there any ways that we can improve on this?
2) Between HashMap and ArrayList, which may be a better choice for storing Recipes in the RecipeDatabase and RecipeBook? (currently, we are using HashMap)
3) What is the best way to pull recipes from online sources? Tips on cleaning the data 

## What has worked well so far with the design?
Some things that have worked well with our design thus far are:
* Packaging by layer (e.g. Entities, Gateways, Use cases) works well because it allows us to find the java files and neatly organize them. Moreover, it helps us check whether our code follows the Clean Architecture dependency rule.
* Packaging by component (e.g. CLI, Filter, Commands) also works well because we can find and access the files that are related to each other by grouping related files together.
* Our program requires filtering features that filter the recipes in the database (e.g. by food type). Since we have to add more ways to filter the recipes later on, we created an interface “Filter” and classes that are responsible for filtering recipes in specific way (e.g. FoodTypeFilter class).
* We tried to follow the Single Responsibility Principle of the SOLID Design Principles. We tried to make each class to have only one responsibility (e.g. manager classes of each feature of the program).

## Brief Summary of Tasks undertaken by each member and Next Steps to be taken

### DOHYUN

* #### TASKS DONE: 
  * Creating and modifying CRC cards, general designing discussions
  * Designing part of the progress report. 
  * Implemented DatabaseManager class and tests, Filter interface, FoodTypeFilter class and tests, and RecipeDatabase class (with Mark).

* #### NEXT STEPS:
  * Implement more filter classes. (e.g. CaloriesFilter class, AllergyFilter class).

### EMILY

* #### TASKS DONE: 
  * Worked on general design discussions 
  * Implementing UserManager class (revised by Mark) and test cases, and modifying User class 
  * Worked on summary of scenario walkthrough for progress report.

* #### NEXT STEPS:
  * Would like to start working on Group class - organizing the class and required methods and identifying how each method will interact with other classes.

### HAYUN

* #### TASKS DONE: 
  * Worked on modifying and creating CRC cards as table, 
  * Worked on Summary of CRC cards for the progress report
  * modifying RecipeBook, RecipeBookManager and test cases
  * scheduling meetings with TA.

* #### NEXT STEPS:
  * Would like to focus on the PreferenceBook class to specify the allergies and dietary restriction data.

### HELENA

* #### TASKS DONE: 
  * Came up with the project idea, contributed to design discussion.
  * Implemented the User Class and test cases, partial implementation of PreferenceBook.
  * Created and organized Gdoc for project planning.

* #### NEXT STEPS:
  * Would like to work on the data analysis for user recommendations.
  * Would also like to work on more filter classes (ethnicity, prep time/difficulty).

### MARK

* #### TASKS DONE: 
  * Worked on building the commandLineInterface and the relevant Page and Command classes. 
  * Helped write CRC cards of classes in the CLI package. 
  * Reviewed the team’s code and worked on getting it running all together without errors.

* #### NEXT STEPS:
  * Would like to work on making the code even more SOLID
  * add more functionality with respect to what the user can do (including adding their own recipes and rating them) and expanding the test suite.

### MICHELLE

* #### TASKS DONE: 
  * Worked on the writing the textfiles versions of and creation of CRC cards, participating in design discussions,  writing and editing the programme specification and scenario walk-through, converting the information to the Markdown versions, generating recipes
  * implementing RecipeBook (revised by Mark), writing test cases
  * helping with the organisation of the GoogleDoc and meeting agenda creations

* #### NEXT STEPS: 
  * Would like to work on developing the RecipeBook - different sections of recipe book
  * Potentially work on group features and data analysis for the recommendations/ pulling data from the web

### MILICA

* #### TASKS DONE: 
  * Involved in design discussion and progress report
  * Implemented Recipe and RecipeGateway Classes (revised by Mark). Revised DatabaseManager and GetNewRecipeCommand. 
  * Scheduling and hosting zoom meetings for group work.

* #### NEXT STEPS:
  * Work on implementing rating system for Recipe and possibly an Ingredient class
