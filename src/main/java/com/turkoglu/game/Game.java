package com.turkoglu.game;

public interface Game {

    void start();

    /**
     * a false value indicates the round is exited by a player
     * @return boolean
     */
    boolean play();

    void stop();

    boolean isOn();
}
