
import java.io.*;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ContactApplication {

    public static void main(String[] args) {
        String directory = "Contacts";
        String filename = "contacts.txt";


        createFileIfNotExists(directory, filename);

        try {
            readLines(directory,filename);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createFileIfNotExists(String directory, String filename) {
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        try {
            if (Files.notExists(dataFile)) {
                Files.createDirectories(dataDirectory);
            }

            if (Files.notExists(dataFile)) {
                Files.createFile(dataFile);
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        public static void writeListToFile(ArrayList<String> list, String directory, String filenale) throws IOException {
            Path filePath = Paths.get(directory, filename);
            List<String> list = Files.readAllLines(filePath);

            for(String item : list) {
                System.out.println(item);
            }
        }

        public static ArrayList<String> makelist() {
            ArrayList<String> list = new ArrayList<>();
            Input input = new Input();
            String item;
            do {
                item = input.getString("Please input the item you want to add to the list.");

            } while (input.yesNo("Do you want to add another item to the list? Press y or yes to continue"));
            return list;
        }
    }

