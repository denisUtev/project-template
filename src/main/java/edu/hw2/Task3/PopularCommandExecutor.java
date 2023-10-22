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
        boolean isExecuted = false;
        ConnectionException exception = null;
        for (int i = 0; i < maxAttempts; i++) {
            try {
                manager.getConnection().execute(command);
                manager.getConnection().close();
                isExecuted = true;
                break;
            } catch (ConnectionException e) {
                exception = e;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (!isExecuted) {
            throw exception;
        }
    }
}
