package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class MenuTest {

    private Menu menu;
    private PrintStream testStream;
    private InputReader inputReader;
    private Map<Integer, Command> commandMap;
    private Command command;


    @Before
    public void setup() {
        testStream = mock(PrintStream.class);
        inputReader = mock(InputReader.class);
        commandMap = new HashMap<>();

        menu = new Menu(testStream, inputReader, commandMap);
        command = mock(Command.class);
    }


    @Test
    public void shouldDisplayOptionsAtLaunch() {
        commandMap.put(1, command);
        when(command.getName()).thenReturn("Some Name");

        menu.launch();

        verify(testStream).println(contains("Some Name"));
    }

    @Test
    public void shouldPromptUserToSelectAnOptionAtLaunch() {
        menu.launch();

        verify(testStream).println(contains("Please select an option."));
    }

    @Test
    public void shouldEnumerateOptionsWhenDisplayingThem() {
        commandMap.put(1, command);
        when(command.getName()).thenReturn("Some Name");

        menu.launch();

        verify(testStream).println("[1] Some Name");
    }

    @Test
    public void shouldReadInputWhenLaunching() {
        menu.launch();

        verify(inputReader).readInt();
    }

    @Test
    public void shouldExecuteValidOptionWhenLaunching() {
        when(inputReader.readInt()).thenReturn(1);
        ListBooksCommand listBooksCommand = mock(ListBooksCommand.class);
        commandMap.put(1, listBooksCommand);

        menu.launch();

        verify(listBooksCommand).execute();
    }

    @Test
    public void shouldDisplayMessageWhenSelectingInvalidOption() {
        menu.launch();

        verify(testStream).println("Select a valid option!");
    }
}
