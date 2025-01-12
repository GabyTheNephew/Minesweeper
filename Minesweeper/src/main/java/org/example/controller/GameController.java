package org.example.controller;

import org.example.controller.interfaces.IGameController;
import org.example.model.GameState;
import org.example.model.interfaces.IBoard;
import org.example.model.interfaces.ICell;
import org.example.model.GameSaveService;
import org.example.model.GameSaveState;
import org.example.view.BoardView;
import org.example.view.CellView;
import javafx.scene.input.MouseButton;
import java.io.IOException;

public class GameController implements IGameController {
    private final IBoard board;
    private final BoardView boardView;
    private final GameSaveService gameSaveService;  // Declarare ca field
    private GameState gameState;
    private boolean minesPlaced = false;

    public GameController(IBoard board, BoardView boardView) {
        this.board = board;
        this.boardView = boardView;
        this.gameState = GameState.IN_PROGRESS;
        this.gameSaveService = new GameSaveService();  // Inițializare în constructor
    }

    @Override
    public void initializeGame() {
        gameState = GameState.IN_PROGRESS;
        updateView();
    }

    @Override
    public void revealCell(int row, int col) {
        if (gameState != GameState.IN_PROGRESS) return;

        if (!minesPlaced) {
            board.placeMinesAfterFirstClick(row, col);
            minesPlaced = true;  // Setăm flag-ul la true după plasarea minelor
        }

        if (board.getCell(row, col).isRevealed() || board.getCell(row, col).isFlagged()) return;

        board.getCell(row, col).reveal();

        if (board.getCell(row, col).isMine()) {
            gameState = GameState.LOST;
            revealAllCells();
        } else {
            checkForWin();
        }

        updateView();
    }

    @Override
    public void toggleFlag(int row, int col) {
        if (gameState != GameState.IN_PROGRESS) return;

        board.getCell(row, col).toggleFlag();
        updateView();
    }

    public void saveGame() {
        try {
            gameSaveService.saveGame(board, gameState, minesPlaced);
            // Eventual, poți adăuga un mesaj de confirmare pentru utilizator
            System.out.println("Joc salvat cu succes!");
        } catch (IOException e) {
            e.printStackTrace();
            // Eventual, poți afișa un mesaj de eroare pentru utilizator
            System.out.println("Eroare la salvarea jocului: " + e.getMessage());
        }
    }

    public void loadSavedGame(GameSaveState savedState) {
        if (savedState == null) return;

        gameState = savedState.getGameState();
        minesPlaced = savedState.isMinesPlaced();

        for (GameSaveState.CellState cellState : savedState.getCells()) {
            ICell cell = board.getCell(cellState.getRow(), cellState.getCol());
            if (cellState.isMine()) {
                cell.setMine(true);
            }
            if (cellState.isRevealed()) {
                cell.reveal();
            }
            if (cellState.isFlagged()) {
                cell.toggleFlag();
            }
            cell.setAdjacentMines(cellState.getAdjacentMines());
        }

        updateView();
    }

    @Override
    public GameState getGameState() {
        return gameState;
    }

    @Override
    public void restartGame() {
        initializeGame();
    }

    private void checkForWin() {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                if (!board.getCell(i, j).isMine() && !board.getCell(i, j).isRevealed()) return;
            }
        }
        gameState = GameState.WON;
    }

    private void revealAllCells() {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                board.getCell(i, j).reveal();
            }
        }
    }

    private void updateView() {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                ICell cell = board.getCell(i, j);
                boardView.updateCell(i, j, cell.isRevealed(), cell.isMine(), cell.getAdjacentMines(), cell.isFlagged());
            }
        }
    }

    @Override
    public void initializeView() {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                final int row = i;
                final int col = j;

                CellView cellView = boardView.getCellView(row, col);
                if (cellView != null) {
                    cellView.getButton().setOnMouseReleased(event -> {
                        if (event.getButton() == MouseButton.PRIMARY) {
                            System.out.println("Butonul stâng a fost eliberat pe celula [" + row + "," + col + "]");
                            revealCell(row, col);
                        } else if (event.getButton() == MouseButton.SECONDARY) {
                            System.out.println("Butonul drept a fost eliberat pe celula [" + row + "," + col + "]");
                            toggleFlag(row, col);
                        }
                    });
                }
            }
        }

        boardView.setSaveGameAction(this::saveGame);
    }
}