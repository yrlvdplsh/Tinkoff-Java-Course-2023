package edu.hw1.task5;

import org.junit.jupiter.api.DisplayName;
import static edu.hw1.task5.PalindromeChecker.isPalindromeDescendant;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PalindromeCheckerTest {
    @Test
    @DisplayName("Тест на отрицательном числе")
    public void isPalindromeDescendantTestWithNegativeDigit() {
        int testInt = -1221;
        assertThat(isPalindromeDescendant(testInt)).isEqualTo(false);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "121, true",
        "11111111, true",
        "987789, true"
    })
    @DisplayName("Палиндромы")
    public void isPalindromeDescendantTestWithPalindromes(int value, boolean ans) {
        assertThat(isPalindromeDescendant(value)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "11211230, true",
        "13001120, true",
        "23336014, true"
    })
    @DisplayName("Палиндромы среди потомков")
    public void isPalindromeDescendantTestWithPalindromeDescendants(int value, boolean ans) {
        assertThat(isPalindromeDescendant(value)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "59, false",
        "100162011, false",
        "12, false"
    })
    @DisplayName("Числа, у которых в родословной нет и не будет палиндрома")
    public void isPalindromeDescendantTestWithNoPalindrome(int value, boolean ans) {
        assertThat(isPalindromeDescendant(value)).isEqualTo(ans);
    }
}

