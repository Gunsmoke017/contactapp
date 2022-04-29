package contactapp;

import java.util.Scanner;
import contactapp.Contacts;

public class Controller {

    public void menu(){
        Contacts obj = new Contacts();
        Database obj1 = new Database();

        obj1.createContactFile();

        Scanner a = new Scanner(System.in);
        int choice;


        do {
            System.out.println("===========================");
            System.out.println("    >>>>Contact App<<<<    ");
            System.out.println("===========================");
            System.out.println("(1) View All Contacts\n(2) Create new Contact\n(3) Search contact\n(4) Delete  contact\n(5) Exit");
            choice = a.nextInt();
            switch(choice){
                case 1:
                    obj.viewAllContacts();
                    break;
                case 2:
                    obj.createNewContact();
                    break;
                case 3:
                    obj.searchForContact();
                    break;
                case 4:
                    obj.deleteContact();
                    break;
                case 5:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.err.println("Enter a valid action please");
            }

        } while(choice !=5);
    }
}
