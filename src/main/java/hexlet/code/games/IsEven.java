package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;
import java.util.Scanner;

public class IsEven {
    private static int correctAnswersInARow = 0;
    private static final int RANDOM_UPPER_LIMIT = 100;
    private static final int CORRECT_ANSWERS_LIMIT = 3;

    public static void main() {
        Scanner scanner = new Scanner(System.in);

        while (correctAnswersInARow < CORRECT_ANSWERS_LIMIT) {
            int number = getRandomPositiveInt();
            System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
            System.out.println("Question: " + number);
            String answer = scanner.next();
            isAnswerCorrect(number, answer);
        }

        System.out.println("Congratulations " + Cli.getUserName() + "!");
        System.exit(0);
    }

    public static int getRandomPositiveInt() {
        Random random = new Random();
        return random.nextInt(RANDOM_UPPER_LIMIT);
    }

    public static void isAnswerCorrect(int number, String answer) {
        if ((isEven(number) && answer.equals("yes")) || (!isEven(number) && answer.equals("no"))) {
            System.out.println("Correct!");
            correctAnswersInARow++;
        } else {
            String rightAnswer = answer.equals("yes") ? "'no'" : "'yes'";
            System.out.println(answer + " is wrong answer ;(. Correct answer was " + rightAnswer + ".");
            System.out.println("Let's try again, " + Cli.getUserName() + "!");
            correctAnswersInARow = 0;
            System.exit(0);
        }
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
