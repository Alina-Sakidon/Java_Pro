package HW6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> messages = Arrays.asList("INFO: Starting JuniorCrudServiceApplication using Java 17.0.7",
                "DEBUG: User admin created",
                "INFO: Starting AnotherApplication using Java 17.0.7",
                "DEBUG: User is logged in successfully",
                "ERROR: 500 Internal server error",
                "WORN: Aggregate matching wasn't triggered",
                "WORN: Supplier field cannot be empty");

        File file = new File("src/test.txt");
        if (!file.exists()) {
            if (file.createNewFile())
                System.out.println("Task1 - File is created.");
        } else {
            System.out.println("File is already exist");
        }
        FileWriter writer = new FileWriter(file);
        for (String message : messages) {
            writeLogMessage(writer, message);
        }
        writer.close();

        System.out.println("Task 2/3 - Read and print all log messages");
        readAndPrintAllFile(file);

        System.out.println("Task 4/5 - Print only selected log types messages");
        printLogMessage(file, "DEBUG", "INFO");
    }

    private static void readAndPrintAllFile(File file) {
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }
    }

    private static void printLogMessage(File file, String... logLevels) {
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitMessage = data.split(":");
                if (splitMessage.length == 2 && Arrays.asList(logLevels).contains(splitMessage[0]))
                    System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }
    }

    private static void writeLogMessage(FileWriter writer, String message) throws IOException {
        writer.append(message);
        writer.write(System.getProperty("line.separator"));
    }
}
