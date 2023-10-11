package edu.hw1.task1;

import java.util.regex.Pattern;

public final class VideoLengthCalculator {
    private VideoLengthCalculator() {
    }

    @SuppressWarnings("checkstyle:MagicNumber") public static long minutesToSeconds(String length) {

        if (length == null || !Pattern.matches("\\d+:\\d{2}", length)) {
            return -1;
        }

        long res = 0;
        long t;
        String[] time = length.split(":");

        t = Long.parseLong(time[1]);
        if (t < 0 || t > 59) {
            return -1;
        }
        res += t;

        t = Long.parseLong(time[0]);
        if (t < 0 || (t > Long.MAX_VALUE / 60) || (t == Long.MAX_VALUE / 60 && res > 7)) {
            return -1;
        }
        res += t * 60;

        return res;
    }
}

