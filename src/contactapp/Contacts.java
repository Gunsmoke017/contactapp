package contactapp;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Contacts implements IContactAppMethods{
    private String name, email;
    private Long phoneNumber;

    private String searchName;
    private Long phoneNumberDelete;

    public void setName(){
        Scanner a = new Scanner(System.in);
        System.out.println("Enter name: ");
        this.name = a.nextLine();

    }
    public String getName(){return name;}

    public void setEmail(){
        Scanner a = new Scanner(System.in);
        System.out.println("Enter email: ");
        this.email = a.nextLine();
    }
    public String getEmail(){return email;}

    public void setPhoneNumber(){
        Scanner a = new Scanner(System.in);
        System.out.println("Enter phone number");
        this.phoneNumber = a.nextLong();
    }
    public Long getPhoneNumber(){return phoneNumber;}

    @Override
    public void createNewContact(){
        setName();
        setEmail();
        setPhoneNumber();

        File file = new File("contactList.txt");

        try{
            FileWriter fwrite = new FileWriter(file,true);
            String temp = getName()+ "!" + getEmail()+ "!" + getPhoneNumber().toString()+"\n";
            System.out.println(" ");

            fwrite.write(temp);

            System.out.println("Contact has been added successfully");
            fwrite.close();
        }
        catch(IOException ee){
            ee.printStackTrace();
        }
    }

    public void setSearchName(){
        Scanner a = new Scanner(System.in);
        System.out.println("Enter name: ");
        this.searchName = a.nextLine();
    }

    public String getSearchName(){return searchName;}





    @Override
    public void searchForContact(){
        String[] holder;
        ArrayList<String> nameHolder = new ArrayList<>();
        ArrayList<String> emailHolder = new ArrayList<>();
        ArrayList<String> phoneNumberHolder = new ArrayList<>();

        setSearchName();

        File file = new File("contactList.txt");
        try{
            String lines;
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while((lines = reader.readLine())!=null){
                holder = lines.split("!");
                nameHolder.add(holder[0]);
                emailHolder.add(holder[1]);
                phoneNumberHolder.add(holder[2]);
            }

            for(int i =0; i<nameHolder.size(); i++){
                if(getSearchName().contains(nameHolder.get(i))){
                    System.out.println(nameHolder.get(i) + emailHolder.get(i) + phoneNumberHolder.get(i));
                    break;
                } else {}
            }
        }
        catch (IOException ee){}


    }

    public void setPhoneNumberDelete(){
        Scanner a = new Scanner(System.in);
        System.out.println("Enter phone number of contact you wish to delete:");
        this.phoneNumberDelete = a.nextLong();
    }

    public Long getPhoneNumberDelete(){
        return phoneNumberDelete;
    }

    @Override
    public void deleteContact(){
        String[] holder;
        ArrayList<String> nameHolder = new ArrayList<>();
        ArrayList<String> emailHolder = new ArrayList<>();
        ArrayList<String> phoneNumberHolder = new ArrayList<>();

        setPhoneNumberDelete();

        File file = new File("contactList.txt");
        try{

            String lines;
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while((lines = reader.readLine())!=null){
                holder = lines.split("!");
                nameHolder.add(holder[0]);
                emailHolder.add(holder[1]);
                phoneNumberHolder.add(holder[2]);
            }

            for(int i =0; i<phoneNumberHolder.size(); i++){

                if(getPhoneNumberDelete().toString().equals(phoneNumberHolder.get(i))){
                    System.out.println("====================================");
                    System.out.println(nameHolder.get(i) + emailHolder.get(i) + phoneNumberHolder.get(i));
                    System.out.println("THIS CONTACT WILL BE DELETED");

                    nameHolder.remove(nameHolder.get(i));
                    emailHolder.remove(emailHolder.get(i));
                    phoneNumberHolder.remove(phoneNumberHolder.get(i));

                    FileWriter fwrite = new FileWriter(file,true);
                    FileWriter eraser = new FileWriter(file);
                     eraser.write("");

                    for(int j =0; j< nameHolder.size();j++){
                        String temp = nameHolder.get(j)+ "!" + emailHolder.get(j)+ "!" + phoneNumberHolder.get(j)+"\n";
                        fwrite.write(temp);
                    }
                    fwrite.close();
                    break;
                } else {}
            }
        }
        catch (IOException ee){}
    }

    @Override
    public void viewAllContacts(){
        String[] holder;

        File file = new File("contactList.txt");
        try{
            String lines;
            BufferedReader reader = new BufferedReader(new FileReader(file));

            System.out.println(">>Name<<                    >>Email<<                   >>Phone Number<<");

            while((lines = reader.readLine())!=null){
                holder = lines.split("!");

                System.out.println(holder[0]+"                  " +holder[1]+"                  "+holder[2]);
            }

            reader.close();
        }
        catch (IOException ee){}
    }
}
