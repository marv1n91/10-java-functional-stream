package com.example.task04;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Task04Main {

    public static void main(String[] args) {

        Map<String, Long> frequencies = new HashMap<>();

        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            scanner.useDelimiter("[^\\p{L}\\p{Nd}]+");
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase(Locale.ROOT);
                Long count = frequencies.get(word);
                if (count == null) {
                    frequencies.put(word, 1L);
                } else {
                    frequencies.put(word, count + 1);
                }
            }
        }

        frequencies.keySet().stream()
                .sorted((firstWord, secondWord) -> {
                    int comparison = frequencies.get(secondWord).compareTo(frequencies.get(firstWord));
                    if (comparison != 0) {
                        return comparison;
                    }
                    return firstWord.compareTo(secondWord);
                })
                .limit(10)
                .forEach(word -> System.out.print(word + "\n"));

    }

}
