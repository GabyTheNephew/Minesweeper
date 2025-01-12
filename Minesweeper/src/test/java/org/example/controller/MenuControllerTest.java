package org.example.controller;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.controller.MenuController;
import org.example.view.MenuView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuControllerTest {

    private static Stage primaryStage;

    @BeforeAll
    static void setup() {
        JavaFXInitializer.init(); // Asigurăm inițializarea Toolkit-ului
        Platform.runLater(() -> primaryStage = new Stage());
    }

    @Test
    void testStartNewGame() {
        Platform.runLater(() -> {
            MenuView menuView = new MenuView();
            MenuController menuController = new MenuController(menuView, primaryStage);

            menuController.startNewGame();

            Scene scene = primaryStage.getScene();
            assertNotNull(scene);
            assertEquals("Minesweeper", primaryStage.getTitle());
        });

        waitForFxEvents();
    }

    @Test
    void testLoadGame() {
        Platform.runLater(() -> {
            MenuView menuView = new MenuView();
            MenuController menuController = new MenuController(menuView, primaryStage);

            menuController.loadGame();

            Scene scene = primaryStage.getScene();
            assertNotNull(scene);
        });

        waitForFxEvents();
    }

    private void waitForFxEvents() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
