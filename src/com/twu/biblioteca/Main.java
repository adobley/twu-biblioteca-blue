package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        InputReader inputReader = new InputReader(bufferedReader);
        Library library = new Library(bookList(), new ArrayList<Book>(), printStream, inputReader);
        ApplicationState applicationState = new ApplicationState();

        Menu menu = new Menu(printStream, inputReader, commandMap(library, applicationState));

        Librarian librarian = new Librarian(library, menu, printStream, applicationState);

        librarian.openLibrary();
    }

    private static List<Book> bookList() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Dracula", "Bram Stoker", "1875"));
        books.add(new Book("Moby Dick", "Herman Melville", "1890"));
        return books;
    }

    private static Map<Integer, Command> commandMap(Library library, ApplicationState applicationState) {
        Map<Integer, Command> commandMap = new HashMap<>();
        commandMap.put(1, new ListBooksCommand("List Books", library));
        commandMap.put(2, new CheckoutBookCommand("Checkout Book", library));
        commandMap.put(3, new ReturnBookCommand("Return Book", library));
        commandMap.put(4, new QuitCommand("Quit", applicationState));
        return commandMap;
    }
}
