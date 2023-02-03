package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    protected String directoryPath;
    protected String filePath;

    public Storage(String directoryPath, String filePath) {
        this.directoryPath = directoryPath;
        this.filePath = filePath;
    }
    public void saveToDisk(String commandMsg) {
        try {
            if (new File(filePath).exists() == false) {
                Files.createDirectories(Path.of(directoryPath));
            }
            File file = new File(filePath);

            FileWriter fw = new FileWriter(filePath);
            fw.write(commandMsg);
            fw.close();
        } catch (IOException exception) {
            System.out.println("Error: unable to save tasks to the disk :(");
        }
    }

    public void loadData(ArrayList<String> commandList) {
        try {
            File file = new File(filePath);
            if (file.exists() == false) {
                return;
            }
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String command = sc.nextLine();
                commandList.add(command);
            }
            sc.close();
        } catch (FileNotFoundException exception) {
            System.out.println("No data storage file exists.");
        }
    }
}