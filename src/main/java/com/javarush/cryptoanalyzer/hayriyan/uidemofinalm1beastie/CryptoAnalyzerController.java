package com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;

public class CryptoAnalyzerController {

    static File encryptFile;
    static File decryptFile;
    static File bruteForceDecryptFile;
    static File statisticalDecryptFile;

    @FXML
    private TextField encryptKeyField;

    @FXML
    private TextField decryptKeyField;

    @FXML
    private TextField bruteForceDecryptKeyField;

    @FXML
    private TextField statisticalDecryptKeyField;

    @FXML
    protected void onEncryptSelectFile() {
        FileChooser fileChooser = new FileChooser();
        encryptFile = fileChooser.showOpenDialog(null);
    }

    @FXML
    protected void onDecryptSelectFile() {
        FileChooser fileChooser = new FileChooser();
        decryptFile = fileChooser.showOpenDialog(null);
    }

    @FXML
    protected void onBruteForceDecryptSelectFile() {
        FileChooser fileChooser = new FileChooser();
        bruteForceDecryptFile = fileChooser.showOpenDialog(null);
    }

    @FXML
    protected void onStatisticalDecryptSelectFile() {
        FileChooser fileChooser = new FileChooser();
        statisticalDecryptFile = fileChooser.showOpenDialog(null);
    }

    @FXML
    protected void onEncrypt() {
        System.out.println(encryptKeyField.getCharacters());
    }

    @FXML
    protected void onDecrypt() {
        System.out.println(decryptKeyField.getCharacters());
    }

    @FXML
    protected void onBruteForceDecrypt() {
        System.out.println(bruteForceDecryptKeyField.getCharacters());
    }

    @FXML
    protected void onStatisticalDecrypt() {
        System.out.println(statisticalDecryptKeyField.getCharacters());
    }
}
