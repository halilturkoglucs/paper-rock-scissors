package com.turkoglu.game;

import com.turkoglu.player.ComputerPlayer;
import com.turkoglu.player.HumanPlayer;
import com.turkoglu.player.Player;
import com.turkoglu.rule.GameRulePaperBeatsRock;
import com.turkoglu.rule.GameRuleRockBeatsScissors;
import com.turkoglu.rule.GameRuleScissorsBeatsPaper;
import com.turkoglu.rule.PaperRockScissorsGameRuleEngine;
import com.turkoglu.rule.Rule;
import com.turkoglu.rule.RuleEngine;
import com.turkoglu.strategy.ManualSelectionStrategy;
import com.turkoglu.strategy.PlayingStrategy;
import com.turkoglu.strategy.RandomSelectionStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PaperRockScissorsGame implements Game {

    private List<Player> players;
    private RuleEngine ruleEngine;
    private Map<Player, Integer> statistics;
    private boolean on;

    public PaperRockScissorsGame() {
        this.players = new ArrayList<>();

        List<Rule> rules = new ArrayList<>();
        rules.add(new GameRulePaperBeatsRock());
        rules.add(new GameRuleRockBeatsScissors());
        rules.add(new GameRuleScissorsBeatsPaper());

        this.ruleEngine = new PaperRockScissorsGameRuleEngine(rules);
    }

    @Override
    public void start(Scanner scanner) {
        Player humanPlayer = initialiseHumanPlayer(scanner);
        Player computerPlayer = initialiseComputerPlayer();

        players.add(humanPlayer);
        players.add(computerPlayer);

        this.on = true;

        // Clear the statistics
        this.statistics = new HashMap<>();
    }

    private Player initialiseHumanPlayer(Scanner scanner) {
        PlayingStrategy strategy = new ManualSelectionStrategy(scanner);
        return new HumanPlayer(strategy);
    }

    private Player initialiseComputerPlayer() {
        PlayingStrategy strategy = new RandomSelectionStrategy();
        return new ComputerPlayer(strategy);
    }

    @Override
    public boolean play() {
        List<PlayerSelection> selectionsOfPlayers = new ArrayList<>();

        for (Player player : players) {
            Selection selection = player.play();

            // If any decides to exit, finish the game
            if (Selection.EXIT.equals(selection)) {
                this.on = false;
                return false;
            }

            PlayerSelection playerSelection = new PlayerSelection(player, selection);
            selectionsOfPlayers.add(playerSelection);
        }

        // Decide this round's winner
        Player winner = ruleEngine.decideOnWinner(selectionsOfPlayers);

        if (winner == null) System.out.println("No winners this round - draw");
        else System.out.println("Winner of the round is " + winner);

        // Update statistics
        int totalWins = statistics.getOrDefault(winner, 0) + 1;
        statistics.put(winner, totalWins);

        return true;
    }

    @Override
    public void stop() {
        this.on = false;

        System.out.println("Statistics of the game:");

        players.forEach(player -> {
            int wins = statistics.getOrDefault(player, 0);
            System.out.println("Player " + player + " won " + wins + " times");
        });

        System.out.println("There were a total of " + this.statistics.get(null) + " draws");
    }

    public boolean isOn() {
        return this.on;
    }
}
