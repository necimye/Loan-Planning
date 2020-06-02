package com.codewithpimenova;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);
    public static double getNumber(String prompt) {
        return scanner.nextDouble();
    }
    public static double getNumber(String prompt, double max, double min) {
        double value;

        while (true){
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value <= min || value >= max) break;
            System.out.println("Enter value between " + min + "and " + max);
        }

        return value;
    }
}
