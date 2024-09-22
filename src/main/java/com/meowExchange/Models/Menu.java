package com.meowExchange.Models;

import com.meowExchange.Utils.Calculator;
import com.meowExchange.Utils.ExchangeRateUtil;

import java.util.Scanner;

public class Menu {

    public static void ShowMenu() {
        clearScreen();
        System.out.println(
                """
                        
                                  ___  ___                     _____         _                           \s
                                  |  \\/  |                    |  ___|       | |                          \s
                                  | .  . | ___  _____      __ | |____  _____| |__   __ _ _ __   __ _  ___\s
                                  | |\\/| |/ _ \\/ _ \\ \\ /\\ / / |  __\\ \\/ / __| '_ \\ / _` | '_ \\ / _` |/ _ \\
                                  | |  | |  __/ (_) \\ V  V /  | |___>  < (__| | | | (_| | | | | (_| |  __/
                                  \\_|  |_/\\___|\\___/ \\_/\\_/   \\____/_/\\_\\___|_| |_|\\__,_|_| |_|\\__, |\\___|
                                                                                                __/ |    \s
                                                                                               |___/     \s
                        ================================================================================================
                        |                                                                                              |
                        |                                       Choose an option:                                      |
                        |                                                                                              |
                        |                                   1 - Dollar ⬌ Brazilian Real                                |
                        |                                   2 - Dollar ⬌ Argentine Peso                                |
                        |                                   3 - Dollar ⬌ Colombian Peso                                |
                        |                                   4 - Custom Exchange                                        |
                        |                                                                                              |
                        |                                           Q - Quit                                           |
                        |                                                                                              |
                        ================================================================================================
                        """
        );

        Scanner scanner = new Scanner(System.in);
        char option = scanner.next().charAt(0);

        optionSelected(option);
    }

    private static void optionSelected(char option) {
        switch (option) {
            case '1':
                System.out.println("Enter the amount in dollars: ");
                dollarToReal(Calculator.readDouble());
                break;
            case '2':
                System.out.println("Enter the amount in dollars: ");
                dollarToArgentinePeso(Calculator.readDouble());
                break;
            case '3':
                System.out.println("Enter the amount in dollars: ");
                dollarToColombianPeso(Calculator.readDouble());
                break;
            case '4':
                System.out.println("Enter the amount: ");
                customExchange(Calculator.readDouble());
                break;
            case 'Q':
            case 'q':
                System.exit(0);
            default:
                System.out.println("Invalid option, please try again.");
                waitForEnter();
        }
        ShowMenu();
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void dollarToReal(double amount) {
        double result = ExchangeRateUtil.convertCurrency("USD", "BRL", amount);
        System.out.println("The amount in Brazilian Real is: " + result);
        waitForEnter();
    }

    private static void dollarToArgentinePeso(double amount) {
        double result = ExchangeRateUtil.convertCurrency("USD", "ARS", amount);
        System.out.println("The amount in Argentine Peso is: " + result);
        waitForEnter();
    }

    private static void dollarToColombianPeso(double amount) {
        double result = ExchangeRateUtil.convertCurrency("USD", "COP", amount);
        System.out.println("The amount in Colombian Peso is: " + result);
        waitForEnter();
    }

    private static void customExchange(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the currency you want to convert from: ");
        String fromCurrency = scanner.nextLine();
        System.out.println("Enter the currency you want to convert to: ");
        String toCurrency = scanner.nextLine();
        double result = ExchangeRateUtil.convertCurrency(fromCurrency, toCurrency, amount);
        System.out.println("The amount in " + toCurrency + " is: " + result);
        waitForEnter();
    }

    private static void waitForEnter() {
        System.out.println("Press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
