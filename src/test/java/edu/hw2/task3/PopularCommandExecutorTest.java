package edu.hw2.task3;

import edu.hw2.task3.connection_managers.ConnectionManager;
import edu.hw2.task3.connection_managers.DefaultConnectionManager;
import edu.hw2.task3.connection_managers.FaultyConnectionManager;
import edu.hw2.task3.connections.Connection;
import edu.hw2.task3.connections.FaultyConnection;
import edu.hw2.task3.connections.StableConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

public class PopularCommandExecutorTest {
    @ParameterizedTest
    @MethodSource("updatePackagesArgs")
    @DisplayName("Тестирование PopularCommandExecutor")
    void updatePackagesTest(ConnectionManager manager) {
        PopularCommandExecutor pce = new PopularCommandExecutor(manager, 12);
        Throwable thrown = catchThrowable(() -> {
            pce.updatePackages();
        });
        assertThat(thrown).isInstanceOf(ConnectionException.class);
    }

    static Stream<Arguments> updatePackagesArgs() {
        return Stream.of(
            Arguments.of(new DefaultConnectionManager()),
            Arguments.of(new FaultyConnectionManager())
        );
    }

}
