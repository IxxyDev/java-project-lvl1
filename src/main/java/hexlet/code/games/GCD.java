package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCD {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_UPPER_LIMIT = 100;
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void run() {
        String[][] gameData = new String[Engine.CORRECT_ANSWERS_LIMIT][2];

        for (int turn = 0; turn < Engine.CORRECT_ANSWERS_LIMIT; turn++) {
            var data = generateGameData();
            gameData[turn][0] = data[0];
            gameData[turn][1] = data[1];
        }

        Engine.start(GAME_DESCRIPTION, gameData);
    }

    private static String[] generateGameData() {
        var numbers = getRandomPositiveInts();
        return new String[] {numbers[0] + " " + numbers[1], calculateCSD(numbers)};
    }

    private static String[] getRandomPositiveInts() {
        return new String[] {Integer.toString(RANDOM.nextInt(RANDOM_UPPER_LIMIT)),
            Integer.toString(RANDOM.nextInt(RANDOM_UPPER_LIMIT))};
    }

    private static String calculateCSD(String[] numbers) {
        var firstNumber = Integer.parseInt(numbers[0]);
        var secondNumber = Integer.parseInt(numbers[1]);
        while (firstNumber != 0 && secondNumber != 0) {
            if (firstNumber > secondNumber) {
                firstNumber = firstNumber % secondNumber;
            } else {
                secondNumber = secondNumber % firstNumber;
            }
        }
        return Integer.toString(firstNumber + secondNumber);
    }
}
