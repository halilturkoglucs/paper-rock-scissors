package com.turkoglu.rule;

import com.turkoglu.game.Selection;

public class GameRulePaperBeatsRock extends PaperRockScissorsGameRule {

    @Override
    public boolean applicable(Selection selection) {
        return Selection.PAPER.equals(selection);
    }

    @Override
    public boolean execute(Selection opponentsSelection) {
        return Selection.ROCK.equals(opponentsSelection);
    }
}
