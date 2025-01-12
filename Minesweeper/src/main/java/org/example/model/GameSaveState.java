// GameSaveState.java
package org.example.model;

import java.util.List;
import java.util.ArrayList;

public class GameSaveState {
    private int rows;
    private int cols;
    private int mines;
    private List<CellState> cells;
    private GameState gameState;
    private boolean minesPlaced;

    public GameSaveState() {}

    public GameSaveState(int rows, int cols, int mines, GameState gameState, boolean minesPlaced) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        this.gameState = gameState;
        this.minesPlaced = minesPlaced;
        this.cells = new ArrayList<>();
    }

    public static class CellState {
        private int row;
        private int col;
        private boolean isMine;
        private boolean isRevealed;
        private boolean isFlagged;
        private int adjacentMines;

        public CellState() {}

        public CellState(int row, int col, boolean isMine, boolean isRevealed,
                         boolean isFlagged, int adjacentMines) {
            this.row = row;
            this.col = col;
            this.isMine = isMine;
            this.isRevealed = isRevealed;
            this.isFlagged = isFlagged;
            this.adjacentMines = adjacentMines;
        }

        public int getRow() { return row; }
        public void setRow(int row) { this.row = row; }
        public int getCol() { return col; }
        public void setCol(int col) { this.col = col; }
        public boolean isMine() { return isMine; }
        public void setMine(boolean mine) { isMine = mine; }
        public boolean isRevealed() { return isRevealed; }
        public void setRevealed(boolean revealed) { isRevealed = revealed; }
        public boolean isFlagged() { return isFlagged; }
        public void setFlagged(boolean flagged) { isFlagged = flagged; }
        public int getAdjacentMines() { return adjacentMines; }
        public void setAdjacentMines(int adjacentMines) { this.adjacentMines = adjacentMines; }
    }

    public int getRows() { return rows; }
    public void setRows(int rows) { this.rows = rows; }
    public int getCols() { return cols; }
    public void setCols(int cols) { this.cols = cols; }
    public int getMines() { return mines; }
    public void setMines(int mines) { this.mines = mines; }
    public List<CellState> getCells() { return cells; }
    public void setCells(List<CellState> cells) { this.cells = cells; }
    public GameState getGameState() { return gameState; }
    public void setGameState(GameState gameState) { this.gameState = gameState; }
    public boolean isMinesPlaced() { return minesPlaced; }
    public void setMinesPlaced(boolean minesPlaced) { this.minesPlaced = minesPlaced; }
}