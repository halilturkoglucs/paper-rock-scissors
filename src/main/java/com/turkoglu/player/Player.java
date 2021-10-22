package com.turkoglu.player;

import com.turkoglu.game.Selection;

public interface Player {

    /**
     * Player plays its turn returning their selection
     * @return
     */
    Selection play();
}
