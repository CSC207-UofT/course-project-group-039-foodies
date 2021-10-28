package main.java.Gateways;

import java.io.File;
import java.io.IOException;

public class FileManager {
    String filePath;
    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public void createFile() {
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeName(String newFileName) {
        File oldFile = new File(filePath);
        File newFile = new File(newFileName);
        if (oldFile.renameTo(newFile)) {
            filePath = newFileName;
        }
    }
}
