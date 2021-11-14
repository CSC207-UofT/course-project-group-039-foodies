package main.java.Gateways;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVReader {
    String databasePath;
    String tempPath = System.getProperty("user.dir") + "/src/main/java/Gateways/databases/temp.csv";
    HashMap<String, Integer> columns = new HashMap<>();

    /**
     * Creates a CSVReader of the csv file at databasePath with certain columns
     * @param databasePath The path of the csv file
     * @param columns The name of each column in order
     */
    protected CSVReader(String databasePath, String[] columns) {
        this.databasePath = databasePath;

        for (int i = 0; i < columns.length; i++) {
            this.columns.put(columns[i], i);
        }
    }

    /**
     * Creates a temporary CSVReader to be used internally
     */
    private CSVReader() {
        this.databasePath = tempPath;
    }

    /**
     * Writes a line to the csv file
     * @param line The line written to the csv file, where the ith index corresponds to the value of the ith column
     */
    protected void writeLine(ArrayList<String> line) {
        try {
            String cleanedUpString = removeNewLines("\"" + String.join("\",\"", line) + "\"") + "\n";
            Files.write(
                    Paths.get(databasePath),
                    cleanedUpString.getBytes(), // Surrounds every entry with quotes
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes one line from the csv file where name is the value at a column
     * @param name The value to remove
     * @param column The column to check
     */
    protected void removeLine(String name, String column) {
        removeLine(name, columns.get(column));
    }

    /**
     * Removes one line from the csv file where name is the value at the column of a certain index
     * @param name The value to remove
     * @param location The index of the column to check
     */
    private void removeLine(String name, int location) {
        // Creates a temporary database
        FileManager fileManager = new FileManager(tempPath);
        fileManager.createFile();

        // Writes the file to the temporary database without the lines to delete
        CSVReader tempReader = new CSVReader();
        for (ArrayList<String> line : readFile()) {
            if (!line.isEmpty() && !line.get(location).equals(name)) {
                tempReader.writeLine(line);
            }
        }

        // Removes the temporary database
        fileManager.changeName(databasePath);
    }

    /**
     * Replaces new line characters with '\\n' so that they can be stored in a single line in the csv file
     * @param line The line to process
     * @return The line after processing
     */
    private String removeNewLines(String line) {
        return line.replace("\n", "\\n");
    }

    /**
     * Replaces '\\n' with new lines so that the change made in removeNewLines is undone
     * @param line The line to process
     * @return The line after processing
     */
    private String addNewLines(String line) {
        return line.replace("\\n", "\n");
    }

    /**
     * Returns all entries in the csv file
     * @return Returns an arraylist where each element is an arraylist of the value at each column
     */
    // TODO: Make readFile private, with the column attribute, shouldn't leak its implementation to its children
    protected ArrayList<ArrayList<String>> readFile() {
        ArrayList<ArrayList<String>> returnList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(databasePath));
            String row = reader.readLine();
            while (row != null) {
                row = addNewLines(row);
                CSVStateMachine stateMachine = new CSVStateMachine(row);
                returnList.add(stateMachine.parseLine());
                row = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnList;
    }

    /**
     * A private class responsible for parsing a line of the CSV file cleanly by using finite automaton
     * with three states, a startWordState, an insideWordState, and an endWordState
     */
    private static class CSVStateMachine {
        String line;
        ArrayList<String> parsedLine = new ArrayList<>();

        private CSVStateMachine(String line) {
            this.line = line;
        }

        private ArrayList<String> parseLine() {
            if (line.equals("")) {
                parsedLine = new ArrayList<>();
            } else {
                startWordState(0);
            }

            return parsedLine;
        }

        private void startWordState(int index) {
            if (line.charAt(index) == '"') {
                insideWordState(index + 1, "");
            }
        }

        private void insideWordState(int index, String word) {
            if (line.charAt(index) == '"') {
                endWordState(index + 1, word);
            } else {
                insideWordState(index + 1, word + line.charAt(index));
            }
        }

        private void endWordState(int index, String word) {
            parsedLine.add(word);
            if (index != line.length()) {
                startWordState(index + 1);
            }
        }
    }
}
