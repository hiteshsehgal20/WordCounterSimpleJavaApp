package org.example.wordcounter.service;

import org.example.wordcounter.exception.InvalidWordException;

public interface WordCountService {

    void addWords(String words) throws InvalidWordException;

    int getCountOfWord(String word);

    String getCountofAllWords();
}
