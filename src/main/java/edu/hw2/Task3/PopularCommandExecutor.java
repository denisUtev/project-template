package edu.hw2.Task3;

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
        ConnectionException exception = null;
        for (int i = 0; i < maxAttempts; i++) {
            try (Connection connection = manager.getConnection()){
                connection.execute(command);
                exception = null;
                break;
            } catch (Exception e) {
                exception = new ConnectionException(e);
            }
        }
        if (exception != null) {
            throw exception;
        }
    }
}
