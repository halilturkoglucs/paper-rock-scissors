package com.turkoglu.game;

import com.turkoglu.player.ComputerPlayer;
import com.turkoglu.player.HumanPlayer;
import com.turkoglu.player.Player;
import com.turkoglu.rule.*;
import com.turkoglu.strategy.ManualSelectionStrategy;
import com.turkoglu.strategy.PlayingStrategy;
import com.turkoglu.strategy.RandomSelectionStrategy;

import java.util.*;

public class PaperRockScissorsGame implements Game {

    private List<Player> players;
    private RuleEngine ruleEngine;
    private Map<Player, Integer> statistics;
    private int round;

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

        // Clear the round and the statistics
        this.statistics = new HashMap<>();
        this.round = 0;
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
    public Player play() {
        this.round++;

        List<PlayerSelection> selectionsOfPlayers = new ArrayList<>();

        for (Player player : players) {
            PlayerSelection playerSelection = new PlayerSelection(player, player.play());
            selectionsOfPlayers.add(playerSelection);
        }

        // Decide this round's winner
        Player winner = ruleEngine.decideOnWinner(selectionsOfPlayers);
        int totalWins = statistics.getOrDefault(winner, 0) + 1;
        statistics.put(winner, totalWins);

        return winner;
    }

    @Override
    public void stop() {
        System.out.println("Statistics of the game:");

        players.forEach(player -> {
            int wins = statistics.get(player);
            System.out.println("Player " + player + " won " + wins + " times");
        });

        System.out.println("There were a total of " + this.statistics.get(null) + " draws");
    }
}
