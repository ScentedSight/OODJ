import java.util.TimeZone;
public class Time {

    int hours;
    int minutes;
    int seconds;

    public Time(){
        long time = System.currentTimeMillis();
        TimeZone timeZone = TimeZone.getDefault();
        long offSet = timeZone.getOffset(time);
        long currentTime = time + offSet;
        this.hours = (int) (currentTime/((1000*60)*60))%24;
        this.minutes = (int) (currentTime/(1000*60))%60;
        this.seconds = (int) (currentTime/1000)%60;
    }

    @Override
    public String toString() {
        return hours+ ":" + minutes + ":" + seconds;
    }
}
