package com.turkoglu;

import com.turkoglu.game.PaperRockScissorsGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Paper-Rock-Scissors game is starting..");
        PaperRockScissorsGame game = new PaperRockScissorsGame();
        game.start(scanner);

        while(game.isOn()) {
            game.play();
        }

        System.out.println("The game is interrupted...");
        game.stop();
        System.out.println("Exiting..");
    }
}
