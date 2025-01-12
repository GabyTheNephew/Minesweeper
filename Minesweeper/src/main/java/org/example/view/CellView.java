// CellView.java
package org.example.view;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CellView {
    private final Button button;

    public CellView() {
        this.button = new Button();
        this.button.setMinSize(30, 30);
        this.button.setMaxSize(30, 30);
        this.button.setStyle("-fx-padding: 0; -fx-margin: 0; -fx-background-color: transparent;"); // Elimină padding-ul și marginile
    }

    public Button getButton() {
        return button;
    }

    public void updateView(boolean isRevealed, boolean isMine, int adjacentMines, boolean isFlagged) {
        if (isFlagged) {
            setImage("images/TileFlag.png");  // Display flag image
        } else if (!isRevealed) {
            setImage("images/TileUnknown.png");
        } else {
            if (isMine) {
                setImage("images/TileMine.png");
            } else if (adjacentMines > 0) {
                setImage("images/numbers/Tile" + adjacentMines + ".png");
            } else {
                setImage("images/TileEmpty.png");
            }
        }
    }



    private void setImage(String path) {
        try {
            Image image = new Image(getClass().getResourceAsStream("/" + path));
            if (image.isError()) {
                System.out.println("Eroare la încărcarea imaginii: " + path);
            }

            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(30);  // Setează lățimea imaginii la dimensiunea butonului
            imageView.setFitHeight(30); // Setează înălțimea imaginii la dimensiunea butonului
            imageView.setPreserveRatio(true); // Păstrează raportul de aspect

            this.button.setGraphic(imageView);  // Setează imaginea pe buton
        } catch (Exception e) {
            System.out.println("Eroare la încărcarea imaginii: " + path);
            e.printStackTrace();
        }
    }
}
