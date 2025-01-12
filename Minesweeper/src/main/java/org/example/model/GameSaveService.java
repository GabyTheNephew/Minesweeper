// GameSaveService.java
package org.example.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.interfaces.IBoard;
import org.example.model.interfaces.ICell;

import java.io.File;
import java.io.IOException;

public class GameSaveService {
    private static final String SAVE_FILE_PATH = "minesweeper_save.json";
    private final ObjectMapper objectMapper;

    public GameSaveService() {
        this.objectMapper = new ObjectMapper();
    }

    public void saveGame(IBoard board, GameState gameState, boolean minesPlaced) throws IOException {
        GameSaveState saveState = new GameSaveState(
                board.getRows(),
                board.getCols(),
                board.getMineCount(),
                gameState,
                minesPlaced
        );

        // Salvăm starea fiecărei celule
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                ICell cell = board.getCell(i, j);
                saveState.getCells().add(new GameSaveState.CellState(
                        i, j, cell.isMine(), cell.isRevealed(),
                        cell.isFlagged(), cell.getAdjacentMines()
                ));
            }
        }

        // Salvăm în fișier JSON
        objectMapper.writeValue(new File(SAVE_FILE_PATH), saveState);
    }

    public GameSaveState loadGame() throws IOException {
        File saveFile = new File(SAVE_FILE_PATH);
        if (!saveFile.exists()) {
            return null;
        }
        return objectMapper.readValue(saveFile, GameSaveState.class);
    }

    public boolean hasSavedGame() {
        return new File(SAVE_FILE_PATH).exists();
    }
}