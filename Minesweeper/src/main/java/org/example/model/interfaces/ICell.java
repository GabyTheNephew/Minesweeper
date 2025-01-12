package org.example.model.interfaces;

public interface ICell {
    boolean isMine();
    void setMine(boolean mine);

    boolean isRevealed();
    void reveal();

    boolean isFlagged();
    void toggleFlag();

    int getAdjacentMines();
    void setAdjacentMines(int adjacentMines);
}
