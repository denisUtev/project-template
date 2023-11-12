package edu.hw2;

public final class Task4 {

    private Task4() {

    }

    public static CallingInfo getCallingInfo() {
        StackTraceElement method = new Throwable().getStackTrace()[1];
        return new CallingInfo(method.getClassName(), method.getMethodName());
    }

    public record CallingInfo(String className, String methodName) { }
}
