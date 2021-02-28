package org.example.wordcounter.service;

import org.example.wordcounter.exception.InvalidWordException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class WordCountServiceImplTest {

    @InjectMocks
    WordCountServiceImpl wsc;

    @Test
    public void addWordsSuccessCaseInsensitive() throws InvalidWordException {
        wsc = new WordCountServiceImpl();
        wsc.addWords("Test");
        wsc.addWords("teSt");
        assertEquals(2, wsc.getCountOfWord("test"));
    }

    @Test(expected = InvalidWordException.class)
    public void addWordsValidateStringsWithChars() throws InvalidWordException {
        wsc = new WordCountServiceImpl();
        wsc.addWords("Test1");
        assertEquals(0, wsc.getCountOfWord("Test1"));
    }

    @Test(expected = InvalidWordException.class)
    public void addWordsNulls() throws InvalidWordException {
        wsc = new WordCountServiceImpl();
        wsc.addWords(null);
    }

    @Test
    public void getCountOfWord() {
        wsc = new WordCountServiceImpl();
        assertEquals(2, wsc.getCountOfWord("test"));
    }

}