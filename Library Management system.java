package com.company;

import java.util.Scanner;
import java.util.ArrayList;

abstract class Book {
    int noOfBooks = 0;
    ArrayList<String> array = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    abstract void register();

    void addBook() {
        System.out.println("Enter the book name you want to add: ");
        String temp = sc.nextLine();
        array.add(temp);
        noOfBooks++;
        System.out.println("Book has be successfully added");
        this.displayBooks();
    }

    void displayBooks() {
        System.out.println("The list of available books is: ");
        for (String item : this.array) {
            if (item == null) {
                continue;
            }
            System.out.println("  * " + item);
        }
    }
}

class Library extends Book {
    ArrayList<String> names = new ArrayList<>();

    @Override
    void register() {
        System.out.println("Enter your name: ");
        names.add(sc.nextLine());
        // sc.nextLine();
        System.out.println("** Registration successful **");
    }

    void displayUsers() {
        System.out.println("Displaying all the registered people");
        for (String name : names) {
            System.out.println("   * " + name);
        }
    }

    void issueBook() {
        System.out.println("Enter the name of book you want to issue: ");
        String bookName = sc.nextLine(); // sc.nextLine();
        System.out.println("Enter the name who wants to issue the book: ");
        String name = sc.nextLine();

        for (int i = 0; i < noOfBooks; i++) {
            if (array.contains(bookName) && names.contains(name)) {
                System.out.println(bookName + " issued successfully to " + name);
                array.remove(bookName);
            }
        }
    }

    void returnBook() {
        System.out.println("Enter the book name you want to return: ");
        String returnName = sc.nextLine();
        array.add(returnName);
        System.out.println(returnName + " book has be returned successfully");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {

        Library l1 = new Library();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("Welcome to the Library!!");

        System.out.println("Choose the task you want to perform");
        System.out.println("1. Register");
        System.out.println("2. Add Book");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. Display All Available Books");
        System.out.println("6. Display Registered people");
        while (true) {
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            if (choice == 1) {
                l1.register();
            } else if (choice == 2) {
                l1.addBook();
            } else if (choice == 3) {
                l1.issueBook();
            } else if (choice == 4) {
                l1.returnBook();
            } else if (choice == 5) {
                l1.displayBooks();
            } else if (choice == 6) {
                l1.displayUsers();
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}
