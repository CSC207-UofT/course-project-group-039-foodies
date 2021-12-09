# PROGRESS REPORT

## WHAT HAS WORKED WELL THUS FAR?
* _Packaging by Layer followed by Components_ - This has worked in that we are more likely to adhere to the Clean Architecture while we develop the programme and it is easier to find and fix any areas where it was not followed. Furthermore, separating by components afterwards works well as it means that we can manage the visibility of parts of our code.
* The Command classes - In practice, this made it very easy for all of the team to add new functionality. Because the interface is the bare minimum required, and each command has exactly one responsibility, it was easy for the team to quickly add new features without needing to worry about the implementation of the user interface.
* The CSVReader class - By abstracting out the code for modifying csv files, it was very easy for the team to create their own databases simply by extending this CSVReader class without needing to worry about how it works internally. When bugs emerged in the CSVReader class, none of the other code had to be changed.

## A summary of what each group member has been working on in Phase 2
Judy
- I have mostly worked on Group related classes for phase 1 (implemented Group, GroupManager, GroupCSVReader, GroupCSVReaderTest, and some groups.csv). I have also helped Michelle in implementing some of the Recipebook tests such as RecipeBookManager and SubRecipeBookManager tests. For the last two days, I have worked on refactoring GroupCommands so that we can use CSV methods in the GroupCommands.
- For phase 2, I will be working on refactoring existing Group Commands and implementing the methods to connect Recipebook to the group entities. 

Dohyun
- In Phase 1: Mainly focused on filtering and sorting algorithms of our program. Implemented AllergyFilter class, ServingsFilter class, ServingSort class and ServingComparator class, Sort interface, RatingSort class and RatingComparator class, test classes for all the classes that I implemented in Phase 1. Modified filter and sort tests to use RecipeCollection instead of DatabaseManager, filter and sort interfaces so that they get an array of recipes directly when calling filter/sort method not when initializing, and all codes that I implemented to work with modified filter and sort interfaces. Added Javadoc for all classes and interfaces that I implemented in Phase 0 and 1. Organized the test classes, using packaging by components (e.g. FilterTests and SortTests). Added design decisions and design patterns into the Design Document.
- In Phase 2: If our online database contains calories, modify the Recipe to store calories and implement CalorieFilter and CalorieSort. Since a database of recipes can have a huge amount of recipes, I will try to improve the runtime efficiency of filters and sorts. Improve dependency between the codes related to filters and sorts.

#### MARK
* ##### TASKS DONE: 
  * Phase 1 
    * Starting by refactoring the RecipeDatabase and DatabaseManager out, building the RecipeFactory, RecipeCollection, and RecipeCSVReader to replace them.
    * Built the CSVReader class to read CSV files, and the UserCSVReader to store users permanently.
    * Built the RecipeGateway and JSON classes to allow recipes to be added to the recipes.csv file automatically.
    * Built commands to interact with sorts and filters.
    * Refactored the GUI and CLI to extend a UserInterface abstract class so that they can both execute Commands.
    * Did some basic refactoring and bug fixes at the end, fixing code smells and dependency issues, notably creating a RecipeCollectionFacade to help fix this.
  * Phase 2
    * I did not add new functionality to the code this phase, because I contributed more than I was supposed to in phase 1. Instead, I focused on refactoring the code and fixing bugs.
    * I addressed feedback: getting Github Actions to work and fixing bugs with the filter command and the tests.
    * I removed the bug that showed up in the demo that caused a StackOverflow when the RecipeGateway was communicating with the API.
    * I helped coordinate work on the GUI this phase.
    * I reviewed and refactored my team mates' code, helping identify issues and get everything working together.

* ##### If there was more I time, I would work on:
  * Adding a feature that allows users to add their own recipes.
  * Seperating the presenter from the controller in commands, allowing the GUI and CLI to share code perfectly, while making the GUI as nice as possible
  * Removing repeated code code smells
  * Integrating menus into the app so that the app can recommend the best recipes in a restaurant


Emily 
- Phase 1: The main focus was to set up a base layer of groups in our programme by implementing all the Group related classes including Group (Entity), GroupManager(Use Cases) and 4 commands in GroupCommands package (User Interface). Following the Single Responsibility Principle, GroupFactory (Use Cases) was created with the single responsibility of creating a group safely. A number of test cases were created to test the functionality and correctness of the classes that are created in Phase 1. I will be working on implementing a few more commands in GroupCommands and adding them to the GUI in Phase 2.
- Phase 2: The main focus was to complete all classes that are necessary for the group feature including group, group recipe books and group sub recipe books in the programme with Judy. Some commands that were not fully implemented during Phase 1 were completed. A few more entities for group recipe books and group sub recipe books were created to get started with further implementations. I have done some refactoring so the GroupManager could get removed and GroupCSVReader is used instead. Another huge focus was implementing the GUI. Since there were some interfaces already existing in the GUI, without breaking the pre-existing layout, group-related interfaces were added and pre-existing interfaces were modified. 
- Significant pull request: Pull Request #96
https://github.com/CSC207-UofT/course-project-group-039-foodies/pull/96#issue-1074088319
This includes the majority of implementations that are related to the group feature. Merging this pull request has been delayed a bit due to some conflicts and maven errors. Since this contains a huge number of changes to the files, the summary of the major changes has been commented on for reviewers.


HELENA
- My main task was setting up a GUI that thoroughly represents our program. Using Java’s SwingX framework. I was the primary contributor for all design decisions revolving around the UI and UX in the GUI by formatting and adding different components to maximize the usability and visual aspect of our program. I also implemented a “Top Picks'' algorithm that would predict a series of recipes that a user would like based on the user’s previous recipe choices. I did some basic bug fixes and resolved remaining IntelliJ warnings at the end.
- I plan on continuing to add to the GUI and improving our UI and UX design(increasing functionality and visual apealness, maintaining a certain style), elaborating on the implementation of the Top Picks algorithm and am thinking about adding new methods for data analytics/stats on food trends found in individuals and across all users.

MICHELLE

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
