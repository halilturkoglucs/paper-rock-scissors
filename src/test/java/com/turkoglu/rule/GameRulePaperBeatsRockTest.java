package com.turkoglu.rule;

import com.turkoglu.game.Selection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameRulePaperBeatsRockTest {

    private GameRulePaperBeatsRock rule;

    @BeforeEach
    public void setup() {
        this.rule = new GameRulePaperBeatsRock();
    }

    @Test
    public void selectionPaperIsApplicable() {
        assertTrue(rule.applicable(Selection.PAPER));
    }

    @Test
    public void selectionRockIsNotApplicable() {
        assertFalse(rule.applicable(Selection.ROCK));
    }

    @Test
    public void selectionScissorsIsNotApplicable() {
        assertFalse(rule.applicable(Selection.SCISSORS));
    }

    @Test
    public void selectionExitIsNotApplicable() {
        assertFalse(rule.applicable(Selection.EXIT));
    }

}
