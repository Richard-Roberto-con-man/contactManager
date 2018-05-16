
import java.io.*;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import util.Input;


public class ContactApplication {

    public static void main(String[] args) {
        List<String> contactos;

        String directory = "Contacts";
        String filename = "contacts.txt";

        createFileOnce(directory,filename);
        ArrayList<String> myContacts=makeList();
        overwriteFile(myContacts,directory,filename);
        try {
            readLines(directory,filename);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        //using deleteContact method (it runs ok)
        System.out.println("please enter a contact yo want to delete");
        try {
            List<String> despues = deleteContact(Input.getString(), directory, filename);
            for (String e : despues) {
                System.out.println(e);
            }
        }catch (IOException e){
            System.out.println(e);
        }

    }



    public static void Mainapp(){

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");

        if(Input.getInt()==1){

        }
        else if (Input.getInt()==2){

        }
        else if (Input.getInt()==3){

        }
        else if (Input.getInt()==4){

        }
        else if (Input.getInt()==5){

        }
    }




    //method that  a file on the passed directory and with passed (filename) name
    public static void  createFileOnce(String directory, String filename){

        Path dataDirectory=Paths.get(directory);
        Path dataFile=Paths.get(directory,filename);

        try {
            if(Files.notExists(dataFile)) {
                Files.createDirectory(dataDirectory);
            }
            if(Files.notExists(dataDirectory)){
                Files.createFile(dataFile);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    //method  to write an pre-existent file adding an ArrayList elements
    public static void writeFile(ArrayList<String> contactList,String directory, String filename){
            try {
                Files.write(Paths.get(directory, filename),
                        contactList
                        , StandardOpenOption.APPEND);
            }catch (IOException e){
                System.out.println(e);
            }
    }

    //method to overwrite a pre-existent file
    public static void overwriteFile(ArrayList<String> contactList,String directory, String filename){
        try {
            Files.write(Paths.get(directory, filename),
                    contactList);
        }catch (IOException e){
            System.out.println(e);
        }
    }

    //method that lopp and print out a line per time
    public static void readLines(String directory, String filename) throws IOException {
        Path filePath = Paths.get(directory, filename);
        List<String> list = Files.readAllLines(filePath);
        for(String item : list) {
                System.out.println(item);
        }
        }

    //method to delete a record on the file
    public static List<String> deleteContact(String name,String directory, String filename) throws IOException {
        Path filePath = Paths.get(directory, filename);
        List<String> list = Files.readAllLines(filePath);
        if (Files.notExists(filePath)){
            throw new IOException("the file doesn't exist");
        }
        for(String item : list) {
            if (item.equalsIgnoreCase(name)) {
                list.remove(item.indexOf(name));
            }
        }
            return  list;

    }



    //method to populate an ArrayList with Contact objects
    public static ArrayList<String> makeList() {
        ArrayList<String> list = new ArrayList<>();
        String name;
        String number;
        do {
            System.out.println("Please input the name  you want to add to the contact list.");
            name = Input.getString();
            System.out.println("Please input the phone number for the person you want to add to the contact list.");
            number=Input.getString();
            list.add(name+"|"+number);
            System.out.println("Do you want to add another item to the list? Press y or Yes to continue");
        } while(Input.yesNo());
        return list;
    }

    }





