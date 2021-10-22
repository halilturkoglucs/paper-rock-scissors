package com.turkoglu.rule;

import com.turkoglu.game.PlayerSelection;
import com.turkoglu.player.Player;

import java.util.List;

public class PaperRockScissorsGameRuleEngine implements RuleEngine {

    private List<Rule> rules;

    public PaperRockScissorsGameRuleEngine(List<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public Player decideOnWinner(List<PlayerSelection> playerSelections) {
        PlayerSelection firstPlayer = playerSelections.get(0);
        PlayerSelection secondPlayer = playerSelections.get(1);

        // Execute rules for the first player
        boolean firstPlayerWon = rules.stream().anyMatch(rule -> rule.applicable(firstPlayer.getSelection()) &&
                rule.execute(secondPlayer.getSelection()));

        boolean secondPlayerWon = rules.stream().anyMatch(rule -> rule.applicable(secondPlayer.getSelection()) &&
                rule.execute(firstPlayer.getSelection()));

        // draw
        if (!firstPlayerWon && !secondPlayerWon) {
            return null; // indicating a draw
        } else {
            return firstPlayerWon ? firstPlayer.getPlayer() : secondPlayer.getPlayer();
        }
    }
}
