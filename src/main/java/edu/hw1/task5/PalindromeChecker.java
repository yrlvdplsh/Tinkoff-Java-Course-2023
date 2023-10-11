package edu.hw1.task5;

public final class PalindromeChecker {
    private PalindromeChecker() {
    }

    private static boolean isPalindrome(String number) {
        String reversedNumber = new StringBuilder(number).reverse().toString();
        return number.equals(reversedNumber);
    }

    private static String getDescendant(String number) {
        StringBuilder descendant = new StringBuilder();

        for (int i = 0; i < number.length() - 1; i += 2) {
            int digit1 = Character.getNumericValue(number.charAt(i));
            int digit2 = Character.getNumericValue(number.charAt(i + 1));
            descendant.append(String.valueOf(digit1 + digit2));
        }

        return descendant.toString();
    }

    public static boolean isPalindromeDescendant(long number) {
        if (number < 0) {
            return false;
        }
        String stringNumber = Long.toString(number);

        while (stringNumber.length() > 1) {

            if (isPalindrome(stringNumber)) {
                break;
            }
            if (stringNumber.length() % 2 == 1) {
                return false;
            }
            stringNumber = getDescendant(stringNumber);
        }

        return stringNumber.length() > 1 && isPalindrome(stringNumber);
    }
}
