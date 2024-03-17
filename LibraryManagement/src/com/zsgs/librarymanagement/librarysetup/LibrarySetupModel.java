package com.zsgs.librarymanagement.librarysetup;

import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;

public class LibrarySetupModel {
    private LibrarySetupView librarySetupView;
    private LibraryDatabase libraryDatabase;
    private Library library;

    LibrarySetupModel(LibrarySetupView librarySetupView) {
        this.librarySetupView = librarySetupView;
        libraryDatabase = libraryDatabase.getInstance();
        library = LibraryDatabase.getInstance().getLibrary();
    }

    public void setLibrary(
            String libraryName,
            int id,
            String phoneNo,
            String email,
            String address
    ) {

        Library library = new Library();

        library.setLibraryName(libraryName);
        library.setLibraryId(id);
        library.setPhoneNo(phoneNo);
        library.setEmailId(email);
        library.setAddress(address);

        libraryDatabase.insertLibrary(library);

        librarySetupView.onSetupComplete();

    }
    public void startSetup() {
        if(library == null || library.getLibraryId() == 0) {
            librarySetupView.initiateSetup();
        } else {
            librarySetupView.onSetupComplete();
        }
    }
}
