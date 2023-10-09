package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        List<String> wordList = new ArrayList<>(List.of(word.toLowerCase().split("")));
        List<String> symbolsList = new ArrayList<>(List.of(symbols.split("")));

        for (String letter : symbolsList) {
            wordList.remove(letter);
        }

        return wordList.isEmpty();
    }
}
//END
