package com.codecool.szlukaeszter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    FilePartReader(){
        filePath = "";
        fromLine = 1;
        toLine = 2;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException{
        if (toLine < fromLine || toLine < 1) {throw new IllegalArgumentException();}
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(filePath);
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            sb.append(reader.nextLine() + "\n");
        }
        return sb.toString().trim();
    }

    public String readLines() throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(filePath);
        Scanner reader = new Scanner(file);
        String line = "";
        int i = 0;
        while (reader.hasNext() && i < toLine) {
            if ( i>= fromLine) {
                sb.append(reader.nextLine()+"\n");
            }
            i++;
        }
        return sb.toString().trim();
    }



}



