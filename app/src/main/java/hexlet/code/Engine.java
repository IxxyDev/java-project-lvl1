package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int CORRECT_ANSWERS_LIMIT = 3;

    public static void start(String taskDescription, String[][] gameData) {
        Cli.greetUser();
        System.out.println(taskDescription);
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < CORRECT_ANSWERS_LIMIT; i++) {
            System.out.println("Question: " + gameData[i][0]);
            var userAnswer = scanner.next();
            var correctAnswer = gameData[i][1];

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println(userAnswer + " is wrong answer ;(. Correct answer was " + correctAnswer + ".");
                System.out.println("Let's try again, " + Cli.getUserName() + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + Cli.getUserName() + "!");
    }
}
