package com.zsgs.librarymanagement.login;

import java.util.Scanner;
import com.zsgs.librarymanagement.librarysetup.LibrarySetupView;
import com.zsgs.librarymanagement.LibraryManagement;

public class LoginView {

    private LoginModel loginModel;

    public LoginView() {
        loginModel = new LoginModel(this);
    }

    public void init() {
        System.out.println("--- " + LibraryManagement.getInstance().getAppName() + " --- \nversion "
				+ LibraryManagement.getInstance().getAppVersion());
		System.out.println("\n\nPlease login to proceed.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the user name: ");
        String userName = sc.next();

        System.out.print("Enter the password: ");
        String password = sc.next();

        //sc.close();

        loginModel.setCredential(userName, password);
        loginModel.validateUser(userName, password);
    }

    public void onSuccess() {
        System.out.println("Login Success");

        LibrarySetupView librarySetupView = new LibrarySetupView();
        librarySetupView.init();
    }

    public void showAlert(String alert) {
        System.out.println(alert);
    }
}
