package edu.hw1.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw1.task3.NestableArraysChecker.isNestable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NestableArraysCheckerTest {

    @ParameterizedTest
    @MethodSource("isNestableTestArgs")
    @DisplayName("Тесты  на вложенность/евложенность и пограничные случаи")
    public void isNestableTest(long[] firstArray, long[] secondArray, boolean result) {

        assertThat(isNestable(firstArray, secondArray)).isEqualTo(result);
    }

    private static Stream<Arguments> isNestableTestArgs() {
        return Stream.of(
            //Nestable Arrays
            Arguments.of(new long[] {1, 2, 3, 4}, new long[] {0, 6}, true),
            //UnNestable Arrays - border case - min/max are equal
            Arguments.of(new long[] {1, 2, 3, 6}, new long[] {0, 6}, false),
            Arguments.of(new long[] {0, 2, 3, 4}, new long[] {2, 6}, false),
            //UnNestable Arrays
            Arguments.of(new long[] {12, 13, 14}, new long[] {0, 1, 2}, false),
            Arguments.of(new long[] {1, -1, 3, 6}, new long[] {1, 3}, false),
            //UnNestable Arrays - size of array is 1
            Arguments.of(new long[] {12}, new long[] {0, 1, 2}, false),
            Arguments.of(new long[] {1, -1, 3}, new long[] {1}, false),
            //UnNestable Arrays - one of arrays is empty
            Arguments.of(new long[] {1, -1, 3, 6}, new long[] {}, false),
            Arguments.of(new long[] {}, new long[] {1, -1, 3, 6}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("isNestableTestWithNullArraysArgs")
    @DisplayName("Один из массивов null")
    public void isNestableTestWithNullArrays(long[] firstArray, long[] secondArray) {

        assertThrows(
            NullPointerException.class,
            () -> isNestable(firstArray, secondArray)
        );
    }

    public static Stream<Arguments> isNestableTestWithNullArraysArgs() {
        return Stream.of(
            Arguments.of(null, new long[] {0, 1, 2}),
            Arguments.of(new long[] {1, -1, 3, 6}, null)
        );
    }
}
