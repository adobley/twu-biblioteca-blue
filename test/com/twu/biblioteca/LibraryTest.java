package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    PrintStream printStream;
    List<Book> books;
    Library library;
    Book bookOne;
    Book bookTwo;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        bookOne = mock(Book.class);
        bookTwo = mock(Book.class);

        books = new ArrayList<>();
        library = new Library(books, printStream);
    }

    @Test
    public void shouldReturnOneFormattedBooksStringWhenOnlyOneBook() {
        books.add(bookOne);

        library.bookList();

        verify(bookOne).formattedDetails();
    }


    @Test
    public void shouldReturnSecondFormattedBookWhenMultipleBooksExist() {
        books.add(bookOne);
        books.add(bookTwo);

        library.bookList();

        verify(bookTwo).formattedDetails();
    }

    @Test
    public void shouldRemoveBookByIndexFromListWhenBookIsCheckedOut() {
        books.add(bookOne);
        books.add(bookTwo);

        library.checkoutBook(1);

        assertThat(books.contains(bookOne), is(false));
    }
}
