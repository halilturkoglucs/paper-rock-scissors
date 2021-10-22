package com.turkoglu;

import com.turkoglu.game.Game;
import com.turkoglu.game.PaperRockScissorsGame;
import com.turkoglu.game.ScannerCommandLineReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Paper-Rock-Scissors game is starting..");
        Scanner scanner = new Scanner(System.in);
        Game game = new PaperRockScissorsGame(new ScannerCommandLineReader(scanner));
        game.start();

        while(game.isOn()) {
            game.play();
        }

        System.out.println("The game is interrupted...");
        game.stop();
        System.out.println("Exiting..");
    }
}
