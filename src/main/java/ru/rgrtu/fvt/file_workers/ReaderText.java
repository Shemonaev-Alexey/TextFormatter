package ru.rgrtu.fvt.file_workers;

import ru.rgrtu.fvt.exception.TextFormatterException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReaderText {
    String path;

    public ReaderText(String path) {
        this.path = path;
    }


    public StringBuilder read() {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append(System.lineSeparator());
            }
            System.out.println(">> Read file success!");
        } catch (IOException e) {
            throw new TextFormatterException("Read file is not success!", e);
        }

        return text;
    }

}
