package com.turkoglu.game;

public class InvalidSelectionException extends RuntimeException {

    public InvalidSelectionException(String selection) {
        super("Invalid selection: " + selection);
    }
}
