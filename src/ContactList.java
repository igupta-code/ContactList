import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    ArrayList<Person> contacts;
    Scanner input = new Scanner(System.in);

    public ContactList(){
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts(){
        return contacts;
    }

    public void addContacts(){
        System.out.println("Select a type of contact to add: \n" +
                "1. Student \n2. Worker");
        int num = input.nextInt();
        input.nextLine();

        System.out.println("Please fill in the following information");
        System.out.println("First Name:" );
        String fName = input.nextLine();
        System.out.println("Last Name:" );
        String lName = input.nextLine();
        System.out.println("Phone Number: ");
        String pNum = input.nextLine();


        if (num == 1){
            System.out.println("Grade: ");
            int grade = input.nextInt();
            contacts.add(new Student(fName, lName, pNum, grade));
        }
        else{
            System.out.println("Company: ");
            String company = input.nextLine();
            contacts.add(new Worker(fName, lName, pNum, company));
        }
    }
    public void printContacts(){
        for(Person p : contacts){
            System.out.println(p);
        }
    }

    public void sort(int sortBy){
        if(sortBy == 0){
            for(int i = 0; i < contacts.size()-1; i++) {
                for (int j = 0; j < contacts.size() - i - 1; j++) {
                    if (0 < contacts.get(i).firstName.compareTo(contacts.get(i + 1).firstName)) {
                        swap(i);
                    }
                }
            }
        }
        if(sortBy == 1){
            for(int i = 0; i < contacts.size()-1; i++) {
                for (int j = 0; j < contacts.size() - i - 1; j++) {
                    if(0 < contacts.get(i).lastName.compareTo(contacts.get(i+1).lastName)){
                        swap(i);
                    }
                }
            }
        }
        if(sortBy == 2){
            for(int i = 0; i < contacts.size()-1; i++) {
                for (int j = 0; j < contacts.size() - i - 1; j++) {
                    if(0 < contacts.get(i).phoneNumber.compareTo(contacts.get(i+1).phoneNumber)){
                        swap(i);
                    }
                }
            }
        }

        printContacts();
    }

    // Method swaps the order of a person in contact with the person in front
    public void swap(int i){
        Person swap = contacts.get(i);
        contacts.set(i, contacts.get(i+1));
        contacts.set(i+1, swap);
    }
    // SearchBy: 6 = first name, 7 = last name, 8 = number
    public Person searchByFirstName(String firstName){
        for(Person p : contacts){
            if(p.getFirstName().equals(firstName)){
                return p;
            }
        }
        return null;
    }
    public Person searchByLastName(String lastName){
        for(Person p : contacts){
            if(p.getLastName().equals(lastName)){
                return p;
            }
        }
        return null;
    }
    public Person searchByPhoneNumber(String phoneNumber){
        for(Person p : contacts){
            if(p.getPhoneNumber().equals(phoneNumber)){
                return p;
            }
        }
        return null;
    }


    public void run(){
            System.out.println("Menu: \n1. Add Contact \n" +
                    "2. List All Contacts By First Name \n" +
                    "3. List All Contacts By Last Name \n" +
                    "4. List All Contacts By Phone Number\n" +
                    "5. List all Students\n" +
                    "6. Search By First Name\n" +
                    "7. Search By Last Name\n" +
                    "8. Search By Phone Number\n" +
                    "0. Exit \n");
            int action = input.nextInt();
            input.nextLine();
            if(action == 1){
                addContacts();
            }
            else if(action > 1 && action < 5){
                sort(action-2);
            }
            else if(action == 5){
                listStudents();
            }
            else if(action == 6){
                System.out.println("Enter first name: ");
                System.out.println(searchByFirstName(input.nextLine()));
            }
            else if(action == 7){
                System.out.println("Enter last name: ");
                System.out.println(searchByLastName(input.nextLine()));
            }
            else if(action == 8){
                System.out.println("Enter phone number: ");
                System.out.println(searchByPhoneNumber(input.nextLine()));
            }

            if(action != 0){
                run();
            }
    }

    public void listStudents(){
        for(Person p : contacts){
            if(p instanceof Student){
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to your Contact List");
        System.out.println("Please pick from the following menu options \n");
        ContactList test = new ContactList();
        test.run();
    }


}
