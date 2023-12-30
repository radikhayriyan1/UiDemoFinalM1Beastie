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
    public void doEncrypt(File file, String encryptKey) {
        Path inputFile = Paths.get(file.getPath());
        String newFileName = "/newFile.txt";
        Path outputFile = Path.of(inputFile.getParent() + newFileName);
        int key = Integer.parseInt(encryptKey);

        try {
            String content = new String(Files.readAllBytes(inputFile));
            String encryptedContent = encryptCaesar(content, key);
            Files.write(outputFile, encryptedContent.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
