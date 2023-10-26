package edu.project1;

import edu.project1.input_and_output.Printer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class PrinterTest {
    @Test
    @DisplayName("Проверка класса Printer")
    public void printerTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os, false, StandardCharsets.UTF_8));
        Printer printer = new Printer();
        printer.printMessage("Hello world!");
        assertThat(os.toString(StandardCharsets.UTF_8)).isEqualTo("-> Hello world!\r\n");
    }
}
