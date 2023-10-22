package edu.hw3.task1;

 final class Encoder {
    private Encoder() {
    }

    public static String encodeAtbash(String input) {
        if (input == null) {
            throw new NullPointerException("your string must not be null!");
        }

        char[] encodedString = new char[input.length()];
        int i = 0;

        for (char symbol : input.toCharArray()) {
            char encodedLetter;
            if (Character.isLetter(symbol)) {
                if (Character.isLowerCase(symbol)) {
                    encodedLetter = (char) ('z' - (symbol - 'a'));
                } else {
                    encodedLetter = (char) ('Z' - (symbol - 'A'));
                }
            } else {
                encodedLetter = symbol;
            }

            encodedString[i++] = encodedLetter;
        }

        return new String(encodedString);
    }
}
