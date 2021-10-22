package com.turkoglu.rule;

import com.turkoglu.game.Selection;

public class GameRuleScissorsBeatsPaper extends PaperRockScissorsGameRule {

    @Override
    public boolean applicable(Selection selection) {
        return Selection.SCISSORS.equals(selection);
    }

    @Override
    public boolean execute(Selection opponentsSelection) {
        return Selection.PAPER.equals(opponentsSelection);
    }
}
