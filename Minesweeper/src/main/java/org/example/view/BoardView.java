package org.example.view;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import java.util.Map;
import java.util.HashMap;

public class BoardView {
    private final GridPane gridPane;
    private final VBox mainLayout;
    private final Button saveButton;
    private final Map<String, CellView> cellViewMap;
    private final int rows;
    private final int cols;

    public BoardView(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.gridPane = new GridPane();
        this.mainLayout = new VBox(10); // Spațiere de 10 între elemente
        this.saveButton = new Button("Save Game");
        this.cellViewMap = new HashMap<>();

        mainLayout.getChildren().addAll(gridPane, saveButton);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                CellView cellView = new CellView();
                this.gridPane.add(cellView.getButton(), j, i);
                this.cellViewMap.put(i + "," + j, cellView);
            }
        }

        gridPane.setHgap(0);
        gridPane.setVgap(0);
    }

    public VBox getMainLayout() {
        return mainLayout;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public CellView getCellView(int row, int col) {
        return cellViewMap.get(row + "," + col);
    }

    public void updateCell(int row, int col, boolean isRevealed, boolean isMine, int adjacentMines, boolean isFlagged) {
        CellView cellView = cellViewMap.get(row + "," + col);
        if (cellView != null) {
            cellView.updateView(isRevealed, isMine, adjacentMines, isFlagged);
        }
    }

    public void setSaveGameAction(Runnable action) {
        saveButton.setOnAction(e -> action.run());
    }

    public void adjustGridSize(int cellSize) {
        gridPane.setPrefWidth(cellSize * cols);
        gridPane.setPrefHeight(cellSize * rows);
        gridPane.setStyle("-fx-padding: 0; -fx-margin: 0;");
    }
}