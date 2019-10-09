package com.codecool.szlukaeszter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Test
    void getWordsOrderedAlphabeticallyTest() {
        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/sampleAlphabet.txt", 1, 5);
        FileWordAnalyzer fa = new FileWordAnalyzer(reader);
        Object[] expect = {"A", "B", "C", "D", "F"};
        Object[] result = fa.getWordsOrderedAlphabetically().toArray();
        Assertions.assertArrayEquals(expect, fa.getWordsOrderedAlphabetically().toArray());

    }

    @Test
    void getWordsContainingSubstringTest() {
        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/subStringSample.txt", 1, 5);
        FileWordAnalyzer fa = new FileWordAnalyzer(reader);
        Object[] expect = {"apple 1", "apple 2", "apple 3"};
        Object[] result = fa.getWordsContainingSubstring("apple").toArray();
        Assertions.assertArrayEquals(expect, fa.getWordsContainingSubstring("apple").toArray());

    }

    @Test
    void getStringsWhichPalindromes() {
        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/samplePalindrom.txt", 1, 8);
        FileWordAnalyzer fa = new FileWordAnalyzer(reader);
        Object[] expect = {"rotor", "racecar", "level", "refer"};
        Object[] result = fa.getStringsWhichPalindromes().toArray();
        Assertions.assertArrayEquals(expect, fa.getStringsWhichPalindromes().toArray());
    }
}