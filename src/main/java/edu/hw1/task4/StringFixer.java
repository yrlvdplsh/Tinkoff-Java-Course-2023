package edu.hw1.task4;

public final class StringFixer {
    private StringFixer() {
    }

    public static String fixString(String brokenString) {

        if (brokenString == null || brokenString.isEmpty())  {
            return brokenString;
        }

        StringBuilder fixedString = new StringBuilder(brokenString);
        for (int i = 0; i < brokenString.length() - 1; i += 2) {
            fixedString.setCharAt(i, brokenString.charAt(i + 1));
            fixedString.setCharAt(i + 1, brokenString.charAt(i));
        }

        return fixedString.toString();
    }
}
