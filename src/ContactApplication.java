
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

        String directory = "Contacts";
        String filename = "contacts.txt";
        Mainapp(directory,filename);

    }



    public static void Mainapp(String directory, String filename){
          ArrayList<String> contactos=new ArrayList<>();

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");
            int option=Input.getInt();
            switch (option){
                case 1:
            try {
                readLines(directory, filename);
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
            Mainapp(directory,filename);

                case 2:
            contactos=makeList();
            writeFile(contactos,directory,filename);
            Mainapp(directory,filename);
                case 3:
            System.out.println("pleasse enter the contact name");
            String name=Input.getString();
            try {
                findContact(name,directory,filename);
                Mainapp(directory,filename);
            }catch (IOException e){
                System.out.println("The user that you entered is not on you Contacts"+e.getMessage());
                Mainapp(directory,filename);
            }
                case 4:
            ArrayList<String>allcontactos;
            System.out.println("Please enter the contact name to delete");
            String inputName=Input.getString();
            try {
                allcontactos=deleteContact(inputName,directory,filename);
                overwriteFile(allcontactos,directory,filename);
                Mainapp(directory,filename);
            }catch (IOException e){
                System.out.println(e.getMessage());
                Mainapp(directory,filename);
            }
                case 5:
                    System.out.println("Exiting program");
                    break;

                    default:
                        System.out.println("please enter a valid number for the menu options");

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
        if (list.isEmpty()){
            System.out.println("the contact list is empty");
        }
        for(String item : list) {
                System.out.println(item);
        }
    }

    public static void findContact(String name,String directory, String filename) throws IOException {
        Path filePath = Paths.get(directory, filename);
        List<String> list = Files.readAllLines(filePath);
        for(String item : list) {
            if (item.contains(name)) {
                System.out.println(item);
            }
        }
    }

    //method to delete a record on the file
    public static ArrayList<String> deleteContact(String name,String directory, String filename) throws IOException {
        Path filePath = Paths.get(directory, filename);
        List<String> list = Files.readAllLines(filePath);
        if (Files.notExists(filePath)){
            throw new IOException("the file doesn't exist");
        }
        boolean found=false;
        ArrayList<String> esta=new ArrayList<>();
        esta.addAll(list);
        int index=esta.size()+1;
        for(String item : esta) {
            if (item.equalsIgnoreCase(name)){
                index=esta.indexOf(item);
                found=true;
            }
        }
        if (found==false){
            System.out.println("the element was not found, please enter a valid contact");
            name=Input.getString();
            return deleteContact(name,directory,filename);
        }
        esta.remove(index);
        return  esta;
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
            list.add(name+" | "+number);
            System.out.println("Do you want to add another item to the list? Press y or Yes to continue");
        } while(Input.yesNo());
        return list;
    }

    }





