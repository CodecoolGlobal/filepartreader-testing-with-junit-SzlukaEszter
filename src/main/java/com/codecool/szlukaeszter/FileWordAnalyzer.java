package com.codecool.szlukaeszter;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileWordAnalyzer {

    private FilePartReader reader;
    ;

    FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    private List getLinesFromReader(){
        String text = "";
        try{
            text = reader.readLines();
        }
        catch (IOException exception){
            System.out.println("File not found");
        }
        return Arrays.asList(text.split("\n"));
    }

    public List getWordsOrderedAlphabetically() {
        List<String> result = getLinesFromReader();
        Collections.sort(result);
        return result;
    }

    public List getWordsContainingSubstring(String subString) {
        List<String> result = getLinesFromReader();
        result = result
                .stream()
                .filter(s -> s.contains(subString))
                .collect(Collectors.toList());
        return result;
    }

    public List getStringsWhichPalindromes() {
        List<String> result = getLinesFromReader();
        result = result
                .stream()
                .filter(s -> s.equals(reverseWord(s)))
                .collect(Collectors.toList());
        return result;
    }

    private String reverseWord(String word){
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        sb.reverse();
        return sb.toString();
    }
}

