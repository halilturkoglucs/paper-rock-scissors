package com.turkoglu.player;

import com.turkoglu.game.Selection;
import com.turkoglu.strategy.PlayingStrategy;

public class ComputerPlayer extends AbstractPlayer {

    PlayingStrategy strategy;

    public ComputerPlayer(PlayingStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    Selection decide() {
        System.out.println("Computer deciding..");
        return strategy.decide();
    }

    @Override
    public String toString() {
        return "Computer";
    }
}
