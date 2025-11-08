package com.campusdual.classroom;

import com.campusdual.Utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise {

    public static void main(String[] args) {
        String stringToSave = generateStringToSave(null);
        printToFile(stringToSave);
    }

    public static String generateStringToSave(String string) {
        if (string != null) {
            return string;
        } else {
            return generateUserInputToSave();
        }
    }

    private static String generateUserInputToSave() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String input;
        boolean firstLine = true;
        while (!(input = Utils.string()).isEmpty()) {
            if (!firstLine) {
                sb.append("\n");
            }
            sb.append(input);
            firstLine = false;
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        try {
            File file = new File("src/main/resources/data.txt");
            file.getParentFile().mkdirs();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(string);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

