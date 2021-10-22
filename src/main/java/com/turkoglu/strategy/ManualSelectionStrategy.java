package com.turkoglu.strategy;

import com.turkoglu.game.ExitGameException;
import com.turkoglu.game.Selection;

import java.util.Scanner;

public class ManualSelectionStrategy implements PlayingStrategy {

    private Scanner scanner;

    public ManualSelectionStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    public Selection decide() {
        String choice = scanner.nextLine();
        Selection selection = Selection.of(choice);

        if (Selection.EXIT.equals(selection)) throw new ExitGameException();
        return selection;
    }
}
