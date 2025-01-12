package org.example.model;

import org.example.model.CellState;
import org.example.model.SavedGameState;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SavedGameStateTest {

    @Test
    void testSavedGameStateConstructorAndGetters() {
        List<CellState> cells = new ArrayList<>();
        cells.add(new CellState(true, false, false, 3));

        SavedGameState state = new SavedGameState(10, 10, 20, cells, "IN_PROGRESS");

        assertEquals(10, state.getRows());
        assertEquals(10, state.getCols());
        assertEquals(20, state.getMines());
        assertEquals(1, state.getCells().size());
        assertEquals("IN_PROGRESS", state.getGameState());
    }
}
