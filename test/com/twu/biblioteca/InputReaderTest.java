package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InputReaderTest {

    private InputReader inputReader;
    private BufferedReader bufferedReader;

    @Before
    public void setup() {
        bufferedReader = mock(BufferedReader.class);
        inputReader = new InputReader(bufferedReader);
    }

    @Test
    public void shouldReadUserInputAfterPrompt() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        int option = inputReader.readInt();

        assertThat(option, is(1));
    }

    @Test
    public void shouldReturnStringWhenReadingString() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Some string");

        String line = inputReader.readString();

        assertThat(line, is("Some string"));
    }

}