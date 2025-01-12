package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.controller.MenuController;
import org.example.view.MenuView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView, primaryStage);

        menuView.setStartGameAction(() -> menuController.startNewGame());
        menuView.setLoadGameAction(() -> menuController.loadGame());
        menuView.setQuitGameAction(() -> menuController.quitGame());

        Scene scene = new Scene(menuView.getMenuLayout(), 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Minesweeper");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}