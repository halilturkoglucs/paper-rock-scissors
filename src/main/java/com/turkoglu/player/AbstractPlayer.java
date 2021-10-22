package com.turkoglu.player;

import com.turkoglu.game.Selection;

public abstract class AbstractPlayer implements Player {

    abstract Selection decide();

    public Selection play() {
        Selection selection = decide();
        System.out.println(this + " decided to choose: " + selection);

        return selection;
    }
}
