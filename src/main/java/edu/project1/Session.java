package edu.project1;

import org.jetbrains.annotations.NotNull;

class Session {
    private final Answer answer;
    private final int maxAttempts;
    private int attempts;

    Session(Answer answer, int maxAttempts) {
        this.answer = answer;
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
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

    public String getAnswer() {
        String message = "The word: ";
        if (answer.isWin() || answer.isDefeat(attempts, maxAttempts)) {
            message += answer.getAnswer();
        } else {
            message += answer.getUserAnswer();
        }
        return message;
    }
}
