package ru.rgrtu.fvt;

import ru.rgrtu.fvt.dto.TaskParameter;
import ru.rgrtu.fvt.enums.FormatVariables;
import ru.rgrtu.fvt.file_workers.ReaderText;
import ru.rgrtu.fvt.file_workers.WriterText;
import ru.rgrtu.fvt.users_interface.UsersCommander;

import java.nio.charset.StandardCharsets;

public class TextFormatter {
    public static void main(String[] args) {
        String text = getText();
        TaskParameter taskParameter = getTaskParameter();
        int variable = UsersCommander.getIntValue(">> Enter variable format text 1 or 2");
        String resultText = FormatVariables.getByVariable(variable)
                .startFormat(taskParameter, text);
        new WriterText().writeText(resultText);
    }

    private static String getText() {
        String pathFile = UsersCommander.getStringValue(">> Please enter the path to the file with the text." +
                " File`s name must be in English: ");
        return new ReaderText(new String(pathFile.getBytes(StandardCharsets.UTF_8))).read().toString();
    }

    private static TaskParameter getTaskParameter() {
        int leftLine = UsersCommander.getIntValue(">> Enter left line number: ");
        int rightLine = UsersCommander.getIntValue(">> Enter right line number: ");
        int countSpaces = UsersCommander.getIntValue(">> Enter count space by paragraph: ");
        return new TaskParameter(leftLine, rightLine, countSpaces);
    }
}
