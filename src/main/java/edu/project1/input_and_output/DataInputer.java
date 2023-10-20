package edu.project1.input_and_output;

import java.util.Scanner;

public class DataInputer {
    private final String inputData;
    private final Scanner scanner = new Scanner(System.in);

    public DataInputer() {
        this.inputData = scanner.nextLine();
    }

    public String getInputData() {
        return inputData;
    }
}
