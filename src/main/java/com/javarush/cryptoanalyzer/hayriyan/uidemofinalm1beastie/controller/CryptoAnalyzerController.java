package com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie.controller;

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
    static File statisticalDecryptFile;

    private Scene scene;

    @FXML
    private TextField encryptKeyField;

    @FXML
    private TextField decryptKeyField;

    @FXML
    private TextField bruteForceDecryptKeyField;

    @FXML
    private TextField statisticalDecryptKeyField;

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
    }

    @FXML
    protected void onStatisticalDecryptSelectFile() {
        FileChooser fileChooser = new FileChooser();
        statisticalDecryptFile = fileChooser.showOpenDialog(null);
    }

    @FXML
    protected void onEncrypt() {
        encryptService = new EncryptService();
        boolean isFileEncrypted = encryptService.doEncrypt(encryptFile, encryptKeyField.getCharacters().toString());
        if (isFileEncrypted) {
            encryptFile = null;
            encryptKeyField.setText("");
            LayoutService.changeButtonTextById(LayoutProperties.encryptSelectFieldId, scene, "Select");
        }
    }

    @FXML
    protected void onDecrypt() {
        decryptService = new DecryptService();
        boolean isFileDecrypted = decryptService.doDecrypt(decryptFile, decryptKeyField.getCharacters().toString());
        if (isFileDecrypted) {
            decryptFile = null;
            decryptKeyField.setText("");
            LayoutService.changeButtonTextById(LayoutProperties.decryptSelectFieldId, scene, "Select");
        }
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
