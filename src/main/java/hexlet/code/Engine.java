package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int CORRECT_ANSWERS_LIMIT = 3;
    private static int correctAnswersInARow = 0;
    private static String userName;

    public static void greetUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }

    public static void checkAnswer(String userAnswer, String correctAnswer) {
        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            correctAnswersInARow++;
        } else {
            System.out.println(userAnswer + " is wrong answer ;(. Correct answer was " + correctAnswer + ".");
            System.out.println("Let's try again, " + userName + "!");
            System.exit(0);
        }
    }


    public static void start(String taskDescription, String[] gameData) {
        greetUser();
        System.out.println(taskDescription);
        Scanner scanner = new Scanner(System.in);

        while (correctAnswersInARow < CORRECT_ANSWERS_LIMIT) {
            System.out.println("Question: " + gameData[0]);
            var userAnswer = scanner.next();
            checkAnswer(userAnswer, gameData[1]);
        }

        System.out.println("Congratulations, " + userName + "!");
        System.exit(0);
    }
}
