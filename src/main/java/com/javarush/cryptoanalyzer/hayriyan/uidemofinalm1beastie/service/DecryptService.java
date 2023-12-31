package com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DecryptService {
    private static final Map<Character, Integer> charIndexMap = new HashMap<>();
    private final char[] alphabet;

    public DecryptService(char[] alphabet) {
        this.alphabet = alphabet;
    }
    public boolean doDecrypt(File file, String decryptKey) {
        if (file == null) {
            NotificationService.showNotification("You should select a file");
            return false;
        }
        Path inputFile = Paths.get(file.getPath());
        String newFileName = "/decrypt.txt";
        Path outputFile = Path.of(inputFile.getParent() + newFileName);
        int key;
        try {
            key = Integer.parseInt(decryptKey);
        } catch (NumberFormatException e) {
            NotificationService.showNotification("Key field format is wrong");
            return false;
        }

        try {
            String content = new String(Files.readAllBytes(inputFile));
            String decryptedContent = decryptCaesar(content, key);
            Files.write(outputFile, decryptedContent.getBytes());
        } catch (IOException e) {
            NotificationService.showNotification("Something went wrong, please try again");
            return false;
        }
        NotificationService.showNotification("Decryption was successfully done.");
        return true;
    }

    public boolean doBruteForceDecrypt(File file) {
        if (file == null) {
            NotificationService.showNotification("You should select a file");
            return false;
        }
        Path inputFile = Paths.get(file.getPath());
        try {
            String content = new String(Files.readAllBytes(inputFile));
            for (int i = 1; i <= alphabet.length; i++) {
                String decryptedContent = decryptCaesar(content, i);
                String newFileName = "/bruteForceDecrypt" + i + ".txt";
                Path outputFile = Path.of(inputFile.getParent() + newFileName);
                Files.write(outputFile, decryptedContent.getBytes());
            }
        } catch (IOException e) {
            NotificationService.showNotification("Something went wrong, please try again");
            return false;
        }
        NotificationService.showNotification("Decryption was successfully done.");
        return true;
    }

    private String decryptCaesar(String input, int key) {
        for (int i = 0; i < alphabet.length; i++) {
            charIndexMap.put(alphabet[i], i);
        }
        StringBuilder encryptedText = new StringBuilder();

        for (char ch : input.toCharArray()) {
            Integer index = charIndexMap.get(ch);

            if (index != null) {
                int newIndex = (index - key % alphabet.length + alphabet.length) % alphabet.length;
                encryptedText.append(alphabet[newIndex]);
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }
}
