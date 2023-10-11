package edu.hw1.task7;

import org.junit.jupiter.api.DisplayName;
import static edu.hw1.task7.CycleRotater.rotateLeft;
import static edu.hw1.task7.CycleRotater.rotateRight;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CycleRotaterTest {
    @ParameterizedTest
    @CsvSource(value = {
        "8, 1, 4",
        "19, 3, 14"
    })
    @DisplayName("Корректные числа, cдвиг вправо")
    public void rotateRightTestWithCorrectInput(int n, int shift, int res) {
        assertThat(rotateRight(n, shift)).isEqualTo(res);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "16, 1, 1",
        "17, 2, 6"
    })
    @DisplayName("Корректные числа, cдвиг влево")
    public void rotateLeftTestWithCorrectInput(int n, int shift, int res) {
        assertThat(rotateLeft(n, shift)).isEqualTo(res);
    }

    @Test
    @DisplayName("Отрицательное число или сдвиг в обе стороны")
    public void rotateTestWithNegativeInput() {
        int negativeShift = -14;
        int negativeNumber = -128;
        int testNumber = 128;
        int testShift = 14;

        assertThat(rotateLeft(testNumber, negativeShift)).isEqualTo(-1);
        assertThat(rotateRight(negativeNumber, testShift)).isEqualTo(-1);
    }
}
