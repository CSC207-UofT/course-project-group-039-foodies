package main.java.Gateways;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVReader {
    String databasePath;
    String tempPath = "databases/temp.csv";
    HashMap<String, Integer> columns = new HashMap<>();

    protected CSVReader(String databasePath, String[] columns) {
        this.databasePath = databasePath;

        for (int i = 0; i < columns.length; i++) {
            this.columns.put(columns[i], i);
        }
    }

    private CSVReader() {
        // Creates a temporary reader
        this.databasePath = tempPath;
    }

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

    protected void removeLine(String line, String column) {
        removeLine(line, columns.get(column));
    }

    protected void removeLine(String name, int location) {
        FileManager fileManager = new FileManager(tempPath);
        fileManager.createFile();
        CSVReader tempReader = new CSVReader();
        for (ArrayList<String> line : readFile()) {
            if (!line.get(location).equals(name)) {
                tempReader.writeLine(line);
            }
        }
        fileManager.changeName(databasePath);
    }

    private String removeNewLines(String line) {
        return line.replace("\n", "\\n");
    }

    private String addNewLines(String line) {
        return line.replace("\\n", "\n");
    }

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
     * Parses a line of the CSV file cleanly by using finite automaton
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
