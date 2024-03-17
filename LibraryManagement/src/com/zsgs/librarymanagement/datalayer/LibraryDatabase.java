package com.zsgs.librarymanagement.datalayer;

import java.util.ArrayList;
import java.util.List;

import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.model.User;

public class LibraryDatabase {
    private static LibraryDatabase libraryDatabase;
    private Library library;
    private List<Book> bookList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();

    public static LibraryDatabase getInstance() {
        if(libraryDatabase == null) {
            libraryDatabase = new LibraryDatabase();
        }
        return libraryDatabase;
    }

    public Library getLibrary() {
        return library;
    }

    public void insertLibrary(Library library2) {
        this.library = library2;
    }

    public List<Book> getAllBook() {
        return bookList;
    }

    public Book getBook(long bookId) {
        //run the for loop through the book list.
        for(Book book : bookList) {
            //if it finds the id then then return object.
            if(book.getId() == bookId) {
                return book;
            }
        }

        //if no book with the given id in the list is found then return null;
        return null;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public Book search(String str) {
        // search in the list of objects.
        for(Book book : bookList) {
            //if object with the given name is found then return the book.
            if(book.getName().contains(str)) {
                return book;
            }
        }
        //if no such book is found then return null.
        return null;
    }

    public boolean insertUser(User user) {
        boolean hasUser = false;

        for(User addedUser : userList) {
            if(addedUser.getEmailId().equals(user.getEmailId())) {
                hasUser = true;
                break;
            }
        }

        if(hasUser) {
            return false;
        } else {
            userList.add(user);
            return true;
        }
    }
}
