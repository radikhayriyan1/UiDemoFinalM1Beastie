package com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie.service;

import javafx.scene.Scene;
import javafx.scene.control.Button;

public class LayoutService {
    public static void changeButtonTextById(String id, Scene scene, String text) {
        Button button = (Button) scene.lookup("#" + id);
        if (button != null) {
            button.setText(text);
        }
    }
}
