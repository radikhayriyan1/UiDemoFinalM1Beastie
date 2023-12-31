package com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie;

import com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie.controller.CryptoAnalyzerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CryptoAnalyzerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CryptoAnalyzerApplication.class.getResource("caesar.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Crypto Analyzer");
        stage.setScene(scene);
        stage.show();
        CryptoAnalyzerController controller = fxmlLoader.getController();
        controller.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}