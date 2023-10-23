package edu.hw3.task5;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;
import static edu.hw3.task4.RomanConverter.convertToRoman;
import static edu.hw3.task5.ContactParser.parseContacts;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactParserTest {
    @ParameterizedTest
    @MethodSource("parseContactsCorrectInputTestArgs")
    public void parseContactsCorrectInputTest(List<String> inputList, String order, String expected) {
        assertThat(parseContacts(inputList, order).toString()).isEqualTo(expected);
    }

    private static Stream<Arguments> parseContactsCorrectInputTestArgs() {
        List<String> list1 = Arrays.asList("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes");
        String result1 = "[Thomas Aquinas, Rene Descartes, David Hume, John Locke]";

        List<String> list2 = Arrays.asList("Paul Erdos", "Leonhard Euler", "Carl Gauss");
        String result2 = "[Carl Gauss, Leonhard Euler, Paul Erdos]";

        List<String> list3 = Arrays.asList("John Locke", "Thomas", "David Hume", "Rene Descartes");
        String result3 = "[Rene Descartes, David Hume, John Locke, Thomas]";

        return Stream.of(
            Arguments.of(
                Named.of("test with correct input, direct order", list1), "ASC", result1),
            Arguments.of(
                Named.of("test with correct input, reversed order", list2), "DESC", result2),
            Arguments.of(
                Named.of("test with correct input, some contacts do not have surname", list3),
                "ASC", result3
            ),
            Arguments.of(Named.of("test with empty list", Collections.emptyList()), "ASC", "[]"),
            Arguments.of(Named.of("test with null list", null), "ASC", "[]")
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
        "ASSC",
        "REVERSED",
        "42",
        "_-__-_--"
    })
    @DisplayName("test with invalid sort order")
    public void invalidSortOrderTest(String order) {
        List<String> testList = Arrays.asList("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes");
        assertThrows(
            IllegalArgumentException.class,
            () -> parseContacts(testList, order)
        );
    }
}

