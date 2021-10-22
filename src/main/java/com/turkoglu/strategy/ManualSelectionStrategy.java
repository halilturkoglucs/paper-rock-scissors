package com.turkoglu.strategy;

import com.turkoglu.game.CommandLineReader;
import com.turkoglu.game.Selection;

public class ManualSelectionStrategy implements PlayingStrategy {

    private CommandLineReader commandLineReader;

    public ManualSelectionStrategy(CommandLineReader commandLineReader) {
        this.commandLineReader = commandLineReader;
    }

    public Selection decide() {
        String choice = commandLineReader.readCommand();
        return Selection.of(choice);
    }
}
