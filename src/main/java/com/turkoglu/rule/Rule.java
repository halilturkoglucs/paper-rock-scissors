package com.turkoglu.rule;

import com.turkoglu.game.Selection;

public interface Rule {

    /**
     * Checks if the given move/selection is something that the rule decides on
     * @param selection
     * @return
     */
    boolean applicable(Selection selection);

    /**
     * Returns if player wins the round according to the rule
     * @param selection
     * @return
     */
    boolean execute(Selection selection);

}
