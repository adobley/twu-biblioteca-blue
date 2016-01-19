package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class LibraryTest {

    PrintStream printStream;
    List<Book> books;
    Library library;
    Book bookOne;
    Book bookTwo;
    InputReader inputReader;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        inputReader = mock(InputReader.class);
        bookOne = mock(Book.class);
        bookTwo = mock(Book.class);

        books = new ArrayList<>();
        library = new Library(books, printStream, inputReader);
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
    public void shouldReadInputWhenCheckingOutBook() {
        when(inputReader.readInt()).thenReturn(1);
        books.add(bookOne);

        library.checkoutBook();

        verify(inputReader).readInt();
    }

    @Test
    public void shouldRemoveBookFromListWhenBookIsCheckedOut() {
        when(inputReader.readInt()).thenReturn(1);
        books.add(bookOne);
        books.add(bookTwo);

        library.checkoutBook();

        assertThat(books.contains(bookOne), is(false));
    }

    @Test
    public void shouldDisplaySuccessMessageWhenBookIsCheckedOut() {
        when(inputReader.readInt()).thenReturn(1);
        books.add(bookOne);
        books.add(bookTwo);

        library.checkoutBook();

        verify(printStream, atLeastOnce()).println("Thank you! Enjoy the book");
    }
}
