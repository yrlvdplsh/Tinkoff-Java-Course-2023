package edu.project1.dictionary;

import java.util.ArrayList;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class GameDictionary implements Dictionary {
    private final ArrayList<String> dictionary;
    private final int size;
    private Random random = new Random();

    public GameDictionary() {
        dictionary = new ArrayList<>();
        dictionary.add("miserable");
        dictionary.add("despair");
        dictionary.add("astenia");
        dictionary.add("amerima");
        dictionary.add("sushi");
        dictionary.add("blitzkrieg");
        dictionary.add("tinkoff");
        dictionary.add("oguzok");

        size = dictionary.size();
    }

    @Override
    public @NotNull String getRandomWord() {
        return dictionary.get(random.nextInt(size));
    }
}
