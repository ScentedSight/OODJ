import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Time implements Serializable {

    private byte hours, minutes, seconds;
    private int days, months, years;

    public Time() { //Constructor for current time the moment this object is created
        long time = System.currentTimeMillis();
        TimeZone timeZone = TimeZone.getDefault();
        long offSet = timeZone.getOffset(time);
        long currentTime = time + offSet;
        hours = (byte) ((currentTime/((1000*60)*60))%24);
        minutes = (byte) ((currentTime/(1000*60))%60);
        seconds = (byte) ((currentTime/1000)%60);
        GregorianCalendar calendar = new GregorianCalendar();
        days = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        months = calendar.get(GregorianCalendar.MONTH) + 1;
        years = calendar.get(GregorianCalendar.YEAR);
    }
    
    public int getDay() {
        return days;
    }
    
    public int getMonth() {
        return months;
    }
    
    public int getYear() {
        return years;
    }
    
    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
}
