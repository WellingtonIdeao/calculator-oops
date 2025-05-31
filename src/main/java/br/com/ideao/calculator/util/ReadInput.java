package br.com.ideao.calculator.util;

import java.util.Scanner;

public class ReadInput {
    public static String read() {
        String input = "";
        try(Scanner scanner = new Scanner(System.in)) {
            input = scanner.nextLine();
        }

        return input;
    }

}
