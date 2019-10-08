package com.codecool.szlukaeszter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FilePartReaderTest {


    @Test
    public void setupIllegalArgument() {
        FilePartReader fp = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> fp.setup("sample.txt", 2, 1));
    }

    @Test
    void readSuccess() throws IOException {
        FilePartReader fp = new FilePartReader();
        fp.setup("src/test/resources/sample.txt", 1, 3);
        Assertions.assertEquals("line 1 head\nline 2\nline 3\nline 4\nline 5 end", fp.read());
    }

    @Test
    void readFileNotFound() {
        FilePartReader fp = new FilePartReader();
        fp.setup("src/test/resources/notfound.txt", 1, 3);
        assertThrows(IOException.class, () -> fp.read());
    }

    @Test
    void readLines() throws IOException{
        FilePartReader fp = new FilePartReader();
        fp.setup("src/test/resources/sample.txt", 1, 3);
        Assertions.assertEquals("line 1 head\nline 2", fp.readLines());
    }

    @Test
    void readLinesFileNotFound(){
        FilePartReader fp = new FilePartReader();
        fp.setup("src/test/resources/notfound.txt", 1, 3);
        assertThrows(IOException.class, () -> fp.readLines());
    }
}