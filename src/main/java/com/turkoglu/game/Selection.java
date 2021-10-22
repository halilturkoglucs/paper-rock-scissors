package com.turkoglu.game;

import java.util.Arrays;

public enum Selection {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors"),
    EXIT("Exit");

    private String name;

    Selection(String name) {
        this.name = name;
    }

    public static Selection of(String name) throws InvalidSelectionException {
        return Arrays.stream(Selection.values())
                .filter(selection -> selection.toString().equals(name))
                .findFirst().orElseThrow(() -> new InvalidSelectionException(name));
    }

    public String toString() {
        return name;
    }
}
