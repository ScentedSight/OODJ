import java.util.TimeZone;

public class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(){
        long time = System.currentTimeMillis();
        TimeZone timeZone = TimeZone.getDefault();
    }
}
