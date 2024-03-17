package com.zsgs.librarymanagement.librarysetup;

import java.util.Scanner;

import com.zsgs.librarymanagement.*;
import com.zsgs.librarymanagement.book.BookView;

public class LibrarySetupView {

    private LibrarySetupModel librarySetupModel;

    public LibrarySetupView() {
        librarySetupModel = new LibrarySetupModel(this);
    }

    public void init() {
        librarySetupModel.startSetup();
    }

    public void onSetupComplete() {
        System.out.println("\nLibrary setup already completed.");
        new BookView().init();
    }

    public void showAlert(String alert) {
        System.out.println(alert);
    }

    public void initiateSetup() {
        System.out.println("\n\nGet Library Details from here.");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter library name: ");
        String libraryName = sc.nextLine();

        System.out.print("Enter library id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter phone no: ");
        String phoneNo = sc.nextLine();
        //sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter address: ");
        String address = sc.nextLine();

        librarySetupModel.setLibrary(
                libraryName,
                id,
                phoneNo,
                email,
                address
        );


    }
    
}
