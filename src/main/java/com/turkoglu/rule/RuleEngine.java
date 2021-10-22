package com.turkoglu.rule;

import com.turkoglu.game.PlayerSelection;
import com.turkoglu.player.Player;

import java.util.List;

public interface RuleEngine {

    Player decideOnWinner(List<PlayerSelection> selections);
}
