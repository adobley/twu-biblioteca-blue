package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Book> checkedOutBooks;
    private PrintStream printStream;
    private InputReader inputReader;

    public Library(List<Book> books, List<Book> checkedOutBooks, PrintStream printStream, InputReader inputReader) {
        this.books = books;
        this.checkedOutBooks = checkedOutBooks;
        this.printStream = printStream;
        this.inputReader = inputReader;
    }

    public void booksInLibrary() {
        listBooks(books);
    }

    public void booksCheckedOut() {
        listBooks(checkedOutBooks);
    }

    private void listBooks(List<Book> bookList) {
        Formatter formatter = new Formatter();
        String header = formatHeader(formatter);

        int bookIndex = 1;

        printStream.println();
        printStream.println("No. " + header);

        for (Book book : bookList) {
            printStream.println("[" + bookIndex + "] " + book.formattedDetails());
            bookIndex++;
        }
    }

    private String formatHeader(Formatter formatter) {
        return formatter.formatSubstring("Title", 25) + formatter.formatSubstring("Author", 25) + formatter.formatSubstring("Year", 4);
    }

    public void checkoutBook() {
        printStream.println("\nPlease select a book to checkout: ");
        booksInLibrary();
        printStream.print(">> ");
        int index = inputReader.readInt() - 1;
        if (index >= 0 && index < books.size()) {
            checkedOutBooks.add(books.remove(index));
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("That is not a valid book option.");
        }
    }

    public void returnBook() {
        printStream.println("\nPlease select a book to return: ");
        booksCheckedOut();
        printStream.print(">> ");
        int index = inputReader.readInt() - 1;
        if (index >= 0 && index < checkedOutBooks.size()) {
            books.add(checkedOutBooks.remove(index));
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("That is not a valid book option.");
        }
    }
}
