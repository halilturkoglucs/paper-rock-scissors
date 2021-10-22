package com.turkoglu.strategy;

import com.turkoglu.game.CommandLineReader;
import com.turkoglu.game.InvalidSelectionException;
import com.turkoglu.game.Selection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ManualSelectionStrategyTest {

    @Mock
    private CommandLineReader commandLineReader;

    private ManualSelectionStrategy strategy;

    @BeforeEach
    public void beforeEach() {
        this.strategy = new ManualSelectionStrategy(commandLineReader);
    }

    @Test
    public void decideRock() {
        when(commandLineReader.readCommand()).thenReturn("Rock");

        Selection selection = strategy.decide();

        assertEquals(Selection.ROCK, selection);
        verify(commandLineReader, times(1)).readCommand();
    }

    @Test
    public void decidePaper() {
        when(commandLineReader.readCommand()).thenReturn("Paper");

        Selection selection = strategy.decide();

        assertEquals(Selection.PAPER, selection);
        verify(commandLineReader, times(1)).readCommand();
    }

    @Test
    public void decideScissors() {
        when(commandLineReader.readCommand()).thenReturn("Scissors");

        Selection selection = strategy.decide();

        assertEquals(Selection.SCISSORS, selection);
        verify(commandLineReader, times(1)).readCommand();
    }

    @Test
    public void decideExit() {
        when(commandLineReader.readCommand()).thenReturn("Exit");

        Selection selection = strategy.decide();

        assertEquals(Selection.EXIT, selection);
        verify(commandLineReader, times(1)).readCommand();
    }

    @Test()
    public void decideInvalid() {
        when(commandLineReader.readCommand()).thenReturn("INVALID_SELECTION");

        assertThrows(InvalidSelectionException.class, strategy::decide);

        verify(commandLineReader, times(1)).readCommand();
    }

}
