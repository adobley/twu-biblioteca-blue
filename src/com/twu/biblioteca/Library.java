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

        printStream.println("No. " + header);

        for (Book book : bookList) {
            printStream.println("[" + bookIndex + "] " + book.formattedDetails());
            bookIndex++;
        }

        printStream.println();
    }

    private String formatHeader(Formatter formatter) {
        return formatter.formatSubstring("Title", 25) + formatter.formatSubstring("Author", 25) + formatter.formatSubstring("Year", 4);
    }

    public void checkoutBook() {
        booksInLibrary();
        printStream.println("Please select a book to checkout: ");
        int index = inputReader.readInt() - 1;
        if (index >= 0 && index < books.size()) {
            checkedOutBooks.add(books.remove(index));
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("That book is not available.");
        }
    }

    public void returnBook() {
        booksCheckedOut();
        printStream.println("Please select a book to return: ");
        int index = inputReader.readInt() - 1;
        books.add(checkedOutBooks.remove(index));
        printStream.println("Thank you for returning the book.");
    }
}
