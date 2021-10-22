package com.turkoglu.game;

import java.util.Scanner;

public interface Game {

    void start(Scanner scanner);

    /**
     * a false value indicates the round is exited by a player
     * @return boolean
     */
    boolean play();

    void stop();
}
