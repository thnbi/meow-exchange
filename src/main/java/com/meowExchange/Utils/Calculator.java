package com.meowExchange.Utils;

import java.util.Scanner;

public class Calculator {
    public static double convert(double value, double rate) {
        return value * rate;
    }

    public static double readDouble() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}
