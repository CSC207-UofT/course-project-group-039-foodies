# PROGRESS REPORT

## WHAT HAS WORKED WELL THUS FAR?
* _Packaging by Layer followed by Components_ - This has worked in that we are more likely to adhere to the Clean Architecture while we develop the programme and it is easier to find and fix any areas where it was not followed. Furthermore, separating by components afterwards works well as it means that we can manage the visibility of parts of our code.
* The Command classes - In practice, this made it very easy for all of the team to add new functionality. Because the interface is the bare minimum required, and each command has exactly one responsibility, it was easy for the team to quickly add new features without needing to worry about the implementation of the user interface.
* The CSVReader class - By abstracting out the code for modifying csv files, it was very easy for the team to create their own databases simply by extending this CSVReader class without needing to worry about how it works internally. When bugs emerged in the CSVReader class, none of the other code had to be changed.

## A summary of what each group member has been working on in Phase 2
#### Hayun (Judy)
* ##### TASKS DONE: 
  * Phase 1 
    * I have mostly worked on Group related classes for phase 1 (implemented Group, GroupManager, GroupCSVReader, GroupCSVReaderTest, and some groups.csv). I have also helped Michelle in implementing some of the Recipebook tests such as RecipeBookManager and SubRecipeBookManager tests. For the last two days, I have worked on refactoring GroupCommands so that we can use CSV methods in the GroupCommands. For phase 2, I will be working on refactoring existing Group Commands and implementing the methods to connect Recipebook to the group entities. 
  * Phase 2
    * I have heavily focused on implementing classes that are related to group and group recipe books. While the implementation for group entities was mostly done in phase 1, I had to add entities for group recipe books and group sub recipe books. I have implemented most of the Commands that are related to Group, GroupRecipeBook, and GroupSubRecipeBook and have implemented CSV Readers and their tests for Group and GroupRecipeBook. I worked on modifying the PageManager and GroupRecipeBook entity so that all commands for GroupRecipeBook can work properly without any errors. I have also helped Emily in implementing GUI for groups and group recipe books and have worked on fixing Camel Cases and docstrings. 
  * Pull request
    * Pull request #98 (https://github.com/CSC207-UofT/course-project-group-039-foodies/pull/98). This pull request contained most of the changes or additions we made for phase 2. Worked on creating new commands and CSV readers and updating any changes for entities and GUI. 


#### Dohyun
* ##### TASKS DONE: 
  * Phase 1 
    * In Phase 1: Mainly focused on filtering and sorting algorithms of our program. Implemented AllergyFilter class, ServingsFilter class, ServingSort class and ServingComparator class, Sort interface, RatingSort class and RatingComparator class, test classes for all the classes that I implemented in Phase 1. Modified filter and sort tests to use RecipeCollection instead of DatabaseManager, filter and sort interfaces so that they get an array of recipes directly when calling filter/sort method not when initializing, and all codes that I implemented to work with modified filter and sort interfaces. Added Javadoc for all classes and interfaces that I implemented in Phase 0 and 1. Organized the test classes, using packaging by components (e.g. FilterTests and SortTests). Added design decisions and design patterns into the Design Document.
  * Phase 2
     * In Phase 2: Mainly worked on implementing GUI parts of filters and sorts. Added commands to add and remove filters to the RecipeBook, added commands to set and remove sort to the RecipeBook, added commands to add and remove filters to the SubRecipeBook, added commands to set and remove sort to the SubRecipeBook, added GUI page that is responsible for filtering and sorting RecipeBook, and added GUI page that is responsible for filtering and sorting SubRecipeBook. Modified RecipeBook entity and SubRecipeBook entity to match my implementation of filter and sort GUI. Also, refactored the entire program (added javadoc to public methods, removed unused imports, and removed empty classes).
  * Pull request
    * Pull Request #23 (https://github.com/CSC207-UofT/course-project-group-039-foodies/pull/23) - Worked on implementing filter and sort algorithms (use cases), added javadocs, and added tests. I made pull requests frequently, so only some part of the code is in this pull request.
    * Pull Request #82 (https://github.com/CSC207-UofT/course-project-group-039-foodies/pull/82) - Worked on implementing GUI parts of filters and sorts. Added commands, added GUI pages, and modified RecipeBook and SubRecipeBook entities.

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
https://github.com/CSC207-UofT/course-project-group-039-foodies/pull/96#issue-1074088319.
This includes the majority of implementations that are related to the group feature. Merging this pull request has been delayed a bit due to some conflicts and maven errors. Since this contains a huge number of changes to the files, the summary of the major changes has been commented on for reviewers.


Helena
* #### PHASE 1
  * My main task was setting up a GUI that thoroughly represents our program. Using Java’s SwingX framework. I was the primary contributor for all design decisions revolving around the UI and UX in the GUI by formatting and adding different components to maximize the usability and visual aspect of our program. I also implemented a “Top Picks'' algorithm that would predict a series of recipes that a user would like based on the user’s previous recipe choices. I did some basic bug fixes and resolved remaining IntelliJ warnings at the end.
  * I plan on continuing to add to the GUI and improving our UI and UX design(increasing functionality and visual apealness, maintaining a certain style), elaborating on the implementation of the Top Picks algorithm and am thinking about adding new methods for data analytics/stats on food trends found in individuals and across all users.

* #### PHASE 2
  * I focused on finishing the implementation of the TopPicks algorithm that predicts recipes that users will like and adding the necessary command and GUI page so that the user can interact with it. I made additional changes to the UI/UX design of the GUI, by changing the background, fonts colour and size. I also worked on fixing Camel Case. I also focused on removing code smells. I removed all unused imports, inverted some methods, deleted empty classes as well as unused methods and refactored duplicated methods to address almost all IntelliJ warnings. 
Significant pull requests: #107 https://github.com/CSC207-UofT/course-project-group-039-foodies/pull/107 and #83 https://github.com/CSC207-UofT/course-project-group-039-foodies/pull/83 These pull requests include a majority of the implementation for TopPicks, UX/UI GUI design changes, and refactoring. 


MICHELLE

* ##### PHASE 1: 
  * I created, updated and refactored the following classes RecipeBook, SubRecipeBook, RecipeBookManager, SubRecipeBookManager, RecipeBookCSVReader and RecipeCommands.
  * I wrote tests for RecipeBook and SubRecipeBook
  * I participated in some of the design decisions.
  * I worked on majority of the MarkDown file for the Design Document.
  * I also worked on some of sectons of the Design Document with team members.

* ##### PHASE 2: 
  * I worked on the RecipeBook and Sub-Recipe Book structure in the GUI (the pages related to these and edited some of the commands etc) as a major part of Phase 2.
  * I assisted on the TopPicks through discussion with Helena on how to implement some of the methods and how to approach the algorithm.
  * I refactored code, mostly writing JavaDoc and fixing camelCase issues.
  * I reviewed pull requests 

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
