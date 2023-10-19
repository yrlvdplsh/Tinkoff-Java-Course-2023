package edu.hw2.task3;

import edu.hw2.task3.connection_managers.ConnectionManager;
import edu.hw2.task3.connection_managers.DefaultConnectionManager;
import edu.hw2.task3.connection_managers.FaultyConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PopularCommandExecutorTest {

    @ParameterizedTest
    @CsvSource(value = {
        "0",
        "-10"
    })
    @DisplayName("Проверка корректности работы программы при передаче некорректного maxAttempts")
    public void IllegalMaxAttemptsTest(int value) {

        assertThrows(
            IllegalArgumentException.class,
            () -> new PopularCommandExecutor(new DefaultConnectionManager(), value)
        );
    }

    @ParameterizedTest
    @MethodSource("updatePackagesArgs")
    @DisplayName("Тестирование PopularCommandExecutor")
    void updatePackagesTest(ConnectionManager manager) {

        PopularCommandExecutor pce = new PopularCommandExecutor(manager, 12);
        assertThrows(ConnectionException.class, () -> {
            for (int i = 0; i < 100; i++) {
                pce.updatePackages();
            }
        });

    }

    static Stream<Arguments> updatePackagesArgs() {
        return Stream.of(
            Arguments.of(new DefaultConnectionManager()),
            Arguments.of(new FaultyConnectionManager())
        );
    }

}
