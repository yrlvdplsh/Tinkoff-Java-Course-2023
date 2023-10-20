package edu.project1;

import edu.project1.dictionary.GameDictionary;
import edu.project1.input_and_output.DataInputer;
import edu.project1.input_and_output.Printer;

class ConsoleHangman {
    //добавить класс с настройками мб
    //переделать сессию как единовременное состояние игры
    //добавить везде отказоустойчивость блин
    //подумать что сделать с answer тк он и тут и в сессии
    private final GameDictionary dictionary;
    private final Printer printer;
    private final Answer answer;
    private final Session session;

    ConsoleHangman(int maxAttempts) {
        this.dictionary = new GameDictionary();
        this.printer = new Printer();
        this.answer = new Answer(dictionary.getRandomWord());
        this.session = new Session(answer, maxAttempts, 0);
    }

    public void run() {
        GuessResult result = null;
        printer.printMessage("Guess a letter:");
        while (true) {
            result = tryGuess();
            if (result instanceof GuessResult.Win || result instanceof GuessResult.Defeat) {
                printer.printMessage(answer.getAnswer());
                break;
            }
        }
    }

    private GuessResult tryGuess() {
        DataInputer inputer = new DataInputer();
        char letter = inputer.getInputData().charAt(0);
        GuessResult result = session.guess(letter);
        answer.updateUserAnswer(letter);
        printer.printMessage(result.message());
        printer.printMessage(answer.getUserAnswer());
        return result;
    }

    private void printState(GuessResult guess) {
    }

    /*public static void main(String[] args) {
        ConsoleHangman game = new ConsoleHangman(5);
        game.run();
    }*/
}
