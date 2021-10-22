package com.turkoglu.rule;

import com.turkoglu.game.PlayerSelection;
import com.turkoglu.game.Selection;
import com.turkoglu.player.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaperRockScissorsGameRuleEngineTest {

    private static List<Rule> rules;

    private PaperRockScissorsGameRuleEngine engine;

    @Mock
    private Player player1;

    @Mock
    private Player player2;

    @BeforeAll
    public static void beforeAll() {
        rules = new ArrayList<>();
        rules.add(new GameRulePaperBeatsRock());
        rules.add(new GameRuleRockBeatsScissors());
        rules.add(new GameRuleScissorsBeatsPaper());
    }

    @BeforeEach
    public void beforeEach() {
        engine = new PaperRockScissorsGameRuleEngine(rules);
    }

    /**
     * For simplicity, the project supports 2 players, thus 2 selections on each round: one for computer, one for human
     * However, it can be extended. However, to ensure this case for now, we can
     * use IllegalArgumentException
     */
    @Test
    public void throwIllegalArgumentException_whenThereAreMoreThanTwoUsers() {
        PlayerSelection firstSelection = new PlayerSelection(player1, Selection.PAPER);
        PlayerSelection secondSelection = new PlayerSelection(player2, Selection.ROCK);
        PlayerSelection thirdSelection = new PlayerSelection(player1, Selection.SCISSORS);


        List<PlayerSelection> selections = new ArrayList<>();
        selections.add(firstSelection);
        selections.add(secondSelection);
        selections.add(thirdSelection);


        assertThrows(IllegalArgumentException.class, () -> engine.decideOnWinner(selections));
    }

    @Test
    public void paperBeatsRock() {
        PlayerSelection firstSelection = new PlayerSelection(player1, Selection.ROCK);
        PlayerSelection secondSelection = new PlayerSelection(player2, Selection.PAPER);

        List<PlayerSelection> selections = new ArrayList<>();
        selections.add(firstSelection);
        selections.add(secondSelection);

        Player winner = engine.decideOnWinner(selections);
        assertEquals(player2, winner);
    }

    @Test
    public void rockBeatsScissors() {
        PlayerSelection firstSelection = new PlayerSelection(player1, Selection.ROCK);
        PlayerSelection secondSelection = new PlayerSelection(player2, Selection.SCISSORS);

        List<PlayerSelection> selections = new ArrayList<>();
        selections.add(firstSelection);
        selections.add(secondSelection);

        Player winner = engine.decideOnWinner(selections);
        assertEquals(player1, winner);
    }

    @Test
    public void scissorsBeatsPaper() {
        PlayerSelection firstSelection = new PlayerSelection(player1, Selection.PAPER);
        PlayerSelection secondSelection = new PlayerSelection(player2, Selection.SCISSORS);

        List<PlayerSelection> selections = new ArrayList<>();
        selections.add(firstSelection);
        selections.add(secondSelection);

        Player winner = engine.decideOnWinner(selections);
        assertEquals(player2, winner);
    }

}
