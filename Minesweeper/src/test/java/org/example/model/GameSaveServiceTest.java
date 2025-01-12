package org.example.model;

import org.example.model.GameSaveService;
import org.example.model.GameState;
import org.example.model.GameSaveState;
import org.example.model.interfaces.IBoard;
import org.example.model.interfaces.ICell;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class GameSaveServiceTest {

    @Test
    void testSaveAndLoadGame() throws IOException {
        IBoard mockBoard = mock(IBoard.class);
        ICell mockCell = mock(ICell.class);

        when(mockBoard.getRows()).thenReturn(5);
        when(mockBoard.getCols()).thenReturn(5);
        when(mockBoard.getMineCount()).thenReturn(10);
        when(mockBoard.getCell(anyInt(), anyInt())).thenReturn(mockCell);

        when(mockCell.isMine()).thenReturn(false);
        when(mockCell.isRevealed()).thenReturn(false);
        when(mockCell.isFlagged()).thenReturn(false);
        when(mockCell.getAdjacentMines()).thenReturn(2);

        GameSaveService saveService = new GameSaveService();
        saveService.saveGame(mockBoard, GameState.IN_PROGRESS, true);

        File saveFile = new File("minesweeper_save.json");
        assertTrue(saveFile.exists());

        GameSaveState loadedState = saveService.loadGame();
        assertNotNull(loadedState);

        saveFile.delete(); // Curățăm fișierul după test
    }
}
