import java.util.GregorianCalendar;
import java.util.TimeZone;
public class Time {

    private byte hours;
    private byte minutes;
    private byte seconds;
    private byte days;
    private byte months;
    private short years;

    public Time() { //Constructor for current time the moment this object is created
        long time = System.currentTimeMillis();
        TimeZone timeZone = TimeZone.getDefault();
        long offSet = timeZone.getOffset(time);
        long currentTime = time + offSet;
        hours = (byte) ((currentTime/((1000*60)*60))%24);
        minutes = (byte) ((currentTime/(1000*60))%60);
        seconds = (byte) ((currentTime/1000)%60);
        GregorianCalendar calendar = new GregorianCalendar();
        days = (byte) calendar.get(GregorianCalendar.DAY_OF_MONTH);
        months = (byte) calendar.get(GregorianCalendar.MONTH + 1);
        years = (short) calendar.get(GregorianCalendar.YEAR);
    }
    
    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
}
