package com.twu.biblioteca;

public class CheckoutBookCommand extends Command{

    private Library library;
    private InputReader inputReader;

    public CheckoutBookCommand(String name, Library library, InputReader inputReader) {
        super(name);
        this.library = library;
        this.inputReader = inputReader;
    }

    @Override
    public void execute() {
        library.checkoutBook(inputReader.readInt());
    }
}
