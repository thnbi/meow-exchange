package com.meowExchange.Models;

import java.util.Scanner;

public class Menu {

    public static void ShowMenu(){
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

    private static void optionSelected(char option){
        clearScreen();
        switch(option) {
            case '1':
                System.out.println("Dollar ⬌ Brazilian Real");
                break;
            case '2':
                System.out.println("Dollar ⬌ Argentine Peso");
                break;
            case '3':
                System.out.println("Dollar ⬌ Colombian Peso");
                break;
            case 'Q' | 'q':
                System.out.println("Quitting...");
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
