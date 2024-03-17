package com.zsgs.librarymanagement.users;

import java.util.Scanner;

import com.zsgs.librarymanagement.model.User;
import com.zsgs.librarymanagement.book.BookView;

public class UsersView {

	private UsersModel usersModel;
	private BookView bookView;

	public UsersView() {
		usersModel = new UsersModel(this);
		bookView = new BookView();
	}

	public void initAdd() {
		System.out.println("Enter the following user Details: ");
		Scanner scanner = new Scanner(System.in);
		User user = new User();
		System.out.println("\nEnter user name:");
		user.setName(scanner.nextLine());
		System.out.println("\nEnter user emailId:");
		user.setEmailId(scanner.next());
		usersModel.addNewUser(user);
	}

	public void showLibraryName(String libraryName) {
		System.out.println("Current Library Name - " + libraryName);
	}

	public void onUserAdded(User user) {
		System.out.println("\n------- User '" + user.getName() + "' added successfully ------- \n");
		checkForAddNewUser();
	}

	public void onUserExist(User user) {
		System.out.println("\n------- User '" + user.getName() + "' already exist -------\n");
		checkForAddNewUser();
	}

	private void checkForAddNewUser() {
		System.out.println("Do you want to add more users? \nType Yes/No");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("yes")) {
			initAdd();
		} else if (choice.equalsIgnoreCase("no")) {
			System.out.println("\n Thanks for adding users");
			bookView.init();
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForAddNewUser();
		}
	}
}

