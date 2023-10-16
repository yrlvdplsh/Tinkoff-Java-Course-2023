package edu.hw1.task1;

import java.util.regex.Pattern;

public final class VideoLengthCalculator {
    private final static long LONG_LIMIT_SEC = 7;
    private final static long SECONDS_IN_MINUTE = 60;
    private final static String REGEX = "\\d+:\\d{2}";

    private VideoLengthCalculator() {
    }

    public static long minutesToSeconds(String length) {

        if (length == null || !Pattern.matches(REGEX, length)) {
            return -1;
        }

        long res = 0;
        long t;
        String[] time = length.split(":");

        t = Long.parseLong(time[1]);
        if (t < 0 || t >= SECONDS_IN_MINUTE) {
            return -1;
        }
        res += t;

        t = Long.parseLong(time[0]);
        if (t < 0 || (t > Long.MAX_VALUE / SECONDS_IN_MINUTE)
            || (t == Long.MAX_VALUE / SECONDS_IN_MINUTE && res > LONG_LIMIT_SEC)) {
            return -1;
        }
        res += t * SECONDS_IN_MINUTE;

        return res;
    }
}

