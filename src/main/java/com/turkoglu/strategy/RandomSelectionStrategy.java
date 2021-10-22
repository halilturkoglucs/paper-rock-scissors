package com.turkoglu.strategy;

import com.turkoglu.game.Selection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomSelectionStrategy implements PlayingStrategy {

    private static final int SELECTION_SIZE = Selection.values().length;

    private static final Map<Integer, Selection> selections = new HashMap<>();

    static {
        Selection[] selectionEnums = Selection.values();

        for (int i = 0; i < selectionEnums.length; i++) {
            selections.put(i+1, selectionEnums[i]);
        }
    }

    public RandomSelectionStrategy() {

    }

    @Override
    public Selection decide() {
        Random random = new Random();
        // random selection between [1, SELECTION_SIZE] inclusive
        int randomChoice = random.nextInt(SELECTION_SIZE - 1) + 1;

        return selections.get(randomChoice);
    }
}
