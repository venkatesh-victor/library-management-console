package com.zsgs.librarymanagement.book;

import java.util.Scanner;

import com.zsgs.librarymanagement.users.UsersView;
import com.zsgs.librarymanagement.users.UsersModel;

public class BookView {
    private Scanner sc = new Scanner(System.in);
    private BookModel bookModel;
 
    
    public BookView() {
        bookModel = new BookModel(this);
    }

    public void init() {
        //unstopping loop for keeping the application running.
        while(true) {
            System.out.println("1.Add Book  2.Search Book  3.Update Book");
            System.out.println("4.To view all the books available. 5.Add user  0.Exit \n Enter the choice");
            
            sc.nextLine();
            int choice = sc.nextInt();
            switch (choice) {
                case 1 : {
                    addBook();
                    break;
                } case 2 : {
                    searchBook();
                    break;
                } case 3: {
                    updateBook();
                    break;
                } case 4: {
                    viewBooks();
                    break;
                } case 5: {
                    UsersView usersView = new UsersView();
                    usersView.initAdd();
                }case 0: {
                    return;
                } default: {
                    System.out.println("Invalid choice.");
                }
            }
        }
    }

    public void viewBooks() {
        bookModel.viewAllBooks();
    }

    private void updateBook() {
        //edition, volume, availability.
        sc.nextLine();
        System.out.print("Enter id to update book:");
        int updId = sc.nextInt();
        System.out.print("Enter new edition number: ");
        String edition = sc.nextLine();
        System.out.print("Enter new volume number: ");
        int volume = sc.nextInt();
        System.out.print("Enter the new available count of the book: ");
        int availability = sc.nextInt();
        bookModel.updateBook(updId, edition, volume, availability);
    }

    private void searchBook() {
        //nextline() method for consuming the newline character if it exists in the terminal.
        sc.nextLine();
        System.out.println("Enter the book name you want to search for: ");
        String str = sc.nextLine();
        bookModel.searchBook(str);
    }

    private void addBook() {
        //method logic for adding the book.
        System.out.print("Enter book id: ");
        long id = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter book name: ");
        String name = sc.nextLine();
        System.out.print("Enter volume: ");
        int volume = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter author name: ");
        String author = sc.nextLine();
        System.out.print("Enter publication: ");
        String publication = sc.nextLine();
        System.out.print("Enter edition: ");
        String edition = sc.nextLine();
        System.out.print("Enter Genre: ");
        String journer = sc.nextLine();
        System.out.print("Enter how many books available: ");
        int availability = sc.nextInt();

        bookModel.setupBook(
                name, author, publication, edition, journer, id,
                volume, availability
        );

    }

    public static void showLibraryName(String libraryName) {
        System.out.println("Current Library Name - " + libraryName);
    }

    public void showAlert(String alert) {
        System.out.println(alert);
    }

}
