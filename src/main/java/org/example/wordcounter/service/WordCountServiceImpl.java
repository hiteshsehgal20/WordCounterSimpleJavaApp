package org.example.wordcounter.service;

import org.example.wordcounter.exception.InvalidWordException;
import org.example.wordcounter.util.MutableInteger;
import org.example.wordcounter.util.TranslatorProvider;

import java.util.HashMap;
import java.util.Map;

public class WordCountServiceImpl implements WordCountService {

    private static final Map<String, MutableInteger> counterMap = new HashMap<>();
    private static final TranslatorProvider translatorProvider = new TranslatorProvider();

    @Override
    public void addWords(String word) throws InvalidWordException {
        if (isValidWord(word)) {
            String key = translatorProvider.translate(word.toLowerCase());
            counterMap.compute(key, (k, v) -> v == null ? new MutableInteger(0) : v)
                    .increment();
        } else {
            throw new InvalidWordException("Invalid Words");
        }

    }

    @Override
    public int getCountOfWord(String word) {
        if (isValidWord(word) && counterMap.containsKey(word.toLowerCase())) {
            return counterMap.get(translatorProvider.translate(word).toLowerCase()).getCount();
        }
        return 0;
    }

    @Override
    public String getCountofAllWords() {
        StringBuilder sb = new StringBuilder();
        counterMap.entrySet().forEach(entry -> {
            sb.append(entry.getKey() + " : " + entry.getValue().getCount() + "\n");
        });
        return sb.toString();
    }

    private boolean isValidWord(String str) {
        return ((str != null))
                && (!str.equals("")
                && (str.chars().allMatch(Character::isLetter)));
    }

}
