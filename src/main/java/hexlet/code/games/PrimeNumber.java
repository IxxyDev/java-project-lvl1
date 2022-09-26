package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Utils;

public class PrimeNumber {
    private static final int RANDOM_UPPER_LIMIT = 500;
    private static final String PRIME_NUMBER_GAME_DESCRIPTION =
        "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void run() {
        String[][] gameData = new String[Engine.CORRECT_ANSWERS_LIMIT][2];

        for (int turn = 0; turn < Engine.CORRECT_ANSWERS_LIMIT; turn++) {
            var data = generateGameData();
            gameData[turn][0] = data[0];
            gameData[turn][1] = data[1];
        }
        Engine.start(PRIME_NUMBER_GAME_DESCRIPTION, gameData);
    }

    private static String[] generateGameData() {
        var randomNumber = Utils.generateRandomPositiveInt(RANDOM_UPPER_LIMIT);
        return new String[] {Integer.toString(randomNumber), checkAnswer(randomNumber)};
    }

    private static String checkAnswer(int number) {
        return Utils.isPrime(number) ? "yes" : "no";
    }
}
