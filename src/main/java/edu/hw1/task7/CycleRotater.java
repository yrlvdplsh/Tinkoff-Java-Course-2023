package edu.hw1.task7;

public final class CycleRotater {
    private CycleRotater() {
    }

    public static int rotateLeft(int n, int shift) {
        if (n < 0 || shift < 0) {
            return -1;
        }
        String number = Integer.toBinaryString(n);

        if (shift == 0 || number.length() == 1) {
            return n;
        }

        int realShift = shift % number.length();
        number = number.substring(realShift) + number.substring(0, realShift);

        return Integer.parseInt(number, 2);
    }

    public static int rotateRight(int n, int shift) {
        if (n < 0 || shift < 0) {
            return -1;
        }
        String number = Integer.toBinaryString(n);

        if (shift == 0 || number.length() == 1) {
            return n;
        }

        int realShift = shift % number.length();
        number =
            number.substring(number.length() - realShift) + number.substring(0, number.length() - realShift);

        return Integer.parseInt(number, 2);
    }
}
