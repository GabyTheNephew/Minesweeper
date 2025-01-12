// DifficultySelectionView.java
package org.example.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.model.Difficulty;

public class DifficultySelectionView {
    private Difficulty selectedDifficulty;

    public void show() {
        Stage stage = new Stage();
        VBox layout = new VBox(10); // Spațiere între elemente

        Button easyButton = new Button("Easy");
        Button mediumButton = new Button("Medium");
        Button hardButton = new Button("Hard");

        easyButton.setOnAction(e -> {
            selectedDifficulty = Difficulty.EASY;
            stage.close();
        });
        mediumButton.setOnAction(e -> {
            selectedDifficulty = Difficulty.MEDIUM;
            stage.close();
        });
        hardButton.setOnAction(e -> {
            selectedDifficulty = Difficulty.HARD;
            stage.close();
        });

        layout.getChildren().addAll(easyButton, mediumButton, hardButton);

        Scene scene = new Scene(layout, 200, 150);
        stage.setTitle("Select Difficulty");
        stage.setScene(scene);
        stage.showAndWait();
    }

    public Difficulty getSelectedDifficulty() {
        return selectedDifficulty;
    }
}
