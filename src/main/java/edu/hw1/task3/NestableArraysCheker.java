package edu.hw1.task3;

import java.util.Arrays;

public final class NestableArraysCheker {
    private NestableArraysCheker() {
    }

    public static boolean isNestable(long[] array1, long[] array2) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long min1 = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;

        for (long l: array1) {
            if (l > max1) {
                max1 = l;
            }
            if (l < min1) {
                min1 = l;
            }
        }
        for (long l: array2) {
            if (l > max2) {
                max2 = l;
            }
            if (l < min2) {
                min2 = l;
            }
        }

        return (max1 < max2 && min1 > min2);
    }
}
