package edu.hw1.task2;

public final class DigitCounter {
    private DigitCounter() {
    }

    @SuppressWarnings("checkstyle:MagicNumber") public static int countDigits(long number) {
        if (number / 10 != 0) {
            return 1 + countDigits(number / 10);
        }
        return 1;
    }
}
