package org.example.model;

import org.example.model.interfaces.IBoard;
import org.example.model.interfaces.ICell;

import java.util.Random;

public class Board implements IBoard {
    private final int rows;
    private final int cols;
    private final int mines;
    private  Cell[][] grid;
    private boolean minesPlaced = false;

    public Board(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        this.grid = new Cell[rows][cols];

        initializeBoard();
    }
    @Override
    public int getMineCount() {
        return this.mines;
    }
    public void placeMinesAfterFirstClick(int firstRow, int firstCol) {
        if (minesPlaced) return;

        Random random = new Random();
        int placedMines = 0;

        while (placedMines < mines) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            if ((row != firstRow || col != firstCol) && !grid[row][col].isMine()) {
                this.grid[row][col].setMine(true);
                placedMines++;
            }
        }

        calculateAdjacentMines();
        minesPlaced = true;
    }

    @Override
    public void printAllMines() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j].isMine()) {
                    System.out.print(i + " " +j );
                }
                else {
                    System.out.print("Nu e ");
                }
            }
        }
    }

    @Override
    public void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.grid[i][j] = new Cell();
            }
        }
    }

    @Override
    public void placeMines() {
        Random random = new Random();
        int placedMines = 0;

        while (placedMines < mines) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            if (!grid[row][col].isMine()) {
                System.out.println("Mine placed at [" + row + ", " + col + "]");
                this.grid[row][col].setMine(true);
                placedMines++;
            }
        }
    }

    @Override
    public void calculateAdjacentMines() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j].isMine()) {
                    continue;
                }

                int count = 0;

                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        int newRow = i + x;
                        int newCol = j + y;

                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                                grid[newRow][newCol].isMine()) {
                            count++;
                        }
                    }
                }

                grid[i][j].setAdjacentMines(count);
            }
        }
    }

    @Override
    public ICell getCell(int row, int col) {
        return grid[row][col];
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getCols() {
        return cols;
    }
}
