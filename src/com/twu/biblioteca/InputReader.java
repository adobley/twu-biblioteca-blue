package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;

public class InputReader {
    private BufferedReader bufferedReader;

    public InputReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int readInt() {
        return Integer.parseInt(readString());
    }

    public String readString() {
        String string = "";

        try {
            string = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return string;
    }
}
