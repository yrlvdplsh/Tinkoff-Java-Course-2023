package edu.hw1.task0;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PrintHelloWorld {
    private final static Logger LOGGER = LogManager.getLogger();

    private PrintHelloWorld() {
    }

    public static void print() {
        LOGGER.info("Привет, мир!");
    }
}
