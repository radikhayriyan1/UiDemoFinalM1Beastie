package com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie.controller;

import com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie.constant.Alphabet;
import com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie.constant.LayoutProperties;
import com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie.service.DecryptService;
import com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie.service.EncryptService;
import com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie.service.LayoutService;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class CryptoAnalyzerController {
    EncryptService encryptService;
    DecryptService decryptService;

    static File encryptFile;
    static File decryptFile;
    static File bruteForceDecryptFile;

    private Scene scene;

    @FXML
    private TextField encryptKeyField;

    @FXML
    private TextField decryptKeyField;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @FXML
    protected void onEncryptSelectFile() {
        FileChooser fileChooser = new FileChooser();
        encryptFile = fileChooser.showOpenDialog(null);
        if (encryptFile != null) {
            LayoutService.changeButtonTextById(LayoutProperties.encryptSelectFieldId, scene, "Update");
        }
    }

    @FXML
    protected void onDecryptSelectFile() {
        FileChooser fileChooser = new FileChooser();
        decryptFile = fileChooser.showOpenDialog(null);
        if (decryptFile != null) {
            LayoutService.changeButtonTextById(LayoutProperties.decryptSelectFieldId, scene, "Update");
        }
    }

    @FXML
    protected void onBruteForceDecryptSelectFile() {
        FileChooser fileChooser = new FileChooser();
        bruteForceDecryptFile = fileChooser.showOpenDialog(null);
        if (bruteForceDecryptFile != null) {
            LayoutService.changeButtonTextById(LayoutProperties.bruteForceDecryptSelectFieldId, scene, "Update");
        }
    }

    @FXML
    protected void onEncrypt() {
        encryptService = new EncryptService(Alphabet.RU);
        boolean isFileEncrypted = encryptService.doEncrypt(encryptFile, encryptKeyField.getCharacters().toString());
        if (isFileEncrypted) {
            encryptFile = null;
            encryptKeyField.setText("");
            LayoutService.changeButtonTextById(LayoutProperties.encryptSelectFieldId, scene, "Select");
        }
    }

    @FXML
    protected void onDecrypt() {
        decryptService = new DecryptService(Alphabet.RU);
        boolean isFileDecrypted = decryptService.doDecrypt(decryptFile, decryptKeyField.getCharacters().toString());
        if (isFileDecrypted) {
            decryptFile = null;
            decryptKeyField.setText("");
            LayoutService.changeButtonTextById(LayoutProperties.decryptSelectFieldId, scene, "Select");
        }
    }

    @FXML
    protected void onBruteForceDecrypt() {
        decryptService = new DecryptService(Alphabet.RU);
        boolean isFileDecrypted = decryptService.doBruteForceDecrypt(bruteForceDecryptFile);
        if (isFileDecrypted) {
            bruteForceDecryptFile = null;
            LayoutService.changeButtonTextById(LayoutProperties.bruteForceDecryptSelectFieldId, scene, "Select");
        }
    }
}
