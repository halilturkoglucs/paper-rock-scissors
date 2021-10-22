package com.turkoglu.rule;

import com.turkoglu.game.Selection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameRuleScissorsBeatsPaperTest {

    private GameRuleScissorsBeatsPaper rule;

    @BeforeEach
    public void setup() {
        this.rule = new GameRuleScissorsBeatsPaper();
    }

    @Test
    public void selectionPaperIsNotApplicable() {
        assertFalse(rule.applicable(Selection.PAPER));
    }

    @Test
    public void selectionRockIsNotApplicable() {
        assertFalse(rule.applicable(Selection.ROCK));
    }

    @Test
    public void selectionScissorsIsApplicable() {
        assertTrue(rule.applicable(Selection.SCISSORS));
    }

    @Test
    public void selectionExitIsNotApplicable() {
        assertFalse(rule.applicable(Selection.EXIT));
    }

}
