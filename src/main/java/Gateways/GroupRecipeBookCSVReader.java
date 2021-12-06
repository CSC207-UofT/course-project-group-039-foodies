package main.java.Gateways;

import main.java.Entities.*;
import main.java.UseCases.GroupRecipeBookManager;
import main.java.UseCases.Utilities.RecipeCollectionFacade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class GroupRecipeBookCSVReader extends CSVReader {
    private final static GroupRecipeBookCSVReader instance = new GroupRecipeBookCSVReader(
            System.getProperty("user.dir") +
                    "/src/main/java/Gateways/databases/groupRecipeBooks.csv"); // a singleton

    private final static GroupRecipeBookCSVReader testInstance = new GroupRecipeBookCSVReader(
            System.getProperty("user.dir") +
                    "/src/test/java/GatewaysTests/groupRecipesTest.csv"); // a singleton for testing safely

    public static GroupRecipeBookCSVReader getInstance() {
        return instance;
    }

    public static GroupRecipeBookCSVReader getTestInstance() {
        return testInstance;
    }

    /**
     * Create a GroupRecipeBookCSVReader of the csv file with directory path and
     * a list of string indicating the columns.
     *
     * @param path - the directory path of the csv file.
     */
    protected GroupRecipeBookCSVReader(String path) {
        super(path, new String[]{"groupName", "groupName - SubRecipeBookName", "subRecipeBookDesc", "recipeList"});
    }

    /**
     * Add a GroupSubRecipeBook category to the groupSubRecipeBook list for group, when there are no recipes in the
     * groupSubRecipeBook.
     * @param group - the group which the sub-recipe book belongs
     * @param subRecipeBookName - the name of groupSubRecipeBook that was created.
     * @param subRecipeBookDesc - the groupSubRecipeBook description
     */
    public void addNewSubRecipeBook(Group group, String subRecipeBookName, String subRecipeBookDesc) {
        addSubRecipeBook(group.getGroupName(), subRecipeBookName, subRecipeBookDesc);
    }

    /**
     * Helper function used to add the new groupSubRecipeBook to the CSV file
     * @param groupName - the name of the group whom the groupSubRecipeBook belongs
     * @param subRecipeBookName - the name of the groupSubRecipeBook
     * @param subRecipeBookDesc - the description of the groupSubRecipeBook
     */
    private void addSubRecipeBook(String groupName, String subRecipeBookName, String subRecipeBookDesc) {
        ArrayList<String> newSubRecipeBookInfo = new ArrayList<>();
        String fullSubRecipeBookName = groupName + " - " + subRecipeBookName;
        newSubRecipeBookInfo.add(groupName);
        newSubRecipeBookInfo.add(fullSubRecipeBookName);
        newSubRecipeBookInfo.add(subRecipeBookDesc);
        newSubRecipeBookInfo.add(" ");
        writeLine(newSubRecipeBookInfo);
    }

    /**
     * Checks if the groupSubRecipeBook exists with a certain group name and group subRecipeBookName.
     * @param groupName - the group name to check
     * @param subRecipeBookName - the name of the groupSubRecipeBook
     * @return A boolean representing whether there is a groupSubRecipeBook
     */
    public boolean isSubRecipeBook(String groupName, String subRecipeBookName) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(1).equals(groupName + " - " + subRecipeBookName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Update the list of recipes for a groupSubRecipeBook of a particular group.
     * @param groupName - the username of the user
     * @param groupSubRecipeBook - the name of the groupSubRecipeBook to add to
     */
    public void updateRecipeBookCSV(String groupName, GroupSubRecipeBook groupSubRecipeBook) {
        String groupSubRecipeBookName = groupSubRecipeBook.getName();
        String groupSubRecipeBookDesc = groupSubRecipeBook.getDescription();
        removeLine(groupName + " - " + groupSubRecipeBookName, "groupName - SubRecipeBookName");
        addSubRecipeBook(groupName, groupSubRecipeBookName, groupSubRecipeBookDesc, groupSubRecipeBook.getRecipes());
    }

    private void addSubRecipeBook(String groupName, String groupSubRecipeBookName,
                                  String groupSubRecipeBookDesc, Recipe[] recipes) {
        ArrayList<String> SubRecipeBookInfo = new ArrayList<>();
        SubRecipeBookInfo.add(groupName);
        SubRecipeBookInfo.add(groupName + " - " + groupSubRecipeBookName);
        SubRecipeBookInfo.add(groupSubRecipeBookDesc);
        ArrayList<String> recipeList = new ArrayList<>();
        for (Recipe recipe: recipes) {
            recipeList.add(recipe.getName());
        }
        if (recipeList.size() == 0) {
            SubRecipeBookInfo.add(" ");
        } else {
            SubRecipeBookInfo.add(String.join(", ", recipeList));
        }
        writeLine(SubRecipeBookInfo);
    }

    /**
     * Delete the GroupSubRecipeBook from the list of subRecipes.
     * @param groupName - the group name which the sub-recipe book corresponds to
     * @param groupSubRecipeBookName - the subRecipeBook to be deleted.
     */
    public void deleteSubRecipeBook(String groupName, String groupSubRecipeBookName) {
        removeLine(groupName + " - " + groupSubRecipeBookName, "groupName - SubRecipeBookName");
    }

    /**
     * Return the lists of recipes in the groupSubRecipeBook with name SubRecipeBookName for group.
     * @param groupName - the name of the group which recipeBook is to be returned
     * @param groupSubRecipeBook - the subRecipeBook from which the recipes to be returned are found.
     *
     * @return - the SubRecipeBook
     */
    public RecipeCollection getSubRecipeBookRecipesList(String groupName, GroupSubRecipeBook groupSubRecipeBook) {
        for (ArrayList<String> line : readFile())
            if (!line.isEmpty() && line.get(1).equals(groupName + " - " + groupSubRecipeBook.getName())) {
                ArrayList<String> recipeNames = new ArrayList<>(Arrays.asList(line.get(3). split(", ")));
                return makeRecipeLists(recipeNames);
            }
        return null;
    }

    public RecipeCollection getSubRecipeBookRecipesList(Group group, GroupSubRecipeBook groupSubRecipeBook) {
        for (ArrayList<String> line : readFile())
            if (!line.isEmpty() && line.get(1).equals(group.getGroupName() + " - " + groupSubRecipeBook.getName())) {
                ArrayList<String> recipeNames = new ArrayList<>(Arrays.asList(line.get(3). split(", ")));
                return makeRecipeLists(recipeNames);
            }
        return null;
    }

    /**
     * Generate the RecipeCollection containing the set of recipes in the groupSubRecipeBook
     * @param recipeNames - an array list of the names of recipes
     * @return - a collection of recipes
     */
    private RecipeCollection makeRecipeLists(ArrayList<String> recipeNames) {
        RecipeCollection recipes = new RecipeCollection();
        RecipeCollection recipeLists = RecipeCSVReader.getInstance().getRecipes();
        for (String recipeName: recipeNames) {
            if (!recipeName.equals(" ")) {
                Recipe recipe = RecipeCollectionFacade.findRecipe(recipeLists, recipeName);
                RecipeCollectionFacade.addRecipe(recipes, recipe);
            }
        }
        return recipes;
    }

    /**
     * Return a list of the GroupSubRecipesBooks for a particular group.
     * @param group - the group which the groupSubRecipeBooks correspond to.
     * @return an arraylist containing the groupSubRecipeBooks of group
     */
    public GroupRecipeBook getGroupRecipeBook(Group group) {
        HashMap<GroupSubRecipeBook, RecipeCollection> groupSubRecipeBooks = new HashMap<>();
        for (ArrayList<String> line: readFile()) {
            if (line.get(0).equals(group.getGroupName())) {
                String[] groupNameSubRecipeBookNameInfo = line.get(1).split(" - ");
                String groupSubRecipeBookName = groupNameSubRecipeBookNameInfo[1];
                String groupSubRecipeBookDesc = line.get(2);
                GroupSubRecipeBook groupSubRecipeBook =
                        new GroupSubRecipeBook(groupSubRecipeBookName, groupSubRecipeBookDesc);
                RecipeCollection subRecipeBookRecipes = getSubRecipeBookRecipesList(group, groupSubRecipeBook);
                groupSubRecipeBooks.put(groupSubRecipeBook, subRecipeBookRecipes);
            }
        }
        return createRecipeBook(groupSubRecipeBooks);
    }

    public GroupRecipeBook getGroupRecipeBook(String groupName) {
        HashMap<GroupSubRecipeBook, RecipeCollection> groupSubRecipeBooks = new HashMap<>();
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(groupName)) {
                String[] groupSubRecipeBookNameInfo = line.get(1).split(" - ");
                String groupSubRecipeBookName = groupSubRecipeBookNameInfo[1];
                String groupSubRecipeBookDesc = line.get(2);
                GroupSubRecipeBook groupSubRecipeBook =
                        new GroupSubRecipeBook(groupSubRecipeBookName, groupSubRecipeBookDesc);
                RecipeCollection groupSubRecipeBookRecipes =
                        getSubRecipeBookRecipesList(groupName, groupSubRecipeBook);
                groupSubRecipeBooks.put(groupSubRecipeBook, groupSubRecipeBookRecipes);
            }
        }
        return createRecipeBook(groupSubRecipeBooks);
    }

    private GroupRecipeBook createRecipeBook(HashMap<GroupSubRecipeBook, RecipeCollection> groupSubRecipeBooks) {
        GroupRecipeBook groupRecipeBook = new GroupRecipeBook();
        GroupRecipeBookManager groupRecipeBookManager = new GroupRecipeBookManager(groupRecipeBook);
        for (GroupSubRecipeBook groupSubRecipeBook: groupSubRecipeBooks.keySet()) {
            groupRecipeBookManager.addSubRecipeBook(groupSubRecipeBook.getName(), groupSubRecipeBook.getDescription());
            for (Recipe recipe : groupSubRecipeBooks.get(groupSubRecipeBook)) {
                groupRecipeBookManager.addRecipe(groupSubRecipeBook.getName(), recipe);
            }
        } return groupRecipeBook;
    }
}
