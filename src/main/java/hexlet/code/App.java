package hexlet.code;

import hexlet.code.games.ArithmeticProgression;
import hexlet.code.games.Calculator;
import hexlet.code.games.GCD;
import hexlet.code.games.IsEven;
import hexlet.code.games.IsPrime;

import java.util.Scanner;


public class App {
    // Через Enum не получалось проверить в switch/case(((
    private static final int EXIT = 0;
    private static final int GREET = 1;
    private static final int IS_EVEN = 2;
    private static final int CALCULATOR = 3;
    private static final int CHECK_DIVIDER = 4;
    private static final int ARITHMETIC_PROGRESSION = 5;
    private static final int IS_PRIME = 6;

    public static void main(String[] args) {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        switch (number) {
            case EXIT -> System.exit(0);
            case GREET -> Engine.greetUser();
            case IS_EVEN -> IsEven.run();
            case CALCULATOR -> Calculator.run();
            case CHECK_DIVIDER -> GCD.run();
            case ARITHMETIC_PROGRESSION -> ArithmeticProgression.run();
            case IS_PRIME -> IsPrime.run();
            default -> {
                System.out.println("Sorry, there is no such option");
                System.exit(0);
            }
        }
    }

    private static void printMenu() {
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet");
        System.out.println("2 - Is Even");
        System.out.println("3 - Calculator");
        System.out.println("4 - GCD");
        System.out.println("5 - Arithmetic Progression");
        System.out.println("6 - Is Prime");
        System.out.println("0 - Exit");
        System.out.println("Your choice ");
    }
}
