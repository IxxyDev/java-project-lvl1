package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.IsEven;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet");
        System.out.println("2 - Is Even");
        System.out.println("3 - Calculator");
        System.out.println("0 - Exit");
        System.out.println("Your choice ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                Cli.greetUser();
            case 2:
                Cli.greetUser();
                IsEven.main();
            case 3:
                Cli.greetUser();
                Calculator.main();
            case 0:
                System.exit(0);
            default:
                System.out.println("Sorry, there's no such menu option");
        }
    }
}
