package org.example.view;

import javafx.application.Platform;
import org.example.controller.JavaFXInitializer;
import org.example.view.DifficultySelectionView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifficultySelectionViewTest {

    @BeforeAll
    static void setup() {
        JavaFXInitializer.init();
    }

    @Test
    void testCreateDifficultySelectionView() {
        Platform.runLater(() -> {
            DifficultySelectionView view = new DifficultySelectionView();
            assertNotNull(view); // Verificăm că instanța este creată
        });

        waitForFxEvents();
    }

    @Test
    void testSelectDifficulty() {
        Platform.runLater(() -> {
            DifficultySelectionView view = new DifficultySelectionView();

            // Simulăm deschiderea UI-ului și selecția dificultății
            view.show();
            view.getSelectedDifficulty(); // Acest lucru ar trebui să returneze o dificultate

            // În test real, ai testa selecția, dar în mod curent verificăm că nu există excepții
            assertNotNull(view.getSelectedDifficulty());
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
