package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calculator {
    private static final Random RANDOM = new Random();
    private static final int NUMBER_OF_OPERATIONS = 3;
    private static final int RANDOM_UPPER_LIMIT = 100;
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";

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
        int[] randomPositiveNumbers = getRandomPositiveIntegers();
        String expression = createExpression(randomPositiveNumbers, getRandomOperation());
        return new String[] {expression, Integer.toString(calculate(
            randomPositiveNumbers[0],
            randomPositiveNumbers[1],
            getRandomOperation()
        ))};
    }

    public static int[] getRandomPositiveIntegers() {
        var numbers = new int[2];
        numbers[0] = RANDOM.nextInt(RANDOM_UPPER_LIMIT);
        numbers[1] = RANDOM.nextInt(RANDOM_UPPER_LIMIT);

        return numbers;
    }

    private static String getRandomOperation() {
        int number = RANDOM.nextInt(NUMBER_OF_OPERATIONS);

        return switch (number) {
            case 0 -> "+";
            case 1 -> "-";
            default -> "*";
        };
    }

    private static String createExpression(int[] numbers, String operation) {
        return numbers[0] + " " + operation + " " + numbers[1];
    }

    private static int calculate(int firstOperand, int secondOperand, String operation) {
        return switch (operation) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            default -> firstOperand * secondOperand;
        };
    }
}
