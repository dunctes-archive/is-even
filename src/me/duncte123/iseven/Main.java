package me.duncte123.iseven;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws Exception {

        File output = new File("isEven.js");

        if (!output.exists()) {
            output.createNewFile();
        } else {
            output.delete();
            output.createNewFile();
        }

        int cases = Integer.MAX_VALUE;
//        int cases = 100;

        try (FileWriter fw = new FileWriter(output)) {
            try (BufferedWriter writer = new BufferedWriter(fw)) {
                writer.write("export function isEven(number) {\n");
                writer.write(indent(4) + "switch (number) {\n");

                for (int i = 0; i < cases; i++) {
                    writer.write(indent(8) + "case ");
                    writer.write(String.valueOf(i));
                    writer.write(":\n");
                    writer.write(indent(12));
                    writer.write("return ");
                    writer.write(String.valueOf(i % 2 == 0));
                    writer.write(";\n");
                }

                writer.write("    }\n");
                writer.write("}\n");
            }
        }

    }

    private static String indent(int spaces) {
        return " ".repeat(Math.max(0, spaces));
    }
}
