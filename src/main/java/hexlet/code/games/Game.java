package hexlet.code.games;

import hexlet.code.Engine;

public abstract class Game {
    private static String gameDescription;


    static void run() {
        String[][] gameData = new String[Engine.CORRECT_ANSWERS_LIMIT][2];

        for (int turn = 0; turn < Engine.CORRECT_ANSWERS_LIMIT; turn++) {
            var data = generateGameData();
            gameData[turn][0] = data[0];
            gameData[turn][1] = data[1];
        }
        Engine.start(gameDescription, gameData);
    }

    abstract String[] generateGameData();
}
