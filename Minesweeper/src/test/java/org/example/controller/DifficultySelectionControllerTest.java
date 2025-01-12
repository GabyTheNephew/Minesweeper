package org.example.controller;

import javafx.application.Platform;
import org.example.controller.DifficultySelectionController;
import org.example.model.Difficulty;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifficultySelectionControllerTest {

    @BeforeAll
    static void setup() {
        JavaFXInitializer.init(); // Asigurăm inițializarea Toolkit-ului
    }

    @Test
    void testDisplayDifficultySelection() {
        Platform.runLater(() -> {
            DifficultySelectionController controller = new DifficultySelectionController();
            controller.displayDifficultySelection(difficulty -> {
                assertEquals(Difficulty.EASY, difficulty);
            });
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
