package org.example.view;

import javafx.application.Platform;
import org.example.controller.JavaFXInitializer;
import org.example.view.CellView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CellViewTest {

    @BeforeAll
    static void setup() {
        JavaFXInitializer.init();
    }

    @Test
    void testCreateCellView() {
        Platform.runLater(() -> {
            CellView cellView = new CellView();
            assertNotNull(cellView.getButton()); // Verificăm că butonul a fost creat
        });

        waitForFxEvents();
    }

    @Test
    void testUpdateView() {
        Platform.runLater(() -> {
            CellView cellView = new CellView();

            // Simulăm actualizarea vizuală a celulei
            cellView.updateView(true, false, 2, false);

            // Nu există funcții directe pentru verificare, dar putem verifica că nu apar excepții
            assertNotNull(cellView.getButton().getGraphic());
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
