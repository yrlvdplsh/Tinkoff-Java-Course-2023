package edu.hw1.task3;

import java.util.Arrays;

public final class NestableArraysChecker {
    private NestableArraysChecker() {
    }

    public static boolean isNestable(long[] array1, long[] array2) {

        if (array1 == null || array2 == null) {
            throw new NullPointerException("Invalid Input");
        }
        if (array2.length <= 1 || array1.length <= 1) {
            return false;
        }

        long max1 = Arrays.stream(array1).max().getAsLong();
        long max2 = Arrays.stream(array2).max().getAsLong();
        long min1 = Arrays.stream(array1).min().getAsLong();
        long min2 = Arrays.stream(array2).min().getAsLong();

        return (max1 < max2 && min1 > min2);
    }
}
