package org.example.model;
import java.util.List;
public class SavedGameState {
    private int rows;
    private int cols;
    private int mines;
    private List<CellState> cells;
    private String gameState;  // Store the GameState as a string

    public SavedGameState(int rows, int cols, int mines, List<CellState> cells, String gameState) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        this.cells = cells;
        this.gameState = gameState;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getMines() {
        return mines;
    }

    public List<CellState> getCells() {
        return cells;
    }

    public String getGameState() {
        return gameState;
    }
}
