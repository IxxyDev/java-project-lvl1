package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Utils;

public class Calculator {
    private static final int NUMBER_OF_OPERATIONS = 3;
    private static final int RANDOM_UPPER_LIMIT = 100;
    private static final String CALCULATOR_GAME_DESCRIPTION = "What is the result of the expression?";

    public static void run() throws Exception {
        String[][] gameData = new String[Engine.CORRECT_ANSWERS_LIMIT][2];

        for (int turn = 0; turn < Engine.CORRECT_ANSWERS_LIMIT; turn++) {
            var data = generateGameData();
            gameData[turn][0] = data[0];
            gameData[turn][1] = data[1];
        }

        Engine.start(CALCULATOR_GAME_DESCRIPTION, gameData);
    }

    private static String[] generateGameData() throws Exception {
        int[] randomPositiveNumbers = Utils.generateRandomPositiveIntArray(RANDOM_UPPER_LIMIT);
        String operation = Utils.generateRandomOperation(NUMBER_OF_OPERATIONS);
        String expression = createExpression(randomPositiveNumbers, operation);

        return new String[] {expression, Integer.toString(calculate(
            randomPositiveNumbers[0],
            randomPositiveNumbers[1],
            operation
        ))};
    }

    private static String createExpression(int[] numbers, String operation) {
        return numbers[0] + " " + operation + " " + numbers[1];
    }

    private static int calculate(int firstOperand, int secondOperand, String operation) throws Exception {
        return switch (operation) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            case "*" -> firstOperand * secondOperand;
            default -> throw new Exception("This operation is not allowed");
        };
    }
}
