import java.util.GregorianCalendar;
import java.util.TimeZone;
public class Time {

    byte hours;
    byte minutes;
    byte seconds;
    byte days;
    byte months;
    short years;

    public Time(){
        long time = System.currentTimeMillis();
        TimeZone timeZone = TimeZone.getDefault();
        long offSet = timeZone.getOffset(time);
        long currentTime = time + offSet;
        this.hours = (byte) ((currentTime/((1000*60)*60))%24);
        this.minutes = (byte) ((currentTime/(1000*60))%60);
        this.seconds = (byte) ((currentTime/1000)%60);
        GregorianCalendar calendar = new GregorianCalendar();
        this.days = (byte) calendar.get(GregorianCalendar.DAY_OF_MONTH);
        this.months = (byte) calendar.get(GregorianCalendar.MONTH + 1);
        this.years = (short) calendar.get(GregorianCalendar.YEAR);
    }

    @Override //For writing to order history for time retrieval functions etc
    public String toString() {
        return hours+ ":" + minutes + ":" + seconds + "," + days + ":" + months + ":" + years;
    }
}
