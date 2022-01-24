package com.company;

import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String email;
    private int mailboxCapacity;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";
    private String alternateEmail;

    //constructor recieve firstname and lastname
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created: " + this.firstName + " " + this.lastName);

        //call a method asking for the department -return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        //call a method for random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);

        //combine elements to generarte email

        email = firstName.toLowerCase() + "." + lastName.toLowerCase()+ "@" + department +"."+ companySuffix;
        System.out.println("Your email address is: " + email );

    }

    //Ask for department (sales, development, accounting) Leave blank if none
    private String setDepartment() {
        System.out.print(" Department Codes\n1 for Sales \n2 for Development\n3 for Accounting\n0 for none\nEnter Department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Development";
        } else if (depChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }

    }




    //generate random password

    private String randomPassword(int length) {

        String passwordSet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$";
        char[] password = new char[length];
        for (int i = 0; i < length; i++)
        {
            int rand = (int) (Math.random()* passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }


    //set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;

    }
    //change password
    public void changePassword(String password){
        this.password = password;
    }


    //get methods
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Display Name: " + firstName + " "+ lastName+ " Company email: " + email + " Mailbox Space: " + mailboxCapacity + "mb";
    }
}


