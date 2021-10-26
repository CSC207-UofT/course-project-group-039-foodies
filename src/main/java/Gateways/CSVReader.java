package main.java.Gateways;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class CSVReader {
    String databasePath;

    protected CSVReader(String databasePath) {
        this.databasePath = databasePath;
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

    private String removeNewLines(String line) {
        return line.replace("\n", "\\n");
    }

    private String addNewLines(String line) {
        return line.replace("\\n", "\n");
    }

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
