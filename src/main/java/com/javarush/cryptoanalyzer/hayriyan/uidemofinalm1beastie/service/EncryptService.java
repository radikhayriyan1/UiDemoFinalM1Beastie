package com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie.service;
import com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie.constant.Alphabet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class EncryptService {
    private static final Map<Character, Integer> charIndexMap = new HashMap<>();
    public boolean doEncrypt(File file, String encryptKey) {
        if (file == null) {
            NotificationService.showNotification("You should select a file");
            return false;
        }
        Path inputFile = Paths.get(file.getPath());
        String newFileName = "/encrypt.txt";
        Path outputFile = Path.of(inputFile.getParent() + newFileName);
        int key;
        try {
            key = Integer.parseInt(encryptKey);
        } catch (NumberFormatException e) {
            NotificationService.showNotification("Key field format is wrong");
            return false;
        }

        try {
            String content = new String(Files.readAllBytes(inputFile));
            String encryptedContent = encryptCaesar(content, key);
            Files.write(outputFile, encryptedContent.getBytes());
        } catch (IOException e) {
            NotificationService.showNotification("Something went wrong, please try again");
            return false;
        }
        NotificationService.showNotification("Encryption was successfully done.");
        return true;
    }

    private String encryptCaesar(String input, int key) {
        for (int i = 0; i < Alphabet.RU.length; i++) {
            charIndexMap.put(Alphabet.RU[i], i);
        }
        StringBuilder encryptedText = new StringBuilder();

        for (char ch : input.toCharArray()) {
            Integer index = charIndexMap.get(ch);

            if (index != null) {
                int newIndex = (index + key) % Alphabet.RU.length;
                encryptedText.append(Alphabet.RU[newIndex]);
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }
}
