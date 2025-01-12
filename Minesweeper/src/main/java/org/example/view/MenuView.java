// MenuView.java
package org.example.view;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

public class MenuView {
    private final VBox menuLayout;
    private final Button startButton;
    private final Button loadButton;
    private final Button quitButton;

    public MenuView() {
        this.menuLayout = new VBox(10);
        this.startButton = new Button("New Game");
        this.loadButton = new Button("Load Game");
        this.quitButton = new Button("Quit Game");

        menuLayout.getChildren().addAll(startButton, loadButton, quitButton);

        menuLayout.setAlignment(Pos.CENTER);
    }

    public VBox getMenuLayout() {
        return menuLayout;
    }

    public void setStartGameAction(Runnable action) {
        startButton.setOnAction(e -> action.run());
    }

    public void setLoadGameAction(Runnable action) {
        loadButton.setOnAction(e -> action.run());
    }

    public void setQuitGameAction(Runnable action) {
        quitButton.setOnAction(e -> action.run());
    }
}
