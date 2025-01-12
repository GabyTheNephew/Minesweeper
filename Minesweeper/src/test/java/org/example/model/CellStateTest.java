package org.example.model;

import org.example.model.CellState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellStateTest {

    @Test
    void testCellStateConstructorAndSetters() {
        CellState cellState = new CellState(false, false, true, 3);

        assertTrue(cellState.isFlagged());
        assertEquals(3, cellState.getAdjacentMines());

        cellState.setMine(true);
        cellState.setRevealed(true);
        cellState.setAdjacentMines(5);

        assertTrue(cellState.isMine());
        assertTrue(cellState.isRevealed());
        assertEquals(5, cellState.getAdjacentMines());
    }
}
