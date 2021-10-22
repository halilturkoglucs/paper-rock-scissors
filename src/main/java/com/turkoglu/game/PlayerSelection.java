package com.turkoglu.game;

import com.turkoglu.player.Player;

public class PlayerSelection {

    private Player player;
    private Selection selection;

    public PlayerSelection(Player player, Selection selection) {
        this.player = player;
        this.selection = selection;
    }

    public Player getPlayer() {
        return player;
    }

    public Selection getSelection() {
        return selection;
    }
}
