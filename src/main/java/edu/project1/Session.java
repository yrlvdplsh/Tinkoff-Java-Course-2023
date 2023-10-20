package edu.project1;

import org.jetbrains.annotations.NotNull;

class Session {
    private final Answer answer;
    private final int maxAttempts;
    private int attempts;

    Session(Answer answer, int maxAttempts, int attempts) {
        this.answer = answer;
        this.maxAttempts = maxAttempts;
        this.attempts = attempts;
    }

    @NotNull public GuessResult guess(char guess) {
        GuessResult result;

        if (!answer.updateUserAnswer(guess)) {
            attempts++;
            if (attempts >= maxAttempts) {
                result = new GuessResult.Defeat(answer, attempts, maxAttempts);
            } else {
                result = new GuessResult.FailedGuess(answer, attempts, maxAttempts);
            }
        } else if (answer.isWin()) {
            result = new GuessResult.Win(answer, attempts, maxAttempts);
        } else {
            result = new GuessResult.SuccessfulGuess(answer, attempts, maxAttempts);
        }

        return result;
    }

    @NotNull public GuessResult giveUp() {
        return new GuessResult.Defeat(answer, attempts, maxAttempts);
    }
}
