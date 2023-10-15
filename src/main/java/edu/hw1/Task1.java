package hw1;

public class Task1 {

    private static final int SECONDS_IN_MINUTE = 60;
    public static int minutesToSeconds(String time){
        int seconds = Integer.parseInt(time.substring(time.indexOf(':') + 1));
        if(seconds >= SECONDS_IN_MINUTE)
            return -1;
        seconds +=  Integer.parseInt(time.substring(0, time.indexOf(':'))) * SECONDS_IN_MINUTE;
        return seconds;
    }
}
