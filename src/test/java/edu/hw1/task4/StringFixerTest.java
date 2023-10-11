package edu.hw1.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.task4.StringFixer.fixString;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringFixerTest {
    @ParameterizedTest
    @CsvSource(value = {
        "123456, 214365",
        "hTsii  s aimex dpus rtni.g, This is a mixed up string.",
        "badce, abcde"
    })
    @DisplayName("Корректный ввод")
    public void fixStringTestWithCorrectInput(String value, String ans) {
        assertThat(fixString(value)).isEqualTo(ans);
    }

    @Test
    @DisplayName("Ввод пустой строки/null")
    public void fixStringTextWithIncorrectInput() {
        String emptyString = "";
        String nullString = null;

        assertThat(fixString(emptyString)).isEqualTo("");
        assertThat(fixString(nullString)).isEqualTo(null);
    }
}
