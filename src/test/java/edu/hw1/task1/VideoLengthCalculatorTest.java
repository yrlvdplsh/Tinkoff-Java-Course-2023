package edu.hw1.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.task1.VideoLengthCalculator.minutesToSeconds;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class VideoLengthCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {
        "12:12, 732",
        "30:03, 1803",
        "999:32, 59972",
        "00:00, 0",
        "00:59, 59"
    })
    @DisplayName("Проверка работы программы с корректными данными")
    public void minutesToSecondsTestWithCorrectInput(String length, int ans) {
        assertThat(minutesToSeconds(length)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-10:12, -1",
        "12:-12, -1",
        "999:100, -1"
    })
    @DisplayName("Данные с неверным диапазоном значений")
    public void minutesToSecondsTestWithIncorrectInput(String length, int ans) {
        assertThat(minutesToSeconds(length)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "12.12, -1",
        "00;00, -1",
        "F1:10, -1",
        "00.00.00, -1",
        "ANAPA, -1",
    })
    @DisplayName("ДАнные с неверным форматом ввода")
    public void minutesToSecondsTestWithIncorrectFormat(String length, int ans) {
        assertThat(minutesToSeconds(length)).isEqualTo(ans);
    }

    @Test
    @DisplayName("Ввод пустой строки/null")
    public void minutesToSecondsTestWithEmptyString() {
        assertThat(minutesToSeconds("")).isEqualTo(-1);
        assertThat(minutesToSeconds(null)).isEqualTo(-1);
    }
}
