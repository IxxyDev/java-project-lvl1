package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;
import java.util.Scanner;

public class Calculator {
    private static int correctAnswersInARow = 0;
    private static final int NUMBER_OF_OPERATIONS = 3;
    private static final int CORRECT_ANSWERS_LIMIT = 3;
    private static final int RANDOM_UPPER_LIMIT = 100;

    public static void main() {
        Scanner scanner = new Scanner(System.in);

        while (correctAnswersInARow < CORRECT_ANSWERS_LIMIT) {
            var numbers = getRandomPositiveIntegers();
            var operation = getRandomOperation();
            var expression = createExpression(numbers, operation);

            System.out.println("What is the result of the expression?");
            System.out.println("Question: " + expression);
            int answer = scanner.nextInt();
            var correctAnswer = calculate(expression);
            isAnswerCorrect(correctAnswer, answer);
        }

        System.out.println("Congratulations " + Cli.getUserName() + "!");
        System.exit(0);
    }

    public static int[] getRandomPositiveIntegers() {
        var numbers = new int[2];
        Random random = new Random();
        numbers[0] = random.nextInt(RANDOM_UPPER_LIMIT);
        numbers[1] = random.nextInt(RANDOM_UPPER_LIMIT);

        return numbers;
    }

    private static void isAnswerCorrect(int correctAnswer, int answer) {
        if (answer == correctAnswer) {
            System.out.println("Correct!");
            correctAnswersInARow++;
        } else {
            System.out.println(answer + " is wrong answer ;(. Correct answer was " + correctAnswer + ".");
            System.out.println("Let's try again, " + Cli.getUserName() + "!");
            correctAnswersInARow = 0;
            System.exit(0);
        }
    }

    private static String getRandomOperation() {
        Random random = new Random();
        int number = random.nextInt(NUMBER_OF_OPERATIONS);

        return switch (number) {
            case 0 -> "+";
            case 1 -> "-";
            default -> "*";
        };
    }

    private static String createExpression(int[] numbers, String operation) {
        return numbers[0] + " " + operation + " " + numbers[1];
    }

    private static int calculate(String expression) {
        var arr = expression.split(" ");
        var firstOperand = Integer.parseInt(arr[0]);
        var operation = arr[1];
        var secondOperand = Integer.parseInt(arr[2]);

        return switch (operation) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            default -> firstOperand * secondOperand;
        };
    }
}
