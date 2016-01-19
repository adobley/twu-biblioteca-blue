package com.twu.biblioteca;

public class CheckoutBookCommand extends Command{

    private Library library;

    public CheckoutBookCommand(String name, Library library) {
        super(name);
        this.library = library;
    }

    @Override
    public void execute() {
        library.checkoutBook();
    }
}
