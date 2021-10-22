package com.turkoglu.player;

import com.turkoglu.game.Selection;
import com.turkoglu.strategy.PlayingStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerTest {

    @Mock
    private PlayingStrategy strategy;

    @Test
    public void whenPlayerIsHuman_thenDecide() {
        Selection selection = Selection.PAPER;
        when(strategy.decide()).thenReturn(selection);

        Player player = new HumanPlayer(strategy);
        player.play();

        verify(strategy, times(1)).decide();
    }

    @Test
    public void whenPlayerIsComputer_thenDecide() {
        Selection selection = Selection.PAPER;
        when(strategy.decide()).thenReturn(selection);

        Player player = new ComputerPlayer(strategy);
        player.play();

        verify(strategy, times(1)).decide();
    }
}
