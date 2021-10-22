package com.turkoglu.rule;

import com.turkoglu.game.Selection;

public class GameRuleRockBeatsScissors extends PaperRockScissorsGameRule {

    @Override
    public boolean applicable(Selection selection) {
        return Selection.ROCK.equals(selection);
    }

    @Override
    public boolean winsAgainst(Selection opponentsSelection) {
        return Selection.SCISSORS.equals(opponentsSelection);
    }
}
