package org.example.model;

import org.example.model.GameSaveState;
import org.example.model.GameState;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameSaveStateTest {

    @Test
    void testGameSaveStateConstructorAndGetters() {
        GameSaveState state = new GameSaveState(5, 5, 10, GameState.IN_PROGRESS, true);

        assertEquals(5, state.getRows());
        assertEquals(5, state.getCols());
        assertEquals(10, state.getMines());
        assertEquals(GameState.IN_PROGRESS, state.getGameState());
        assertTrue(state.isMinesPlaced());
    }
}
