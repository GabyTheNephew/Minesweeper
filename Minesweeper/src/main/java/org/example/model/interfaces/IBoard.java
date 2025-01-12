package org.example.model.interfaces;

public interface IBoard {
    void initializeBoard();
    void placeMines();
    void calculateAdjacentMines();

    ICell getCell(int row, int col);
    int getMineCount();
    int getRows();
    int getCols();
    void placeMinesAfterFirstClick(int firstRow, int firstCol);
    void printAllMines();
}
