package edu.hw1.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.task3.NestableArraysChecker.isNestable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NestableArraysCheckerTest {

    @Test
    @DisplayName("Nestable(не смог перевести) массивы")
    public void isNestableTestWithCorrectArrays() {

        long[] array1 = {1, 2, 3, 4};
        long[] array2 = {0, 6};

        assertThat(isNestable(array1, array2)).isEqualTo(true);
    }

    @Test
    @DisplayName("Пограничный случай - минимумы/максимумы совпадают")
    public void isNestableTestWithEdgeCase() {

        long[] array1 = {0, 2, 3, 4};
        long[] array2 = {0, 6};

        assertThat(isNestable(array1, array2)).isEqualTo(false);

        long[] array3 = {1, 2, 3, 6};
        long[] array4 = {2, 6};

        assertThat(isNestable(array3, array4)).isEqualTo(false);
    }

    @Test
    @DisplayName("Другие случаи невложенности")
    public void isNestableTestWithBadArrays() {

        long[] array1 = {12, 13, 14};
        long[] array2 = {0, 1, 2};

        assertThat(isNestable(array1, array2)).isEqualTo(false);

        long[] array3 = {1, -1, 3, 6};
        long[] array4 = {1, 3};

        assertThat(isNestable(array3, array4)).isEqualTo(false);
    }

    @Test
    @DisplayName("Один из массивов состоит из 1 элемента")
    public void isNestableTestWithTooSmallArrays() {

        long[] array1 = {12};
        long[] array2 = {0, 1, 2};

        assertThat(isNestable(array1, array2)).isEqualTo(false);

        long[] array3 = {1, -1, 3};
        long[] array4 = {1};

        assertThat(isNestable(array3, array4)).isEqualTo(false);
    }

    @Test
    @DisplayName("Один из массивов пустой/null")
    public void isNestableTestWithEmptyOrNullArrays() {

        long[] array1 = null;
        long[] array2 = {0, 1, 2};

        assertThat(isNestable(array1, array2)).isEqualTo(false);

        long[] array3 = {1, -1, 3, 6};
        long[] array4 = null;

        assertThat(isNestable(array3, array4)).isEqualTo(false);

        long[] array5 = {1, -1, 3, 6};
        long[] array6 = {};

        assertThat(isNestable(array3, array4)).isEqualTo(false);

        long[] array7 = {};
        long[] array8 = {1, -1, 3, 6};

        assertThat(isNestable(array3, array4)).isEqualTo(false);
    }
}
