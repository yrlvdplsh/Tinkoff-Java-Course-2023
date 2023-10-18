package edu.hw2.task3;

import edu.hw2.task3.connection_managers.ConnectionManager;
import edu.hw2.task3.connections.Connection;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        ConnectionException cause = null;
        for (int i = 0; i < maxAttempts; i++) {
            try (Connection con = manager.getConnection()) {
                con.execute(command);
            } catch (Exception e) {
                cause = (ConnectionException) e;
            }
        }

        if (cause != null) {
            throw cause;
        }
    }
}
