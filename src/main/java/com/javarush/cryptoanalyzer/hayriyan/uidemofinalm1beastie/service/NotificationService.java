package com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie.service;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NotificationService {
    public static void showNotification(String message) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Notification");
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        Label label = new Label(message);
        pane.getChildren().add(label);

        stage.setScene(new Scene(pane, 250, 100));
        stage.showAndWait();
    }
}
