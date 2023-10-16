package edu.hw1.task2;

import org.junit.jupiter.api.DisplayName;
import static edu.hw1.task2.DigitCounter.countDigits;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DigitCounterTest {
    @ParameterizedTest
    @CsvSource(value = {
        "12, 2",
        "1, 1",
        "999999999, 9",
        "9223372036854775807, 19"
    })
    @DisplayName("Неотрицательные числа")
    public void countDigitsTestWithNonNegative(long value, int ans) {
        assertThat(countDigits(value)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-12, 2",
        "-1, 1",
        "-999999999, 9"
    })
    @DisplayName("Отрицательные числа")
    public void countDigitsTestWithNegative(int value, int ans) {
        assertThat(countDigits(value)).isEqualTo(ans);
    }


}
