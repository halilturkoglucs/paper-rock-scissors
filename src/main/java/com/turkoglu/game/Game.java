package com.turkoglu.game;

import com.turkoglu.player.Player;

import java.util.Scanner;

public interface Game {

    void start(Scanner scanner);

    /**
     * Returns the winner of the round
     * @return
     */
    Player play();

    void stop();
}
