package com.twu.biblioteca;

public class ReturnBookCommand extends Command {
    private Library library;

    public ReturnBookCommand(String name, Library library) {
        super(name);
        this.library = library;
    }

    @Override
    void execute() {
        library.returnBook();
    }
}
