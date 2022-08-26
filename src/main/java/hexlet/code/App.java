package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.GCD;
import hexlet.code.games.IsEven;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet");
        System.out.println("2 - Is Even");
        System.out.println("3 - Calculator");
        System.out.println("4 - GCD");
        System.out.println("0 - Exit");
        System.out.println("Your choice ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        switch (number) {
            case 0 -> System.exit(0);
            case 1 -> Engine.greetUser();
            case 2 -> IsEven.run();
            case 3 -> Calculator.run();
            case 4 -> GCD.run();
            default -> {
                System.out.println("Sorry, there is no such option");
                System.exit(0);
            }
        }
    }
}
