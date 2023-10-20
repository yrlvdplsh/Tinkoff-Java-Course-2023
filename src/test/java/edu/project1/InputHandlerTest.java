package edu.project1;

import edu.project1.dictionary.GameDictionary;
import edu.project1.input_and_output.DataInputer;
import edu.project1.input_and_output.InputHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.stream.Stream;
import static edu.hw1.task3.NestableArraysChecker.isNestable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.*;

public class InputHandlerTest {
    @Test
    @DisplayName("Ввод пустой строки")
    public void emptyInputTest() {
        InputStream is = System.in;
        System.setIn(new ByteArrayInputStream("".getBytes()));

        InputHandler inputHandler = new InputHandler();

    }
}
