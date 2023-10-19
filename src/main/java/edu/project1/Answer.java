package edu.project1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class Answer {
    private final String answer;
    private final char[] userAnswer;

    public Answer(@NotNull String answer) {
        this.answer = answer;
        userAnswer = new char[answer.length()];
        Arrays.fill(userAnswer, '*');
    }

    public void updateUserAnswer(char letter) {
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == letter) {
                userAnswer[i] = letter;
            }
        }
    }

    public String getUserAnswer() {
        return new String(userAnswer);
    }
}
