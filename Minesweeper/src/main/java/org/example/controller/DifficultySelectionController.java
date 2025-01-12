// DifficultySelectionController.java
package org.example.controller;

import org.example.model.Difficulty;
import org.example.view.DifficultySelectionView;

public class DifficultySelectionController {

    public void displayDifficultySelection(DifficultySelectionCallback callback) {
        DifficultySelectionView view = new DifficultySelectionView();
        view.show();

        Difficulty selectedDifficulty = view.getSelectedDifficulty();
        callback.onDifficultySelected(selectedDifficulty);
    }

    public interface DifficultySelectionCallback {
        void onDifficultySelected(Difficulty difficulty);
    }
}
