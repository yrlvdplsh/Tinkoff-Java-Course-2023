package edu.project1;

import edu.project1.input_and_output.InputHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.*;

public class ConsoleHangmanTest {
    @Test
    @DisplayName("Ввод некорректного словаря")
    public void invalidDictionaryTest() {
        String[] words = new String[1];
        words[0] = "1";


    }
}
