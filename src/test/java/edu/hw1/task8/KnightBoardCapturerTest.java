package edu.hw1.task8;

import org.junit.jupiter.api.DisplayName;
import static edu.hw1.task8.KnightBoardCapturer.knightBoardCapture;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class KnightBoardCapturerTest {
    @Test
    @DisplayName("Кони не могут захватить друг друга")
    public void knightBoardCaptureTestWithGoodBoard() {
        int[][] board = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };

        assertThat(knightBoardCapture(board)).isTrue();
    }

    @Test
    @DisplayName("Кони могут захватить друг друга")
    public void knightBoardCaptureTestWithBadBoard() {
        int[][] board = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };

        assertThat(knightBoardCapture(board)).isFalse();
    }

    @Test
    @DisplayName("Доска неверных размеров")
    public void knightBoardCaptureTestWithInvalidSize() {
        int[][] board1 = {
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };

        assertThrows(
            IllegalArgumentException.class,
            () -> {
                knightBoardCapture(board1);
            }
        );

        int[][] board2 = {
            {1, 0, 1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 1},
            {0, 0, 1, 0, 0, 1, 0},
            {1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 1, 0}
        };

        assertThrows(
            IllegalArgumentException.class,
            () -> {
                knightBoardCapture(board2);
            }
        );

        int[][] board3 = {{}};
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                knightBoardCapture(board1);
            }
        );
    }
}
