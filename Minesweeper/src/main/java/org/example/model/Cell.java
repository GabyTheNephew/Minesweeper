package org.example.model;

import org.example.model.interfaces.ICell;

public class Cell implements ICell {
    private boolean isMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private int adjacentMines;

    public Cell() {
        this.isMine = false;
        this.isRevealed = false;
        this.isFlagged = false;
        this.adjacentMines = 0;
    }

    @Override
    public boolean isMine() {
        return isMine;
    }

    @Override
    public void setMine(boolean mine) {
        this.isMine = mine;
        System.out.println("Mine set at: " + this.isMine);
    }

    @Override
    public boolean isRevealed() {
        return isRevealed;
    }

    @Override
    public void reveal() {
        isRevealed = true;
    }

    @Override
    public boolean isFlagged() {
        return isFlagged;
    }

    @Override
    public void toggleFlag() {
        isFlagged = !isFlagged;
    }

    @Override
    public int getAdjacentMines() {
        return adjacentMines;
    }

    @Override
    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }
}
