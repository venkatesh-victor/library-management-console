package com.zsgs.librarymanagement.users;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.User;

public class UsersModel {

	private UsersView usersView;

	UsersModel(UsersView usersView) {
		this.usersView = usersView;
	}

	public void addNewUser(User user) {
		if (LibraryDatabase.getInstance().insertUser(user)) {
			usersView.onUserAdded(user);
		} else {
			usersView.onUserExist(user);
		}
	}
}