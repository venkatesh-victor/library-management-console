package com.zsgs.librarymanagement.book;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.Library;

import java.util.List;

public class BookModel {
    private BookView bookView;
    private LibraryDatabase libraryDatabase;

    public BookModel(BookView bookView) {
        this.bookView = bookView;
        Library library = LibraryDatabase.getInstance().getLibrary();
        libraryDatabase = LibraryDatabase.getInstance();
        BookView.showLibraryName(library.getLibraryName());
    }

    //method for setting up the book.
    public void setupBook( String  name, String author,
            String publication, String edition,
            String journer, long id,
            int volume, int availability
            )
    {

        if(libraryDatabase.getBook(id) == null) {
            Book book = new Book();
            book.setName(name);
            book.setAuthor(author);
            book.setPublication(publication);
            book.setEdition(edition);
            book.setJourner(journer);
            book.setId(id);
            book.setVolume(volume);
            book.setAvailability(availability);

            libraryDatabase.addBook(book);
            bookView.showAlert("Book added");
         // bookView.showAlert(libraryDatabase.getAllBook().get(0).getName());
        } else {
            bookView.showAlert("A book with the same id already exists.");
        }
    }

    //method for searching for a specific book.
    public void searchBook(String str) {
        Book searchedBook = libraryDatabase.search(str);
        if(searchedBook != null) {
            System.out.println("\n--------------------------------------------------");
            bookView.showAlert("Here are the details of the book you search for: ");
            bookView.showAlert("Book Name: " + searchedBook.getName());
            bookView.showAlert("Written by: " + searchedBook.getAuthor());
            bookView.showAlert("Edition: " + searchedBook.getEdition());
            bookView.showAlert("Volume: " + searchedBook.getVolume());
            bookView.showAlert("Library has " + searchedBook.getAvailability() + " no of book available at the moment.");
            System.out.println("-----------------------------------------------------");
        } else {
            bookView.showAlert("There is no book for the query: " + str);
        }
    }

    //method for viewing all the books in the library.
    public void viewAllBooks() {
        System.out.println("\n-----------------------------------------\n");
        List<Book> booklist = libraryDatabase.getAllBook();
        for(int i = 0; i < booklist.size(); i++) {
            bookView.showAlert(booklist.get(i).getName() + " Written by " + booklist.get(i).getAuthor());
        }
        System.out.println("\n-----------------------------------------\n");
    }

    // method for updating an existing book.
    public void updateBook(int updId, String edition, int volume, int availability) {
        Book toupdateBook = libraryDatabase.getBook(updId);
        if(toupdateBook != null) {
            toupdateBook.setEdition(edition);
            toupdateBook.setVolume(volume);
            toupdateBook.setAvailability(availability);

            bookView.showAlert("Book details updates successfully.");
        } else {
            bookView.showAlert("The book is not available.");
        }
    }
}
