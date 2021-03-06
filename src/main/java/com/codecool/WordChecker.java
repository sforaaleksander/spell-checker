package com.codecool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 *
 * Implement your word checker here.  A word checker has two responsibilities:
 * given a word list, answer the questions "Is the word 'x' in the wordlist?"
 * and "What are some suggestions for the misspelled word 'x'?"
 *
 * WordChecker uses a class called WordList that I haven't provided the source
 * code for.  WordList has only one method that you'll ever need to call:
 *
 * public boolean lookup(String word)
 *
 * which returns true if the given word is in the WordList and false if not.
 */

public class WordChecker {
    private WordList wordList;

    /**
     * Constructor that initializes a new WordChecker with a given WordList.
     *
     * @param wordList Initial word list to check against.
     * @see WordList
     */
    public WordChecker(WordList wordList) {
        this.wordList = wordList;
    }


    /**
     * Returns true if the given word is in the WordList passed to the
     * constructor, false otherwise.
     *
     * @param word Word to chack against the internal word list
     * @return bollean indicating if the word was found or not.
     */
    public boolean wordExists(String word) {
        return wordList.lookup(word);
    }


    /**
     * Returns an ArrayList of Strings containing the suggestions for the
     * given word.  If there are no suggestions for the given word, an empty
     * ArrayList of Strings (not null!) should be returned.
     *
     * @param word String to check against
     * @return A list of plausible matches
     */
    public List<String> getSuggestions(String word) {
        List<String> suggestions = new ArrayList<>();
        suggestions.addAll(adjacentPairSwap(word));
        suggestions.addAll(insertLetterInBetween(word));
        suggestions.addAll(deleteEachLetter(word));
        suggestions.addAll(replaceEachLetter(word));
        suggestions.addAll(addSpaceBetweenEachLetter(word));
        return suggestions;
    }

    private List<String> adjacentPairSwap(String word) {
        List<String> suggestions = new ArrayList<>();
        String swapped;
        char[] letters = word.toCharArray();
        for (int i = 0; i < letters.length - 2; i++) {
            letters = word.toCharArray();
            char temp = letters[i];
            letters[i] = letters[i + 1];
            letters[i + 1] = temp;
            swapped = String.valueOf(letters);
            if (wordList.lookup(swapped)) {
                suggestions.add(swapped);
            }
        }
        return suggestions;
    }

    private List<String> insertLetterInBetween(String word) {
        List<String> suggestions = new ArrayList<>();
        String fixedWord;
        char[] original = word.toCharArray();
        char[] letters = new char[original.length + 1];
        for (int i = 0; i < letters.length; i++) {
            System.arraycopy(original, 0, letters, 0, original.length);
            moveLetters(letters, i, original.length);
            for (char c = 'A'; c <= 'Z'; ++c) {
                letters[i] = c;
                fixedWord = String.valueOf(letters);
                if (wordList.lookup(fixedWord)) {
                    suggestions.add(fixedWord);
                }
            }
        }
        return suggestions;
    }

    private void moveLetters(char[] array, int start, int end) {
        if (end - start >= 0) System.arraycopy(array, start, array, start + 1, end - start);
    }

    private List<String> deleteEachLetter(String word) {
        List<String> suggestions = new ArrayList<>();
        String replaced;
        for (int i = 0; i < word.length() - 1; i++) {
            replaced = new StringBuilder(word).deleteCharAt(i).toString();
            if (wordList.lookup(replaced)) {
                suggestions.add(replaced);
            }
        }
        return suggestions;
    }

    private List<String> replaceEachLetter(String word) {
        List<String> suggestions = new ArrayList<>();
        for (int i = 0; i < word.length() - 1; i++) {
            for (char c = 'A'; c <= 'Z'; ++c) {
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, c);
                String string = sb.toString();
                if (wordList.lookup(string)) {
                    suggestions.add(string);
                }
            }
        }
        return suggestions;
    }

    private Collection<? extends String> addSpaceBetweenEachLetter(String word) {
        List<String> suggestions = new ArrayList<>();
        for (int i = 0; i < word.length() - 1; i++) {
            for (int j = 0; j < word.length() - 1; j++) {
                String s1 = word.substring(0, i);
                String s2 = word.substring(j);
                if (wordList.lookup(s1)) {
                    suggestions.add(s1);
                }
                if (wordList.lookup(s2)) {
                    suggestions.add(s2);
                }
            }
        }
    return suggestions;
    }
}
