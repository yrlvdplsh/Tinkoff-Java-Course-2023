package edu.hw1.task6;

import java.util.Arrays;
import java.util.stream.IntStream;

public final class KaprecarCounter {

    private static final int LOW = 1000;
    private static final int HIGH = 9999;
    private static final int KAPRECAR_NUMBER = 6174;

    private KaprecarCounter() {
    }

    @SuppressWarnings("checkstyle:MagicNumber") public static int countK(int number) {
        if (number < LOW || number > HIGH) {
            return -1;
        }

        if (number == KAPRECAR_NUMBER) {
            return 0;
        }

        String stringNumber = String.valueOf(number);
        char[] numberDigits = stringNumber.toCharArray();
        char[] numberDigitsReverse = new char[4];

        if (IntStream.of(1, 2, 3).allMatch(i -> (numberDigits[0] == numberDigits[i]))) {
            return -1;
        }

        Arrays.sort(numberDigits);
        for (int i = 0; i < 2; i++) {
            numberDigitsReverse[i] = numberDigits[3 - i];
            numberDigitsReverse[3 - i] = numberDigits[i];
        }
        int num1 = Integer.parseInt(new String(numberDigits));
        int num2 = Integer.parseInt(new String(numberDigitsReverse));

        return 1 + countK(Math.abs(num1 - num2));
    }
}
