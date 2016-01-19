package com.twu.biblioteca;

public class ListBooksCommand extends Command{

    private Library library;

    public ListBooksCommand(String name, Library library) {
        super(name);
        this.library = library;
    }

    @Override
    public void execute() {
        library.booksInLibrary();
    }
}
