package edu.hw1.task8;

public final class KnightBoardCapturer {
    private static final int SIZE = 8;
    private static final int[][] MOVES = {{-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {-2, -1}, {2, -1}, {-2, 1}, {2, 1}};

    private KnightBoardCapturer() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        if (board.length != SIZE) {
            throw new IllegalArgumentException("Invalid length of board");
        }

        for (int i = 0; i < SIZE; i++) {
            if (board[i].length != SIZE) {
                throw new IllegalArgumentException("Invalid width of board");
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 1) {
                    for (var m : MOVES) {
                        if (!(i + m[0] < 0 || i + m[0] >= SIZE || j + m[1] < 0 || j + m[1] >= SIZE)) {
                            if (board[i + m[0]][j + m[1]] == 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
