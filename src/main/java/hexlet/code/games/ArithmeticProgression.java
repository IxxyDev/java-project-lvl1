package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class ArithmeticProgression {
    private static final Random RANDOM = new Random();
    private static final int PROGRESSION_LENGTH_LIMIT = 5;
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int FIRST_NUMBER_LIMIT = 15;
    private static final int STEP_LIMIT = 20;
    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";

    public static void run() {
        var step = RANDOM.nextInt(STEP_LIMIT) + 1;
        var progressionLength = RANDOM.nextInt(PROGRESSION_LENGTH_LIMIT) + MIN_PROGRESSION_LENGTH;
        var firstNumber = RANDOM.nextInt(FIRST_NUMBER_LIMIT);
        var position = RANDOM.nextInt(progressionLength - 1);
        String[][] gameData = new String[Engine.CORRECT_ANSWERS_LIMIT][2];

        for (int turn = 0; turn < Engine.CORRECT_ANSWERS_LIMIT; turn++) {
            var data = generateGameData(generateProgression(firstNumber, progressionLength, step), position);
            gameData[turn][0] = data[0];
            gameData[turn][1] = data[1];
        }
        Engine.start(GAME_DESCRIPTION, gameData);
    }

    private static String[] generateGameData(String[] progression, int position) {
        var question = new StringBuilder();
        var correctAnswer = progression[position];
        progression[position] = "..";

        for (String value : progression) {
            question.append(value).append(" ");
        }
        return new String[] {question.toString(), correctAnswer};
    }

    private static String[] generateProgression(int firstNumber, int progressionLength, int step) {
        String[] result = new String[progressionLength];

        for (int i = 0; i < progressionLength; i++) {
            firstNumber += step;
            result[i] = String.valueOf(firstNumber);
        }
        return result;
    }

}
