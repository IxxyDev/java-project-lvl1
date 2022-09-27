package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Utils;

public class EvenNumber {
    private static final int RANDOM_UPPER_LIMIT = 100;
    private static final String EVEN_NUMBER_GAME_DESCRIPTION = "Answer 'yes' if number even otherwise answer 'no'.";

    public static void run() {
        String[][] gameData = new String[Engine.CORRECT_ANSWERS_LIMIT][2];

        for (int turn = 0; turn < Engine.CORRECT_ANSWERS_LIMIT; turn++) {
            var data = generateGameData();
            gameData[turn][0] = data[0];
            gameData[turn][1] = data[1];
        }
        Engine.start(EVEN_NUMBER_GAME_DESCRIPTION, gameData);
    }

    private static String[] generateGameData() {
        var number = Utils.generateRandomPositiveInt(RANDOM_UPPER_LIMIT);
        return new String[] {Integer.toString(number), checkAnswer(number)};
    }

    private static String checkAnswer(int number) {
        return Utils.isEven(number) ? "yes" : "no";
    }
}
