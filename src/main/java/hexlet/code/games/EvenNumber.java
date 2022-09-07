package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class EvenNumber {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_UPPER_LIMIT = 100;
    private static final String GAME_DESCRIPTION = "Answer 'yes' if number even otherwise answer 'no'.";

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
        var number = getRandomPositiveInt();
        return new String[] {Integer.toString(number), getCorrectAnswer(number)};
    }

    private static int getRandomPositiveInt() {
        return RANDOM.nextInt(RANDOM_UPPER_LIMIT);
    }

    private static String getCorrectAnswer(int number) {
        return isEven(number) ? "yes" : "no";
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
