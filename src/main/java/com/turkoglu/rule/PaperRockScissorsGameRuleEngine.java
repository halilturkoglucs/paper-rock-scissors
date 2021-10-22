package com.turkoglu.rule;

import com.turkoglu.game.PlayerSelection;
import com.turkoglu.player.Player;

import java.util.List;

public class PaperRockScissorsGameRuleEngine implements RuleEngine {

    private final List<Rule> rules;

    public PaperRockScissorsGameRuleEngine(List<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public Player decideOnWinner(List<PlayerSelection> playerSelections) {
        if (playerSelections.isEmpty() || playerSelections.size() > 2) throw new IllegalArgumentException();

        PlayerSelection firstPlayer = playerSelections.get(0);
        PlayerSelection secondPlayer = playerSelections.get(1);

        // Execute rules for the first player
        boolean firstPlayerWon = rules.stream().anyMatch(rule -> rule.applicable(firstPlayer.getSelection()) &&
                rule.winsAgainst(secondPlayer.getSelection()));

        if (firstPlayerWon) return firstPlayer.getPlayer();

        // Execute rules for the second player in case the first player has not won
        boolean secondPlayerWon = rules.stream().anyMatch(rule -> rule.applicable(secondPlayer.getSelection()) &&
                rule.winsAgainst(firstPlayer.getSelection()));

        // draw
        if (!secondPlayerWon) {
            return null; // indicating a draw
        } else {
            return secondPlayer.getPlayer();
        }
    }
}
