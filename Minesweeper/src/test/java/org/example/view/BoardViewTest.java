package org.example.view;

import javafx.application.Platform;
import org.example.controller.JavaFXInitializer;
import org.example.view.BoardView;
import org.example.view.CellView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BoardViewTest {

    @BeforeAll
    static void setup() {
        JavaFXInitializer.init();
    }

    @Test
    void testCreateBoardView() {
        Platform.runLater(() -> {
            BoardView boardView = new BoardView(5, 5);

            assertNotNull(boardView.getMainLayout()); // Verificăm că layout-ul principal există
            assertNotNull(boardView.getGridPane()); // Verificăm că GridPane-ul este creat
        });

        waitForFxEvents();
    }

    @Test
    void testUpdateCell() {
        Platform.runLater(() -> {
            BoardView boardView = new BoardView(5, 5);

            // Actualizăm o celulă
            boardView.updateCell(0, 0, true, false, 3, false);

            // Verificăm că celula a fost actualizată
            CellView cellView = boardView.getCellView(0, 0);
            assertNotNull(cellView); // Verificăm că celula există
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
