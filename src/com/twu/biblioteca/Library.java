package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<Book> books;
    private PrintStream printStream;
    private InputReader inputReader;

    public Library(List<Book> books, PrintStream printStream, InputReader inputReader) {
        this.books = books;
        this.printStream = printStream;
        this.inputReader = inputReader;
    }

    public void bookList() {
        Formatter formatter = new Formatter();
        String header = formatHeader(formatter);

        int bookIndex = 1;

        printStream.println("No. " + header);

        for (Book book: books) {
            printStream.println("[" + bookIndex + "] " + book.formattedDetails());
            bookIndex++;
        }

        printStream.println();
    }

    private String formatHeader(Formatter formatter) {
        return formatter.formatSubstring("Title", 25) + formatter.formatSubstring("Author", 25) + formatter.formatSubstring("Year", 4);
    }

    public void checkoutBook() {
        printStream.println("Please select a book to checkout: ");
        int index = inputReader.readInt() - 1;
        books.remove(index);
        printStream.println("Thank you! Enjoy the book");
    }
}
