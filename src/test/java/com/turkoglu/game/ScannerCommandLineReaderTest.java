package com.turkoglu.game;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScannerCommandLineReaderTest {

    @Test
    public void readCommand() {
        final String command = "Rock";
        ByteArrayInputStream in = new ByteArrayInputStream(command.getBytes());
        Scanner scanner = new Scanner(in);

        ScannerCommandLineReader reader = new ScannerCommandLineReader(scanner);
        String readCommand = reader.readCommand();

        assertEquals("Rock", readCommand);
    }
}
