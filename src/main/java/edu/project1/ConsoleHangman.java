package edu.project1;

import edu.project1.dictionary.GameDictionary;
import edu.project1.input_and_output.DataInputer;
import edu.project1.input_and_output.Printer;

class ConsoleHangman {
    //добавить класс с настройками мб
    //добавить везде отказоустойчивость блин
    //добавить в сессию обработку повторов
    //проверка ввода и тд
    private final Printer printer;
    private final Session session;

    ConsoleHangman(int maxAttempts) {
        GameDictionary dictionary = new GameDictionary();
        this.printer = new Printer();
        this.session = new Session(new Answer(dictionary.getRandomWord()), maxAttempts);

        this.run();
    }

    private void run() {
        GuessResult result = null;
        printer.printMessage("Welcome to the Hangman game");
        printer.printMessage("If you want to give up, enter \"exit\"");
        while (true) {
            printer.printMessage("Guess a letter:");
            result = tryGuess();
            if (result instanceof GuessResult.Win || result instanceof GuessResult.Defeat) {
                break;
            }
        }
    }

    private GuessResult tryGuess() {
        GuessResult result;
        DataInputer inputer = new DataInputer();
        String command = inputer.getInputData();

        if (command.equals("exit")) {
            result = session.giveUp();
        } else {
            char letter = inputer.getInputData().charAt(0);
            result = session.guess(letter);
        }

        printState(result);
        return result;

    }

    private void printState(GuessResult result) {
        printer.printMessage(result.message());
        printer.printMessage(session.getAnswer());
    }

    /*public static void main(String[] args) {
        ConsoleHangman game = new ConsoleHangman(5);
    }*/
}
