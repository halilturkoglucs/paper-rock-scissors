package com.turkoglu.game;

import java.util.Scanner;

public class ScannerCommandLineReader implements CommandLineReader {

    private final Scanner scanner;

    public ScannerCommandLineReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readCommand() {
        return scanner.nextLine();
    }
}
