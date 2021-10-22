package com.turkoglu.player;

import com.turkoglu.game.InvalidSelectionException;
import com.turkoglu.game.Selection;
import com.turkoglu.strategy.PlayingStrategy;

public class HumanPlayer extends AbstractPlayer {

    PlayingStrategy strategy;

    public HumanPlayer(PlayingStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Selection decide() {
        System.out.println("----------------------");
        System.out.println("Please provide your selection: Paper|Rock|Scissors|Exit");
        try {
            return strategy.decide();
        } catch (InvalidSelectionException e) {
            System.out.println(e.getMessage());
            return decide();
        }
    }

    @Override
    public String toString() {
        return "Human";
    }
}
