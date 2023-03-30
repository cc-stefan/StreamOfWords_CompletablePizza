package streamOfWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class StreamOfWords {
    public static void main(String[] args) throws IOException {
        String firstName = "Claudiu";

        List<String> words = Files.lines(Path.of("words.txt"))
                .filter(word -> word.length() <= firstName.length())
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .toList();

        String longestWord = words.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

        System.out.println("Filtered, lowercase, unique, and sorted words in ascending natural order: " + words);
        System.out.println("Longest word: " + longestWord);
    }
}