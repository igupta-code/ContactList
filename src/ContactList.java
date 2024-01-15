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

        for(int i = 0; i < contacts.size()-1; i++){
            for(int j = 0; j < contacts.size() - i; j++){
                if(0 > contacts.get(i).firstName.compareTo(contacts.get(i+1).firstName)){
                    Person swap = contacts.get(i);
                    contacts.set(i, contacts.get(i+1));
                    contacts.set(i+1, swap);
                }
            }
        }
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
        if(action == 1){
            addContacts();
        }
        else if(action == 0){
            return;
        }
        else if(action > 1 && action < 5){
            sort(action-2);
        }
        else if(action == 5){
            listStudents();
        }
        else if(action > 5){
            return;
        }
    }

    public void listStudents(){
        return;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to your Contact List");
        System.out.println("Please pick from the following menu options \n");
        ContactList test = new ContactList();
        test.run();
    }


}
