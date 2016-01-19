package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<Book> books;
    private PrintStream printStream;

    public Library(List<Book> books, PrintStream printStream) {
        this.books = books;
        this.printStream = printStream;
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

    public void checkoutBook(int bookIndex) {
        int index = bookIndex - 1;
        books.remove(index);
    }
}
