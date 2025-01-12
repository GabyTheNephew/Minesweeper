package org.example.controller;

import org.example.controller.interfaces.IMenuController;
import org.example.model.Board;
import org.example.model.GameSaveState;
import org.example.model.GameSaveService;
import org.example.model.interfaces.IBoard;
import org.example.view.BoardView;
import org.example.view.MenuView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuController implements IMenuController {
    private final MenuView menuView;
    private final Stage primaryStage;

    public MenuController(MenuView menuView, Stage primaryStage) {
        this.menuView = menuView;
        this.primaryStage = primaryStage;
    }

    @Override
    public void startNewGame() {
        DifficultySelectionController difficultySelectionController = new DifficultySelectionController();
        difficultySelectionController.displayDifficultySelection(difficulty -> {
            IBoard board = new Board(difficulty.getRows(), difficulty.getCols(), difficulty.getMines());
            BoardView boardView = new BoardView(board.getRows(), board.getCols());
            GameController gameController = new GameController(board, boardView);

            gameController.initializeView();
            gameController.initializeGame();

            int cellSize = 30;
            boardView.adjustGridSize(cellSize);

            // Folosim mainLayout în loc de gridPane
            Scene scene = new Scene(boardView.getMainLayout(),
                    board.getCols() * cellSize,
                    (board.getRows() * cellSize) + 50); // +50 pentru spațiul butonului de salvare

            primaryStage.setScene(scene);
            primaryStage.setTitle("Minesweeper");
            primaryStage.show();
        });
    }

    @Override
    public void loadGame() {
        GameSaveService gameSaveService = new GameSaveService();
        try {
            GameSaveState savedState = gameSaveService.loadGame();
            if (savedState != null) {
                IBoard board = new Board(savedState.getRows(), savedState.getCols(), savedState.getMines());
                BoardView boardView = new BoardView(board.getRows(), board.getCols());

                GameController gameController = new GameController(board, boardView);
                gameController.initializeView();
                gameController.loadSavedGame(savedState);

                int cellSize = 30;
                boardView.adjustGridSize(cellSize);

                // Folosim mainLayout în loc de gridPane
                Scene scene = new Scene(boardView.getMainLayout(),
                        savedState.getCols() * cellSize,
                        (savedState.getRows() * cellSize) + 50); // +50 pentru spațiul butonului

                primaryStage.setScene(scene);
                primaryStage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Poți adăuga aici un dialog pentru a informa utilizatorul despre eroare
        }
    }

    @Override
    public void quitGame() {
        System.exit(0);
    }
}