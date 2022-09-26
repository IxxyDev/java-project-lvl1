package hexlet.code.utils;

import java.util.Random;

public class Utils {
    private static final Random RANDOM = new Random();

    public static int generateRandomPositiveInt(int limit) {
        return RANDOM.nextInt(limit);
    }

    public static int[] generateRandomPositiveIntArray(int limit) {
        var numbers = new int[2];
        numbers[0] = RANDOM.nextInt(limit);
        numbers[1] = RANDOM.nextInt(limit);

        return numbers;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String calculateGSD(int firstNumber, int secondNumber) {
        while (firstNumber != 0 && secondNumber != 0) {
            if (firstNumber > secondNumber) {
                firstNumber = firstNumber % secondNumber;
            } else {
                secondNumber = secondNumber % firstNumber;
            }
        }
        return Integer.toString(firstNumber + secondNumber);
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static String generateRandomOperation(int numberOfOperations) throws Exception {
        int number = RANDOM.nextInt(numberOfOperations);

        return switch (number) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> throw new Exception("This operation is not allowed");
        };
    }
}
