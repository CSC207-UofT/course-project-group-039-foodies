package main.java.Gateways;

import java.io.File;
import java.io.IOException;

/**
 * A helper class for handling files
 */
public class FileManager {
    String filePath;
    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Creates a new file at the path
     */
    public void createFile() {
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes the name of a file
     * @param newFileName The new path of the file
     */
    public void changeName(String newFileName) {
        File oldFile = new File(filePath);
        File newFile = new File(newFileName);
        newFile.delete();
        if (oldFile.renameTo(newFile)) {
            filePath = newFileName;
        }
    }
}
