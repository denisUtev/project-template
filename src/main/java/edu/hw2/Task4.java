package edu.hw2;

public final class Task4 {

    private Task4() {

    }

    public static CallingInfo getCallingInfo() {
        StackTraceElement[] methods = Thread.currentThread().getStackTrace();
        return new CallingInfo(methods[2].getClassName(), methods[2].getMethodName());
    }

    public record CallingInfo(String className, String methodName) { }
}
