package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Utils;

public class GCD {
    private static final int RANDOM_UPPER_LIMIT = 100;
    private static final String GCD_GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void run() {
        String[][] gameData = new String[Engine.CORRECT_ANSWERS_LIMIT][2];

        for (int turn = 0; turn < Engine.CORRECT_ANSWERS_LIMIT; turn++) {
            var data = generateGameData();
            gameData[turn][0] = data[0];
            gameData[turn][1] = data[1];
        }

        Engine.start(GCD_GAME_DESCRIPTION, gameData);
    }

    private static String[] generateGameData() {
        var numbers = Utils.generateRandomPositiveIntArray(RANDOM_UPPER_LIMIT);
        return new String[] {numbers[0] + " " + numbers[1], Utils.calculateGSD(
            numbers[0], numbers[1])};
    }
}
