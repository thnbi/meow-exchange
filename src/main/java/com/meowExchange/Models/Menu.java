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
                        |                                   1 - US Dollar ⬌ Brazilian Real                             |
                        |                                   2 - US Dollar ⬌ Chinese Ren                                |
                        |                                   3 - US Dollar ⬌ Japanese Yen                               |
                        |                                   4 - Brazilian Real ⬌ US Dollar                             |
                        |                                   5 - Brazilian Real ⬌ Japanese Yen                          |
                        |                                   6 - Brazilian Real ⬌ Chinese Ren                           |
                        |                                                                                              |
                        |                                   0 - Custom Exchange                                        |
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
            case '0':
                customExchange();
                break;
            case '1':
                convertCurrency("USD", "BRL");
                break;
            case '2':
                convertCurrency("USD", "CNY");
                break;
            case '3':
                convertCurrency("USD", "JPY");
                break;
            case '4':
                convertCurrency("BRL", "USD");
                break;
            case '5':
                convertCurrency("BRL", "JPY");
                break;
            case '6':
                convertCurrency("BRL", "CNY");
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

    private static void customExchange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter only the currency code (e.g. USD, BRL, CNY, JPY)");
        System.out.println("Enter the currency you want to convert from: ");
        String fromCurrency = scanner.nextLine();
        System.out.println("Enter the currency you want to convert to: ");
        String toCurrency = scanner.nextLine();

        convertCurrency(fromCurrency, toCurrency);
    }

    private static void convertCurrency(String fromCurrency, String toCurrency) {
        try {
            System.out.println("Enter the amount you want to convert: ");
            double amount = Calculator.readDouble();
            double result = ExchangeRateUtil.convertCurrency(fromCurrency, toCurrency, amount);
            System.out.println("The amount in " + toCurrency + " is: " + result);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        waitForEnter();
    }

    private static void waitForEnter() {
        System.out.println("Press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
