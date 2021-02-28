package org.example.wordcounter;

import org.example.wordcounter.exception.InvalidWordException;
import org.example.wordcounter.service.WordCountService;
import org.example.wordcounter.service.WordCountServiceImpl;

import java.util.Scanner;


public class WordCount {

    public static void main(String[] args) {

        WordCountService wcs = new WordCountServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("To add words enter 1.  To Search enter 2.");
            String option = scanner.nextLine();
            if ("1".equals(option)) {
                System.out.println("Enter Word");
                try {
                    wcs.addWords(scanner.nextLine());
                } catch (InvalidWordException e) {
                    e.printStackTrace();
                }
            } else if ("2".equals(option)) {
                System.out.println("Enter Word");
                System.out.println(wcs.getCountOfWord(scanner.nextLine()));
            } else break;

        }
        System.out.println(wcs.getCountofAllWords());

    }
}
