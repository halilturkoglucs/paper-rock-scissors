package com.turkoglu.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaperRockScissorsGameTest {

    @Mock
    private CommandLineReader commandLineReader;

    private PaperRockScissorsGame game;

    @BeforeEach
    public void beforeEach() {
        game = new PaperRockScissorsGame(commandLineReader);
        game.start();
    }

    @Test
    public void start() {
        assertTrue(game.isOn());
    }

    @Test
    public void whenPlayerMakesASelection_thenRoundCompletes() {
        when(commandLineReader.readCommand()).thenReturn("Rock");

        boolean roundResult = game.play();

        assertTrue(roundResult);
        verify(commandLineReader, times(1)).readCommand();
    }

    @Test
    public void whenPlayerExits_thenRoundFails() {
        when(commandLineReader.readCommand()).thenReturn("Exit");

        boolean roundResult = game.play();

        assertFalse(roundResult);
        verify(commandLineReader, times(1)).readCommand();
    }

    @Test
    public void whenPlayerMakesAnInvalidSelection_thenUserIsPromptedAgain() {
        // Provide 4 invalid inputs which will trigger re-reading input resulting in 5 calls
        when(commandLineReader.readCommand())
                .thenReturn("INVALID_COMMAND", "INVALID_COMMAND2", " ", "", "Scissors");

        boolean roundResult = game.play();

        assertTrue(roundResult);
        verify(commandLineReader, times(5)).readCommand();
    }

    @Test
    public void play() {
        when(commandLineReader.readCommand())
                .thenReturn("Rock", "Scissors", "Paper", "INVALID_COMMAND", "Paper");

        // 4 rounds since one of the provided selections is invalid
        for (int i = 0; i < 4; i++) {
            boolean roundResult = game.play();
            assertTrue(roundResult);
        }

        verify(commandLineReader, times(5)).readCommand();
    }

    @Test
    public void playUntilPlayerSelectsExit() {
        when(commandLineReader.readCommand())
                .thenReturn("Rock", "Scissors", "Paper", "INVALID_COMMAND", "Paper", "Exit");

        // 4 rounds since one of the provided selections is invalid and at the 5th round, user exits
        boolean roundResult;

        for (int i = 0; i < 4; i++) {
            roundResult = game.play();
            assertTrue(roundResult);
        }

        roundResult = game.play();
        assertFalse(roundResult);

        verify(commandLineReader, times(6)).readCommand();
    }

    @Test
    public void stop() {
        game.stop();
        assertFalse(game.isOn());
    }
}
