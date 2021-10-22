package com.turkoglu.strategy;

import com.turkoglu.game.Selection;

public interface PlayingStrategy {

    /**
     * Decide on the next move depending on the strategy
     * @return
     */
    Selection decide();

}
