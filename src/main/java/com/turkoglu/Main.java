package com.turkoglu;

import com.turkoglu.game.ExitGameException;
import com.turkoglu.game.PaperRockScissorsGame;
import com.turkoglu.player.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Paper-Rock-Scissors game is starting..");
        PaperRockScissorsGame game = new PaperRockScissorsGame();
        game.start(scanner);

        while(true) {
            try {
                Player winnerOfTheRound = game.play();
                if (winnerOfTheRound == null) System.out.println("No winners this round - draw");
                else System.out.println("Winner of the round is " + winnerOfTheRound.toString());
            } catch (ExitGameException e) {
                System.out.println("The game is interrupted...");
                game.stop();
                System.out.println("Exiting..");
                break;
            }
        }
    }
}
