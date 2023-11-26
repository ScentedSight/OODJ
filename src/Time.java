import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
public class Time {

    private byte hours;
    private byte minutes;
    private byte seconds;
    private int days;
    private int months;
    private int years;
    private Date date;

    public Time() { //Constructor for current time the moment this object is created
        Date date = new Date();
        this.date = date; //Set dates for easier comparison during user viewing records function
        long time = System.currentTimeMillis();
        TimeZone timeZone = TimeZone.getDefault();
        long offSet = timeZone.getOffset(time);
        long currentTime = time + offSet;
        hours = (byte) ((currentTime/((1000*60)*60))%24);
        minutes = (byte) ((currentTime/(1000*60))%60);
        seconds = (byte) ((currentTime/1000)%60);
        GregorianCalendar calendar = new GregorianCalendar();
        days = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        months = calendar.get(GregorianCalendar.MONTH + 1);
        years = calendar.get(GregorianCalendar.YEAR);
    }
    
    public Date getDate() { //Return date object stored upon creation of order for user viewing past order records function
        return date;
    }
    
    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
}
