package org.example.controller.interfaces;

import org.example.model.GameState;

public interface IGameController {
    void initializeGame();
    void revealCell(int row, int col);
    void toggleFlag(int row, int col);
    GameState getGameState();
    void restartGame();
    void initializeView();
}
