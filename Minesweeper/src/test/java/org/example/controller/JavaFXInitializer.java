package org.example.controller;

import javafx.application.Platform;

public class JavaFXInitializer {

    private static boolean initialized = false;

    public static void init() {
        if (!initialized) {
            Platform.startup(() -> {}); // Inițializează Toolkit
            initialized = true; // Marchează Toolkit-ul ca fiind inițializat
        }
    }
}
