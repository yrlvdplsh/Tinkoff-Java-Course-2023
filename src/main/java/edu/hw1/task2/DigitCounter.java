package edu.hw1.task2;

public final class DigitCounter {

    private static final int TEN = 10;

    private DigitCounter() {
    }

    public static int countDigits(long number) {
        if (number / TEN != 0) {
            return 1 + countDigits(number / TEN);
        }
        return 1;
    }
}
