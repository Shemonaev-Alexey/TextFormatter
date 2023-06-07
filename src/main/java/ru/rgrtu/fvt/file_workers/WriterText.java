package ru.rgrtu.fvt.file_workers;

import ru.rgrtu.fvt.exception.TextFormatterException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class WriterText {
    public void writeText(String text) {
        File file = new File("TextFormatterResult.txt");
        try (OutputStreamWriter writer =
                     new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.UTF_8)) {
            PrintWriter printWriter = new PrintWriter(writer);

            printWriter.printf("%s" + "%n", text).close();
            System.out.println(">> Write file success!");
            System.out.println(">> Path to formatted file: ");
            System.out.println(file.getAbsolutePath());
        } catch (IOException ex) {
            throw new TextFormatterException("Write file is not success!", ex);
        }
    }
}
