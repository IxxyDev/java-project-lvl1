package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class ArithmeticProgression {
    private static String correctAnswer;
    private static final int PROGRESSION_LENGTH_LIMIT = 8;
    private static final int FIRST_NUMBER_LIMIT = 15;
    private static final int STEP_LIMIT = 20;

    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";

    public static void run() {
        var turn = 0;
        String[][] gameData = new String[Engine.CORRECT_ANSWERS_LIMIT][2];

        while (turn < Engine.CORRECT_ANSWERS_LIMIT) {
            gameData[turn][0] = getGameData()[0];
            gameData[turn][1] = getGameData()[1];
            turn++;
        }

        Engine.start(GAME_DESCRIPTION, gameData);
    }

    public static String[] getGameData() {
        var progression = popRandomElement(generateProgression());
        var question = new StringBuilder();
        for (String s : progression) {
            question.append(s).append(" ");
        }
        return new String[] {question.toString(), correctAnswer};
    }

    private static String[] generateProgression() {
        Random random = new Random();
        // To have at least 2 numbers;
        var progressionLength = random.nextInt(PROGRESSION_LENGTH_LIMIT) + 2;
        var firstNumber = random.nextInt(FIRST_NUMBER_LIMIT);
        var step = random.nextInt(STEP_LIMIT);

        String[] result = new String[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            firstNumber += step;
            result[i] = String.valueOf(firstNumber);
        }
        return result;
    }

    private static String[] popRandomElement(String[] progression) {
        Random random = new Random();
        var position = random.nextInt(progression.length - 1);

        correctAnswer = progression[position];
        progression[position] = "..";
        return progression;
    }
}
