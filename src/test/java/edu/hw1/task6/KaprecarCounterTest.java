package edu.hw1.task6;

import org.junit.jupiter.api.DisplayName;
import static edu.hw1.task6.KaprecarCounter.countK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class KaprecarCounterTest {
    @ParameterizedTest
    @CsvSource(value = {
        "6621, 5",
        "6554, 4",
        "1234, 3"
    })
    @DisplayName("Корректные числа")
    public void countKTestWithCorrectInput(int value, int ans) {
        assertThat(countK(value)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "6, -1",
        "65, -1",
        "123, -1",
        "-1242, -1",
        "12345, -1"
    })
    @DisplayName("Отрицательные числа и числа неверной разрядности")
    public void countKTestWithInCorrectInput(int value, int ans) {
        assertThat(countK(value)).isEqualTo(ans);
    }

    @Test
    @DisplayName("Число с одинаковыми цифрами")
    public void countKTestWithOneDigit() {
        int testInt = 6666;

        assertThat(countK(testInt)).isEqualTo(-1);
    }
}
