package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calculator {
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
        String expression = createExpression(getRandomPositiveIntegers(), getRandomOperation());
        return new String[] {expression, Integer.toString(calculate(expression))};
    }

    public static int[] getRandomPositiveIntegers() {
        var numbers = new int[2];
        Random random = new Random();
        numbers[0] = random.nextInt(RANDOM_UPPER_LIMIT);
        numbers[1] = random.nextInt(RANDOM_UPPER_LIMIT);

        return numbers;
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
